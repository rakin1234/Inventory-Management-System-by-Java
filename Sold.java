import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class Sold {
	private JFrame frame;
	private JLabel soldL;
	
	public Sold() {
		frame = new JFrame();
		soldL = new JLabel("Sold");
		
		FlowLayout f = new FlowLayout(FlowLayout.CENTER, 10, 20);
		frame.setLayout(f);
		
		frame.add(soldL);
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setSize(200, 100);
	}
}
