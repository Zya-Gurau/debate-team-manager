package market;

import java.util.ArrayList;

import athlete.Athlete;

/**
 * 
 * This abstract class implements Item objects that can boost athlete stats
 *
 */

public abstract class Item{
	/**
	 * the offence stat
	 */
	private int offence;
	/**
	 * the stamina stat
	 */
	private int stamina;
	/**
	 * the defence stat
	 */
	private int defence;
	/**
	 * the speaking style stat
	 */
	private int speakingStyle;
	/**
	 * the name of the item
	 */
	private String name;
	/**
	 * the buy price of an item
	 */
	private int cost;
	
	/**
	 * a specific item creator
	 * constructs an item based on given parameters
	 * 
	 * @param n the name of item
	 * @param off the offence stat of the item
	 * @param stam the stamina stat of the item
	 * @param def the defence stat of the item
	 * @param speaking the speaking style of the item
	 */
	public Item(String n,int off, int stam, int def, int speaking){
		name = n;
		offence = off;
		stamina = stam;
		defence = def;
		speakingStyle = speaking;
		Price price = new Price();
		cost = price.priceGenerator(offence, stamina, defence);
		
	}
	/**
	 * gets the name of the item
	 * 
	 * @return name the name of the item
	 */
	public String getName() {
		return name;
	}
	/**
	 * gets the offence stat of the item
	 * 
	 * @return offence the offence stat of the item
	 */
	public int getOffence() {
		return offence;
	}
	/**
	 * gets the stamina stat of the item
	 * 
	 * @return stamina the stamina stat of the item
	 */
	public int getStamina() {
		return stamina;
	}
	/**
	 * gets the defence stat of the item
	 * 
	 * @return defence the defence stat of the item
	 */
	public int getDefence() {
		return defence;
	}
	/**
	 * gets the price of the item
	 * 
	 * @return cost the price of the item
	 */
	public int getPrice() {
		return cost;
	}
	/**
	 * gets the speaking style of the item
	 * 
	 * @return speaking the name of the item
	 */
	public int getSpeakingStyle() {
		return speakingStyle;
	}
	
	
	/**
	 * returns list of items for purchase
	 *
	 * @return itemList the list of items
	 */
	public static ArrayList<Item> createItemList(){
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(new Book());
		itemList.add(new Timer());
		itemList.add(new Refill());
		itemList.add(new WaterBottle());
		return itemList;		
	}
	
	/**
	 * returns a string representation of the item describing their stats
	 * @return name the name of the item
	 **/
	public String toString() {
		return name;
	}
	
	/**
	 * returns a string representation of the item describing their stats
	 * @return a string represneting the items stats
	 **/
	public String toStringStats() {
		return name+":" + "\nOffense: "+ offence +"\nStamina: " + stamina +"\nDefense: "+defence + "\nSpeaking Style:" + speakingStyle;
	}
	
	/**
	 * takes the athlete param and boosts their stats based on item stats
	 * 
	 * @param item the item being used
	 * @param athlete the athlete stats being boosted
	 **/
	public void useItem(Item item, Athlete athlete) {
		int off = item.getOffence() + athlete.getOffense();
		int stam = item.getStamina() + athlete.getStamina();
		int def = item.getDefence() + athlete.getDefense();
		int speak = item.getSpeakingStyle() + athlete.getSpeakingStyle();
		if (off > 10) {
			off = 10;
		}
		if (stam > 10) {
			stam = 10;
		}
		if (def > 10) {
			def = 10;
		}
		if (speak > 10) {
			speak = 10;
		}
		athlete.setOffense(off);
		athlete.setStamina(stam);
		athlete.setDefense(def);
		athlete.setSpeakingStyle(speak);
	}

}