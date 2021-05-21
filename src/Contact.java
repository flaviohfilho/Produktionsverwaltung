/**
 * @author lahingm
 * @review Flavio
 */
public abstract class Contact {
	
	private String mail;
	private String tel;
	private String street;
	private String housenumber;
	private String zipID;

	/**
	 * @param mail
	 * @param tel
	 * @param street
	 * @param housenumber
	 * @param zipID
	 */
	protected Contact(String mail, String tel, String street,
			 String housenumber, String zipID) {
	 this.mail = mail;	
	 this.tel = tel;	
	 this.street = street;	
	 this.housenumber = housenumber;	
	 this.zipID = zipID;	
	
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHousenumber() {
		return this.housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getZipID() {
		return this.zipID;
	}

}
