import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class ChangeSellerPassword implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel passwordL;
	private JTextField passwordT;
	
	private JButton submitB;
	
	public ChangeSellerPassword() {
		// Initialize variables
		frame = new JFrame();
		
		passwordL = new JLabel("New Password");
		passwordT = new JTextField();
		
		submitB = new JButton("Submit");
		
		// Register button
		submitB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(2, 2);
		frame.setLayout(g);
		
		// Add components in frame
		frame.add(passwordL);
		frame.add(passwordT);
		frame.add(submitB);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(350, 175);
		frame.setLocation(505, 255);
		frame.setTitle("Change Seller Password");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitB) { // Submit button clicked
			try {
				String t = passwordT.getText();
				SellerId i = new SellerId();
				i.changePassword(t);
				try{
					FileWriter f = new FileWriter("seller_password.txt");
					f.write(i.getPassword() + ""); // Store new password in file
					f.close();
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			}
			catch(Exception ex) {
				EmptyFields wm = new EmptyFields();
			}
			Done done = new Done();
			frame.setVisible(false);
		}
	}
}
