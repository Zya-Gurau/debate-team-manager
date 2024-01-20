package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import athlete.Athlete;
import team.Team;

class TeamTest {
	private Team teamTest;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		teamTest = new Team();
		teamTest.addTeamMember(new Athlete());
	}

	@Test
	void ToStringTest() {
		assertEquals("Team Name: "+ teamTest.getName() +"\n"+teamTest.getTeamMemberList().get(0).toString()+"\n\n", teamTest.toString());
	}
	
	@Test
	void addTeamMemberTest() {
		teamTest.addTeamMember(new Athlete());
		assertEquals(2,teamTest.getTeamMemberList().size());
	}
	
	@Test
	void teamNameConstructorTest() {
		Team newTeamTest = new Team("Test Team");
		assertEquals("Test Team", newTeamTest.getName());
	}
	
	@Test
	void SpeakerPositionGettersAndSettersTest() {
		teamTest.addTeamMember(new Athlete());
		teamTest.addTeamMember(new Athlete());
		teamTest.addTeamMember(new Athlete());
		teamTest.setFirstSpeaker(teamTest.getTeamMemberList().get(0));
		teamTest.setSecondSpeaker(teamTest.getTeamMemberList().get(1));
		teamTest.setThirdSpeaker(teamTest.getTeamMemberList().get(2));
		teamTest.setFourthSpeaker(teamTest.getTeamMemberList().get(3));
		assertEquals(teamTest.getTeamMemberList().get(0), teamTest.getFirstSpeaker());
		assertEquals(teamTest.getTeamMemberList().get(1), teamTest.getSecondSpeaker());
		assertEquals(teamTest.getTeamMemberList().get(2), teamTest.getThirdSpeaker());
		assertEquals(teamTest.getTeamMemberList().get(3), teamTest.getFourthSpeaker());
	}
	
	@Test
	void setTeamMemberListTest() {
		ArrayList<Athlete> teamMemberList = new ArrayList<Athlete>();
		teamMemberList.add(new Athlete());
		teamMemberList.add(new Athlete());
		teamTest.setTeamMemberList(teamMemberList);
		assertEquals(teamMemberList, teamTest.getTeamMemberList());
	}

}
