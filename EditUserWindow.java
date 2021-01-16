import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;

public class EditUserWindow implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel userTypeL;
	private JComboBox userTypeC;
	
	private JButton changeUsernameB;
	private JButton changePasswordB;
	
	private String[] userTypeChoices = {"Admin", "Seller"};
	
	public EditUserWindow() {
		// Initialize variables
		frame = new JFrame();
		
		userTypeL = new JLabel("User Type");
		userTypeC = new JComboBox(userTypeChoices);
		
		changeUsernameB = new JButton("Change Username");
		changePasswordB = new JButton("Change Password");
		
		// Register button
		changeUsernameB.addActionListener(this);
		changePasswordB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(2, 2);
		frame.setLayout(g);
		
		// Add components in frame
		frame.add(userTypeL);
		frame.add(userTypeC);
		frame.add(changeUsernameB);
		frame.add(changePasswordB);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(300, 150);
		frame.setLocation(500,250);
		frame.setTitle("Edit User ID");
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == changeUsernameB) { // Change Username button clicked
			if(userTypeC.getSelectedItem().toString().equals(userTypeChoices[0])) { // Account type Admin selected
				ChangeAdminUsername name = new ChangeAdminUsername();
				frame.setVisible(false);
			}
			if(userTypeC.getSelectedItem().toString().equals(userTypeChoices[1])) { // Account type Seller selected
				ChangeSellerUsername name = new ChangeSellerUsername();
				frame.setVisible(false);
			}
		}
		if(e.getSource() == changePasswordB) { // Change Password button clicked
			if(userTypeC.getSelectedItem().toString().equals(userTypeChoices[0])) { // Account type Admin selected
				ChangeAdminPassword password = new ChangeAdminPassword();
				frame.setVisible(false);
			}
			if(userTypeC.getSelectedItem().toString().equals(userTypeChoices[1])) { // Account type Seller selected
				ChangeSellerPassword passsword = new ChangeSellerPassword();
				frame.setVisible(false);
			}
		}
	}
}
