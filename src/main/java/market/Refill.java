package market;

import GameEnviroment.GameLogic;

/**
 * 
 * This class implements a Refill item that boosts defence stat
 * 
 */
public class Refill extends Item{
	
	/**
	 * the Refill constructor
	 */
	public Refill() {
		super("Refill",0,0, GameLogic.randomNumberInRange(3,10),0);
	}
	
	
}
