package market;

/**
 * defines the price
 *
 */
public class Price{

	private int sum;
	private int price;
	private int division;
	
	/**
	 * determines the price based on stats
	 * @param offence the offense stat
	 * @param stamina the stamina stat
	 * @param defence the defense stat
	 * @return price the determined price
	 */
	public int priceGenerator(int offence, int stamina, int defence) {
		sum = offence + stamina + defence;
		division = sum / 5;
		switch (division) {
		case 0:{
			price = 50; 
			break;
		}
		case 1:{
			price = 60;
			break;
		}
		case 2:{
			price = 70;
			break;
		}
		}
		return price;
	}



}