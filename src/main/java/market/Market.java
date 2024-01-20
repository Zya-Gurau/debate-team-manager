package market;

import java.util.*;

import GameEnviroment.GameLogic;
import athlete.Athlete;
import athlete.AthleteCreator;
/**
 * 
 * This class implements the Market where items and athletes can be sold and purchased
 * 
 */
public class Market{
	/**
	 * the list of purchasable athletes
	 */
	private ArrayList<Athlete> purchasableAthletes;
	/**
	 * the list of the purchasable items
	 */
	private ArrayList<Item> purchasableItems;
	/**
	 * the number of athletes for purchase
	 */
	private int numAthletes;
	/**
	 * the maximum number of athletes for purchase
	 */
	private int numMax = 5;
	/**
	 * the minimum number of athletes for purchase
	 */
	private int numMin = 3;
	
	
	/**
	 * market constructor
	 */
	public Market() {
		numAthletes = GameLogic.randomNumberInRange(numMin, numMax);
		purchasableAthletes = AthleteCreator.createPlayerAthleteList(numAthletes);
		purchasableItems = Item.createItemList();
	}

	
	/**
	 * returns list of athletes for purchase
	 * @return purchasableAthletes the list of purchasable athletes
	 */
	public ArrayList<Athlete> getPurchasableAthletes() {
		return purchasableAthletes;
	}
	
	/**
	 * returns list of purchasable items
	 * @return purchasableItems the list of purchasable items
	 */
	public ArrayList<Item> getPurchasableItems() {
		return purchasableItems;
	}
	
	/**
	 * adds sold athlete to market
	 * increases balance by athlete price
	 * removes sold athlete from team
	 * @param soldAthlete the athlete that is being sold
	 */
	public void sellAthletes(Athlete soldAthlete) {
			purchasableAthletes.add(soldAthlete);
			GameLogic.playerTeam.addMoney(soldAthlete.getBuyBackPrice());
			GameLogic.playerTeam.getTeamMemberList().remove(soldAthlete);
	}
	/**
	 * adds item to market
	 * increases balance by item price
	 * removes item from team inventory
	 * @param soldItem the item that is being sold
	 */
	public void sellItems(Item soldItem) {
		
			purchasableItems.add(soldItem);
			GameLogic.playerTeam.addMoney(soldItem.getPrice());
			GameLogic.playerTeam.getInventory().remove(soldItem);
	}
	/**
	 * trys to subtract cost of item from team balance
	 * if sufficient funds, adds item to inventory
	 * 		then removes item from purchasable items
	 * else produces InsuffientBalanceError
	 * @param purchasedItem the item that is being purchased
	 * @return a boolean based on whether the item was successfully bought
	 */
	public boolean purchaseItem(Item purchasedItem) {
				int cost = purchasedItem.getPrice();
				try {
				GameLogic.playerTeam.subtractMoney(cost);
				}
				catch (Exception e) {
					return false;
				}
				GameLogic.playerTeam.addItem(purchasedItem);
				purchasableItems.remove(purchasedItem);
				return true;
	}
	/**
	 * trys to subtract cost of athlete from team balance
	 * if sufficient funds, adds athlete to team
	 *		then removes athlete from purchasableAthletes
	 * else produces InsufficientBalanceError
	 * @param purchasedAthlete the athlete to be purchased
	 * @return a boolean based on whether the athlete was successfully bought
	 */
	public boolean purchaseAthlete(Athlete purchasedAthlete) {
				int cost = purchasedAthlete.getPrice();
				try {
				GameLogic.playerTeam.subtractMoney(cost);
				}
				catch (Exception e) {
					return false;
				}
				GameLogic.playerTeam.addTeamMember(purchasedAthlete);
				purchasableAthletes.remove(purchasedAthlete);
				return true;
	}

	/**
	 * the constructor for the initial team players
	 * @return initialAthleteList the starting athletes
	 */
	public ArrayList<Athlete> initialAthletes() {
		ArrayList<Athlete> initialAthleteList = new ArrayList<>();
		Athlete athlete1 = new Athlete("Cerce", GameLogic.randomNumberInRange(3,10),8, 7, 200, "Model",GameLogic.randomNumberInRange(3,10) );
		Athlete athlete2 = new Athlete("Abi", 5,8, 6, 200, "Comparative",GameLogic.randomNumberInRange(3,10));
		Athlete athlete3 = new Athlete("Conrad", 7,8, GameLogic.randomNumberInRange(3,10), 200, "Model", GameLogic.randomNumberInRange(3,10) );
		Athlete athlete4 = new Athlete("Gwen", 6,8, GameLogic.randomNumberInRange(3,10), 200, "Abstract", 7 );
		initialAthleteList.add(athlete1);
		initialAthleteList.add(athlete2);
		initialAthleteList.add(athlete3);
		initialAthleteList.add(athlete4);
		return initialAthleteList;
	}
	
	
	
	

}