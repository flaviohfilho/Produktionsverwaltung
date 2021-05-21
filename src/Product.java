
/**
 * Das Produkt der produziert ist in 3 verschiedene Größen
 * also wir haben so zu sagen nur 3 Produkte zum verkaufen
 * Constuctor
 * Das Produkt hat die Attribute: </p>
 * productId :int</p>
 * name  :String </p>
 * price : float </p>
 * width :int </p>
 * height :int </p>
 * @author ismail und Lahing
 *
 */
public  class Product {
	private int productId;
	/**
	 * Produktname
	 */
	private String name;
	private int price;
	private int width;
	private int height;
	/**
	 * Steuer
	 * tax :int
	 */
	private int tax;
	/**
	 * 
	 * @param name :String
	 * @param price : float
	 * @param width : int
	 * @param height :int
	 */
	//Product(){}
	
	public Product(String name,int price, int tax, int width,int height){
		this.name = name;
		this.price = price;
		this.tax = tax;
		this.width = width;
		this.height = height;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public  int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}	/**
	 * Brutto
	 * @return
	 */
	
	public int gross() {
		return tax * getPrice();
	}

	public int getTax() {
		return this.tax;
	}
	


	
}
