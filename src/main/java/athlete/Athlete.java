package athlete;

/**
 * 
 * This class implements an Athlete that can participate in debates
 *
 */

public class Athlete{
	
	/**
	 * the name of the athlete
	 */
	private String name;
	/**
	 * the offense stat (this represents the rebuttal content of a debate speech)
	 */
	private int offense; 
	/**
	 * the stamina stat 
	 */
	private int stamina;
	/**
	 * the athletes current stamina
	 */
	private int currentStamina;
	/**
	 * the defense stat (this represents the substantive content of a debate speech)
	 */
	private int defense;
	/**
	 * the buy price of an athlete
	 */
	private int price;
	/**
	 * used to calculate the buy back price of the athlete
	 */
	private static int buyBackModifier = 50;
	/**
	 * the preferred debate style of the athlete
	 */
	private String preferedDebateStyle;
	/**
	 * the speaking style stat
	 */
	private int speakingStyle;
	/**
	 * true if the athlete is injured, false if not
	 */
	private boolean isInjured;
	
	/**
	 * default athlete constructor
	 */
	public Athlete(){
		setName("nullAthlete");
		setOffense(0);
		setStamina(0);
		currentStamina = stamina;
		setDefense(0);
		setPrice(0);
		setPreferedDebateStyle("None");
		setSpeakingStyle(0);
		setInjured(false);
	}
	
	/**
	 * a more specific athlete constructor
	 * constructs an athlete based on the given parameters
	 * 
	 * @param name the name of the athlete
	 * @param offence the offence stat of the athlete
	 * @param stamina the stamina stat of the athlete
	 * @param defense the defense state of the athlete
	 * @param price the price of the athlete
	 * @param debateStyle the preferred debate style of the athlete
	 * @param speakingStyle the speaking style stat of the athlete
	 */
	public Athlete(String name, int offence, int stamina, int defense, int price, String debateStyle, int speakingStyle) {
		setName(name);
		setOffense(offence);
		setStamina(stamina);
		currentStamina = this.stamina;
		setDefense(defense);
		setPrice(price);
		setPreferedDebateStyle(debateStyle);
		setSpeakingStyle(speakingStyle);
		setInjured(false);
	}
	
	/**
	 * returns the athletes name
	 * @return name the athletes name
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * returns a string representation of the athlete describing their stats
	 * @return a string detailing the athletes stats
	 */
	public String toStringStats() {
		return name + System.getProperty("line.separator")+"Offense: "+offense+"\nStamina: " + currentStamina +" / "+ stamina +"\nDefense: "+defense + 
				"\nSpeaking style: " + speakingStyle +"\nPrefered style: "+preferedDebateStyle;
	}
	
	/**
	 * gets the name of the athlete
	 * 
	 * @return name the name of the athlete
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name of the athlete
	 * 
	 * @param name the name of the athlete
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * gets the offense stat
	 * @return the offense stat of the athlete
	 */
	public int getOffense() {
		return offense;
	}
	
	/**
	 * sets the offense stat 
	 * @param offense the offense stat of the athlete
	 */
	public void setOffense(int offense) {
		this.offense = offense;
	}
	
	/**
	 * returns the stamina stat
	 * 
	 * @return stamina the stamina stat of the athlete
	 */
	public int getStamina() {
		return stamina;
	}
	
	/**
	 * sets the stamina stat
	 * 
	 * @param stamina the stamina stat of the athlete
	 */
	public void setStamina(int stamina) {
		this.stamina = stamina;
		this.currentStamina = stamina;
	}
	
	/**
	 * returns the defense stat
	 * 
	 * @return defense the defense stat of the athlete
	 */
	public int getDefense() {
		return defense;
	}
	
	/**
	 * sets the defense stat
	 * 
	 * @param defense the defense stat of the athlete
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	/**
	 * returns the price of the athlete
	 * 
	 * @return price the price of the athlete
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * sets the price of the athlete
	 * 
	 * @param price the price of the athlete
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * returns the price of the athlete
	 * 
	 * @return price the price of the athlete
	 */
	public int getContractPrice() {
		return price;
	}
	
	/**
	 * returns the buy back price of the athlete
	 * 
	 * @return the buy back price of the athlete
	 */
	public int getBuyBackPrice() {
		return price - buyBackModifier;
	}
	
	/**
	 * returns a description of the athlete
	 * 
	 * @return a description of the athlete 
	 */
	public String getDescription() {
		return toString();
	}
	
	/**
	 * returns the preferred debate style of the athlete
	 * 
	 * @return preferredDebateStyle the preferred debate style of the athlete
	 */
	public String getPreferedDebateStyle() {
		return preferedDebateStyle;
	}
	
	/**
	 * set the preferred debate style
	 * 
	 * @param preferedDebateStyle the preferred debate style of the athlete
	 */
	public void setPreferedDebateStyle(String preferedDebateStyle) {
		this.preferedDebateStyle = preferedDebateStyle;
	}
	
	/**
	 * returns the speaking style stat
	 * 
	 * @return speakingStyle the speaking style stat of the athlete
	 */
	public int getSpeakingStyle() {
		return speakingStyle;
	}
	
	/**
	 * set the speaking style stat
	 * 
	 * @param speakingStyle the speaking style stat of the athlete
	 */
	public void setSpeakingStyle(int speakingStyle) {
		this.speakingStyle = speakingStyle;
	}
	
	/**
	 * returns the stamina stat
	 * 
	 * @return speakingStyle the stamina stat of the athlete
	 */
	public int getCurrentStamina() {
		return currentStamina;
	}
	
	/**
	 * sets the athletes current stamina to amount
	 * 
	 * @param amount the amount of stamina 
	 */
	public void setCurrentStamina(int amount) {
		currentStamina = amount;
	}
	
	/**
	 * subtracts a given amount from the athletes current stamina
	 * 
	 * @param subtractAmount the amount subtracted from the athletes current stamina
	 */
	public void subtractCurrentStamina(int subtractAmount) {
		currentStamina = currentStamina - subtractAmount;
		if(currentStamina < 0) {
			currentStamina = 0;
		}	
	}
	/**
	 * returns the isInjured
	 * 
	 * @return isInjured indicates whether the athlete is injured or not
	 */
	public boolean getIsInjured() {
		return isInjured;
	}
	
	/**
	 * sets the isInjured boolean
	 * 
	 * @param isInjured indicates whether the athlete is injured or not
	 */
	public void setInjured(boolean isInjured) {
		this.isInjured = isInjured;
	}
	
	/**
	 * increases all of the athletes stats by one if the stat is not already 10
	 */
	public void trainAthlete() {
		if(getOffense() != 10) {
			setOffense(getOffense()+1);
		}
		
		if(getDefense() != 10) {
			setDefense(getDefense()+1);
		}
		
		if(getStamina() != 10) {
			setStamina(getStamina()+1);
		}
		
		if(getSpeakingStyle() != 10) {
			setSpeakingStyle(getSpeakingStyle()+1);
		}

	}

}
