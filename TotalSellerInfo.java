import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class TotalSellerInfo {
	// Declare variables
	private JFrame frame;
	
	private JLabel totalSellerL;
	private JTextField totalSellerT;
	
	private JLabel totalSalaryL;
	private JTextField totalSalaryT;
	
	private int totalSeller;
	private int totalSalary;
	
	public TotalSellerInfo() {
		// Initialize variables
		frame = new JFrame();
		
		totalSellerL = new JLabel("Number of Sellers");
		totalSellerT = new JTextField();
		
		totalSalaryL = new JLabel("Total Salary Cost Per Month");
		totalSalaryT = new JTextField();
		
		// Set Layout
		GridLayout g = new GridLayout(2, 2);
		frame.setLayout(g);
		
		//Add components in frame
		frame.add(totalSellerL);
		frame.add(totalSellerT);
		frame.add(totalSalaryL);
		frame.add(totalSalaryT);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(500, 250);
		frame.setLocation(500, 250);
		frame.setTitle("Total Seller & Salary Info");
		
		readFromFile();
		
		totalSellerT.setText(totalSeller + "");
		totalSalaryT.setText(totalSalary + "");
	}
	
	public void readFromFile(){
		try {
			File x1 = new File("totalsellers.txt");
			File x2 = new File("totalsalary.txt");
			Scanner y1 = new Scanner(x1);
			Scanner y2 = new Scanner(x2);
			
			while(y1.hasNextLine()) {
				String preTotalSellers = y1.nextLine(); // read previous number of total sellers
				totalSeller = Integer.parseInt(preTotalSellers);
			}
			
			while(y2.hasNextLine()) {
				String preTotalSalary = y2.nextLine(); // read previous total salary cost per month
				totalSalary = Integer.parseInt(preTotalSalary);
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
