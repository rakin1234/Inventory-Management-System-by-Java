import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

public class Done {
	private JFrame frame;
	private JLabel doneL;
	
	public Done() {
		frame = new JFrame();
		doneL = new JLabel("Done");
		
		FlowLayout f = new FlowLayout(FlowLayout.CENTER, 10, 20);
		frame.setLayout(f);
		
		frame.add(doneL);
		
		frame.setVisible(true);
		frame.setSize(200, 100);
		frame.setLocation(560, 290);
	}
}
