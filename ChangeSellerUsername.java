import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class ChangeSellerUsername implements ActionListener {
	// Declare varables
	private JFrame frame;
	
	private JLabel userNameL;
	private JTextField userNameT;
	
	private JButton submitB;
	
	public ChangeSellerUsername() {
		// Initialize variables
		frame = new JFrame();
		
		userNameL = new JLabel("New Username");
		userNameT = new JTextField();
		
		submitB = new JButton("Submit");
		
		// Register button
		submitB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(2, 2);
		frame.setLayout(g);
		
		// Add components in frame
		frame.add(userNameL);
		frame.add(userNameT);
		frame.add(submitB);
		
		// Set frame characyeristics
		frame.setVisible(true);
		frame.setSize(350, 175);
		frame.setLocation(505, 255);
		frame.setTitle("Change Seller Username");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitB) { // Submit button clicked
			try {
				String t = userNameT.getText();
				SellerId i = new SellerId();
				i.changeUsername(t);
				try{
					FileWriter f = new FileWriter("seller_username.txt");
					f.write(i.getUsername()); // Store new username in file
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
