import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;

public class Home implements ActionListener {
	// Declare variables
	private JFrame frame;
	private JButton addItemB;
	private JButton addSellerB;
	private JButton checkOwnerB;
	private JButton checkCashBoxB;
	private JButton checkStockB;
	private JButton editUserIdB;
	private JButton removeItemB;
	private JButton removeSellerB;
	private JButton sellItemB;
	private JButton searchSoldItemB;
	private JButton searchSellerB;
	private JButton setOwnerB;
	private JButton totalSoldItemB;
	private JButton totalSellerInfoB;
	private JButton startNewMonthB;
	
	public Home () {
		// Initialize variables
		frame = new JFrame();
		addItemB = new JButton("Add Item");
		addSellerB = new JButton("Add Seller");
		checkOwnerB = new JButton("Check Owner Info");
		checkCashBoxB = new JButton("Check Cashbox");
		checkStockB = new JButton("Check Stock");
		editUserIdB = new JButton("Edit User ID");
		removeItemB = new JButton("Remove Item");
		removeSellerB = new JButton("Remove Seller");
		sellItemB = new JButton("Search & Sell Item");
		searchSoldItemB = new JButton("Search Sold Item With Customer Info");
		searchSellerB = new JButton("Search Seller");
		setOwnerB = new JButton("Set Owner");
		totalSoldItemB = new JButton("Total Number Of Items Sold");
		totalSellerInfoB = new JButton("Total Seller & Total Salary Cost Per Month");
		startNewMonthB = new JButton("Start New Month");
		
		// Register buttons
		addItemB.addActionListener(this);
		addSellerB.addActionListener(this);
		checkOwnerB.addActionListener(this);
		checkCashBoxB.addActionListener(this);
		checkStockB.addActionListener(this);
		editUserIdB.addActionListener(this);
		removeItemB.addActionListener(this);
		removeSellerB.addActionListener(this);
		sellItemB.addActionListener(this);
		searchSoldItemB.addActionListener(this);
		searchSellerB.addActionListener(this);
		setOwnerB.addActionListener(this);
		totalSoldItemB.addActionListener(this);
		totalSellerInfoB.addActionListener(this);
		startNewMonthB.addActionListener(this);
		
		// Set Layout
		GridLayout g = new GridLayout(8, 2);
		frame.setLayout(g);
		
		// Add components in frame
		frame.add(addItemB);
		frame.add(addSellerB);
		frame.add(checkOwnerB);
		frame.add(checkCashBoxB);
		frame.add(checkStockB);
		frame.add(editUserIdB);
		frame.add(removeItemB);
		frame.add(removeSellerB);
		frame.add(sellItemB);
		frame.add(searchSoldItemB);
		frame.add(searchSellerB);
		frame.add(setOwnerB);
		frame.add(totalSoldItemB);
		frame.add(totalSellerInfoB);
		frame.add(startNewMonthB);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setLocation(280, 175);
		frame.setTitle("Home");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addItemB) { // Add Item button clicked
			AddItem w1 = new AddItem();
		}
		if(e.getSource() == addSellerB) { // Add Seller button clicked
			AddSeller w2 = new AddSeller();
		}
		if(e.getSource() == checkOwnerB) { // Check Owner Info button clicked
			CheckOwner w3 = new CheckOwner();
		}
		if(e.getSource() == checkCashBoxB) { // Check Cashbox button clicked
			CheckProfitOrLoss w4 = new CheckProfitOrLoss();
		}
		if(e.getSource() == checkStockB) { // Check Stock button clicked
			CheckStock w5 = new CheckStock();
		}
		if(e.getSource() == editUserIdB) { // Edit User ID button clicked
			EditUserWindow w6 = new EditUserWindow();
		}
		if(e.getSource() == removeItemB) { // Remove Item button clicked
			RemoveItem w7 = new RemoveItem();
		}
		if(e.getSource() == removeSellerB) { // Remove Seller button clicked
			RemoveSeller w8 = new RemoveSeller();
		}
		if(e.getSource() == sellItemB) { // Search & Sell Item button clicked
			SearchAndSellItemWindow w9 = new SearchAndSellItemWindow();
		}
		if(e.getSource() == searchSoldItemB) { // Search Sold Item With Customer Info button clicked
			SearchSoldItem w10 = new SearchSoldItem();
		}
		if(e.getSource() == searchSellerB) { // Search Seller button clicked
			SearchSeller w11 = new SearchSeller();
		}
		if(e.getSource() == setOwnerB) { // Set Owner button clicked
			SetOwner w12 = new SetOwner();
		}
		if(e.getSource() == totalSoldItemB) { // Total Number Of Items Sold button clicked
			CheckTotalSoldItems w13 = new CheckTotalSoldItems();
		}
		if(e.getSource() == totalSellerInfoB) { // Total Seller & Total Salary Cost Per Month button clicked
			TotalSellerInfo w14 = new TotalSellerInfo();
		}
		if(e.getSource() == startNewMonthB) { // Start New Month button clicked
			try {
				// Write files with initial value
				FileWriter f1 = new FileWriter("items.txt");
				f1.write(""); // Delete previous contents
				f1.close();
				
				FileWriter f2 = new FileWriter("totalrevenue.txt");
				f2.write(0 + "");
				f2.close();
				
				FileWriter f3 = new FileWriter("totalitems.txt");
				f3.write(0 + "");
				f3.close();
				
				FileWriter f4 = new FileWriter("totalsolditems.txt");
				f4.write(0 + "");
				f4.close();
				
				FileWriter f5 = new FileWriter("totalcost.txt");
				f5.write(0 + "");
				f5.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			Done done = new Done();
		}
	}
}
