package market;

import GameEnviroment.GameLogic;

/**
 * 
 * This class implements a Water Bottle item that boosts speaking style stat
 * 
 */
public class WaterBottle extends Item{

	/**
	 * the Water Bottle constructor
	 */
	public WaterBottle() {
		super("WaterBottle",0,0,0, GameLogic.randomNumberInRange(3,10));
	}
	
	
}
