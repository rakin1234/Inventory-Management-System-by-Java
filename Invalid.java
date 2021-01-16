import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Invalid {
	private JFrame frame;
	private JLabel invalidL;
	
	public Invalid() {
		frame = new JFrame();
		invalidL = new JLabel("Invalid Username or Password");
		
		FlowLayout f = new FlowLayout(FlowLayout.CENTER, 10, 20);
		frame.setLayout(f);
		
		frame.add(invalidL);
		
		frame.setVisible(true);
		frame.setSize(215, 100);
		frame.setLocation(560, 290);
	}
}
