import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.util.*;

public class SetOwner implements ActionListener{
	// Declaer variables
	private JFrame frame;
	
	private JLabel nameL;
	private JTextField nameT;
	
	private JLabel ageL;
	private JTextField ageT;
	
	private JLabel genderL;
	private JComboBox genderC;
	
	private JLabel phoneNumberL;
	private JTextField phoneNumberT;
	
	private JButton setB;
	
	public SetOwner() {
		// Initialize variables
		frame = new JFrame();
		
		nameL = new JLabel("Name");
		nameT = new JTextField();
		
		ageL = new JLabel("Age");
		ageT = new JTextField();
		
		genderL = new JLabel("Gender");
		String[] gender = {"Male", "Female"};
		genderC = new JComboBox(gender);
		
		phoneNumberL = new JLabel("Phone Number(Excluding 0)");
		phoneNumberT = new JTextField();
		
		setB = new JButton("Set");
		
		// Register button
		setB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(5, 2);
		frame.setLayout(g);
		
		// Add components in frame
		frame.add(nameL);
		frame.add(nameT);
		
		frame.add(ageL);
		frame.add(ageT);
		
		frame.add(genderL);
		frame.add(genderC);
		
		frame.add(phoneNumberL);
		frame.add(phoneNumberT);
		
		frame.add(setB);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(800, 400);
		frame.setLocation(380, 190);
		frame.setTitle("Set Owner");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == setB) {
			try {
				// Owner info
				String s = nameT.getText();
				int d1 = Integer.parseInt(ageT.getText());
				String z = genderC.getSelectedItem().toString();
				int d3 = Integer.parseInt(phoneNumberT.getText());
				Owner y = new Owner(s, d1, z, d3);
				int d4 = y.phoneNumber(d3);
				try{
					// Write owner info in file
					FileWriter f = new FileWriter("owner.txt");
					f.write(y.getName() + "\n" + y.getAge() + "\n" + y.getGender() + "\n" + y.getPhone());
					f.close();
				}
				catch(Exception ex){
					System.out.println(ex);
				}
				Done done = new Done();
				frame.setVisible(false);
			}
			catch(Exception ex) {
				EmptyFields h = new EmptyFields();
			}
		}
	}
}
