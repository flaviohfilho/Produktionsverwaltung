/**
 * OrderPosition ist Position der Produkt, Menge
 * und Preis in der Rechnung 
 * Das brauchen wir für die Datenbank
 * 
 * @author ismaila
 *
 */

public class OrderPosition {

	private int amount;
	private Product product;

	
	public OrderPosition(Product product, int amount) {
		this.product = product;
		this.amount =amount;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	

	

	
	
			
}
