import java.awt.*;
import java.applet.Applet;

import javax.swing.*;

public class Calculator extends JPanel {
	
	public Calculator() {
		
		JFrame frame = new JFrame("Calculator");
		ButtonGrid buttons = new ButtonGrid();
		frame.setBackground(Color.DARK_GRAY);
		JTextField result = new JTextField("0");
		frame.setSize(300,420);
		frame.add(result);
		buttons.setBackground(Color.DARK_GRAY);
		buttons.setForeground(Color.black);
		frame.add(buttons);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}

}
