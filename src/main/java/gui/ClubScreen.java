package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GameEnviroment.GameLogic;
import athlete.Athlete;

import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * this class implements the club where the player can look at the properties of their team, and choose their current speakers
 *
 */
public class ClubScreen {

	private JFrame frame;
	private JTextField setAthleteNameTextField;


	/**
	 * Create the application.
	 */
	public ClubScreen() {
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
		
		JLabel currentAthleteLabel = new JLabel("Currently Selected Athlete:");
		currentAthleteLabel.setBounds(137, 123, 357, 13);
		frame.getContentPane().add(currentAthleteLabel);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
		athleteListModel.addAll(GameLogic.playerTeam.getTeamMemberList());
		
		JList<Athlete> athleteList = new JList<>(athleteListModel);
		athleteList.setSelectedIndex(0);
		athleteList.setBackground(new Color(255, 255, 255));
		athleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		athleteList.setBorder(new CompoundBorder());
		athleteList.setBounds(10, 122, 117, 185);
		frame.getContentPane().add(athleteList);
		
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(137, 146, 117, 13);
		frame.getContentPane().add(nameLabel);
		
		JLabel offenseLabel = new JLabel("Offense: ");
		offenseLabel.setBounds(137, 169, 117, 13);
		frame.getContentPane().add(offenseLabel);
		
		JLabel defenseLabel = new JLabel("Defense: ");
		defenseLabel.setBounds(137, 192, 117, 13);
		frame.getContentPane().add(defenseLabel);
		
		JLabel staminaLabel = new JLabel("Stamina: ");
		staminaLabel.setBounds(137, 215, 117, 13);
		frame.getContentPane().add(staminaLabel);
		
		JLabel preferredStyleLabel = new JLabel("Preferred Style: ");
		preferredStyleLabel.setBounds(137, 238, 300, 13);
		frame.getContentPane().add(preferredStyleLabel);
		
		JLabel speakingStyleLabel = new JLabel("Speaking Style: ");
		speakingStyleLabel.setBounds(137, 261, 237, 13);
		frame.getContentPane().add(speakingStyleLabel);
		
		JLabel firstSpeakerLabel = new JLabel("First Speaker: " + GameLogic.playerTeam.getFirstSpeaker());
		firstSpeakerLabel.setBounds(504, 123, 244, 13);
		frame.getContentPane().add(firstSpeakerLabel);
		
		JLabel secondSpeakerLabel = new JLabel("Second Speaker: "+ GameLogic.playerTeam.getSecondSpeaker());
		secondSpeakerLabel.setBounds(504, 225, 244, 13);
		frame.getContentPane().add(secondSpeakerLabel);
		
		JLabel thirdSpeakerLabel = new JLabel("Third Speaker: "+ GameLogic.playerTeam.getThirdSpeaker());
		thirdSpeakerLabel.setBounds(504, 314, 244, 13);
		frame.getContentPane().add(thirdSpeakerLabel);
		
		JLabel fourthSpeakerLabel = new JLabel("Fourth Speaker: "+ GameLogic.playerTeam.getFourthSpeaker());
		fourthSpeakerLabel.setBounds(504, 407, 244, 13);
		frame.getContentPane().add(fourthSpeakerLabel);
		
		JButton chooseFirstSpeakerButton = new JButton("Choose Speaker");
		chooseFirstSpeakerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.playerTeam.setFirstSpeaker(athleteList.getSelectedValue());
				firstSpeakerLabel.setText("First Speaker: " + GameLogic.playerTeam.getFirstSpeaker());
				secondSpeakerLabel.setText("Second Speaker: " + GameLogic.playerTeam.getSecondSpeaker());
				thirdSpeakerLabel.setText("Third Speaker: " + GameLogic.playerTeam.getThirdSpeaker());
				fourthSpeakerLabel.setText("Fourth Speaker: " + GameLogic.playerTeam.getFourthSpeaker());
			}
		});
		chooseFirstSpeakerButton.setBounds(573, 165, 175, 21);
		frame.getContentPane().add(chooseFirstSpeakerButton);
		
		JButton chooseSecondSpeakerButton = new JButton("Choose Speaker");
		chooseSecondSpeakerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.playerTeam.setSecondSpeaker(athleteList.getSelectedValue());
				firstSpeakerLabel.setText("First Speaker: " + GameLogic.playerTeam.getFirstSpeaker());
				secondSpeakerLabel.setText("Second Speaker: " + GameLogic.playerTeam.getSecondSpeaker());
				thirdSpeakerLabel.setText("Third Speaker: " + GameLogic.playerTeam.getThirdSpeaker());
				fourthSpeakerLabel.setText("Fourth Speaker: " + GameLogic.playerTeam.getFourthSpeaker());
			}
		});
		chooseSecondSpeakerButton.setBounds(573, 263, 175, 21);
		frame.getContentPane().add(chooseSecondSpeakerButton);
		
		JButton chooseThirdSpeakerButton = new JButton("Choose Speaker");
		chooseThirdSpeakerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.playerTeam.setThirdSpeaker(athleteList.getSelectedValue());
				firstSpeakerLabel.setText("First Speaker: " + GameLogic.playerTeam.getFirstSpeaker());
				secondSpeakerLabel.setText("Second Speaker: " + GameLogic.playerTeam.getSecondSpeaker());
				thirdSpeakerLabel.setText("Third Speaker: " + GameLogic.playerTeam.getThirdSpeaker());
				fourthSpeakerLabel.setText("Fourth Speaker: " + GameLogic.playerTeam.getFourthSpeaker());
			}
		});
		chooseThirdSpeakerButton.setBounds(573, 353, 175, 21);
		frame.getContentPane().add(chooseThirdSpeakerButton);
		
		JButton chooseFourthSpeakerButton = new JButton("Choose Speaker");
		chooseFourthSpeakerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.playerTeam.setFourthSpeaker(athleteList.getSelectedValue());
				firstSpeakerLabel.setText("First Speaker: " + GameLogic.playerTeam.getFirstSpeaker());
				secondSpeakerLabel.setText("Second Speaker: " + GameLogic.playerTeam.getSecondSpeaker());
				thirdSpeakerLabel.setText("Third Speaker: " + GameLogic.playerTeam.getThirdSpeaker());
				fourthSpeakerLabel.setText("Fourth Speaker: " + GameLogic.playerTeam.getFourthSpeaker());
			}
		});
		chooseFourthSpeakerButton.setBounds(573, 456, 175, 21);
		frame.getContentPane().add(chooseFourthSpeakerButton);
		
		JLabel currentPositionLabel = new JLabel("Current Position: ");
		currentPositionLabel.setBounds(137, 284, 251, 13);
		frame.getContentPane().add(currentPositionLabel);
		
		JButton doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.launchMainMenuScreen();
				closeWindow();
			}
		});
		doneButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		doneButton.setBounds(10, 431, 180, 96);
		frame.getContentPane().add(doneButton);
		
		JLabel screenTitleLabel = new JLabel("CLUB");
		screenTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		screenTitleLabel.setBounds(346, 21, 102, 89);
		frame.getContentPane().add(screenTitleLabel);
		
		setAthleteNameTextField = new JTextField();
		setAthleteNameTextField.setBounds(10, 83, 141, 20);
		frame.getContentPane().add(setAthleteNameTextField);
		setAthleteNameTextField.setColumns(10);
		
		JButton setAthleteNameButton = new JButton("set name");
		setAthleteNameButton.setBounds(17, 49, 134, 23);
		frame.getContentPane().add(setAthleteNameButton);
		
		JLabel teamNameLabel = new JLabel("Team: " + GameLogic.playerTeam.getName());
		teamNameLabel.setBounds(17, 21, 275, 14);
		frame.getContentPane().add(teamNameLabel);
		
		
		athleteList.addListSelectionListener(new ListSelectionListener() {
			 
			  public void valueChanged(ListSelectionEvent e) {
			    Athlete selectedAthlete = athleteList.getSelectedValue();
			    if(selectedAthlete != null) {
			    nameLabel.setText("Name: " + selectedAthlete.getName());
			    offenseLabel.setText("Offense: " + selectedAthlete.getOffense());
			    defenseLabel.setText("Defense: " + selectedAthlete.getDefense());
			    staminaLabel.setText("Stamina: " + selectedAthlete.getCurrentStamina() + "/" + selectedAthlete.getStamina());
			    speakingStyleLabel.setText("Speaking Style: " + selectedAthlete.getSpeakingStyle());
			    preferredStyleLabel.setText("Preferred Style: " + selectedAthlete.getPreferedDebateStyle());
			    
			    if(selectedAthlete == GameLogic.playerTeam.getFirstSpeaker()) {
			    	currentPositionLabel.setText("Current Position: First Speaker");
			    }
			    else if(selectedAthlete == GameLogic.playerTeam.getSecondSpeaker()) {
			    	currentPositionLabel.setText("Current Position: Second Speaker");
			    }
			    else if(selectedAthlete == GameLogic.playerTeam.getThirdSpeaker()) {
			    	currentPositionLabel.setText("Current Position: Third Speaker");
			    }
			    else if(selectedAthlete == GameLogic.playerTeam.getFourthSpeaker()) {
			    	currentPositionLabel.setText("Current Position: Fourth Speaker");
			    }
			    else {
			    	currentPositionLabel.setText("Current Position: N/A");
			    }
			  }
			  }
			});
		
		athleteList.getSelectedValue();
		
		setAthleteNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setAthleteNameTextField.getText().length() > 0 && athleteList.getSelectedIndex() != -1) {
					GameLogic.playerTeam.getTeamMemberList().get(athleteList.getSelectedIndex()).setName(setAthleteNameTextField.getText());
					DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
					athleteListModel.addAll(GameLogic.playerTeam.getTeamMemberList());
					athleteList.setModel(athleteListModel);
					athleteList.setSelectedIndex(-1);
				}
			}
		});
		
		
		
		
		
		
	}
	
	/**
	 * closes the window
	 */
	public void closeWindow() {
		frame.dispose();
	}
}
