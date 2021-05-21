import java.awt.Color;

import javax.swing.JTextField;

public class Helper {
	//TODO
	public static final int intValueOf(String string) {
		
		int value = 0;
		
		try {
			value = Integer.valueOf(string);
		}
		catch(NumberFormatException e) {
			return -1;
		}
		
		return value;
	}
	
	
	
	public static final boolean checkNumberInput(JTextField txtField, int maxLength) {
			
		boolean b = true;
		int value = 0;
		try {
			value = Integer.valueOf(txtField.getText());
		}
		catch(NumberFormatException e) {
			b = false;
			txtField.setText("");
			txtField.setBackground(Color.RED);
			return b;
		}
		if( maxLength <= txtField.getText().length() && value > 0) {
			b = false;
			txtField.setText("");
			txtField.setBackground(Color.RED);
		}
		return b;
	}
	
	public static final boolean isChar(JTextField txtField, int maxLength) {
		
		String string = txtField.getText();
		boolean b = false ;
		
			for(int i =0; i < string.length(); i++) {
				if(Character.isLetter(string.charAt(i))) {
					b = true;
				}else {
					b = false;
					txtField.setText("");
					txtField.setBackground(Color.RED);
					break;
				}
			}
			if( maxLength <= string.length()) {
				b = false;
				txtField.setText("");
				txtField.setBackground(Color.RED);
			}
			return b;

	}
	
	public static final boolean checkEmail(JTextField txtField, int maxLength) {
		boolean b = false ;
		String email = txtField.getText().trim();

    	if(( (email.endsWith(".com") || email.endsWith(".net") || email.endsWith(".de"))&& (email.indexOf("@") != -1) ) && maxLength > email.length() ) {
    		
    		return b;
    		
    	}
    	else {
    		txtField.setText("");
			txtField.setBackground(Color.RED);
    		return b;
    		
    	}

}
	
}
