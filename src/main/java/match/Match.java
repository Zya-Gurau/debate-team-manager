package match;

import java.util.ArrayList;

import GameEnviroment.GameLogic;
import athlete.Athlete;
import team.PlayerTeam;
import team.Team;

/**
 * 
 * This Class defines a Match in where the player team debates against an oppositions team based on a moot
 * 
 *
 */
public class Match {
	
	/**
	 * the players team
	 */
	private PlayerTeam playerTeam;
	/**
	 * the opposition team
	 */
	private Team oppTeam;
	/**
	 * the debate moot
	 */
	private Moot moot;
	/**
	 * a list containing the players first, second, third, and fourth speakers
	 */
	private Athlete[] speakerList = new Athlete[4];
	
	
	/**
	 * Constructs a match between the playerTeam and opposingTeam based on the moot
	 * initialises required variables
	 * 
	 * @param playerTeam the players team
	 * @param opposingTeam the opposing team
	 * @param moot the matches moot
	 */
	public Match(PlayerTeam playerTeam, Team opposingTeam, Moot moot) {
		this.playerTeam = playerTeam;
		this.oppTeam = opposingTeam;
		this.moot = moot;
		speakerList[0] = GameLogic.playerTeam.getFirstSpeaker(); 
		speakerList[1] = GameLogic.playerTeam.getSecondSpeaker(); 
		speakerList[2] = GameLogic.playerTeam.getThirdSpeaker(); 
		speakerList[3] = GameLogic.playerTeam.getFourthSpeaker();
	}
	
	/**
	 * gets the matches moot
	 * @return moot the matches moot
	 */
	public String getMoot() {
		return moot.getName();
	}
	
	/**
	 * gets the style of the matches moot 
	 * @return moot.getStyle()
	 */
	public String getMootStyle() {
		return moot.getStyle();
	}
	
	/**
	 * get the opposing team
	 * @return oppTeam the opposing team
	 */
	public Team getOppTeam() {
		return oppTeam;
	}
	
	
	/**
	 * Calculates the style preference bonus of a given athlete(speaker)
	 * +2 if the athletes style preference is equal to the style of the moot
	 * -1 if the athletes style preference is not equal to the style of the moot
	 * 
	 * @param athlete a given athlete
	 * @return stylePreferenceBonus a bonus used when calculating a speakers individual points
	 */
	public int getStylePreferenceBonus(Athlete athlete) {
		int stylePreferenceBonus = 2;
		if (athlete.getPreferedDebateStyle() != moot.getStyle()) {
			stylePreferenceBonus = -1;
		}
		return stylePreferenceBonus;
	}
	
	/**
	 * the method used to calculate the points of a first speakers speech
	 * 
	 * @param athlete a given athlete
	 * @return the first speakers points
	 */
	public double calculateFirstSpeakerPoints(Athlete athlete) {
		int stylePreferenceBonus = getStylePreferenceBonus(athlete);
		return (athlete.getDefense()+stylePreferenceBonus + (athlete.getSpeakingStyle()* 0.5));
	}
	
	/**
	 * the method used to calculate the points of a second speakers speech
	 * 
	 * @param athlete a given athlete
	 * @return the second speakers points
	 */
	public double calculateSecondSpeakerPoints(Athlete athlete) {
		int stylePreferenceBonus = getStylePreferenceBonus(athlete);
		return ((athlete.getDefense()/2)+athlete.getOffense()+stylePreferenceBonus + (athlete.getSpeakingStyle()* 0.5));
	}
	
	/**
	 * the method used to calculate the points of a third speakers speech
	 * 
	 * @param athlete a given athlete
	 * @return the third speakers points
	 */
	public double calculateThirdSpeakerPoints(Athlete athlete) {
		int stylePreferenceBonus = getStylePreferenceBonus(athlete);
		return (athlete.getOffense()+stylePreferenceBonus + (athlete.getSpeakingStyle()* 0.5));
	}
	
	/**
	 * the method used to calculate the points of a fourth speakers speech
	 * 
	 * @param athlete a given athlete
	 * @return the fourth speakers points
	 */
	public double calculateFourthSpeakerPoints(Athlete athlete) {
		int stylePreferenceBonus = getStylePreferenceBonus(athlete);
		return (athlete.getOffense()+stylePreferenceBonus + athlete.getSpeakingStyle());
	}
	
	
	/**
	 * calculates the the amount of money given to the player for winning a match
	 * 
	 * @param totalPlayerPoints the players total points
	 * @param totalOppPoints the opposing teams total points
	 * @return the amount of money given to the player for winning a match
	 */
	public int calculateWinMoney(double totalPlayerPoints, double totalOppPoints) {
		return (int) (((totalPlayerPoints - totalOppPoints) * 10) + 100);
	}

	
	/**
	 * subtracts 3 stamina from each of the players speakers and checks if an athletes stamina has reached 0
	 * if stamina = 0 the athlete is set to injured.
	 * @return injuredList a list of injured athletes
	 */
	public ArrayList<Athlete> playerTeamAthleteEffects() {
		GameLogic.playerTeam.getFirstSpeaker().subtractCurrentStamina(3);
		GameLogic.playerTeam.getSecondSpeaker().subtractCurrentStamina(3);
		GameLogic.playerTeam.getThirdSpeaker().subtractCurrentStamina(3);
		GameLogic.playerTeam.getFourthSpeaker().subtractCurrentStamina(3);
		Athlete[] speakers = {GameLogic.playerTeam.getFirstSpeaker(),GameLogic.playerTeam.getSecondSpeaker(),
				GameLogic.playerTeam.getThirdSpeaker(),GameLogic.playerTeam.getFourthSpeaker()};
		ArrayList<Athlete> injuredList = new ArrayList<Athlete>();
		for(Athlete athlete : speakers) {
			if (athlete.getCurrentStamina() <= 0) {
				athlete.setInjured(true);
				injuredList.add(athlete);
			}
		}
		return injuredList;
	}
	
	/**
	 * calculates the points of each speaker in the players team.
	 * 
	 * @return playerPointsArray an array containing the points of each of the players speakers
	 */
	public double[] calculatePlayerSpeakerPoints() {
		double playerFirstPoints = calculateFirstSpeakerPoints(playerTeam.getFirstSpeaker());
		double playerSecondPoints = calculateSecondSpeakerPoints(playerTeam.getSecondSpeaker());
		double playerThirdPoints = calculateThirdSpeakerPoints(playerTeam.getThirdSpeaker());
		double playerFourthPoints = calculateFourthSpeakerPoints(playerTeam.getFourthSpeaker());
		double[] playerPointsArray = {playerFirstPoints, playerSecondPoints, playerThirdPoints, playerFourthPoints};
		return playerPointsArray;
	}
	
	/**
	 * calculates the points of each speaker in the opposing team.
	 * 
	 * @return oppPointsArray an array containing the points of each of the opposing teams speakers
	 */
	public double[] calculateOpposingSpeakerPoints() {
		double oppFirstPoints = calculateFirstSpeakerPoints(oppTeam.getFirstSpeaker());
		double oppSecondPoints = calculateSecondSpeakerPoints(oppTeam.getSecondSpeaker());
		double oppThirdPoints = calculateThirdSpeakerPoints(oppTeam.getThirdSpeaker());
		double oppFourthPoints = calculateFourthSpeakerPoints(oppTeam.getFourthSpeaker());
		double[] oppPointsArray = {oppFirstPoints, oppSecondPoints, oppThirdPoints, oppFourthPoints};
		return oppPointsArray;
	}
	
	/**
	 * Calculates the sum of an Array of speakers points.
	 * 
	 * @param pointsArray an array containing points from each of the four speakers
	 * @return the sum of the elements of pointsArray
	 */
	public double getSumOfPointsArray(double[] pointsArray) {
		return pointsArray[0] + pointsArray[1] + pointsArray[2] + pointsArray[3];
	}
	
	/**
	 * plays a match
	 *@return allPoints an array containing the total points of both teams
	 */
	public double[] playMatch() {
		double[] playerPointsArray = calculatePlayerSpeakerPoints();
		double totalPlayerPoints = getSumOfPointsArray(playerPointsArray);
		
		double[] oppPointsArray = calculateOpposingSpeakerPoints();
		double totalOppPoints = getSumOfPointsArray(oppPointsArray);
		
		double[] allPoints = {totalPlayerPoints, totalOppPoints};
		GameLogic.incrementWeek();
		GameLogic.setCurrentMatches();
		return allPoints;	
		
	}
}
