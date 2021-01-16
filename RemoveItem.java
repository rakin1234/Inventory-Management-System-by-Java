import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class RemoveItem implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel nameL;
	private JTextField nameT;
	
	private JButton searchB;
	private JTextField searchT;
	
	private JButton removeB;
	
	private Item[] items;
	private int totalCost;
	private int totalItems;
	
	public RemoveItem() {
		// Initialize variables
		items = new Item[50]; // since we don't know the exact number of items, initialize the array to a reasonably sized one
		
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
		
		// Add in frame
		frame.add(nameL);
		frame.add(nameT);
		frame.add(searchB);
		frame.add(searchT);
		frame.add(removeB);
		
		// Set frame characterstics
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setLocation(500, 250);
		frame.setTitle("Remove Item");
		
		readFromFile();
	}
	
	// Read File & store in an array
	public void readFromFile() {
		try {
			File f1 = new File("items.txt");
			File f2 = new File("totalcost.txt");
			File f3 = new File("totalitems.txt");
			
			Scanner s1 = new Scanner(f1);
			Scanner s2 = new Scanner(f2);
			Scanner s3 = new Scanner(f3);
			int i = 0;
			
			while(s1.hasNextLine()){
				String a = s1.nextLine(); // Read name
				String b = s1.nextLine(); // Read buy price
				int z = Integer.parseInt(b);
				String c = s1.nextLine(); // Read sell price
				int u = Integer.parseInt(c);
				Item temp = new Item(a, z, u); // Create Item object
				items[i] = temp; // Add item in array
				i++;
			}
			
			while(s2.hasNextLine()){
				String a = s2.nextLine(); // Read previous cost
				totalCost = Integer.parseInt(a);
			}
			
			while(s3.hasNextLine()){
				String a2 = s3.nextLine(); // Read previous number of items
				totalItems = Integer.parseInt(a2);
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
					fw.write(items[i].getName());
					fw.write("\n");
					fw.write(items[i].getBuyPrice() + "");
					fw.write("\n");
					fw.write(items[i].getSellPrice() + "");
					fw.write("\n");
				}
			}
			fw.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// Search Item
	public Item findItem(String key){
		Item s = null;
		for(int i = 0; i < items.length; i++){
			if(items[i] != null && items[i].getName().equals(key)){ // name matches
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
		Item found = null;
		if(e.getSource() == searchB){ // Search button clicked
			try {
				String i = nameT.getText();
				found = findItem(i); // Search item
				
				if(found != null){
					searchT.setText(found.toString()); // Show found item
				}
				else{
					searchT.setText("Not found!");
				}
			}
			catch(Exception ex) {
				EmptyFields em = new EmptyFields(); // Open empty fields window if item info fields are empty
			}
		}
		if(e.getSource() == removeB){ // Remove button clicked
			try {
				String i = nameT.getText();
				Item found2 = findItem(i);
				
				int newTotalCost = totalCost - found2.getBuyPrice();
				int newTotalItems = totalItems - 1;
				
				removeItem(i); // Remove item
				writeToFile();
				
				try {
					FileWriter f1 = new FileWriter("totalcost.txt");
					f1.write(newTotalCost + "");
					f1.close();
					
					FileWriter f2 = new FileWriter("totalitems.txt");
					f2.write(newTotalItems + "");
					f2.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
				
				Removed re = new Removed(); // Show removed successfully
				frame.setVisible(false);
			}
			catch(Exception ex) {
				NotFound nf = new NotFound(); // Open empty fields window if item info fields are empty
			}
		}
	}
}
