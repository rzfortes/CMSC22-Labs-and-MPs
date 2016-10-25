import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class RockPaperScissorsLizardSpock extends Frame{
	
	private Random rand = new Random();
	String[] tack = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
	private int pScore = 0;
	private int cScore = 0;
	
	public RockPaperScissorsLizardSpock() {
		setLayout(new FlowLayout());
		Label label1 = new Label("Your choice:", Label.LEFT);
		CheckboxGroup choices = new CheckboxGroup();
		TextField txtResult = new TextField("Result");
		Button button1 = new Button("RockPaperScissorsLizardSpock!");
		Label player = new Label("Player's Score: ");
		Label computer = new Label("Computer's Score");
		
		Checkbox rock = new Checkbox("Rock", choices, true);
		Checkbox paper = new Checkbox("Paper", choices, true);
		Checkbox scissors = new Checkbox("Scissors", choices, true);
		Checkbox lizard = new Checkbox("Lizard", choices, true);
		Checkbox spock = new Checkbox("Spock", choices, true);
		
		add(label1);
		add(rock);
		add(paper);
		add(scissors);
		add(lizard);
		add(spock);
		add(txtResult);
		add(button1);
		add(player);
		add(new TextField());
		add(new TextField());
		add(computer);
		setVisible(true);
		
		//anonymous class for button
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// computer generate hand choice
				//compare computer's hand choice to player's hand choice
			}
		});
		
		// for closing the window
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	// for random int
	public int randInt(int min, int max) {
		int randomNum = rand.nextInt((max-min) + 1) + min;
		return randomNum;
	}
	
	// computer's 
	public int computer() {
		int attack = randInt(1, 5);
		return attack;
	}
	
	public static void main(String[] args) {
		new RockPaperScissorsLizardSpock();
	}

}
