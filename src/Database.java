import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class Database {

    String db = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC&user=admin&password=12345";
    Connection con = null;
    

    public Database() throws SQLException {
        con = DriverManager.getConnection(db);
    }

    void newDB (){
        try {
             Statement stmt = con.createStatement();
            ArrayList<String> sqlStmts = new ArrayList<>();



            if (! con.getMetaData().getTables(null,null,"ZIP",null).next()){
                sqlStmts.add("CREATE TABLE ZIP(zip_number CHAR(30) CHARACTER SET utf8, city VARCHAR(255))");
            }
            if (! con.getMetaData().getTables(null,null,"PERSON",null).next()){
                sqlStmts.add("CREATE TABLE PERSON(personID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(255) CHARACTER SET utf8, " +
                        "lastname VARCHAR(255) CHARACTER SET utf8, kind CHAR(1), birthday DATE," +
                        "email VARCHAR(255) CHARACTER SET utf8, tel CHAR(30) CHARACTER SET utf8, " +
                        "street VARCHAR(255) CHARACTER SET utf8, housenumber CHAR(30) CHARACTER SET utf8, zip CHAR(30) CHARACTER SET utf8, " +
                        "FOREIGN KEY (zip) REFERENCES ZIP(zip_number))");
            }
            if (! con.getMetaData().getTables(null,null,"MATERIAL",null).next()){
                sqlStmts.add("CREATE TABLE MATERIAL(materialID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(255) CHARACTER SET utf8, " +
                        "length INTEGER)");
            }
            if (! con.getMetaData().getTables(null,null,"PRODUCT",null).next()){
                sqlStmts.add("CREATE TABLE PRODUCT(productID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(255) CHARACTER SET utf8, " +
                        "value FLOAT(12,2), tax INTEGER, length FLOAT(6,2), width FLOAT(6,2))");
            }
            if (! con.getMetaData().getTables(null,null,"MACHINE",null).next()){
                sqlStmts.add("CREATE TABLE MACHINE(machineID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, model VARCHAR(255) CHARACTER SET utf8)");
            }
            if (! con.getMetaData().getTables(null,null,"STORAGE",null).next()){
                sqlStmts.add("CREATE TABLE STORAGE(storageID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(255) CHARACTER SET utf8)");
            }
            if (! con.getMetaData().getTables(null,null,"STORAGE_PRODUCT_INFO",null).next()){
                sqlStmts.add("CREATE TABLE STORAGE_PRODUCT_INFO(storageID INTEGER, productID INTEGER, amount INTEGER," +
                        "FOREIGN KEY (storageID) REFERENCES STORAGE(storageID),FOREIGN KEY (productID) REFERENCES PRODUCT(productID))");
            }
            if (! con.getMetaData().getTables(null,null,"STORAGE_MATERIAL_INFO",null).next()){
                sqlStmts.add("CREATE TABLE STORAGE_MATERIAL_INFO(storageID INTEGER, materialID INTEGER, amount INTEGER," +
                        "FOREIGN KEY (storageID) REFERENCES STORAGE(storageID),FOREIGN KEY (materialID) REFERENCES MATERIAL(materialID))");
            }
            if (! con.getMetaData().getTables(null,null,"SHIFT",null).next()){
                sqlStmts.add("CREATE TABLE SHIFT(shiftID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, start_hour TIME, end_hour TIME)");
            }
            if (! con.getMetaData().getTables(null,null,"SHIFT_PLAN",null).next()){
                sqlStmts.add("CREATE TABLE SHIFT_PLAN(shift_planID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, machineID INTEGER," +
                        "date DATE, shiftID INTEGER, FOREIGN KEY (machineID) REFERENCES MACHINE(machineID)," +
                        "FOREIGN KEY (shiftID) REFERENCES SHIFT(shiftID) )");
            }
            if (! con.getMetaData().getTables(null,null,"SHIFT_PLAN_INFO",null).next()){
                sqlStmts.add("CREATE TABLE SHIFT_PLAN_INFO(shift_planID INTEGER, personID INTEGER, " +
                        "FOREIGN KEY (shift_planID) REFERENCES SHIFT_PLAN(shift_planID), " +
                        "FOREIGN KEY (personID) REFERENCES PERSON(personID) )");
            }
            if (! con.getMetaData().getTables(null,null,"PLACED_ORDER",null).next()){
                sqlStmts.add("CREATE TABLE PLACED_ORDER( placed_orderID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, personID INTEGER," +
                        " open_date DATE, close_date DATE, total FLOAT(12,2), status CHAR(30) CHARACTER SET utf8, " +
                        "FOREIGN KEY (personID) REFERENCES PERSON(personID))");
            }
            if (! con.getMetaData().getTables(null,null,"ORDER_INFO",null).next()){
                sqlStmts.add("CREATE TABLE ORDER_INFO(placed_orderID INTEGER, productID INTEGER," +
                        "amount INTEGER, " +
                        "FOREIGN KEY (placed_orderID) REFERENCES PLACED_ORDER(placed_orderID), " +
                        "FOREIGN KEY (productID) REFERENCES PRODUCT(productID))");
            }


            for(String sql : sqlStmts){
                stmt.executeUpdate(sql);
            }
            System.out.println("Tables applied.");

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    boolean verifyQuery(String str, String... reference) throws SQLException {

        boolean exist = false;

        try {
            PreparedStatement statement = con.prepareStatement(str);
            int x = 1;
            for (String str2 : reference) {
                statement.setString(x++, str2);
            }

            try (ResultSet rs = statement.executeQuery()) {
                exist = rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    int executeQuery(String str, String... reference) throws SQLException {
        try {
            PreparedStatement statement = con.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);

            int x = 1;
            for(String str2 : reference) {
                statement.setString(x++, str2);
            }
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    ResultSet getQuery(String str, String... reference) throws SQLException {

        ResultSet rs = null;

        PreparedStatement statement = con.prepareStatement(str);

        int x = 1;
        for(String str2 : reference){
            statement.setString(x++, str2);
        }

        rs = statement.executeQuery();
        return rs;

    }

    public String get_SHA_512_SecurePassword(String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    public Customer getCustomer (int id) throws SQLException{
        Customer customer;
        String query = "SELECT*FROM PERSON WHERE personID = ? AND kind = ?";
        ResultSet rs = getQuery(query,""+id,"C");
        if(rs.next()){
             return customer = new Customer(rs.getInt(1),rs.getString(2), rs.getString(3),
                    rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                    rs.getString(9),rs.getString(10));
        }
        return null;
    }

    public Customer[] getAllCustomer () throws SQLException{
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT*FROM PERSON WHERE kind = ?";
        ResultSet rs = getQuery(query,""+"C");
        while (rs.next()){
             customers.add(new Customer(rs.getInt(1),rs.getString(2), rs.getString(3),
                    rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                    rs.getString(9),rs.getString(10)));
        }
        return customers.toArray(new Customer[0]);
    }

    public Worker getWorker (int id) throws SQLException{
        Worker worker;
        String query = "SELECT*FROM PERSON WHERE personID = ? AND kind = ?";
        ResultSet rs = getQuery(query,""+id,"W");
        if(rs.next()){
            return worker = new Worker(rs.getInt(1),rs.getString(2), rs.getString(3),
                    rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                    rs.getString(9),rs.getString(10));
        }
        return null;
    }

    public Worker[] getAllWorker() throws SQLException{
        List<Worker> workers = new ArrayList<>();
        String query = "SELECT*FROM PERSON WHERE kind = ?";
        ResultSet rs = getQuery(query,""+"W");
        while (rs.next()){
            workers.add(new Worker(rs.getInt(1),rs.getString(2), rs.getString(3),
                    rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                    rs.getString(9),rs.getString(10)));
        }
        return workers.toArray(new Worker[0]);
    }

    public Deliver getDeliver (int id) throws SQLException{
        Deliver deliver;
        String query = "SELECT*FROM PERSON WHERE personID = ? AND kind = ?";
        ResultSet rs = getQuery(query,""+id,"D");
        if(rs.next()){
            return deliver = new Deliver(rs.getInt(1),rs.getString(2),
                    rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
                    rs.getString(10));
        }
        return null;
    }

    public Deliver[] getAllDeliver() throws SQLException{
        List<Deliver> delivers = new ArrayList<>();
        String query = "SELECT*FROM PERSON WHERE kind = ?";
        ResultSet rs = getQuery(query,""+"D");
        while (rs.next()){
            delivers.add(new Deliver(rs.getInt(1),rs.getString(2),
                    rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
                    rs.getString(10)));
        }
        return delivers.toArray(new Deliver[0]);
    }

    public Product getProduct(int id) throws SQLException{
        Product product;
        String query = "SELECT*FROM PRODUCT WHERE productID = ?";
        ResultSet rs = getQuery(query,""+id);
        if(rs.next()){
            return product = new Product(rs.getString(2),rs.getInt(3),rs.getInt(4),
                    rs.getInt(5),rs.getInt(6));
        }
        return null;
    }

    public Product[] getAllProduct() throws SQLException{
        List<Product> products = new ArrayList<>();
        String query = "SELECT*FROM PRODUCT";
        ResultSet rs = getQuery(query);
        while (rs.next()){
            products.add(new Product(rs.getString(2),rs.getInt(3),rs.getInt(4),
                    rs.getInt(5),rs.getInt(6)));
        }
        return products.toArray(new Product[0]);
    }

   /* public OrderModell newOrderModel(int customerID) throws SQLException{
        Customer customer = getCustomer(customerID);
        LocalDate date = LocalDate.now();
       OrderModell order =  new OrderModell(customer,convertToDateViaSqlDate(date));
        String query = "INSERT INTO PLACED_ORDER(personID,open_date,status) VALUES(?,?,?)";
        executeQuery(query,""+customerID,toString(date),"QUEUE");
    }*/







    public static void main(String[] args) {

        try {
            Database database = new Database();
            database.newDB();

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }

}
