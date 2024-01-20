package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;

import athlete.Athlete;
import GameEnviroment.GameLogic;
import market.Item;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextArea;

/**
 * this class defines the inventory screen where the player can use items
 *
 */
public class Inventory {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Inventory() {
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
		
		JLabel inventoryLabel = new JLabel("INVENTORY");
		inventoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		inventoryLabel.setBounds(308, 11, 143, 70);
		frame.getContentPane().add(inventoryLabel);
		
		DefaultListModel<Item> itemListModel = new DefaultListModel<>();
		itemListModel.addAll(GameLogic.playerTeam.getInventory());
		JList<Item> itemsList = new JList<Item>(itemListModel);
		itemsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemsList.setBounds(80, 138, 143, 246);
		frame.getContentPane().add(itemsList);
		itemsList.getSelectedValue();	
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
		athleteListModel.addAll(GameLogic.playerTeam.getTeamMemberList());
		JList<Athlete> teamList = new JList<Athlete>(athleteListModel);
		teamList.setBounds(491, 138, 143, 246);
		frame.getContentPane().add(teamList);
		teamList.getSelectedValue();
		
		JButton useButton = new JButton("USE");
		useButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		useButton.setBounds(396, 192, 85, 21);
		frame.getContentPane().add(useButton);
		
		JLabel itemsLabel = new JLabel("ITEMS");
		itemsLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		itemsLabel.setBounds(126, 114, 45, 13);
		frame.getContentPane().add(itemsLabel);
		
		JLabel teamLabel = new JLabel("TEAM");
		teamLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		teamLabel.setBounds(536, 114, 45, 13);
		frame.getContentPane().add(teamLabel);
		
		JButton doneButton = new JButton("DONE");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.launchMainMenuScreen();
				closeWindow();
			}
		});
		doneButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		doneButton.setBounds(38, 565, 112, 41);
		frame.getContentPane().add(doneButton);
		
		JButton doneButton_1 = new JButton("Done");
		doneButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.launchMainMenuScreen();
				closeWindow();
			}
		});
		doneButton_1.setBounds(38, 469, 89, 23);
		frame.getContentPane().add(doneButton_1);
		
		JTextArea itemStatsTextArea = new JTextArea();
		itemStatsTextArea.setBounds(233, 138, 142, 132);
		frame.getContentPane().add(itemStatsTextArea);
		
		JTextArea athleteStatstextArea = new JTextArea();
		athleteStatstextArea.setBounds(645, 138, 148, 132);
		frame.getContentPane().add(athleteStatstextArea);
		
		itemsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					if(itemsList.getSelectedIndex() != -1) {
						itemStatsTextArea.setText(itemsList.getSelectedValue().toStringStats());
					}else {
						itemStatsTextArea.setText("");
					}
			}	
		});
		
		teamList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					if(teamList.getSelectedIndex() != -1) {
						athleteStatstextArea.setText(teamList.getSelectedValue().toStringStats());
					}else {
						athleteStatstextArea.setText("");
					}
			}	
		});
		
		useButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(itemsList.getSelectedIndex() != -1 && teamList.getSelectedIndex() != -1) {
					Item item = itemsList.getSelectedValue();
					item.useItem(item, teamList.getSelectedValue());
					JOptionPane.showMessageDialog(frame,"You have used " + item + " on " + teamList.getSelectedValue());
					DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
					athleteListModel.addAll(GameLogic.playerTeam.getTeamMemberList());
					teamList.setModel(athleteListModel);
					GameLogic.playerTeam.removeItem(item);
					DefaultListModel<Item> itemListModel = new DefaultListModel<>();
					itemListModel.addAll(GameLogic.playerTeam.getInventory());
					itemsList.setModel(itemListModel);
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
