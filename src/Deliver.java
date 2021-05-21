public class Deliver extends Company{

    private int deliverID;
    /**
     * @param name        : String
     * @param mail        : String
     * @param tel         : String
     * @param street      : String
     * @param housenumber : String
     * @param zipID       : String
     * @author Flavio
     */
    public Deliver(int deliverID, String name, String mail, String tel, String street, String housenumber, String zipID) {
        super(name, mail, tel, street, housenumber, zipID);
        this.deliverID = deliverID;
    }
}
