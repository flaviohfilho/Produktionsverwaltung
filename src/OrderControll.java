import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

/**
 * 
 * @author malvah/Dennis
 *
 */

public class OrderControll {
	private OrderView view;
	private OrderModel model;
	
	private boolean viewSwitch;
	
	private boolean inputSwitch;
	
	
	/**
	 * Um TextFelder leer zu machen
	 * @return
	 */
	public void reset() {
		
		
		view.getTxtFirstname.setText("");
		view.getTxtLastname.setText("");
		view.getTxtStreet.setText("");
		view.getTxtHousnumber.setText("");
		view.getTxtZip.setText("");
		view.getTxtCity.setText("");
		view.getTxtMail.setText("");
		view.getTxtTel.setText("");
		view.getTxtAmount.setText("");
		view.getInformationList.clear();
		
	}
	
	/**
	 * Eingabe überprüfung
	 */
	public boolean inputCheck() {
		
	   JTextField firstname = view.getTxtFirstname();
	  if(!Helper.isChar(firstname, 20))
		  return false;
	  
	   JTextField lastname = view.getTxtLastname();
	   if( !Helper.isChar(lastname, 20))
		   return false;
	   
	   JTextField street = view.getTxtStreet();
	   if(!Helper.isChar(street,35))
		   return false;
	   
	   JTextField number = view.getTxtHouseNumber();
	   if(!Helper.isChar(number,4))
		   return false;
	   
	   JTextField zip = view.getTxtZip();
	   if(!Helper.checkNumberInput(zip,5))
		   return false;
	   
	   JTextField city = view.getTxtCity();
	   if(!Helper.isChar(city,20))
		   return false;
	   
	   JTextField tel = view.getTxtTel();
	   if(!Helper.checkNumberInput(tel,20))
		   return false;
	   
	   JTextField email = view.getTxtMail();
	   if(!Helper.checkEmail(email,100))
		   return false;
	   
	   JTextField amount = view.getTxtAmount.getText();
	   if(!Helper.checkNumberInput(amount, 10))
		   return false;
	   
	   return true;
	   
	}
	
	
	
	
	/**
	 * Alle Button-Daten in Liste hinzufügen
	 * @author malvah/ Dennis
	 *
	 */
	class insertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(inputCheck()) {
			// TODO Auto-generated method stub
				ArrayList<String> entries = new ArrayList<>();
				entries.add(view.getTxtFirstname.getText());
				entries.add(view.getTxtLastname.getText());
				entries.add(view.getTxtStreet.getText());
				entries.add(view.getTxtHouseNumber.getText());
				entries.add(view.getTxtZip.getText());
				entries.add(view.getTxtCity.getText());
				entries.add(view.getTxtTel.getText());
				entries.add(view.getTxtMail.getText());
				entries.add(view.getTxtAmount.getText());
				
				for(int i = 0; i< entries.size(); i++) {
					view.getInformationList().setInformationList( entries.get(i));
				}
			}
			
			
			
		}
		
		
		
		
	}
	
	
	/**
	 * um Liste und TextField leer zu machen
	 * @author malvah/Dennis
	 *
	 */
	class resetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			reset();
			
			//TODO InformationList leeren

			
		}
	}
	
	/**
	 * Alle gespeicherte Bestellung anzeigen lassen
	 * wird viewSwitch an
	 * @author malvah/Dennis
	 *
	 */
		class ShowOrder implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//alle Bestellung aus Datenbank in InormationListener anzeigen lassen
				
			}
			
		}
		
		
		/**
		 * wenn viewSwitch an ist 
		 * kann man änderung in Bestellung machen
		 * @author malvah/Dennis
		 *
		 */
		class changeListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int orderId = Helper.intValueOf(view.model.getSelectedEntry().split()[0]);
				//OrderModell order = new Order aus Datenbank;
				//if( order.getStatus() == WAITINGLIST )
				// TODO Warteliste runter und 
				//viewSwitch auf false setzen
				
				
				
			}
			
		}
		
		
		/**
		 *  wenn viewSwitch an ist 
		 * kann man stornieren in Bestellung machen
		 * @author malvah/Dennis
		 *
		 */
		class Cancel implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//die Bestellung aus DB löshen
				//viewSwitch auf false setzen
			}
			
		}
		
		
}
