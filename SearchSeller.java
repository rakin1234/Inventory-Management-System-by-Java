import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class SearchSeller implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel nameL;
	private JTextField nameT;
	
	private JButton searchB;
	private JTextField searchT;
	
	private Seller[] sellers;
	
	public SearchSeller() {
		// Initialize variables
		sellers = new Seller[50]; // since we don't know the exact number of items, initialize the array to a reasonably sized one
		
		frame = new JFrame();
		
		nameL = new JLabel("Enter name to search");
		nameT = new JTextField();
		
		searchB = new JButton("Search");
		searchT = new JTextField();
		
		// Register button
		searchB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(2, 2);
		frame.setLayout(g);
		
		//Add components in frame
		frame.add(nameL);
		frame.add(nameT);
		frame.add(searchB);
		frame.add(searchT);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setLocation(500, 250);
		frame.setTitle("Search Seller");
		
		readFromFile();
	}
	
	// Read seller info from file & store into an array
	public void readFromFile(){
		try {
			File f = new File("sellers.txt");
			Scanner s = new Scanner(f);
			int i = 0;
			
			while(s.hasNextLine()){
				String a = s.nextLine(); // Read name
				String b = s.nextLine(); // Read age
				int h = Integer.parseInt(b);
				String c = s.nextLine(); // Read gender
				String d = s.nextLine(); // Read Salary
				int z = Integer.parseInt(d);
				String e = s.nextLine(); // Read phone number
				int u = Integer.parseInt(e);
				Seller temp = new Seller(a, h, c, z, u);
				sellers[i] = temp;
				i++;
			}
		}
		catch (Exception e) {
			searchT.setText("");
		}
	}
	
	// Search seller
	public Seller findSeller(String key){
		Seller s = null;
		for(int i = 0; i < sellers.length; i++){
			if(sellers[i] != null && sellers[i].getName().equals(key)) { // Name matches
				s = sellers[i];
				break;
			}
		}
		return s;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchB){ // Search button clicked
			try {
				String i = nameT.getText();
				Seller found = findSeller(i); // Search seller
				
				if(found != null){
					searchT.setText(found.toString()); // Show found seller
				}
				else{
					searchT.setText("Not found!");
				}
			}
			catch(Exception ex) {
				EmptyFields w = new EmptyFields(); // Show empty fields
			}
		}
	}
}
