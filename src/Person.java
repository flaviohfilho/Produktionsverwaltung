/**
 * @author lahingm
 * @review Flavio
 * Person is an abstract class that extends the class Contact
 *
 * 
 */
public abstract class Person extends Contact{

	private String lastname;
	private String firstname;
	private String birthday;


	/**
	 * @param lastname
	 * @param firstname
	 * @param birthday
	 * @param mail
	 * @param tel
	 * @param street
	 * @param housenumber
	 * @param zipID
	 */
	 protected Person( String lastname, String firstname, String birthday, String mail, String tel, String street,
					String housenumber, String zipID ) {
	 	super(mail,tel,street,housenumber,zipID);
	 	this.lastname = lastname;
	 	this.firstname = firstname;
	 	this.birthday = birthday;
	
	 }

	public String getLastname() {
		return this.lastname;
		}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	 	}
	
	public String getFirstname() { return this.firstname; }

	public void setFirstname(String firstname) {
		this.firstname = firstname;
		}

}


