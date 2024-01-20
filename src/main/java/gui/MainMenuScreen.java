package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GameEnviroment.GameLogic;
import GameEnviroment.RandomEvent;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * this class implements the main menu screen where the player can choose what they want to do, 
 * view their team, view their inventory, go to the market, go to the stadium, and take a by
 * @author user
 *
 */
public class MainMenuScreen {

	private JFrame frame;

	

	/**
	 * Create the application.
	 */
	public MainMenuScreen() {
		initialize();
		frame.setVisible(true);
		GameLogic.updateMarket();
		if(GameLogic.isGameOver()) {
			gameOverPopup();
		}
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
		 
		JButton clubButton = new JButton("Club");
		clubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.launchClubScreen();
				closeWindow();
			}
		});
		clubButton.setBounds(311, 201, 122, 21);
		frame.getContentPane().add(clubButton);
		
		JButton marketButton = new JButton("Market");
		marketButton.setBounds(311, 251, 122, 21);
		frame.getContentPane().add(marketButton);
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.launchMarketScreen();
				closeWindow();
			}
		});
		
		JButton stadiumButton = new JButton("Stadium");
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameLogic.playerTeam.isAbleToPlay() == true && GameLogic.playerTeam.isFullSpeakers() == true) {
				GameLogic.launchStadiumScreen();
				closeWindow();
				}
				else {
					JOptionPane.showMessageDialog(frame,"Your team is unable to play a match!");
				}
			}
		});
		stadiumButton.setBounds(311, 303, 122, 21);
		frame.getContentPane().add(stadiumButton);
		
		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.setBounds(311, 355, 122, 21);
		frame.getContentPane().add(inventoryButton);
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.launchInventoryScreen();
				closeWindow();
			}
		});
		
		JLabel currentWeekLabel = new JLabel("Current Week:");
		currentWeekLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		currentWeekLabel.setBounds(25, 129, 159, 26);
		frame.getContentPane().add(currentWeekLabel);
		
		
		JLabel currentWeekValueLabel = new JLabel("0/0");
		currentWeekValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		currentWeekValueLabel.setBounds(25, 165, 99, 21);
		frame.getContentPane().add(currentWeekValueLabel);
		currentWeekValueLabel.setText(Integer.toString(GameLogic.currentWeek) + "/" + Integer.toString(GameLogic.seasonLength));
		
		JLabel pointsLabel = new JLabel("Points:");
		pointsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pointsLabel.setBounds(25, 201, 99, 26);
		frame.getContentPane().add(pointsLabel);
		
		JLabel pointsValueLabel = new JLabel("0");
		pointsValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pointsValueLabel.setBounds(25, 237, 103, 21);
		frame.getContentPane().add(pointsValueLabel);
		pointsValueLabel.setText(Integer.toString(GameLogic.playerTeam.getPoints()));
		
		JLabel moneyLabel = new JLabel("Money:");
		moneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		moneyLabel.setBounds(25, 266, 99, 26);
		frame.getContentPane().add(moneyLabel);
		
		JLabel moneyValueLabel = new JLabel("0");
		moneyValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		moneyValueLabel.setBounds(25, 307, 73, 21);
		frame.getContentPane().add(moneyValueLabel);
		moneyValueLabel.setText(Integer.toString(GameLogic.playerTeam.getMoney()));
		
		JButton byButton = new JButton("Take A By");
		byButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.playerTeam.rechargeStamina();
				GameLogic.updateMarket();
				GameLogic.setCurrentMatches();
				GameLogic.incrementWeek();
				JOptionPane.showMessageDialog(frame,"You have taken a by, one week has passed");
				randomEventCaller();
				GameLogic.launchAthleteTrainingScreen();
				closeWindow();
			}
		});
		byButton.setBounds(311, 400, 122, 21);
		frame.getContentPane().add(byButton);
		
		JLabel ScreenTitleLabel = new JLabel("MAIN MENU");
		ScreenTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ScreenTitleLabel.setBounds(286, 34, 205, 50);
		frame.getContentPane().add(ScreenTitleLabel);
		
		
		
	}
	
	/**
	 * closes the window
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * calls random events when the player takes a by
	 */
	public void randomEventCaller() {
		int randomInt = GameLogic.randomNumberInRange(1, 100);
		if(randomInt >= RandomEvent.getRandomEventThreshHold()) {
			int statIncreaseRandomInt = GameLogic.randomNumberInRange(1, 100);
			if(statIncreaseRandomInt >= 20) {
				RandomEvent.statIncrease();
				JOptionPane.showMessageDialog(frame,"One of your athlete's stats has been increased!");
			}
			else{
				int playerQuitsRandomInt = GameLogic.randomNumberInRange(1, 100);
				if(playerQuitsRandomInt >= 90 && GameLogic.playerTeam.getTeamMemberList().size() > 4) {
					RandomEvent.athleteQuits();
					JOptionPane.showMessageDialog(frame,"One of your athletes has quit!");
				}
				else {
					RandomEvent.athleteJoins();
					JOptionPane.showMessageDialog(frame,"A new athlete has joined your team!");
				}
			}
		}
	}
	
	/**
	 * shows a popup when the game over conditions are met
	 */
	public void gameOverPopup() {
		if(GameLogic.isGameOver()) {
			if(!GameLogic.playerTeam.canContinue() && GameLogic.currentWeek <= GameLogic.seasonLength) {
				JOptionPane.showMessageDialog(frame,"Game Over!, your team cannot continue, Team Name: " + GameLogic.playerTeam.getName() 
				+", Points: " + GameLogic.playerTeam.getPoints()+ ", Money Made: " + GameLogic.playerTeam.getMoney()
				+ ", Season Length: " + GameLogic.seasonLength);
			}
			else {
				JOptionPane.showMessageDialog(frame,"Season has finished,Team Name: " + GameLogic.playerTeam.getName() 
				+ ", Points: " + GameLogic.playerTeam.getPoints() + ", Money Made: " + GameLogic.playerTeam.getMoney()
				+ ", Season Length: " + GameLogic.seasonLength);
			}
			
			closeWindow();
		}
	}
	
	

}
