package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GameEnviroment.GameLogic;

import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * this class implements the setup screen where the player can choose their team name, desired season length, and difficulty
 *
 */
public class SetupScreen {

	private JFrame frame;
	private JTextField teamNameTextField;
	/**
	 * the games difficulty
	 */
	private int difficultyValue;
	/**
	 * the season length (default 5)
	 */
	private int seasonLengthValue = 5;

	

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 829, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel teamNameLabel = new JLabel("Team Name:");
		teamNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		teamNameLabel.setBounds(72, 105, 160, 32);
		frame.getContentPane().add(teamNameLabel);
		
		JLabel seasonLengthLabel = new JLabel("Season Length:");
		seasonLengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		seasonLengthLabel.setBounds(72, 194, 160, 32);
		frame.getContentPane().add(seasonLengthLabel);
		
		JLabel difficultyLabel = new JLabel("Difficulty:");
		difficultyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		difficultyLabel.setBounds(72, 286, 160, 32);
		frame.getContentPane().add(difficultyLabel);
		
		teamNameTextField = new JTextField();
		teamNameTextField.setBounds(344, 111, 219, 30);
		frame.getContentPane().add(teamNameTextField);
		teamNameTextField.setColumns(10);
		
		JRadioButton difEasyRadioButton = new JRadioButton("Easy");
		difEasyRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDifficultyValue(1);
			}
		});
		difEasyRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		difEasyRadioButton.setBounds(286, 296, 103, 21);
		frame.getContentPane().add(difEasyRadioButton);
		
		JRadioButton difMediumRadioButton = new JRadioButton("Medium");
		difMediumRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDifficultyValue(2);
			}
		});
		difMediumRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		difMediumRadioButton.setBounds(286, 350, 103, 21);
		frame.getContentPane().add(difMediumRadioButton);
		
		JRadioButton difHardRadioButton = new JRadioButton("Hard");
		difHardRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDifficultyValue(3);
			}
		});
		difHardRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		difHardRadioButton.setBounds(286, 409, 103, 21);
		frame.getContentPane().add(difHardRadioButton);
		
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(difEasyRadioButton);
		radioButtonGroup.add(difMediumRadioButton);
		radioButtonGroup.add(difHardRadioButton);
		
		
		JLabel seasonLengthValueLabel = new JLabel("5");
		seasonLengthValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		seasonLengthValueLabel.setBounds(674, 194, 75, 32);
		frame.getContentPane().add(seasonLengthValueLabel);
		
		
		JSlider seasonLengthSlider = new JSlider();
		seasonLengthSlider.setValue(5);
		seasonLengthSlider.setMinorTickSpacing(1);
		seasonLengthSlider.setMajorTickSpacing(1);
		seasonLengthSlider.setMaximum(15);
		seasonLengthSlider.setMinimum(5);
		seasonLengthSlider.setBounds(308, 204, 306, 22);
		frame.getContentPane().add(seasonLengthSlider);
		seasonLengthSlider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					 setSeasonLengthValue(seasonLengthSlider.getValue());
					 seasonLengthValueLabel.setText(Integer.toString(getSeasonLengthValue()));
		}
		});
	          
		
		
		
		
		
		
		JButton doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameLogic.nameValidator(teamNameTextField.getText()) && difficultyValue != 0) {
					GameLogic.setup(teamNameTextField.getText(), getSeasonLengthValue(), getDifficultyValue());
					GameLogic.launchMainMenuScreen();
					closeWindow();
				}
				else {
					JOptionPane.showMessageDialog(frame, "You haven't completed the setup!");
				}
			}
		});
		doneButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		doneButton.setBounds(10, 445, 172, 82);
		frame.getContentPane().add(doneButton);
		
		JLabel screenTitleLabel = new JLabel("SETUP");
		screenTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		screenTitleLabel.setBounds(348, 10, 112, 51);
		frame.getContentPane().add(screenTitleLabel);
		
		JLabel nameSelectionTipLabel = new JLabel("Team name must be between 3-15 characters and contain no special characters");
		nameSelectionTipLabel.setBounds(256, 152, 619, 13);
		frame.getContentPane().add(nameSelectionTipLabel);
		
		JLabel seasonLengthTipLabel = new JLabel("(weeks)");
		seasonLengthTipLabel.setBounds(99, 223, 83, 13);
		frame.getContentPane().add(seasonLengthTipLabel);
	}
	
	/**
	 * gets the difficultyValue for use in the gui
	 * @return difficultyValue the difficulty value of the game
	 */
	public int getDifficultyValue() {
		return difficultyValue;
	}
	
	/**
	 * sets the difficultyValue for use in the gui
	 * @param difficultyValue the difficulty value of the game
	 */
	public void setDifficultyValue(int difficultyValue) {
		this.difficultyValue = difficultyValue;
	}
	
	/**
	 * gets the seasonLengthValue for use in the gui
	 * @return seasonLengthValue the season length of the game
	 */
	public int getSeasonLengthValue() {
		return seasonLengthValue;
	}
	
	/**
	 * sets the seasonLengthValue for use in the gui
	 * @param seasonLengthValue the season length of the game
	 */
	public void setSeasonLengthValue(int seasonLengthValue) {
		this.seasonLengthValue = seasonLengthValue;
	}
	
	/**
	 * closes the window
	 */
	public void closeWindow() {
		frame.dispose();
	}
}
