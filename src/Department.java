public class Department {

    private int departmentID;
    private String name;
    private Worker manager;

    public Department(int departmentID, String name) {
        this.departmentID = departmentID;
        this.name = name;
    }

    public Worker getManager() {
        return manager;
    }

    public void setManager(Worker manager) {
        this.manager = manager;
    }
}
