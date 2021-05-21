import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Menu {

	private JFrame frame;
	
	private JButton btnProductManagement;
	private JButton btnMachineControl;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 461, 242);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnProductManagement = new JButton("Productverwaltung");
		btnProductManagement.setBounds(41, 55, 132, 73);
		frame.getContentPane().add(btnProductManagement);
		
		btnMachineControl = new JButton("Machinesteuerung");
		btnMachineControl.setBounds(242, 55, 132, 73);
		frame.getContentPane().add(btnMachineControl);
	}

}
