import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class AddItem implements ActionListener {
	// Declare variables
	private JFrame frame;
	
	private JLabel itemNameL;
	private JTextField itemNameT;
	
	private JLabel buyingCostL;
	private JTextField buyingCostT;
	
	private JLabel sellingPriceL;
	private JTextField sellingPriceT;
	
	private JButton addB;
	
	private Item[] items;
	private int totalCost;
	private int totalItems;
	
	public AddItem() {
		// Initialize variables
		items = new Item[50];
		frame = new JFrame();
		
		itemNameL = new JLabel("Item Name");
		itemNameT = new JTextField();
		
		buyingCostL = new JLabel("Buying Cost");
		buyingCostT = new JTextField();
		
		sellingPriceL = new JLabel("Selling Price");
		sellingPriceT = new JTextField();
		
		addB = new JButton("Add");
		
		//Register button
		addB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(4, 2);
		frame.setLayout(g);
		
		// Add in frame
		frame.add(itemNameL);
		frame.add(itemNameT);
		
		frame.add(buyingCostL);
		frame.add(buyingCostT);
		
		frame.add(sellingPriceL);
		frame.add(sellingPriceT);
		
		frame.add(addB);
		
		// set frame
		frame.setVisible(true);
		frame.setSize(700, 350);
		frame.setLocation(310, 200);
		frame.setTitle("Add Item");
		
		readFromFile();
	}
	
	public void readFromFile() {
		try {
			File x1 = new File("totalcost.txt");
			File x2 = new File("totalitems.txt");
			
			Scanner y1 = new Scanner(x1); // Reader
			Scanner y2 = new Scanner(x2); // Reader
			
			while(y1.hasNextLine()) {
				String preTotalCost = y1.nextLine(); // read previous total cost
				totalCost = Integer.parseInt(preTotalCost);
			}
			
		while(y2.hasNextLine()) {
				String preTotalItems = y2.nextLine(); // read previous total items
				totalItems = Integer.parseInt(preTotalItems);
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addB) { //Add button clicked
			try {
				// Added Item 
				String name = itemNameT.getText();
				int buyCost = Integer.parseInt(buyingCostT.getText());
				int sellPrice = Integer.parseInt(sellingPriceT.getText());
				
				int newTotalCost = totalCost + buyCost; // Increase Total Item Importing cost
				int newTotalItems = totalItems + 1; // Increase total number of items
				
				Item p = new Item(name, buyCost, sellPrice);
				try{
					// Write item info in Files
					FileWriter f1 = new FileWriter("items.txt", true);
					FileWriter f2 = new FileWriter("totalcost.txt");
					FileWriter f3 = new FileWriter("totalitems.txt");

					f1.write(p.getName());
					f1.write("\n");
					f1.write(p.getBuyPrice() + "");
					f1.write("\n");
					f1.write(p.getSellPrice() + "");
					f1.write("\n");
					f1.close();
					
					f2.write(newTotalCost + "");
					f2.close();
					
					f3.write(newTotalItems + "");
					f3.close();
				}
				catch(Exception ex){
					System.out.println(ex);
				}
				Added q = new Added(); // Show successfully added
				frame.setVisible(false);
			}
			catch(Exception ex) {
				EmptyFields w = new EmptyFields(); // Open empty fields window if item adding info fields are empty
			}
		}
	}
}