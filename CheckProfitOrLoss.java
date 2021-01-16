import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class CheckProfitOrLoss {
	// Declare variables
	private JFrame frame;
	
	private JLabel profitOrLossL;
	private JTextField profitOrLossT;
	
	private int totalSalary;
	private int totalCost;
	
	private int totalRevenue;
	
	public CheckProfitOrLoss() {
		// Initialize variables
		frame = new JFrame();
		
		profitOrLossL = new JLabel("Profit/Loss on this month");
		profitOrLossT = new JTextField();
		
		//Set Layout
		GridLayout g = new GridLayout(1, 2);
		frame.setLayout(g);
		
		//Add components in frame
		frame.add(profitOrLossL);
		frame.add(profitOrLossT);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(300, 150);
		frame.setLocation(500, 265);
		frame.setTitle("Cashbox");
		
		readFromFile();
		profitOrLossT.setText((totalRevenue - (totalCost + totalSalary)) + ""); // Show profit/loss
	}
	
	public void readFromFile(){
		try {
			File x1 = new File("totalsalary.txt");
			File x2 = new File("totalcost.txt");
			File x3 = new File("totalrevenue.txt");
			
			Scanner s1 = new Scanner(x1);
			Scanner s2 = new Scanner(x2);
			Scanner s3 = new Scanner(x3);
			
			while(s1.hasNextLine()) {
				String str1 = s1.nextLine(); // Read total salary cost
				totalSalary = Integer.parseInt(str1);
			}
			
			while(s2.hasNextLine()) {
				String str2 = s2.nextLine(); // Read total cost
				totalCost = Integer.parseInt(str2);
			}
			
			while(s3.hasNextLine()) {
				String str3 = s3.nextLine();// Read total revenue
				totalRevenue = Integer.parseInt(str3);
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
