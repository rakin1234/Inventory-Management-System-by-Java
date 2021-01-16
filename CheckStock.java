import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class CheckStock {
	// Declare variables
	private JFrame frame;
	private JLabel totalItemL;
	private JTextField totalItemT;
	private int totalItem;
	
	public CheckStock() {
		// Initialize variables
		frame = new JFrame();
		totalItemL = new JLabel("Total Item Remaining");
		totalItemT = new JTextField();
		
		//Set Layout
		GridLayout g = new GridLayout(1, 2);
		frame.setLayout(g);
		
		//Add components in frame
		frame.add(totalItemL);
		frame.add(totalItemT);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setSize(350, 175);
		frame.setLocation(500, 250);
		frame.setTitle("Stock");
		
		readFromFile();
		totalItemT.setText(totalItem + ""); // Show total item
	}
	
	public void readFromFile(){
		try {
			File x = new File("totalitems.txt");
			Scanner s = new Scanner(x);
			
			while(s.hasNextLine()) {
				String str = s.nextLine(); // Read total item
				totalItem = Integer.parseInt(str);
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
