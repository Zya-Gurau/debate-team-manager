package athlete;

import java.util.ArrayList;

import GameEnviroment.GameLogic;
import team.Team;

/**
 * 
 * this class defines the athlete creator, a tool used to generate athletes
 *
 */

public class AthleteCreator {
	/**
	 * a list of possible names for athletes
	 */
	private static String[] names = {"James","Mary","Patricia",
			"Jennifer","Linda","David","William","Richard","Ashley","Paul",
			"Laura","Cynthia","Amy","Ryan","Jason","Anna","Larry","Helen",
			"Rachel","Samuel","Benjamin","Alexander","Maria","Diane"}; //24 names
	/**
	 * a list of preferred debate style
	 */
	private static String[] debateStyles = {"Empirical", "Comparative","Model","Abstract"};
	/**
	 * helper value for the range of the names array
	 */
	private static int namesRange = names.length-1;
	/**
	 * helper value for the range of the debate styles array
	 */
	private static int debateStylesRange = debateStyles.length -1;
	
	
	/**
	 * creates an athlete 
	 * @param statMin the minimum value a stat can be 
	 * @param statMax the maximum value a stat can be 
	 * @return athlete return the athlete created
	 */
	public static Athlete createAthlete(int statMin, int statMax) {
		String name = names[GameLogic.randomNumberInRange(0,namesRange)];
		int offence = GameLogic.randomNumberInRange(statMin,statMax);
		int stamina = GameLogic.randomNumberInRange(statMin,statMax);
		int defence = GameLogic.randomNumberInRange(statMin,statMax);
		int price = 200;
		int speakingStyle = GameLogic.randomNumberInRange(statMin,statMax);
		String preferedDebateStyle = debateStyles[GameLogic.randomNumberInRange(0,debateStylesRange)];
		Athlete athlete = new Athlete(name, offence, stamina, defence, price, preferedDebateStyle, speakingStyle);
		return athlete;
	}
	
	/**
	 * creates a list of athletes
	 * @param athleteAmount the amount of athletes to create
	 * @return athleteList the list of athletes
	 */
	public static ArrayList<Athlete> createPlayerAthleteList(int athleteAmount){
		ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
		int statMin = 4; // Minimum value of stat range
	    int statMax = 10; // Maximum value of stat range
		for(int i = 0; i<athleteAmount;i++) {
			Athlete athlete = createAthlete(statMin, statMax);
			athleteList.add(athlete);
		}
		return athleteList;
	}
	
	
	/**
	 * creates an enemy team 
	 * @param difficultyModifier modifies the enemy athletes stats based on the difficulty setting
	 * @param currentWeekModifier modifies the enemy athletes stats based on the current week
	 * @return enemyTeam the enemy team 
	 */
	public static Team createEnemyTeam(int difficultyModifier, int currentWeekModifier){//, int weekModifier
		Team enemyTeam = new Team();
		
		int statMin = 1+difficultyModifier+currentWeekModifier; // Minimum value of stat range
		
		if(statMin > 10) {
			statMin = 10;
		}
		
	    int statMax = 10; // Maximum value of stat range
		for(int i = 0; i<4;i++) {
			Athlete athlete = createAthlete(statMin, statMax);
			enemyTeam.addTeamMember(athlete);
		}
		enemyTeam.setFirstSpeaker(enemyTeam.getTeamMemberList().get(0));
		enemyTeam.setSecondSpeaker(enemyTeam.getTeamMemberList().get(1));
		enemyTeam.setThirdSpeaker(enemyTeam.getTeamMemberList().get(2));
		enemyTeam.setFourthSpeaker(enemyTeam.getTeamMemberList().get(3));
		return enemyTeam;
	}
	


}
