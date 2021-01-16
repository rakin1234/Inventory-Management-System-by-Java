import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class Added {
	private JFrame frame;
	private JLabel addedL;
	
	public Added() {
		frame = new JFrame();
		addedL = new JLabel("Added");
		
		FlowLayout f = new FlowLayout(FlowLayout.CENTER, 10, 20);
		frame.setLayout(f);
		
		frame.add(addedL);
		
		frame.setVisible(true);
		frame.setSize(200, 100);
		frame.setLocation(560, 290);
	}
}
