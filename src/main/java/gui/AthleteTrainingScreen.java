package gui;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GameEnviroment.GameLogic;
import athlete.Athlete;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * 
 * This class defines the athlete training screen where the 
 * player can train one of their athletes to increase their stats
 *
 */
public class AthleteTrainingScreen {

	private JFrame frame;



	/**
	 * Create the application.
	 */
	public AthleteTrainingScreen() {
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
		athleteListModel.addAll(GameLogic.playerTeam.getTeamMemberList());
		
		JList<Athlete> athleteList = new JList<>(athleteListModel);
		athleteList.setSelectedIndex(0);
		athleteList.setBackground(new Color(255, 255, 255));
		athleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		athleteList.setBorder(new CompoundBorder());
		athleteList.setBounds(206, 180, 117, 221);
		frame.getContentPane().add(athleteList);
		
		JTextArea teamAthleteStatsTextArea = new JTextArea();
		teamAthleteStatsTextArea.setBounds(337, 180, 163, 111);
		frame.getContentPane().add(teamAthleteStatsTextArea);
		
		JButton trainButton = new JButton("Train");
		trainButton.setBounds(378, 321, 89, 23);
		frame.getContentPane().add(trainButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.launchMainMenuScreen();
				closeWindow();
			}
		});
		exitButton.setBounds(378, 366, 89, 23);
		frame.getContentPane().add(exitButton);
		
		JLabel titleLabel = new JLabel("Athlete Training");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(254, 57, 308, 43);
		frame.getContentPane().add(titleLabel);
		
		athleteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(athleteList.getSelectedIndex() != -1) {
					teamAthleteStatsTextArea.setText(athleteList.getSelectedValue().toStringStats());
				
				}else {
					teamAthleteStatsTextArea.setText("");

				}
		}
	});
		
	trainButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Athlete athlete = athleteList.getSelectedValue();
			athlete.trainAthlete();
			JOptionPane.showMessageDialog(frame, "All of "+ athlete + "'s stats have been increased by 1!");
			GameLogic.launchMainMenuScreen();
			closeWindow();
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
