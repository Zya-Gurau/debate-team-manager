package GameEnviroment;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import athlete.Athlete;
import athlete.AthleteCreator;
import gui.ClubScreen;
import gui.MainMenuScreen;
import gui.SetupScreen;
import gui.MarketScreen;
import gui.StadiumScreen;
import match.Match;
import match.Moot;
import team.PlayerTeam;
import market.Market;
import gui.Inventory;
import gui.AthleteTrainingScreen;

/**
 * 
 * This class defines most of the games functionality
 *
 */

public class GameLogic {
	
	/**
	 * The players team of debaters
	 */
	public static PlayerTeam playerTeam;
	/**
	 * The amount of matches able to be played (length of the game)
	 */
	public static int seasonLength;
	/**
	 * The current week
	 */
	public static int currentWeek = 1;
	/**
	 * A modifier used in the generation of opposing debaters based of the current week
	 * (How far through the game the player is)
	 */
	public static int currentWeekModifier = 0;
	/**
	 * The difficulty level 1-3
	 */
	public static int difficulty;
	/**
	 * The first available match for the current week
	 */
	public static Match currentMatchOne;
	/**
	 * The second available match for the current week
	 */
	public static Match currentMatchTwo;
	/**
	 * The third available match for the current week
	 */
	public static Match currentMatchThree;
	/**
	 * A list of available moots used to generate matches
	 */
	public static Moot[] mootList = {new Moot("THB that eating meat is murder.", "Empirical"), new Moot("THB that capital punishment solves nothing.", "Empirical"), 
			new Moot("THB that this country is too isolated.", "Empirical"),new Moot("THB that exams are not a good form of testing.", "Empirical"), new Moot("THB that the value of sport is over-rated.", "Empirical"),
			new Moot("THB that humanity has gained more from Walt Disney than from Shakespeare.", "Comparative"), new Moot("THB that humanity ha gained more from science than from literature.", "Comparative"),
			new Moot("THB that imagination is more important than knowledge.", "Comparative"),new Moot("THB that intolerance is more dangerous than ignorance.", "Comparative"),new Moot("THB that vaping is more dangerous than smoking.", "Comparative"),
			new Moot("THB that private schools should be abolished.", "Model"),new Moot("THB that that this country should stay nuclear free.", "Model"),new Moot("THB that alcohol should be banned in this country.", "Model"),
			new Moot("THB that private cars should be banned from our streets.", "Model"),new Moot("THB that school uniforms should be abolished.", "Model"),
			new Moot("THB that crime pays.", "Abstract"),new Moot("THB that money is the root of all evil.", "Abstract"),new Moot("THB that every cloud has a silver lining.", "Abstract"),new Moot("THB that might is always right.", "Abstract"),
			new Moot("THB that there is always a tomorrow.", "Abstract")};
	/**
	 * A default athlete used to initialise the player's team
	 */
	public static Athlete nullAthlete = new Athlete();
	
	/**
	 * the initial market object
	 */
	public static Market market = new Market();
	
	/**
	 * increments the current week by one
	 */
	public static void incrementWeek() {
		currentWeek = currentWeek + 1;
	}
	
	/**
	 * used to generate random numbers within a specified range
	 * 
	 * @param min the lower bound for the random number generation
	 * @param max the upper bound for the random number generation
	 * @return a random number with the upper and lower bound
	 */
	public static int randomNumberInRange(int min, int max) {
		return(int)Math.floor(Math.random() * (max - min + 1) + min);
	}
	
	/**
	 * the function used to set the currentWeekModifier
	 * the value of the modifier is based on whether the current week is a multiple of 3, 
	 * if so the value of the cuurentWeekModifier is increased by 1
	 */
	public static void setCurrentWeekModifier() {
		if(currentWeek % 4 == 0) {
			currentWeekModifier = currentWeekModifier + 1;
		}
	}
	
	/**
	 * both sets and get the current week modifier
	 * 
	 * @return currentWeekModifier 
	 */
	public static int getCurrentWeekModifier() {
		setCurrentWeekModifier();
		return currentWeekModifier;
	}
	
	/**
	 * sets the available matches for the current week
	 */
	public static void setCurrentMatches() {
		currentMatchOne = new Match(playerTeam, AthleteCreator.createEnemyTeam(difficulty, getCurrentWeekModifier()),GameLogic.mootList[GameLogic.randomNumberInRange(0, GameLogic.mootList.length-1)]);
		currentMatchTwo = new Match(playerTeam, AthleteCreator.createEnemyTeam(difficulty, getCurrentWeekModifier()),GameLogic.mootList[GameLogic.randomNumberInRange(0, GameLogic.mootList.length-1)]);
		currentMatchThree = new Match(playerTeam, AthleteCreator.createEnemyTeam(difficulty, getCurrentWeekModifier()),GameLogic.mootList[GameLogic.randomNumberInRange(0, GameLogic.mootList.length-1)]);
	}
	
	/**
	 * used to make sure the players chosen team name conforms to the requirements
	 * The team name must be between 3-15 letter and include on special characters
	 * 
	 * @param name taken from user input
	 * @return a boolean based on whether the inputed name is acceptable
	 */
	public static boolean nameValidator(String name) {
		if(name.length() <= 15 && name.length()>=3) {
			Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
			
			Matcher hasSpecial = special.matcher(name); 
			
			if(hasSpecial.find() == false) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 * updates the market attribute 
	 */
	public static void updateMarket() {
			GameLogic.market = new Market();
	}
	
	/**
	 * returns a boolean indicating whether or not the game is over
	 * 
	 * @return a boolean: true if the game is over, false if not
	 */
	public static boolean isGameOver() {
		if(currentWeek == seasonLength + 1 || playerTeam.canContinue() == false) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * initialises all of the variables needed to start the game
	 * -sets difficulty
	 * -sets seasonLength
	 * -creates a PlayerTeam and initialises the starting Athletes and team name, getting the player to choose their speaking positions
	 * -initialises the available matches for the current week
	 * @param name the ame of the player team
	 * @param seasonLengthValue the length of the season
	 * @param difficultyValue the games difficulty
	 */
	public static void setup(String name, int seasonLengthValue, int difficultyValue) {
		playerTeam = new PlayerTeam(name);
		difficulty = difficultyValue;
		seasonLength = seasonLengthValue;
		
		ArrayList<Athlete> initialSpeakers = market.initialAthletes();
		for(Athlete athlete : initialSpeakers) {
			playerTeam.addTeamMember(athlete);
		}
		setCurrentMatches();
		
		
	}
	
	
	/**
	 * launches the setup screen
	 */
	public static void launchSetupScreen() {
		SetupScreen setupScreen = new SetupScreen();
	}
	
	/**
	 * launches the main menu screen
	 * 
	 */
	public static void launchMainMenuScreen() {
		MainMenuScreen mainMenuScreen = new MainMenuScreen();
	}
	
	/**
	 * launches the club screen
	 */
	public static void launchClubScreen() {
		ClubScreen clubScreen = new ClubScreen();
	}
	
	/**
	 * launches the stadium screen
	 */
	public static void launchStadiumScreen() {
		StadiumScreen stadiumScreen = new StadiumScreen();
	}
	
	/**
	 * launches the market screen
	 */
	public static void launchMarketScreen() {
		MarketScreen marketScreen = new MarketScreen();
	}
	
	/**
	 * launches the inventory screen
	 */
	public static void launchInventoryScreen() {
		Inventory marketScreen = new Inventory();
	}
	
	/**
	 * launches the athlete training screen
	 */
	public static void launchAthleteTrainingScreen() {
		AthleteTrainingScreen athleteTrainingScreen = new AthleteTrainingScreen();
	}
	
	/**
	 * Where the game is run from
	 * @param args main args 
	 */
	public static void main(String[] args) {
		
		GameLogic.launchSetupScreen();
		
		
	}
}
