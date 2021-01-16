import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class NotFound {
	private JFrame frame;
	private JLabel notFoundL;
	
	public NotFound() {
		frame = new JFrame();
		notFoundL = new JLabel("Not Found!");
		
		FlowLayout f = new FlowLayout(FlowLayout.CENTER, 10, 20);
		frame.setLayout(f);
		
		frame.add(notFoundL);
		
		frame.setVisible(true);
		frame.setSize(200, 100);
		frame.setLocation(560, 290);
		
	}
}
