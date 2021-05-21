/**
 * @author Flavio
 *
 */

public abstract class Company extends Contact {

    private String name;

    /**
     * @author Flavio

     * @param name : String
     * @param mail : String
     * @param tel : String
     * @param street : String
     * @param housenumber : String
     * @param zipID : String
     */
    protected Company (String name, String mail, String tel, String street,
                      String housenumber, String zipID) {
        super(mail, tel, street, housenumber, zipID);
        this.name = name;

    }
}
