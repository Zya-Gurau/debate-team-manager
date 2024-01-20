package market;

import GameEnviroment.GameLogic;

/**
 * 
 * This class implements a Timer item that boosts stamina stat
 * 
 */
public class Timer extends Item{
	/**
	 * the Timer constructor
	 */
	public Timer() {
		super("Timer",0,GameLogic.randomNumberInRange(3,10),0,0);
	}
	
}
