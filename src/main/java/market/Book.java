package market;

import GameEnviroment.GameLogic;

/**
 * 
 * This class implements a Book item that boosts offence stat
 * 
 */

public class Book extends Item{
	
	/**
	 * the Book constructor
	 */
	public Book() {
		super("Book",GameLogic.randomNumberInRange(3,10),0,0,0);
	}
	
}
