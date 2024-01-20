package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GameEnviroment.GameLogic;
import athlete.Athlete;
import match.Match;
import match.Moot;
import team.PlayerTeam;
import team.Team;

class MatchTest {
	
	PlayerTeam playerTeam;
	Team oppTeam;
	Moot moot;
	Match match;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		moot = new Moot("This house believes that testing should be easier", "Empirical");
		Athlete athleteOne = new Athlete("Athlete One", 5,2,8,5,"Empirical",5);
		Athlete athleteTwo = new Athlete("Athlete Two", 7,3,7,5,"Model",5);
		Athlete athleteThree = new Athlete("Athlete Three", 8,5,5,5,"Empirical",5);
		Athlete athleteFour = new Athlete("Athlete Four", 7,7,5,5,"Abstract",8);
		playerTeam = new PlayerTeam(0,"Test PlayerTeam");
		GameLogic.playerTeam = playerTeam;
		playerTeam.addTeamMember(athleteOne);
		playerTeam.addTeamMember(athleteTwo);
		playerTeam.addTeamMember(athleteThree);
		playerTeam.addTeamMember(athleteFour);
		playerTeam.setFirstSpeaker(athleteOne);
		playerTeam.setSecondSpeaker(athleteTwo);
		playerTeam.setThirdSpeaker(athleteThree);
		playerTeam.setFourthSpeaker(athleteFour);
		
		Athlete oppAthleteOne = new Athlete("Athlete One", 5,5,7,5,"Empirical",5);
		Athlete oppAthleteTwo = new Athlete("Athlete Two", 6,5,6,5,"Model",5);
		Athlete oppAthleteThree = new Athlete("Athlete Three", 7,5,5,5,"Empirical",5);
		Athlete oppAthleteFour = new Athlete("Athlete Four", 6,5,5,5,"Abstract",7);
		oppTeam = new Team("Test oppTeam");
		oppTeam.addTeamMember(oppAthleteOne);
		oppTeam.addTeamMember(oppAthleteTwo);
		oppTeam.addTeamMember(oppAthleteThree);
		oppTeam.addTeamMember(oppAthleteFour);
		
		oppTeam.setFirstSpeaker(oppAthleteOne);
		oppTeam.setSecondSpeaker(oppAthleteTwo);
		oppTeam.setThirdSpeaker(oppAthleteThree);
		oppTeam.setFourthSpeaker(oppAthleteFour);
		
		match = new Match(playerTeam, oppTeam, moot);
	}

	@Test
	void calculateSpeakerPointsTest() {
		assertEquals(12.5, match.calculateFirstSpeakerPoints(playerTeam.getFirstSpeaker()));
		assertEquals(11.5, match.calculateSecondSpeakerPoints(playerTeam.getSecondSpeaker()));
		assertEquals(12.5, match.calculateThirdSpeakerPoints(playerTeam.getThirdSpeaker()));
		assertEquals(14.0, match.calculateFourthSpeakerPoints(playerTeam.getFourthSpeaker()));
	}
	
	@Test
	void calculateWinMoneyTest(){
		//win money is only given when the player points are higher than the opposing
		//teams points, this means we do not need to worry about this method returning negative values
		assertEquals(105,match.calculateWinMoney(40.5, 40.0));
		assertEquals(225,match.calculateWinMoney(30, 17.5));
		assertEquals(265,match.calculateWinMoney(36.5, 20));
	}
	
	@Test
	void calculateOpposingSpeakerPoints() {
		double[] array = {11.5,10.5,11.5,12};
		assertTrue(Arrays.equals(array, match.calculateOpposingSpeakerPoints()));
	}
	
	@Test
	void calculatePlayerSpeakerPoints() {
		double[] array = {12.5,11.5,12.5,14};
		assertTrue(Arrays.equals(array, match.calculatePlayerSpeakerPoints()));
		
	}
	
	@Test
	void playerTeamAthleteEffects() {
		match.playerTeamAthleteEffects();
		assertTrue(playerTeam.getFirstSpeaker().getIsInjured());
		assertTrue(playerTeam.getSecondSpeaker().getIsInjured());
		assertEquals(2, playerTeam.getThirdSpeaker().getCurrentStamina());
		assertEquals(4, playerTeam.getFourthSpeaker().getCurrentStamina());
	}
	
	@Test
	void playMatchTest() {
		double[] testArray = {50.5, 45.5};
		assertTrue(Arrays.equals(testArray, match.playMatch()));
	}
	

	

}
