import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * @author ismail
 * 
 * Nach MVC Pattern
 * OrderModell ist ein Teil von Order
 * oderId :int
 * tax :int
 * status :int
 * orderDate :Date 
 * 
 */
public class OrderModell {
	/**
	 * in LinkedList bekommt man den Produkt und die Menge in eine Liste 
	 * für den Bestellposition
	 */
	private LinkedList<OrderPosition> orderPos = new LinkedList<>(); 
	//Product product = new Product();
	
	/**
	 * customer :Customer
	*/
	private Customer customer;
	/**
	 * orderId :int
	 */
	private int orderId;

	/**
	 * Status: Warteschlange ,Bearbeitung und fertig
	 * status :int
	 */
	private OrderStatus status = OrderStatus.QUEUE;
	/**
	 * orderDate :Date Bestelldatum
	 */
	private Date orderDate;
	/**
	 * orderDate :Date </p> Datum der Auslieferung
	 */
	private Date endDate;
	
	/**
	 * 
	 * @param customer
	 * @param orderDate
	 * @param productPostion
	 */
	
	OrderModell(Customer customer,Date orderDate){
		this.customer = customer;
		this.orderDate = orderDate;
		}

	/**
	 * Hier ist die Berechnung:
	 * falls der kunde Rabatt bekommt
	 * oder nicht
	 * discount Methode gibt den Gesamtpreis
	 * mit Rabbat oder auch ohne Rabatt
	 * Rabatt
	 * @return
	 */
	private int getBrutto =0;
	private int total=0;
	private int total_mit_discount=0;
	public int discount(Product product) {
		for(OrderPosition op : orderPos) {
			total += op.getProduct().getPrice();
		}
		if(total >= 100000) {
			 total_mit_discount =(total*5)/100;
			 getBrutto = total_mit_discount+(int)(total_mit_discount / 100.0 * product.getTax() );
			 return total_mit_discount+(int)(total_mit_discount / 100.0 * product.getTax() );
		}
		return total+(int)(total / 100.0 * product.getTax() );
	
	
	}


	/**
	 * 
	 * @param status
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	/**
	 * gibt status zurück
	 * @return status
	 */
	public OrderStatus getStatus() {
		return this.status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Customer createCustomer() {
		
		//String[] kundenEntitaet = db.getCustomer();
		
		
		
	}
	
	public void insertCustomer() {
		
		//db.insertCustomer();
		
	}
	
	

}
























