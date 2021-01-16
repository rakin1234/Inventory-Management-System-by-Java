import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class EmptyFields {
	private JFrame frame;
	private JLabel emptyFieldsL;
	
	public EmptyFields() {
		frame = new JFrame();
		emptyFieldsL = new JLabel("Empty Fields");
		
		FlowLayout f = new FlowLayout(FlowLayout.CENTER, 10, 20);
		frame.setLayout(f);
		
		frame.add(emptyFieldsL);
		
		frame.setVisible(true);
		frame.setSize(200, 100);
		frame.setLocation(560, 290);
	}
}
