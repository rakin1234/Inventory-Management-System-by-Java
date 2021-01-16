import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class LogInWindow implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel accountTypeL;
	private JComboBox accountTypeC;
	
	private JLabel usernameL;
	private JTextField usernameT;
	
	private JLabel passwordL;
	private JPasswordField passwordP;
	
	private JButton logInB;
	
	private AdminId x1;
	private SellerId x2;
	private String[] accountTypeChoices = {"Admin", "Seller"};
	
	public LogInWindow() {
		// Initialize variables
		frame = new JFrame();
		
		accountTypeL = new JLabel("Account Type");
		accountTypeC = new JComboBox(accountTypeChoices);
		
		usernameL = new JLabel("Username");
		usernameT = new JTextField();
		
		passwordL = new JLabel("Password");
		passwordP = new JPasswordField();
		
		logInB = new JButton("Log In");
		
		// Register button
		logInB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(4, 2);
		frame.setLayout(g);
		
		// Add components in frame
		frame.add(accountTypeL);
		frame.add(accountTypeC);
		
		frame.add(usernameL);
		frame.add(usernameT);
		
		frame.add(passwordL);
		frame.add(passwordP);
		
		frame.add(logInB);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 250);
		frame.setLocation(440, 250);
		frame.setTitle("Inventory Management System");
		
		readFromFile();
	}
	
	public void readFromFile(){
		try {
			File f1 = new File("admin_username.txt");
			File f2 = new File("admin_password.txt");
			File f3 = new File("seller_username.txt");
			File f4 = new File("seller_password.txt");
			
			Scanner s1 = new Scanner(f1);
			Scanner s2 = new Scanner(f2);
			Scanner s3 = new Scanner(f3);
			Scanner s4 = new Scanner(f4);
			
			while(s1.hasNextLine()) {
				String a = s1.nextLine(); // Read Admin Username
				
				while(s2.hasNextLine()) {
					String b = s2.nextLine(); // Read Admin Password
					x1 = new AdminId(a, b);
				}	
			}
			
			while(s3.hasNextLine()) {
				String a = s3.nextLine();// Read Seller Username
				
				while(s4.hasNextLine()) {
					String b = s4.nextLine(); // Read Seller Password
					x2 = new SellerId(a, b);
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logInB) { // Log In button clicked
			try {
				if(accountTypeC.getSelectedItem().toString().equals(accountTypeChoices[0])) { // Account type Admin selected
					// Check if Username & Password match
					if(usernameT.getText().equals(x1.getUsername()) && String.valueOf(passwordP.getPassword()).equals(x1.getPassword())) {
						frame.setVisible(false);
						Home b = new Home(); // Open Homepage
					}
					else {
						Invalid j = new Invalid(); // Show Invalid Username or Password
					}
				}
				
				if(accountTypeC.getSelectedItem().toString().equals(accountTypeChoices[1])) { // Account type Seller selected
					// Check if Username & Passeord match
					if(usernameT.getText().equals(x2.getUsername()) && String.valueOf(passwordP.getPassword()).equals(x2.getPassword())) {
						frame.setVisible(false);
						SearchAndSellItemWindowForSeller c = new SearchAndSellItemWindowForSeller(); // Open Search & Sell Item Window
					}
					else {
						Invalid j = new Invalid(); // Show Invalid Username & Password
					}
				}
			}
			catch(Exception ex) {
				EmptyFields k = new EmptyFields(); // Show empty fields
			}
		}
	}
}
