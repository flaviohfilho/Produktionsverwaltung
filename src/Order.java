import java.util.Date;
import java.util.List;

public class Order {

    private int orderID;
    private int customerID;
    private Date date;
    private List<Product> products;
    private int paymentMethodeID;
    private int deliveryMethodeID;
    private int discount;
    private int sale;
    private int count;

    public Order(int orderID, int customerID, Date date) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.date = date;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public List<Product> getAllProduct(){
        return this.products;
    }

    public int getPaymentMethodeID() {
        return paymentMethodeID;
    }

    public void setPaymentMethodeID(int paymentMethodeID) {
        this.paymentMethodeID = paymentMethodeID;
    }

    public int getDeliveryMethodeID() {
        return deliveryMethodeID;
    }

    public void setDeliveryMethodeID(int deliveryMethodeID) {
        this.deliveryMethodeID = deliveryMethodeID;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private class PaymentMethode{

        private int methodeID;
        private String name;

        public PaymentMethode(int methodeID, String name) {
            this.methodeID = methodeID;
            this.name = name;
        }
    }

    private class DeliveryMethode{

        private int methodeID;
        private String name;

        public DeliveryMethode(int methodeID, String name) {
            this.methodeID = methodeID;
            this.name = name;
        }
    }

}
