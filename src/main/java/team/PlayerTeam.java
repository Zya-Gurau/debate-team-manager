package team;

import java.util.ArrayList;

import GameEnviroment.GameLogic;
import athlete.Athlete;
import market.InsufficientBalanceException;
import market.Item;

/**
 * 
 * this class implements the PlayerTeam which is extends the Team class, it defines the functionality of the players team
 *
 */
public class PlayerTeam extends Team{
	
	/**
	 * the players money
	 */
	private int money;
	/**
	 * the players points
	 */
	private int points;
	/**
	 * the players inventory, a list of purchasable objects
	 */
	private ArrayList<Item> inventory = new ArrayList<Item>(); 
	
	/**
	 * gets the players inventory
	 * 
	 * @return inventory the players inventory
	 */
	public ArrayList<Item> getInventory(){
		return inventory;
	}
	
	/**
	 * adds an item to the inventory list
	 * 
	 * @param item the item added to the inventory list
	 */
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	/**
	 * gets the players money
	 * 
	 * @return money the players money
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * gets the players points
	 * 
	 * @return points the players points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * the default PlayerTeam constructor sets name, money, and points
	 * money and points are set to a default value of 100 and 0 respectively
	 * @param name the new team name
	 */
	public PlayerTeam(String name) {
		super(name);
		money = 100;
		points = 0;
	}
	
	/**
	 * a PlayerTeam constructor sets name, money, and points
	 * @param name the new team name
	 * @param money the amount of money the player starts with
	 */
	public PlayerTeam(int money, String name) {
		super(name);
		this.money = money;
		points = 0;
	}
	
	/**
	 * removes an item from the players inventory
	 * @param item the item to be removed
	 */
	public void removeItem(Item item) {
		this.inventory.remove(item);
	}
	
	/**
	 * subtracts the players money buy a certain amount, if the players money drops below 0 it throws and exception
	 * 
	 * @param subtractAmount the amount to subtract from the players money
	 * @throws InsufficientBalanceException indicates an insufficient balance
	 */
	public void subtractMoney(int subtractAmount) throws InsufficientBalanceException{
		int prevMoney = money;
		money = money - subtractAmount;
		if(money < 0) {
			money = prevMoney;
			throw new InsufficientBalanceException("Insufficient Balance");
		}	
	}
	
	/**
	 * adds a certain amount to the players money
	 * 
	 * @param addAmount amount to add to the players money
	 */
	public void addMoney(int addAmount) {
		money = money + addAmount;
	}
	
	/**
	 * adds a certain amount to the players points
	 * 
	 * @param addAmount amount to add to the players points
	 */
	public void addPoints(int addAmount) {
		points = points + addAmount;
	}
	
	/**
	 * resets the stamina of each athlete in the players team, including none active team members
	 */
	public void rechargeStamina() {
		for (Athlete athlete : getTeamMemberList()) {
			athlete.setCurrentStamina(athlete.getStamina());
		}
	}
	
	/**
	 * checks if the player is able to continue playing the game.
	 * if the player does not have four non injured athletes then return false, else return true
	 * @return a boolean based on whether the player's team can continue
	 */
	public boolean canContinue() {
		int nonInjured = 0;
		for(Athlete athlete: getTeamMemberList()) {
			if(athlete.getIsInjured() == false) {
				nonInjured += 1;
			}
		}
		if (nonInjured >=4) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * removes a team member from the players team based on an index value
	 * 
	 * @param index the index of the athlete in the team member list
	 */
	public void removeTeamMember(int index) {
		if(getTeamMemberList().size() > 0  && index <= getTeamMemberList().size()) {
		ArrayList<Athlete> team = getTeamMemberList();
		Athlete athlete = team.get(index);
		speakerClashFixer(athlete);
		team.remove(index);
		setTeamMemberList(team);
		}
		
	}
	
	/**
	 * sets a given speaker position to a given athlete
	 * 
	 * @param selectedPositionNumber the selected speaker position
	 * @param selectedAthlete the  selected athlete
	 */
	public void setSpeakerPosition(int selectedPositionNumber, Athlete selectedAthlete) {
		speakerClashFixer(selectedAthlete);
		if(selectedPositionNumber == 1) {
			setFirstSpeaker(selectedAthlete);
			}
		if(selectedPositionNumber == 2) {
			setSecondSpeaker(selectedAthlete);
			}
		if(selectedPositionNumber == 3) {
			setThirdSpeaker(selectedAthlete);
			}
		if(selectedPositionNumber == 4) {
			setFourthSpeaker(selectedAthlete);
			}
	}
	
	/**
	 * checks if all of the speaker positions are filled, returns true if so and false if not
	 * 
	 * @return a boolean indicated whether all of the speaker positions are filled
	 */
	public boolean isFullSpeakers() {
		if(getFirstSpeaker() == GameLogic.nullAthlete || getSecondSpeaker() == GameLogic.nullAthlete 
				|| getThirdSpeaker() == GameLogic.nullAthlete || getFourthSpeaker() == GameLogic.nullAthlete) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * checks if the team is able to play a match by checking if any athletes are injured, returns true if not and false if so
	 * 
	 * @return a boolean indicating whether or not the team is able to play a match
	 */
	public boolean isAbleToPlay() {
		if(getFirstSpeaker().getIsInjured() == false &&
				getSecondSpeaker().getIsInjured() == false &&
				getThirdSpeaker().getIsInjured() == false &&
				getFourthSpeaker().getIsInjured() == false) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * returns the player teams list of team members as an array 
	 * @return the array containing each of the player teams team members
	 */
	public Athlete[] getTeamMemberListAsArray() {
		return (Athlete[]) GameLogic.playerTeam.getTeamMemberList().toArray();
	}
	
}
