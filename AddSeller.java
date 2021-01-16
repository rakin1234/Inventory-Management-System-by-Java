import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class AddSeller implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel nameL;
	private JTextField nameT;
	
	private JLabel ageL;
	private JTextField ageT;
	
	private JLabel genderL;
	private JComboBox genderC;
	
	private JLabel phoneNumberL;
	private JTextField phoneNumberT;
	
	private JLabel salaryL;
	private JTextField salaryT;
	
	private JLabel appointedOnL;
	private JTextField appointedOnT;
	
	private JButton addB;
	
	private int totalSalary;
	private int totalSeller;
	
	public AddSeller() {
		// Initialize variables
		frame = new JFrame();
		
		nameL = new JLabel("Seller Name");
		nameT = new JTextField();
		
		ageL = new JLabel("Age");
		ageT = new JTextField();
		
		genderL = new JLabel("Gender");
		String[] gender = {"Male", "Female"};
		genderC = new JComboBox(gender);
		
		phoneNumberL = new JLabel("Phone Number(Excluding 0)");
		phoneNumberT = new JTextField();
		
		salaryL = new JLabel("Salary");
		salaryT = new JTextField();
		
		appointedOnL = new JLabel("Appointed On");
		appointedOnT = new JTextField();
		
		addB = new JButton("Add");
		
		// Register button
		addB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(7, 2);
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
		
		frame.add(salaryL);
		frame.add(salaryT);
		
		frame.add(appointedOnL);
		frame.add(appointedOnT);
		
		frame.add(addB);
		
		appointedOnT.setText(new Date().toString());
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(800, 400);
		frame.setLocation(275, 180);
		frame.setTitle("Add Sller");
		
		readFromFile();
	}
	
	public void readFromFile(){
		try {
			File x1 = new File("totalsalary.txt");
			File x2 = new File("totalsellers.txt");
			
			Scanner y1 = new Scanner(x1);
			Scanner y2 = new Scanner(x2);
			
			while(y1.hasNextLine()) {
				String preTotalSalary = y1.nextLine(); // read previous total salary cost per month
				totalSalary = Integer.parseInt(preTotalSalary);
			}
			
			while(y2.hasNextLine()) {
				String preTotalSellers = y2.nextLine(); // read previous number of total sellers
				totalSeller = Integer.parseInt(preTotalSellers);
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addB) { // Add button clicked
			try {
				// Added Seller info
				String s = nameT.getText();
				int d1 = Integer.parseInt(ageT.getText());
				String z = genderC.getSelectedItem().toString();
				int d3 = Integer.parseInt(phoneNumberT.getText());
				int d4 = Integer.parseInt(salaryT.getText());
				
				int newTotalSalary = totalSalary + d4; // Increase total salary cost
				int newTotalSeller = totalSeller + 1; // Increase total seller number
				
				Seller y = new Seller(s, d1, z, d4, d3);
				try{
					// Write seller info in files
					FileWriter f1 = new FileWriter("sellers.txt", true);
					FileWriter f2 = new FileWriter("totalsalary.txt");
					FileWriter f3 = new FileWriter("totalsellers.txt");
					
					f1.write(y.getName());
					f1.write("\n");
					f1.write(y.getAge() + "");
					f1.write("\n");
					f1.write(y.getGender());
					f1.write("\n");
					f1.write(y.getSalary() + "");
					f1.write("\n");
					f1.write(y.getPhoneNumber() + "");
					f1.write("\n");
					f1.close();
					
					f2.write(newTotalSalary + "");
					f2.close();
					
					f3.write(newTotalSeller + "");
					f3.close();
				}
				catch(Exception ex){
					System.out.println(ex);
				}
				Added q = new Added(); // Show successfully added
				frame.setVisible(false);
			}
			catch(Exception ex) {
				EmptyFields t = new EmptyFields(); // Open empty fields window if item adding info fields are empty
			}
		}
	}
}
