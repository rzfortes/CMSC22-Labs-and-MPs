package gui;

import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class RockPaperScissorsLizardSpock extends Frame{
	
	// variables for computer
	private Random rand = new Random();
	String[] tack = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
	private int pScore = 0; // player's score
	private int cScore = 0; // computer's score
	
	// displays the game over dialog
	public void gameOver(String winner) {
		Dialog dialog = new Dialog(this);
		dialog.setLayout(new FlowLayout());
		Button ok = new Button("OK");
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				// BUG: should restart a new game, but dili pa ma-delete ang previous frame
				new RockPaperScissorsLizardSpock();
			}
		});
		
		dialog.add(new Label("Game Over! " + winner + " wins!"));
		dialog.add(ok);
		dialog.pack();
		dialog.setVisible(true);

	}

	public RockPaperScissorsLizardSpock() {
		setLayout(new FlowLayout());
		this.setSize(1000, 1000);
		Label label1 = new Label("Your choice:", Label.LEFT);
		CheckboxGroup choices = new CheckboxGroup();
		Label txtResult = new Label("Result", Label.CENTER);
		TextArea result = new TextArea();
		Button button1 = new Button("RockPaperScissorsLizardSpock!");
		Label player = new Label("Player's Score: ", Label.RIGHT);
		TextField playerScore = new TextField();
		Label computer = new Label("Computer's Score", Label.RIGHT);
		TextField computerScore = new TextField();

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
		add(result);
		add(button1);
		add(player);
		add(playerScore);
		add(computer);
		add(computerScore);
		setVisible(true);

		//anonymous class for button
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// computer generate hand choice
				String compHandChoice = computer();
				String playerHandChoice = choices.getSelectedCheckbox().getLabel().toString();
				String winner = "Computer";
				result.setText("Player chose " + playerHandChoice + "\nComputer chose " + compHandChoice + "\n\n");


				// simplified if else statement since same ra man sila ugu buhaton; increment computer's score
				if(((compHandChoice.compareTo("Rock") == 0) && ((playerHandChoice.compareTo("Lizard") == 0) || (playerHandChoice.compareTo("Scissors") == 0))) 
						|| ((compHandChoice.compareTo("Lizard") == 0) && ((playerHandChoice.compareTo("Paper") == 0) || (playerHandChoice.compareTo("Spock") == 0)))
						|| ((compHandChoice.compareTo("Paper") == 0) && ((playerHandChoice.compareTo("Rock") == 0) || (playerHandChoice.compareTo("Spock") == 0)))
						|| ((compHandChoice.compareTo("Scissors") == 0) && ((playerHandChoice.compareTo("Lizard") == 0) || (playerHandChoice.compareTo("Paper") == 0)))
						|| ((compHandChoice.compareTo("Spock") == 0) && ((playerHandChoice.compareTo("Scissors") == 0) || (playerHandChoice.compareTo("Rock") == 0)))) {
					cScore++;
					result.append("COMPUTER WINS THIS ROUND.");
				} else if(compHandChoice.compareTo(playerHandChoice) != 0) { // as long as dili equal ang hand choice ng player ug computer, player will win the round
					pScore++;
					result.append("YOU WIN THIS ROUND.");
				} else {
					result.append("NO ONE WINS THIS ROUND.");
				}
				
				if(pScore == 5 || cScore == 5) {
					if(pScore > cScore) {
						winner = "Player";
					}
					gameOver(winner);
				}
				playerScore.setText(String.valueOf(pScore));
				computerScore.setText(String.valueOf(cScore));
				setVisible(true);
			}
		});
		
		// for closing the window
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
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
	public String computer() {
		int attack = randInt(1, 5);
		return tack[attack - 1];
	}

	public static void main(String[] args) {
		new RockPaperScissorsLizardSpock();
	}

}

