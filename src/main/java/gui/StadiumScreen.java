package gui;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GameEnviroment.GameLogic;
import athlete.Athlete;
import match.Match;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;

/**
 * this class implements the Stadium, where the player can play one out of the three available matches each week
 *
 */
public class StadiumScreen {

	private JFrame frame;
	/**
	 * the currently selected match
	 */
	private Match currentMatch = GameLogic.currentMatchOne;
	/**
	 * helper attribute, a list of athletes injured in a match
	 */
	private ArrayList<Athlete> injuredList;


	/**
	 * Create the application.
	 */
	public StadiumScreen() {
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
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
		athleteListModel.addAll(currentMatch.getOppTeam().getTeamMemberList());
		
		JList<Athlete> opposingTeamMemberList = new JList<>(athleteListModel);
		opposingTeamMemberList.setSelectedIndex(0);
		opposingTeamMemberList.setBounds(394, 246, 161, 247);
		opposingTeamMemberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(opposingTeamMemberList);
		
		JLabel opposingAthleteStatsLabel = new JLabel("Athlete Stats:");
		opposingAthleteStatsLabel.setBounds(565, 286, 161, 13);
		frame.getContentPane().add(opposingAthleteStatsLabel);
		
		JLabel mootLabel = new JLabel("Moot: ");
		mootLabel.setBounds(10, 131, 45, 13);
		frame.getContentPane().add(mootLabel);
		
		JLabel mootValueLabel = new JLabel("");
		mootValueLabel.setBounds(65, 131, 703, 13);
		frame.getContentPane().add(mootValueLabel);
		
		JLabel mootStyleLabel = new JLabel("Style: ");
		mootStyleLabel.setBounds(10, 162, 45, 13);
		frame.getContentPane().add(mootStyleLabel);
		
		JLabel mootStyleValueLabel = new JLabel("");
		mootStyleValueLabel.setBounds(65, 162, 115, 13);
		frame.getContentPane().add(mootStyleValueLabel);
		
		mootValueLabel.setText(currentMatch.getMoot());
		mootStyleValueLabel.setText(currentMatch.getMootStyle());
		
		
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(565, 319, 185, 13);
		frame.getContentPane().add(nameLabel);
		
		JLabel offenseLabel = new JLabel("Offense:");
		offenseLabel.setBounds(565, 342, 185, 13);
		frame.getContentPane().add(offenseLabel);
		
		JLabel defenseLabel = new JLabel("Defense");
		defenseLabel.setBounds(565, 365, 185, 13);
		frame.getContentPane().add(defenseLabel);
		
		JLabel staminaLabel = new JLabel("Stamina: ");
		staminaLabel.setBounds(565, 388, 185, 13);
		frame.getContentPane().add(staminaLabel);
		
		JLabel preferredStyleLabel = new JLabel("Preferred Style: ");
		preferredStyleLabel.setBounds(565, 411, 300, 13);
		frame.getContentPane().add(preferredStyleLabel);
		
		JLabel speakingStyleLabel = new JLabel("Speaking Style");
		speakingStyleLabel.setBounds(565, 434, 230, 13);
		frame.getContentPane().add(speakingStyleLabel);
		
		JLabel currentPositionLabel = new JLabel("Current Position:");
		currentPositionLabel.setBounds(565, 457, 315, 13);
		frame.getContentPane().add(currentPositionLabel);
		
		JButton playMatchButton = new JButton("Play Match");
		
		playMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				injuredListPopup();
				playMatchPopup();	
		}});
		playMatchButton.setBounds(31, 430, 136, 21);
		frame.getContentPane().add(playMatchButton);
		
		JButton doneButton = new JButton("Done");
		
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.launchMainMenuScreen();
				closeWindow();
			}
		});
		doneButton.setBounds(31, 472, 85, 21);
		frame.getContentPane().add(doneButton);
		
		JRadioButton matchOneRadioButton = new JRadioButton("Match One");
		matchOneRadioButton.setSelected(true);
		matchOneRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentMatch = GameLogic.currentMatchOne;
				DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
				athleteListModel.addAll(currentMatch.getOppTeam().getTeamMemberList());
				opposingTeamMemberList.setModel(athleteListModel);
				mootValueLabel.setText(currentMatch.getMoot());
				mootStyleValueLabel.setText(currentMatch.getMootStyle());
			}
		});
		matchOneRadioButton.setBounds(31, 315, 103, 21);
		frame.getContentPane().add(matchOneRadioButton);
		
		JRadioButton matchTwoRadioButton = new JRadioButton("Match Two");
		matchTwoRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentMatch = GameLogic.currentMatchTwo;
				DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
				athleteListModel.addAll(currentMatch.getOppTeam().getTeamMemberList());
				opposingTeamMemberList.setModel(athleteListModel);
				mootValueLabel.setText(currentMatch.getMoot());
				mootStyleValueLabel.setText(currentMatch.getMootStyle());
			}
		});
		matchTwoRadioButton.setBounds(31, 357, 103, 21);
		frame.getContentPane().add(matchTwoRadioButton);
		
		JRadioButton matchThreeRadioButton = new JRadioButton("Match Three");
		matchThreeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentMatch = GameLogic.currentMatchThree;
				DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
				athleteListModel.addAll(currentMatch.getOppTeam().getTeamMemberList());
				opposingTeamMemberList.setModel(athleteListModel);
				mootValueLabel.setText(currentMatch.getMoot());
				mootStyleValueLabel.setText(currentMatch.getMootStyle());
			}
		});
		matchThreeRadioButton.setBounds(31, 384, 253, 21);
		frame.getContentPane().add(matchThreeRadioButton);
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(matchOneRadioButton);
		radioButtonGroup.add(matchTwoRadioButton);
		radioButtonGroup.add(matchThreeRadioButton);
		
		JLabel opposingTeamLabel = new JLabel("Opposing Team:");
		opposingTeamLabel.setBounds(394, 225, 253, 13);
		frame.getContentPane().add(opposingTeamLabel);
		
		JLabel screenTitleLabel = new JLabel("STADIUM");
		screenTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		screenTitleLabel.setBounds(327, 22, 236, 74);
		frame.getContentPane().add(screenTitleLabel);
		
		
		
		opposingTeamMemberList.addListSelectionListener(new ListSelectionListener() {
			 
			  public void valueChanged(ListSelectionEvent e) {
				
			    Athlete selectedAthlete = opposingTeamMemberList.getSelectedValue();
			    if(selectedAthlete != null) {
			    nameLabel.setText("Name: " + selectedAthlete.getName());
			    offenseLabel.setText("Offense: " + selectedAthlete.getOffense());
			    defenseLabel.setText("Defense: " + selectedAthlete.getDefense());
			    staminaLabel.setText("Stamina: " + selectedAthlete.getCurrentStamina() + "/" + selectedAthlete.getStamina());
			    speakingStyleLabel.setText("Speaking Style: " + selectedAthlete.getSpeakingStyle());
			    preferredStyleLabel.setText("Preferred Style: " + selectedAthlete.getPreferedDebateStyle());
			    
			    if(selectedAthlete == currentMatch.getOppTeam().getFirstSpeaker()) {
			    	currentPositionLabel.setText("Current Position: First Speaker");
			    }
			    else if(selectedAthlete == currentMatch.getOppTeam().getSecondSpeaker()) {
			    	currentPositionLabel.setText("Current Position: Second Speaker");
			    }
			    else if(selectedAthlete == currentMatch.getOppTeam().getThirdSpeaker()) {
			    	currentPositionLabel.setText("Current Position: Third Speaker");
			    }
			    else if(selectedAthlete == currentMatch.getOppTeam().getFourthSpeaker()) {
			    	currentPositionLabel.setText("Current Position: Fourth Speaker");
			    }
			    else {
			    	currentPositionLabel.setText("Current Position: N/A");
			    }
			  }
			  }
			});
		opposingTeamMemberList.getSelectedValue();
	}
	
	/**
	 * displays a popup of any athletes injured during a match
	 */
	public void injuredListPopup() {
		injuredList = currentMatch.playerTeamAthleteEffects();
		String injuredString = "";
		for(Athlete athlete: injuredList) {
			injuredString += athlete+", ";
		}
		if(injuredList.size() > 0) {
			JOptionPane.showMessageDialog(frame, "Injured Athletes: " + injuredString);
		}
		else {
			JOptionPane.showMessageDialog(frame, "No Injured Athletes!" + injuredString);
		}
	}
	
	/**
	 * displays a popup showing the outcome of a match and the points and money won
	 */
	public void playMatchPopup() {
		double[] points = currentMatch.playMatch();

		if(injuredList.size() < 4) {
			if(points[0] > points[1]) {
				JOptionPane.showMessageDialog(frame, "You Win! " + "Player Points: "+ points[0] + " Opposition Points: " 
						+ points[1] + " you get " + (90*1/GameLogic.difficulty) 
						+ " Points, you get $" + currentMatch.calculateWinMoney(points[0], points[1]), currentMatch.getMoot() +"(" + currentMatch.getMootStyle() + ")", JOptionPane.INFORMATION_MESSAGE);
				GameLogic.playerTeam.addMoney(currentMatch.calculateWinMoney(points[0], points[1]));
				GameLogic.playerTeam.addPoints(90*1/GameLogic.difficulty);
			}
			if(points[0] < points[1]) {
				JOptionPane.showMessageDialog(frame, "You Lose! "+ "Player Points: "+ points[0] + " Opposition Points: " + points[1], currentMatch.getMoot() +"(" + currentMatch.getMootStyle() + ")", JOptionPane.INFORMATION_MESSAGE);
			}
			if(points[0] == points[1]) {
				JOptionPane.showMessageDialog(frame, "You Tie! " + "Player Points: "+ points[0] + " Opposition Points: " 
						+ points[1] + " you get " + 20 
						+ " Points, you get $" + 50, currentMatch.getMoot() +"(" + currentMatch.getMootStyle() + ")", JOptionPane.INFORMATION_MESSAGE);	
				GameLogic.playerTeam.addMoney(50);
				GameLogic.playerTeam.addPoints(20);
			}
			GameLogic.launchMainMenuScreen();
			closeWindow();
		}
		else {
			JOptionPane.showMessageDialog(frame, "You lose! all of you team was injured!", currentMatch.getMoot() +"(" + currentMatch.getMootStyle() + ")", JOptionPane.INFORMATION_MESSAGE);
			GameLogic.launchMainMenuScreen();
			closeWindow();
		}
	}
	
	/**
	 * closes the window
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
}
