import java.awt.*;
import java.applet.Applet;

public class ButtonGrid extends Applet {
	
	public ButtonGrid() {
		setLayout(new GridLayout(4, 4));
		add(new Button("AC"));
		add(new Button("+/-"));
		add(new Button("%"));
		add(new Button("÷"));
		add(new Button("7"));
		add(new Button("8"));
		add(new Button("9"));
		add(new Button("x"));
		add(new Button("4"));
		add(new Button("5"));
		add(new Button("6"));
		add(new Button("-"));
		add(new Button("1"));
		add(new Button("2"));
		add(new Button("3"));
		add(new Button("+"));
	}
	
}
