import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class RemoveSeller implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel nameL;
	private JTextField nameT;
	
	private JButton searchB;
	private JTextField searchT;
	
	private JButton removeB;
	
	private Seller[] sellers;
	private int totalSalary;
	private int totalSeller;
	
	public RemoveSeller() {
		// Initialize variables
		sellers = new Seller[50]; // since we don't know the exact number of items, initialize the array to a reasonably sized one
		
		frame = new JFrame();
		
		nameL = new JLabel("Enter name to search");
		nameT = new JTextField();
		
		searchB = new JButton("Search");
		searchT = new JTextField();
		
		removeB =new JButton("Remove");
		
		// Register buttons
		searchB.addActionListener(this);
		removeB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(3, 2);
		frame.setLayout(g);
		
		// Add components in frame;
		frame.add(nameL);
		frame.add(nameT);
		frame.add(searchB);
		frame.add(searchT);
		frame.add(removeB);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(500, 250);
		frame.setLocation(500, 250);
		frame.setTitle("Remove Seller");
		
		readFromFile();
	}
	
	// Read seller info from file & store into an array
	public void readFromFile(){
		try {
			File f1 = new File("sellers.txt");
			File f2 = new File("totalsalary.txt");
			File f3 = new File("totalsellers.txt");
			
			Scanner s1 = new Scanner(f1);
			Scanner s2 = new Scanner(f2);
			Scanner s3 = new Scanner(f3);
			int i = 0;
			
			while(s1.hasNextLine()){
				String a = s1.nextLine(); // Read name
				String b = s1.nextLine(); // Read age
				int h = Integer.parseInt(b);
				String c = s1.nextLine(); //Read gender
				String d = s1.nextLine(); // Read salary
				int z = Integer.parseInt(d);
				String e = s1.nextLine(); // Read phone number
				int u = Integer.parseInt(e);
				Seller temp = new Seller(a, h, c, z, u);
				sellers[i] = temp;
				i++;
			}
			
			while(s2.hasNextLine()) {
				String preTotalSalary = s2.nextLine(); // read previous total salary cost per month
				totalSalary = Integer.parseInt(preTotalSalary);
			}
			
			while(s3.hasNextLine()) {
				String preTotalSellers = s3.nextLine(); // read previous number of total sellers
				totalSeller = Integer.parseInt(preTotalSellers);
			}
		}
		catch (Exception e) {
			searchT.setText("");
		}
	}
	
	// Write seller info in file from array
	public void writeToFile() {
		try {
			File f = new File("sellers.txt");
			FileWriter fw = new FileWriter(f);
			
			for(int i = 0; i < sellers.length; i++){
				if(sellers[i] != null){
					fw.write(sellers[i].getName());
					fw.write("\n");
					fw.write(sellers[i].getAge() + "");
					fw.write("\n");
					fw.write(sellers[i].getGender());
					fw.write("\n");
					fw.write(sellers[i].getSalary() + "");
					fw.write("\n");
					fw.write(sellers[i].getPhoneNumber() + "");
					fw.write("\n");
				}
			}
			fw.close();
		}
		catch (Exception e) {
			System.out.println(e);
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
	
	// Remove seller
	public void removeSeller(String key){
		for(int i = 0; i < sellers.length; i++){
			if(sellers[i] != null && sellers[i].getName().equals(key)) { // Name matches
				sellers[i] = null;
				break;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Seller found = null;
		if(e.getSource() == searchB) { // Search button clicked
			try {
				String i = nameT.getText();
				found = findSeller(i);
				
				if(found != null){
					searchT.setText(found.toString());
				}
				else{
					searchT.setText("Not found!");
				}
			}
			catch(Exception ex) {
				EmptyFields em = new EmptyFields(); // Open empty fields window if seller info fields are empty
			}
		}
		if(e.getSource() == removeB) { // Remove button clicked
			try {
				String i = nameT.getText();
				Seller found2 = findSeller(i);
				
				int newTotalSalary = totalSalary - found2.getSalary();
				int newTotalSeller = totalSeller - 1;
				
				removeSeller(i);
				writeToFile();
				
				try {
					FileWriter fw1 = new FileWriter("totalsalary.txt");
					fw1.write(newTotalSalary + "");
					fw1.close();
					
					FileWriter fw2 = new FileWriter("totalsellers.txt");
					fw2.write(newTotalSeller + "");
					fw2.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
				
				Removed re = new Removed(); // Show removed successfully
				frame.setVisible(false);
			}
			catch(Exception ex) {
				NotFound nf = new NotFound(); // Open empty fields window if seller info fields are empty
			}
		}
	}
}
