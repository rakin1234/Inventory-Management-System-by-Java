import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class ChangeAdminUsername implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel userNameL;
	private JTextField userNameT;
	
	private JButton submitB;
	
	public ChangeAdminUsername() {
		// nitialize variables
		frame = new JFrame();
		
		userNameL = new JLabel("New Username");
		userNameT = new JTextField();
		
		submitB = new JButton("Submit");
		
		// Register button
		submitB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(2, 2);
		frame.setLayout(g);
		
		// Add componentes in frame
		frame.add(userNameL);
		frame.add(userNameT);
		frame.add(submitB);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(350, 175);
		frame.setLocation(505, 255);
		frame.setTitle("Change Admin Username");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitB) { // Submit button clicked
			try {
				String t = userNameT.getText();
				AdminId i = new AdminId();
				i.changeUsername(t);
				try{
					FileWriter f = new FileWriter("admin_username.txt"); // Store new username in file
					f.write(i.getUsername());
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
