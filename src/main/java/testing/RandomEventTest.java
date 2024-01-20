package testing;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GameEnviroment.GameLogic;
import GameEnviroment.RandomEvent;
import athlete.Athlete;
import team.PlayerTeam;

class RandomEventTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		GameLogic.playerTeam = new PlayerTeam("default team");
		GameLogic.playerTeam.addTeamMember(new Athlete());
		GameLogic.playerTeam.addTeamMember(new Athlete());
		
	

	}

	@Test
	void statIncreaseTest() {
		RandomEvent.statIncrease();
		//System.out.println(GameLogic.playerTeam.getTeamMemberList().get(0));
		//System.out.println(GameLogic.playerTeam.getTeamMemberList().get(1));
		assertTrue((GameLogic.playerTeam.getTeamMemberList().get(0).getDefense() == 1 || 
				GameLogic.playerTeam.getTeamMemberList().get(0).getOffense() == 1 || 
				GameLogic.playerTeam.getTeamMemberList().get(0).getStamina() == 1 ||
				GameLogic.playerTeam.getTeamMemberList().get(0).getSpeakingStyle() == 1) ||
				(GameLogic.playerTeam.getTeamMemberList().get(1).getDefense() == 1 || 
				GameLogic.playerTeam.getTeamMemberList().get(1).getOffense() == 1 || 
				GameLogic.playerTeam.getTeamMemberList().get(1).getStamina() == 1 ||
				GameLogic.playerTeam.getTeamMemberList().get(1).getSpeakingStyle() == 1)
				);
	}
	
	@Test
	void athleteQuitsTest() {
		//System.out.println(GameLogic.playerTeam);
		RandomEvent.athleteQuits();
		//System.out.println(GameLogic.playerTeam);
		assertEquals(1, GameLogic.playerTeam.getTeamMemberList().size());
	}
	
	@Test
	void athleteJoinsTest() {
		//System.out.println(GameLogic.playerTeam);
		RandomEvent.athleteJoins();
		//System.out.println(GameLogic.playerTeam);
		assertEquals(3, GameLogic.playerTeam.getTeamMemberList().size());
		RandomEvent.athleteJoins();
		RandomEvent.athleteJoins();
		RandomEvent.athleteJoins();
		RandomEvent.athleteJoins();
		RandomEvent.athleteJoins();
		RandomEvent.athleteJoins();
		assertEquals(9, GameLogic.playerTeam.getTeamMemberList().size());
		RandomEvent.athleteJoins();
		assertEquals(9, GameLogic.playerTeam.getTeamMemberList().size());
	}
	
	@Test
	void generateRandomEventTest() {
		//Excepted values out of 200 tests:
		//number of no calls made: approx 160
		//number of statIncrease() calls: approx 32
		//number of athleteQuits() Calls: approx 0.8
		//number of athleteJoins() calls: approx 7.2
		RandomEvent.generateRandomEventTestHelper();
		//athletesQuits should never be called when the length of the team member list is >= 4
		//by default team member list size is 4 - can change in the test helper method in the RandomEventClass 
		
	}

}
