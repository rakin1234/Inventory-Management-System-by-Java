import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class CheckOwner {
	// Declare variables
	private JFrame frame;
	private JTextField ownerDetailT;
	
	public CheckOwner() {
		// Initialize variables
		frame = new JFrame();
		ownerDetailT = new JTextField();
		
		// Set Layout
		GridLayout g = new GridLayout(1, 1);
		frame.setLayout(g);
		
		// Add Components in frame
		frame.add(ownerDetailT);
		
		// Set frame characteristics
		frame.setVisible(true);
		frame.setLocation(450, 225);
		frame.setSize(500, 250);
		frame.setTitle("Owner Information");
		
		readFromFile();
	}
	
	public void readFromFile(){
		try {
			File f = new File("owner.txt");
			Scanner s = new Scanner(f);
			Owner o = null;
			while(s.hasNextLine()){
				String a = s.nextLine(); // Read name
				String b = s.nextLine(); // Read age
				int h = Integer.parseInt(b);
				String c = s.nextLine(); // Read gender
				String d = s.nextLine(); // Read phone Number
				int z = Integer.parseInt(d);
				o = new Owner(a, h, c, z);
			}
			ownerDetailT.setText(o.toString());
		}
		catch (Exception e) {
			ownerDetailT.setText("");
		}
	}
}
