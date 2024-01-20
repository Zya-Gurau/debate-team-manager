package market;

/**
 * 
 * This class implements InsufficientBalanceException which is used to show when the user doesn't have 
 * enough money to buy something
 *
 */
public class InsufficientBalanceException extends Exception{
	
	/**
	 * default constructor, calls super()
	 * 
	 * @param errorMessage the error message to be displayed
	 */
	public InsufficientBalanceException(String errorMessage) {
		super(errorMessage);
	}

}
