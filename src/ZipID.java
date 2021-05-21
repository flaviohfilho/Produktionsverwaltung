
public  class ZipID {

	private int zipID;
	private String zip;
	private String city;
	
	public ZipID(int zipID, String zip,String city  ) {
		 this.zipID = zipID;
		 this.zip = zip;
		 this.city = city;
	}

	public int getZipID() {
		return this.zipID;
	}

	public void setZipID(int zipID) {
		this.zipID = zipID;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
