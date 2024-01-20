package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import athlete.Athlete;
import athlete.AthleteCreator;
import team.Team;

class AthleteCreatorTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@RepeatedTest(10)
	void createAthleteTest() {
		Athlete athlete = AthleteCreator.createAthlete(3, 10);
		assertTrue(3 <= athlete.getStamina() && athlete.getStamina() <= 10);
		assertTrue(3 <= athlete.getOffense() && athlete.getOffense() <= 10);
		assertTrue(3 <= athlete.getDefense() && athlete.getDefense() <= 10);
		assertTrue(3 <= athlete.getSpeakingStyle() && athlete.getSpeakingStyle() <= 10);
		assertTrue(athlete.getPreferedDebateStyle() == "Empirical" || athlete.getPreferedDebateStyle() == "Comparative" 
				|| athlete.getPreferedDebateStyle() == "Model" || athlete.getPreferedDebateStyle() == "Abstract");
	}
	
	@RepeatedTest(10)
	void createPlayerAthleteList() {
		ArrayList<Athlete> athleteList = AthleteCreator.createPlayerAthleteList(10);
		assertEquals(10, athleteList.size());
		for(Athlete athlete: athleteList) {
			assertTrue(4 <= athlete.getStamina() && athlete.getStamina() <= 10);
			assertTrue(4 <= athlete.getOffense() && athlete.getOffense() <= 10);
			assertTrue(4 <= athlete.getDefense() && athlete.getDefense() <= 10);
			assertTrue(4 <= athlete.getSpeakingStyle() && athlete.getSpeakingStyle() <= 10);
			assertTrue(athlete.getPreferedDebateStyle() == "Empirical" || athlete.getPreferedDebateStyle() == "Comparative" 
					|| athlete.getPreferedDebateStyle() == "Model" || athlete.getPreferedDebateStyle() == "Abstract");
		}
	}
	
	@RepeatedTest(10)
	void createEnemyTeamTest() {
		Team enemyTeam = AthleteCreator.createEnemyTeam(1, 1);
		for(Athlete athlete : enemyTeam.getTeamMemberList()) {
			assertTrue(3 <= athlete.getStamina() && athlete.getStamina() <= 10);
			assertTrue(3 <= athlete.getOffense() && athlete.getOffense() <= 10);
			assertTrue(3 <= athlete.getDefense() && athlete.getDefense() <= 10);
			assertTrue(3 <= athlete.getSpeakingStyle() && athlete.getSpeakingStyle() <= 10);
			assertTrue(athlete.getPreferedDebateStyle() == "Empirical" || athlete.getPreferedDebateStyle() == "Comparative" 
					|| athlete.getPreferedDebateStyle() == "Model" || athlete.getPreferedDebateStyle() == "Abstract");
		}
		
		Team enemyTeamTwo = AthleteCreator.createEnemyTeam(8, 4);
		for(Athlete athlete : enemyTeamTwo.getTeamMemberList()) {
			assertTrue(10 <= athlete.getStamina() && athlete.getStamina() <= 10);
			assertTrue(10 <= athlete.getOffense() && athlete.getOffense() <= 10);
			assertTrue(10 <= athlete.getDefense() && athlete.getDefense() <= 10);
			assertTrue(10 <= athlete.getSpeakingStyle() && athlete.getSpeakingStyle() <= 10);
			assertTrue(athlete.getPreferedDebateStyle() == "Empirical" || athlete.getPreferedDebateStyle() == "Comparative" 
					|| athlete.getPreferedDebateStyle() == "Model" || athlete.getPreferedDebateStyle() == "Abstract");
		}
		
	}

}
