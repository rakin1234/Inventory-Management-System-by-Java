import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class Removed {
	private JFrame frame;
	private JLabel removedL;
	
	public Removed() {
		frame = new JFrame();
		removedL = new JLabel("Removed");
		
		FlowLayout f = new FlowLayout(FlowLayout.CENTER, 10, 20);
		frame.setLayout(f);
		
		frame.add(removedL);
		
		frame.setVisible(true);
		frame.setSize(200, 100);
		frame.setLocation(560, 290);
	}
}
