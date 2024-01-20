package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import GameEnviroment.GameLogic;
import athlete.Athlete;
import match.Match;
import team.PlayerTeam;

class GameLogicTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		GameLogic.currentWeek = 1;
	}

	@Test
	void incrementWeekTest() {
		GameLogic.incrementWeek();
		assertEquals(2, GameLogic.currentWeek);
	}
	
	@RepeatedTest(100)
	void randomNumberInRangeTest() {
		int testNum = GameLogic.randomNumberInRange(1, 10);
		assertTrue(1 <= testNum && testNum <= 10);
	}
	
	@Test
	void setCurrentWeekModifierTest() {
		GameLogic.incrementWeek();
		GameLogic.incrementWeek();
		assertEquals(0, GameLogic.getCurrentWeekModifier());
		GameLogic.incrementWeek();
		assertEquals(1, GameLogic.getCurrentWeekModifier());
		GameLogic.incrementWeek();
		assertEquals(1, GameLogic.getCurrentWeekModifier());
		GameLogic.incrementWeek();
		assertEquals(1, GameLogic.getCurrentWeekModifier());
		GameLogic.currentWeek = 12;
		assertEquals(2, GameLogic.getCurrentWeekModifier());
	}
	
	@Test
	void nameValidatorTest() {
		assertTrue(GameLogic.nameValidator("test name"));
		assertFalse(GameLogic.nameValidator("test*&*$&@@*"));
		assertFalse(GameLogic.nameValidator("te"));
		assertFalse(GameLogic.nameValidator("test name test name test name"));
	}
	
	@Test
	void isGameOver() {
		PlayerTeam testPlayerTeam = new PlayerTeam(10,"Test PlayerTeam");
		testPlayerTeam.addTeamMember(new Athlete());
		testPlayerTeam.addTeamMember(new Athlete());
		testPlayerTeam.addTeamMember(new Athlete());
		testPlayerTeam.addTeamMember(new Athlete());
		testPlayerTeam.addTeamMember(new Athlete());
		
		testPlayerTeam.setFirstSpeaker(testPlayerTeam.getTeamMemberList().get(0));
		testPlayerTeam.setSecondSpeaker(testPlayerTeam.getTeamMemberList().get(1));
		testPlayerTeam.setThirdSpeaker(testPlayerTeam.getTeamMemberList().get(2));
		testPlayerTeam.setFourthSpeaker(testPlayerTeam.getTeamMemberList().get(3));
		GameLogic.playerTeam = testPlayerTeam;
		
		GameLogic.seasonLength = 10;
		GameLogic.currentWeek = 9;
		assertFalse(GameLogic.isGameOver());
		GameLogic.incrementWeek();
		assertFalse(GameLogic.isGameOver());
		GameLogic.incrementWeek();
		assertTrue(GameLogic.isGameOver());
		
		GameLogic.currentWeek = 1;
		
		assertFalse(GameLogic.isGameOver());
		GameLogic.playerTeam.getFirstSpeaker().setInjured(true);
		GameLogic.playerTeam.getSecondSpeaker().setInjured(true);
		assertTrue(GameLogic.isGameOver());
		GameLogic.playerTeam.addTeamMember(new Athlete());
	
	}
	
	@Test
	void setupTest() {
		GameLogic.setup("test team", 6, 3);
		assertEquals("test team", GameLogic.playerTeam.getName());
		assertEquals(6, GameLogic.seasonLength);
		assertEquals(3, GameLogic.difficulty);
		assertTrue(GameLogic.currentMatchOne instanceof Match);
		assertTrue(GameLogic.currentMatchTwo instanceof Match);
		assertTrue(GameLogic.currentMatchThree instanceof Match);
	}
	
	@Test
	void currentMatchesTest() {
		
	}

}
