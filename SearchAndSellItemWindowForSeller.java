import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class SearchAndSellItemWindowForSeller implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel nameL;
	private JTextField nameT;
	
	private JButton searchB;
	private JTextField searchT;
	
	private JLabel priceL;
	private JTextField priceT;
	
	private JLabel cuNameL;
	private JTextField cuNameT;
	
	private JButton sellB;
	
	private Item[] items;
	private int totalItems;
	private int totalRevenue;
	private int totalSoldItems;
	
	public SearchAndSellItemWindowForSeller() {
		//Initialize variables
		items= new Item[50]; // since we don't know the exact number of items, initialize the array to a reasonably sized one
		
		frame = new JFrame();
		
		nameL = new JLabel("Enter name to search");
		nameT = new JTextField();
		
		searchB = new JButton("Search");
		searchT = new JTextField();
		
		priceL = new JLabel("Price");
		priceT = new JTextField();
		
		cuNameL = new JLabel("Customer Name");
		cuNameT = new JTextField();
		
		sellB = new JButton("Sell");
		
		// Register buttons
		searchB.addActionListener(this);
		sellB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(5, 2);
		frame.setLayout(g);
		
		// Add components in frame
		frame.add(nameL);
		frame.add(nameT);
		frame.add(searchB);
		frame.add(searchT);
		frame.add(priceL);
		frame.add(priceT);
		frame.add(cuNameL);
		frame.add(cuNameT);
		frame.add(sellB);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setLocation(400, 200);
		frame.setTitle("Search & Sell Item");
		
		readFromFile();
	}
	
	// Read File & store in an array
	public void readFromFile(){
		try {
			File f1 = new File("items.txt");
			File f2 = new File("totalrevenue.txt");
			File f3 = new File("totalsolditems.txt");
			File f4 = new File("totalitems.txt");
			Scanner s1 = new Scanner(f1);
			Scanner s2 = new Scanner(f2);
			Scanner s3 = new Scanner(f3);
			Scanner s4 = new Scanner(f4);
			int i = 0;
			
			while(s1.hasNextLine()){
				String a = s1.nextLine(); // Read name;
				String b = s1.nextLine(); // Read buy price
				int z = Integer.parseInt(b);
				String c = s1.nextLine(); // Read sell price
				int u = Integer.parseInt(c);
				Item temp = new Item(a, z, u); // Create Item object
				items[i] = temp; // Add item in array
				i++;
			}
			
			while(s2.hasNextLine()){
				String a = s2.nextLine(); // Read previous revenue
				totalRevenue = Integer.parseInt(a);
			}
			
			while(s3.hasNextLine()){
				String a = s3.nextLine(); // Read the number of total sold items
				totalSoldItems = Integer.parseInt(a);
			}
			
			while(s4.hasNextLine()){
				String a = s4.nextLine(); // Read the number of total remaining items
				totalItems = Integer.parseInt(a);
			}
		}
		catch (Exception e) {
			searchT.setText("");
		}
	}
	
	// Write in Files from array
	public void writeToFile(){
		try {
			File f = new File("items.txt");
			FileWriter fw = new FileWriter(f);
			
			for(int i = 0; i < items.length; i++){
				if(items[i] != null){
					fw.write(items[i].getName()); // Write name
					fw.write("\n");
					fw.write(items[i].getBuyPrice() + ""); // Write Buying Price
					fw.write("\n");
					fw.write(items[i].getSellPrice() + ""); // Write Selling Price
					fw.write("\n");
				}
			}
			fw.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Item findItem(String key){
		Item s = null;
		for(int i = 0; i < items.length; i++){
			if(items[i] != null && items[i].getName().equals(key)){ // Match found
				s = items[i];
				break;
			}
		}
		return s;
	}
	
	// Remove Item
	public void removeItem(String key){
		for(int i = 0; i < items.length; i++){
			if(items[i] != null && items[i].getName().equals(key) == true){ //name matches
				items[i] = null;
				break;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchB) { // Search button clicked
			try {
				String i = nameT.getText();
				Item found = findItem(i); // Search item
				
				if(found != null){
					searchT.setText(found.toString()); // Show found item
				}
				
				else{
					searchT.setText("Not found!");
				}
			}
			catch(Exception ex) {
				EmptyFields w = new EmptyFields(); // Show empty fields
			}
		}
		if(e.getSource() == sellB) { // Sell button clicked
			try {
				// Item selling info
				String s1 = nameT.getText();
				Item found2 = findItem(s1);
				
				int newTotalItems = totalItems - 1;
				
				removeItem(s1);
				writeToFile();
				
				String s2 = priceT.getText();
				int in = Integer.parseInt(s2);
				int newTotalRevenue = totalRevenue + in;
				
				String s3 = cuNameT.getText();
				int newTotalSoldItems = totalSoldItems + 1;
				try {
					// Write item selling info in File
					FileWriter f1 = new FileWriter("solditems.txt", true);
					FileWriter f2 = new FileWriter("totalrevenue.txt");
					FileWriter f3 = new FileWriter("totalsolditems.txt");
					FileWriter f4 = new FileWriter("totalitems.txt");
					
					f1.write(s1);
					f1.write("\n");
					f1.write(s2);
					f1.write("\n");
					f1.write(s3);
					f1.write("\n");
					f1.close();
					
					f2.write(newTotalRevenue + "");
					f2.close();
					
					f3.write(newTotalSoldItems + "");
					f3.close();
					
					f4.write(newTotalItems + "");
					f4.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
				Sold s = new Sold(); // Show sold
			}
			catch(Exception ex) {
				NotFound nf = new NotFound(); // Open empty fields window if item info fields are empty
			}
		}
	}
}
