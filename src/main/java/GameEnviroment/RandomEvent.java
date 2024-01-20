package GameEnviroment;

import athlete.Athlete;
import athlete.AthleteCreator;
import team.Team;


/**
 * this class implements the random events that can happen when the player takes a by
 *
 */
public class RandomEvent {
	
	/**
	 * the threshold value needed for a random event to trigger, the random value generated must be above this value
	 */
	private static int randomEventThreshold = 60; // 1-100
	
	/**
	 * gets the randomEventThreshold value
	 * @return randomEventThreshold
	 */
	public static int getRandomEventThreshHold() {
		return randomEventThreshold;
	}
	
	/**
	 * sets the randomEventThreshold Value
	 * @param threshold the new value of randomEventThreshold
	 */
	public static void setRandomEventThreshHold(int threshold) {
		randomEventThreshold = threshold;
	}
	
	/**
	 * gets a random athlete from the players team and increases one of their stats by 1
	 */
	public static void statIncrease() {
		int randomAthleteIndex = GameLogic.randomNumberInRange(0, GameLogic.playerTeam.getTeamMemberList().size()-1);
		Athlete randomAthlete = GameLogic.playerTeam.getTeamMemberList().get(randomAthleteIndex);
		int randomStatInt = GameLogic.randomNumberInRange(1, 4);
		if(randomStatInt == 1) {
			randomAthlete.setDefense(randomAthlete.getDefense()+1);
		}
		if(randomStatInt == 2) {
			randomAthlete.setOffense(randomAthlete.getOffense()+1);
		}
		if(randomStatInt == 3) {
			randomAthlete.setStamina(randomAthlete.getStamina()+1);
		}
		if(randomStatInt == 4) {
			randomAthlete.setSpeakingStyle(randomAthlete.getSpeakingStyle()+1);
		}	
	}
	
	/**
	 * gets a random athlete from the players team and removes them from the team, the chance of a specific athlete being removes increases
	 * if they are injured
	 */
	public static void athleteQuits() {
		int maxNum = 0;
		int currentIndex = 0;
		for(Athlete athlete: GameLogic.playerTeam.getTeamMemberList()) {
			int maxVal = 20;
			if(athlete.getIsInjured()) {
				maxVal = 30;
			}
			int randomNum = GameLogic.randomNumberInRange(1, maxVal);
			if(randomNum >= maxNum) {
				maxNum = randomNum;
				currentIndex = GameLogic.playerTeam.getTeamMemberList().indexOf(athlete);
			}
			
		}
		GameLogic.playerTeam.removeTeamMember(currentIndex);
		
	}
	
	/**
	 * generates an athlete and adds them to the players team if they have room (size of team below 9)
	 */
	public static void athleteJoins() {
		if(GameLogic.playerTeam.getTeamMemberList().size() < 9) {
			Athlete newAthlete = AthleteCreator.createAthlete(4, 10);
			GameLogic.playerTeam.addTeamMember(newAthlete);
			//System.out.println(newAthlete.getName() + " has joined " + GameLogic.playerTeam.getName());
		}
	}
	
	/**
	 * generates a random event
	 * 20% chance for a random event to trigger
	 * 16% chance that a random athletes stat increases
	 * 0.4% chance a random athlete quits (not accounting for injury)
	 * 3.6% chance that a random athletes joins the players team
	 */
	public static void generateRandomEvent() {
		int randomInt = GameLogic.randomNumberInRange(1, 100);
		if(randomInt >= randomEventThreshold) {
			int statIncreaseRandomInt = GameLogic.randomNumberInRange(1, 100);
			if(statIncreaseRandomInt >= 20) {
				statIncrease();
			}
			else{
				int playerQuitsRandomInt = GameLogic.randomNumberInRange(1, 100);
				if(playerQuitsRandomInt >= 90 && GameLogic.playerTeam.getTeamMemberList().size() > 4) {
					athleteQuits();
				}
				else {
					athleteJoins();
				}
			}
		}
	}
	
	/**
	 * same as the generateRandomEvent method but used for testing, shows distribution of random event calls
	 */
	public static void generateRandomEventTestHelper() {
		int numOfTests = 200;
		int numOfIncreaseCalls = 0;
		int numOfQuitCalls = 0;
		int numOfJoinCalls = 0;
		for(int i = 0; i <= numOfTests; i++) {
			
			Team testTeam = new Team();
			testTeam.addTeamMember(new Athlete());
			testTeam.addTeamMember(new Athlete());
			testTeam.addTeamMember(new Athlete());
			testTeam.addTeamMember(new Athlete());
			GameLogic.playerTeam.setTeamMemberList(testTeam.getTeamMemberList());
			
		int randomInt = GameLogic.randomNumberInRange(1, 100);
		if(randomInt >= randomEventThreshold) {
			int statIncreaseRandomInt = GameLogic.randomNumberInRange(1, 100);
			if(statIncreaseRandomInt >= 20) {
				numOfIncreaseCalls = numOfIncreaseCalls + 1;
				statIncrease();
			}
			else{
				int playerQuitsRandomInt = GameLogic.randomNumberInRange(1, 100);
				if(GameLogic.playerTeam.getTeamMemberList().size() > 4 && playerQuitsRandomInt >= 90) {
					numOfQuitCalls = numOfQuitCalls + 1;
					System.out.println("called");
					athleteQuits();
				}
				else {
					numOfJoinCalls = numOfJoinCalls + 1;
					athleteJoins();
				}
			}
		}
	}
		System.out.println("number of statIncrease() Calls: " + numOfIncreaseCalls);
		System.out.println("number of athleteQuits() Calls: " + numOfQuitCalls);
		System.out.println("number of athleteJoins() Calls: " + numOfJoinCalls);
	}

}
