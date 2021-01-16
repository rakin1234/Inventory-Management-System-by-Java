import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class SearchSoldItem implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel nameL;
	private JTextField nameT;
	
	private JButton searchB;
	private JTextField searchT;
	
	private Item[] items;
	
	public SearchSoldItem() {
		// Initialize variables
		items = new Item[50]; // since we don't know the exact number of items, initialize the array to a reasonably sized one
		
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
		
		// Add components in frame
		frame.add(nameL);
		frame.add(nameT);
		frame.add(searchB);
		frame.add(searchT);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setLocation(500, 250);
		frame.setTitle("Search Sold Item");
		
		readFromFile();
	}
	
	// Read sold items information from file & store into an array
	public void readFromFile(){
		try {
			File f = new File("solditems.txt");
			Scanner s = new Scanner(f);
			int i = 0;
			
			while(s.hasNextLine()){
				String a = s.nextLine(); // Read item name
				String b = s.nextLine(); // Read selling price
				int h = Integer.parseInt(b);
				String c = s.nextLine(); // Read customer name
				Item temp = new Item(a, h, c);
				items[i] = temp;
				i++;
			}
		}
		catch (Exception e) {
			searchT.setText("");
		}
	}
	
	// Search sold item
	public Item findItem(String key){
		Item s = null;
		for(int i = 0; i < items.length; i++){
			if(items[i] != null && items[i].getName().equals(key)){
				s = items[i];
				break;
			}
		}
		return s;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchB){ // Search button clicked
			try {
				String i = nameT.getText();
				Item found = findItem(i);
				
				if(found != null){
					// Show found item
					searchT.setText("Sold Item [name = " + found.getName() + ", sellPrice = " + found.getSellPrice() + ", Customer Name = " + found.getCustName() + "]");
				}
				else{
					searchT.setText("Not found!");
				}
			}
			catch(Exception ex) {
				EmptyFields em = new EmptyFields(); // Show Empty Fields
			}
		}
	}
}
