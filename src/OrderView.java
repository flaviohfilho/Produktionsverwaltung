import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderView {

	private JFrame frame;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtHouseNumber;
	private JTextField txtStreet;
	private JTextField txtEmail;
	private JTextField txtTel;
	private JTextField txtCity;
	private JTextField txtZip;
	private JTextField textAmount;
	private JTextField txtOrderID;
	private JTextField txtCustomerID;
	
	private JButton btnToOrder;
	private JButton btnOrderOverview;
	private JButton btnInsert;
	private JButton btnReset;
	private JButton btnCancel;
	private JButton btnChange;
	private JButton btnOrderID;
	private JButton btnCustomerID;
	private JButton btnMachineControl;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderView window = new OrderView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public OrderView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 1005, 712);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstname = new JLabel("Vorname:");
		lblFirstname.setBounds(29, 35, 85, 27);
		frame.getContentPane().add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Nachname:");
		lblLastname.setBounds(29, 73, 85, 27);
		frame.getContentPane().add(lblLastname);
		
		JLabel lblStreet = new JLabel("Stra\u00DFe:");
		lblStreet.setBounds(29, 113, 85, 27);
		frame.getContentPane().add(lblStreet);
		
		JLabel lblCity = new JLabel("Ort:");
		lblCity.setBounds(29, 226, 85, 27);
		frame.getContentPane().add(lblCity);
		
		JLabel lblZip = new JLabel("PLZ:");
		lblZip.setBounds(29, 186, 85, 27);
		frame.getContentPane().add(lblZip);
		
		JLabel lblHouseNumber = new JLabel("Hausnummer:");
		lblHouseNumber.setBounds(29, 148, 85, 27);
		frame.getContentPane().add(lblHouseNumber);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(29, 264, 85, 27);
		frame.getContentPane().add(lblTel);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(29, 302, 85, 27);
		frame.getContentPane().add(lblEmail);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(108, 38, 114, 20);
		frame.getContentPane().add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBounds(108, 76, 114, 20);
		frame.getContentPane().add(txtLastname);
		
		txtHouseNumber = new JTextField();
		txtHouseNumber.setColumns(10);
		txtHouseNumber.setBounds(108, 149, 114, 20);
		frame.getContentPane().add(txtHouseNumber);
		
		txtStreet = new JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(108, 111, 114, 20);
		frame.getContentPane().add(txtStreet);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(108, 309, 114, 20);
		frame.getContentPane().add(txtEmail);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(108, 271, 114, 20);
		frame.getContentPane().add(txtTel);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(108, 233, 114, 20);
		frame.getContentPane().add(txtCity);
		
		txtZip = new JTextField();
		txtZip.setColumns(10);
		txtZip.setBounds(108, 195, 114, 20);
		frame.getContentPane().add(txtZip);
		
		JPanel panel = new JPanel();
		panel.setBounds(387, 35, 371, 105);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel ProductName = new JLabel("Produktname");
		ProductName.setBounds(71, 11, 67, 26);
		panel.add(ProductName);
		
		JLabel lblAmount = new JLabel("Menge");
		lblAmount.setBounds(200, 11, 67, 26);
		panel.add(lblAmount);
		
		JComboBox productName = new JComboBox();
		productName.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		productName.setBounds(71, 40, 67, 22);
		panel.add(productName);
		
		textAmount = new JTextField();
		textAmount.setBounds(197, 41, 76, 20);
		panel.add(textAmount);
		textAmount.setColumns(10);
		
		JComboBox paymentMethod = new JComboBox();
		paymentMethod.setModel(new DefaultComboBoxModel(new String[] {"\u00DCberweisung", "Barzahlung"}));
		paymentMethod.setBounds(29, 379, 190, 40);
		frame.getContentPane().add(paymentMethod);
		
		JLabel lblPaymentMathod = new JLabel("Zahlungsart");
		lblPaymentMathod.setBounds(29, 357, 85, 11);
		frame.getContentPane().add(lblPaymentMathod);
		
		JComboBox shippingOption = new JComboBox();
		shippingOption.setModel(new DefaultComboBoxModel(new String[] {"Abholen", "Liefern"}));
		shippingOption.setBounds(29, 467, 190, 40);
		frame.getContentPane().add(shippingOption);
		
		JLabel lblShippingOption = new JLabel("Versandoption");
		lblShippingOption.setBounds(29, 445, 85, 11);
		frame.getContentPane().add(lblShippingOption);
		
		JLabel lblOrderID = new JLabel("Bestellnummer");
		lblOrderID.setBounds(29, 536, 98, 11);
		frame.getContentPane().add(lblOrderID);
		
		txtOrderID = new JTextField();
		txtOrderID.setBounds(115, 531, 71, 20);
		frame.getContentPane().add(txtOrderID);
		txtOrderID.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(287, 159, 642, 388);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel informationList = new JPanel();
		informationList.setBounds(10, 11, 622, 366);
		panel_1.add(informationList);
		informationList.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(0, 0, 622, 366);
		informationList.add(list);
		
		btnToOrder = new JButton("Bestellen");
		btnToOrder.setBounds(25, 598, 89, 64);
		frame.getContentPane().add(btnToOrder);
		
		btnOrderOverview = new JButton("Bestell\u00FCbersicht");
		btnOrderOverview.setBounds(133, 598, 107, 64);
		frame.getContentPane().add(btnOrderOverview);
		
		btnInsert = new JButton("Einf\u00FCgen");
		btnInsert.setBounds(287, 558, 114, 51);
		frame.getContentPane().add(btnInsert);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(439, 558, 107, 51);
		frame.getContentPane().add(btnReset);
		
		btnCancel = new JButton("Stornieren");
		btnCancel.setBounds(824, 558, 98, 51);
		frame.getContentPane().add(btnCancel);
		
		btnChange = new JButton("\u00C4ndern");
		btnChange.setBounds(683, 558, 98, 51);
		frame.getContentPane().add(btnChange);
		
		JLabel lblProduct = new JLabel("Produkt");
		lblProduct.setBounds(548, 11, 60, 20);
		frame.getContentPane().add(lblProduct);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setColumns(10);
		txtCustomerID.setBounds(115, 558, 71, 20);
		frame.getContentPane().add(txtCustomerID);
		
		JLabel lblCustomerID = new JLabel("Kundennummer");
		lblCustomerID.setBounds(29, 563, 74, 11);
		frame.getContentPane().add(lblCustomerID);
		
		btnOrderID = new JButton("suchen");
		btnOrderID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrderID.setBounds(196, 530, 71, 23);
		frame.getContentPane().add(btnOrderID);
		
		btnCustomerID = new JButton("suchen");
		btnCustomerID.setBounds(196, 558, 71, 23);
		frame.getContentPane().add(btnCustomerID);
		
		btnMachineControl = new JButton("Machinesteuerung");
		btnMachineControl.setBounds(802, 61, 127, 51);
		frame.getContentPane().add(btnMachineControl);
	}
}
