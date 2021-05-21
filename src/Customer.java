/**
 * @author lahingm
 * @review Flavio
 *Class Custome erbt von Class Person
 *
 */
public class Customer extends Person {

	 private int customerID;


	/**
	 * @param customerID
	 * @param name
	 * @param firstname
	 * @param birthday
	 * @param mail
	 * @param tel
	 * @param street
	 * @param housenumber
	 * @param zipID
	 */
	 public Customer( int customerID,String name, String firstname, String birthday, String mail, String tel, String street,
					  String housenumber, String zipID ){

	 super(name,firstname,birthday,mail,tel,street,housenumber,zipID);
	 this.customerID = customerID;

	 }

}