package gui;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import athlete.Athlete;
import GameEnviroment.GameLogic;
import market.Item;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

/**
 * this class defines the market screen where the player can buy and sell items and athletes
 *
 */
public class MarketScreen {

	private JFrame frame;
	private ArrayList<Athlete> athletes = GameLogic.market.getPurchasableAthletes();
	private ArrayList<Item> items = GameLogic.market.getPurchasableItems();


	/**
	 * Create the application.
	 */
	public MarketScreen() {
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
		
		JLabel teamPriceLabel = new JLabel("$");
		teamPriceLabel.setBounds(161, 365, 98, 14);
		frame.getContentPane().add(teamPriceLabel);
		
		JLabel athletePriceLabel = new JLabel("$");
		athletePriceLabel.setBounds(161, 160, 98, 14);
		frame.getContentPane().add(athletePriceLabel);
		
		JLabel itemPriceLabel = new JLabel("$");
		itemPriceLabel.setBounds(442, 160, 98, 14);
		frame.getContentPane().add(itemPriceLabel);
		
		JLabel teamItemPriceLabel = new JLabel("$");
		teamItemPriceLabel.setBounds(442, 373, 98, 14);
		frame.getContentPane().add(teamItemPriceLabel);
		
		JTextArea statsTextArea = new JTextArea();
		statsTextArea.setBounds(161, 38, 163, 111);
		frame.getContentPane().add(statsTextArea);
		
		JTextArea ItemStatsTextArea = new JTextArea();
		ItemStatsTextArea.setBounds(442, 38, 112, 111);
		frame.getContentPane().add(ItemStatsTextArea);
		
		JTextArea teamAthleteStatsTextArea = new JTextArea();
		teamAthleteStatsTextArea.setBounds(161, 243, 163, 111);
		frame.getContentPane().add(teamAthleteStatsTextArea);
		
		JTextArea inventoryItemTextArea = new JTextArea();
		inventoryItemTextArea.setBounds(442, 243, 112, 119);
		frame.getContentPane().add(inventoryItemTextArea);
		
		JLabel marketLabel = new JLabel("Market");
		marketLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marketLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		marketLabel.setBounds(590, 0, 225, 119);
		frame.getContentPane().add(marketLabel);
		
		JButton purchaseButton = new JButton("PURCHASE");
		purchaseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		purchaseButton.setBounds(579, 160, 185, 40);
		frame.getContentPane().add(purchaseButton);
		
		JButton sellButton = new JButton("SELL");
		sellButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sellButton.setBounds(579, 460, 185, 40);
		frame.getContentPane().add(sellButton);
		
		JLabel balanceLabel = new JLabel("Balance: $");
		balanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		balanceLabel.setBounds(589, 101, 124, 48);
		frame.getContentPane().add(balanceLabel);
		
		JLabel balanceAmountLabel = new JLabel("00.00");
		balanceAmountLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		balanceAmountLabel.setBounds(699, 113, 91, 29);
		balanceAmountLabel.setText(String.valueOf(GameLogic.playerTeam.getMoney()));
		frame.getContentPane().add(balanceAmountLabel);
		
		JLabel purchasableLabel = new JLabel("PURCHASABLE");
		purchasableLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		purchasableLabel.setBounds(191, 0, 155, 40);
		frame.getContentPane().add(purchasableLabel);
		
		JLabel sellableLabel = new JLabel("SELLABLE");
		sellableLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sellableLabel.setBounds(191, 202, 105, 40);
		frame.getContentPane().add(sellableLabel);
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
		athleteListModel.addAll(athletes);
		
		JList<Athlete> athleteList = new JList<>(athleteListModel);
		athleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		athleteList.setBounds(10, 38, 142, 153);
		frame.getContentPane().add(athleteList);
		
		
		DefaultListModel<Item> itemListModel = new DefaultListModel<>();
		itemListModel.addAll(items);
		JList<Item> itemsList = new JList<>(itemListModel);
		itemsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemsList.setBounds(334, 38, 98, 153);
		frame.getContentPane().add(itemsList);
		
		
		DefaultListModel<Athlete> teamListModel = new DefaultListModel<>();
		teamListModel.addAll(GameLogic.playerTeam.getTeamMemberList());
		JList<Athlete> teamList = new JList<>(teamListModel);
		teamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		teamList.setBounds(10, 243, 142, 209);
		frame.getContentPane().add(teamList);
		
		
		
		DefaultListModel<Item> inventoryListModel = new DefaultListModel<>();
		inventoryListModel.addAll(GameLogic.playerTeam.getInventory());
		JList<Item> inventoryList = new JList<>(inventoryListModel);
		inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		inventoryList.setBounds(334, 243, 98, 209);
		frame.getContentPane().add(inventoryList);
		
		athleteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					itemsList.clearSelection();
					if(athleteList.getSelectedIndex() != -1) {
					statsTextArea.setText(athleteList.getSelectedValue().toStringStats());
					athletePriceLabel.setText("$"+Integer.toString(athleteList.getSelectedValue().getPrice()));
					}else {
						statsTextArea.setText("");
						athletePriceLabel.setText("$");
					}
			}	
		});
		
		itemsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					athleteList.clearSelection();
					if(itemsList.getSelectedIndex() != -1) {
					ItemStatsTextArea.setText(itemsList.getSelectedValue().toStringStats());
					itemPriceLabel.setText("$"+Integer.toString(itemsList.getSelectedValue().getPrice()));
					}else {
						ItemStatsTextArea.setText("");
						itemPriceLabel.setText("$");
					}
			}	
		});
		
		inventoryList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					teamList.clearSelection();
					if(inventoryList.getSelectedIndex() != -1) {
						inventoryItemTextArea.setText(inventoryList.getSelectedValue().toStringStats());
						teamItemPriceLabel.setText("$"+Integer.toString(inventoryList.getSelectedValue().getPrice()));
					}else {
						inventoryItemTextArea.setText("");
						teamItemPriceLabel.setText("$");
					}
			}	
		});
		
		teamList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					inventoryList.clearSelection();
					if(teamList.getSelectedIndex() != -1) {
						teamAthleteStatsTextArea.setText(teamList.getSelectedValue().toStringStats());
						teamPriceLabel.setText("$" + Integer.toString(teamList.getSelectedValue().getBuyBackPrice()));
					}else {
						teamAthleteStatsTextArea.setText("");
						teamPriceLabel.setText("$");
					}
			}	
		});
		
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(teamList.getSelectedIndex() == -1 && inventoryList.getSelectedIndex() != -1) {
					Item item = inventoryList.getSelectedValue();
					GameLogic.market.sellItems(item);
					JOptionPane.showMessageDialog(frame,"You have Sold: " + item);
					DefaultListModel<Item> itemListModel = new DefaultListModel<>();
					itemListModel.addAll(GameLogic.market.getPurchasableItems());
					itemsList.setModel(itemListModel);
					balanceAmountLabel.setText(String.valueOf(GameLogic.playerTeam.getMoney()));
					itemsList.clearSelection();
					DefaultListModel<Item> inventoryListModel = new DefaultListModel<>();
					inventoryListModel.addAll(GameLogic.playerTeam.getInventory());
					inventoryList.setModel(inventoryListModel);
				}
				if(teamList.getSelectedIndex() != -1 && inventoryList.getSelectedIndex() == -1) {
					Athlete athlete = teamList.getSelectedValue();
					if(GameLogic.playerTeam.getTeamMemberList().size() > 4) {
						GameLogic.market.sellAthletes(athlete);
						JOptionPane.showMessageDialog(frame,"You have Sold: " + athlete);
						DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
						athleteListModel.addAll(GameLogic.market.getPurchasableAthletes());
						athleteList.setModel(athleteListModel);
						balanceAmountLabel.setText(String.valueOf(GameLogic.playerTeam.getMoney()));
						DefaultListModel<Athlete> teamListModel = new DefaultListModel<>();
						teamListModel.addAll(GameLogic.playerTeam.getTeamMemberList());
						teamList.setModel(teamListModel);
						GameLogic.playerTeam.speakerClashFixer(athlete);
					}
				}
			}
		});
		
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(athleteList.getSelectedIndex() == -1 && itemsList.getSelectedIndex() != -1) {
					Item item = itemsList.getSelectedValue();
					boolean bought = GameLogic.market.purchaseItem(item);
					if(bought == true) {
						JOptionPane.showMessageDialog(frame,"You have Purchased: " + item);
						DefaultListModel<Item> itemListModel = new DefaultListModel<>();
						itemListModel.addAll(GameLogic.market.getPurchasableItems());
						itemsList.setModel(itemListModel);
						balanceAmountLabel.setText(String.valueOf(GameLogic.playerTeam.getMoney()));
						itemsList.clearSelection();
						DefaultListModel<Item> inventoryListModel = new DefaultListModel<>();
						inventoryListModel.addAll(GameLogic.playerTeam.getInventory());
						inventoryList.setModel(inventoryListModel);
					}else {
						JOptionPane.showMessageDialog(frame,"Insufficient balance to purchase: " + item);
					}
					
					
				}
				if(athleteList.getSelectedIndex() != -1 && itemsList.getSelectedIndex() == -1) {
					Athlete athlete = athleteList.getSelectedValue();
					boolean bought = GameLogic.market.purchaseAthlete(athlete);
					if(bought == true) {
						JOptionPane.showMessageDialog(frame,"You have Purchased: " + athlete);
						DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
						athleteListModel.addAll(GameLogic.market.getPurchasableAthletes());
						athleteList.setModel(athleteListModel);
						balanceAmountLabel.setText(String.valueOf(GameLogic.playerTeam.getMoney()));
						DefaultListModel<Athlete> teamListModel = new DefaultListModel<>();
						teamListModel.addAll(GameLogic.playerTeam.getTeamMemberList());
						teamList.setModel(teamListModel);
					}else {
						JOptionPane.showMessageDialog(frame,"Insufficient balance to purchase: " + athlete);
					}
				}
			}
		});
		
		
		JLabel athleteLabel = new JLabel("Athletes");
		athleteLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		athleteLabel.setBounds(50, 11, 62, 30);
		frame.getContentPane().add(athleteLabel);
		
		JLabel itemLabel = new JLabel("Items");
		itemLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		itemLabel.setBounds(373, 20, 45, 13);
		frame.getContentPane().add(itemLabel);
		
		JLabel teamLabel = new JLabel("Team");
		teamLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		teamLabel.setBounds(50, 202, 62, 30);
		frame.getContentPane().add(teamLabel);
		
		JLabel inventoryLabel = new JLabel("Inventory");
		inventoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inventoryLabel.setBounds(327, 202, 73, 30);
		frame.getContentPane().add(inventoryLabel);
	 	
		JButton doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.launchMainMenuScreen();
				closeWindow();
			}
		});
		doneButton.setBounds(22, 484, 89, 23);
		frame.getContentPane().add(doneButton);

		
	}
	
	/**
	 * closes the window
	 */
	public void closeWindow() {
		frame.dispose();
	}
}
