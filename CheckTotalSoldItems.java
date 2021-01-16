import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class CheckTotalSoldItems {
	// Declare variables
	private JFrame frame;
	
	private JLabel totalItemL;
	private JTextField totalItemT;
	
	private int totalItem;
	
	public CheckTotalSoldItems() {
		// Initialize variables
		frame = new JFrame();
		
		totalItemL = new JLabel("Total Number Of Items Sold");
		totalItemT = new JTextField();
		
		//Set Layout
		GridLayout g = new GridLayout(1, 2);
		frame.setLayout(g);
		
		//Add components in frame
		frame.add(totalItemL);
		frame.add(totalItemT);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setLocation(500, 250);
		frame.setTitle("Total Number Of Sold Items");
		
		totalItemT.setText(readFromFile() + ""); // Show total item
	}
	
	public int readFromFile(){
		try {
			File x = new File("totalsolditems.txt");
			Scanner s = new Scanner(x);
			
			while(s.hasNextLine()) {
				String str = s.nextLine(); // Read total sold item
				totalItem = Integer.parseInt(str);
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return totalItem;
	}
}
