package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GameEnviroment.GameLogic;
import athlete.Athlete;
import market.InsufficientBalanceException;
import team.PlayerTeam;

class PlayerTeamTest {
	
	PlayerTeam testPlayerTeam;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		testPlayerTeam = new PlayerTeam(10,"Test PlayerTeam");
		testPlayerTeam.addTeamMember(new Athlete());
		testPlayerTeam.addTeamMember(new Athlete());
		testPlayerTeam.addTeamMember(new Athlete());
		testPlayerTeam.addTeamMember(new Athlete());
		testPlayerTeam.addTeamMember(new Athlete());
	}

	@Test
	void addMoneyTest() {
		testPlayerTeam.addMoney(5);
		assertEquals(15, testPlayerTeam.getMoney());
		
	}
	
	@Test
	void canContinueTest() {
		testPlayerTeam.setFirstSpeaker(testPlayerTeam.getTeamMemberList().get(0));
		testPlayerTeam.setSecondSpeaker(testPlayerTeam.getTeamMemberList().get(1));
		testPlayerTeam.setThirdSpeaker(testPlayerTeam.getTeamMemberList().get(2));
		testPlayerTeam.setFourthSpeaker(testPlayerTeam.getTeamMemberList().get(3));
		assertTrue(testPlayerTeam.canContinue());
		testPlayerTeam.getFirstSpeaker().setInjured(true);
		testPlayerTeam.getSecondSpeaker().setInjured(true);
		assertFalse(testPlayerTeam.canContinue());
		testPlayerTeam.addTeamMember(new Athlete());
		assertTrue(testPlayerTeam.canContinue());
	}
	
	@Test
	void subtractMoneyTest() throws InsufficientBalanceException {
		testPlayerTeam.subtractMoney(5);
		assertEquals(5, testPlayerTeam.getMoney());
		InsufficientBalanceException thrown = Assertions.assertThrows(InsufficientBalanceException.class, () -> {
			System.out.println("Exception thrown");   
			testPlayerTeam.subtractMoney(50);
	           
		  });
		Assertions.assertEquals("Insufficient Balance", thrown.getMessage());
	}
	
	@Test
	void rechargeStaminaTest() {
		testPlayerTeam.setFirstSpeaker(testPlayerTeam.getTeamMemberList().get(0));
		testPlayerTeam.setSecondSpeaker(testPlayerTeam.getTeamMemberList().get(1));
		testPlayerTeam.setThirdSpeaker(testPlayerTeam.getTeamMemberList().get(2));
		testPlayerTeam.setFourthSpeaker(testPlayerTeam.getTeamMemberList().get(3));
		for(Athlete athlete: testPlayerTeam.getTeamMemberList()) {
			athlete.setStamina(5);;
		}
		for(Athlete athlete: testPlayerTeam.getTeamMemberList()) {
			athlete.subtractCurrentStamina(3);
		}
		assertEquals(2,testPlayerTeam.getFirstSpeaker().getCurrentStamina());
		assertEquals(2,testPlayerTeam.getSecondSpeaker().getCurrentStamina());
		assertEquals(2,testPlayerTeam.getThirdSpeaker().getCurrentStamina());
		assertEquals(2,testPlayerTeam.getFourthSpeaker().getCurrentStamina());
		
		testPlayerTeam.rechargeStamina();
		
		assertEquals(5,testPlayerTeam.getFirstSpeaker().getCurrentStamina());
		assertEquals(5,testPlayerTeam.getSecondSpeaker().getCurrentStamina());
		assertEquals(5,testPlayerTeam.getThirdSpeaker().getCurrentStamina());
		assertEquals(5,testPlayerTeam.getFourthSpeaker().getCurrentStamina());
		
	}
	
	@Test
	void addPointsTest() {
		testPlayerTeam.addPoints(5);
		assertEquals(5, testPlayerTeam.getPoints());
		
	}
	
	@Test
	void isFullSpeakersTest() {
		assertFalse(testPlayerTeam.isFullSpeakers());
		testPlayerTeam.setFirstSpeaker(testPlayerTeam.getTeamMemberList().get(0));
		testPlayerTeam.setSecondSpeaker(testPlayerTeam.getTeamMemberList().get(1));
		testPlayerTeam.setThirdSpeaker(testPlayerTeam.getTeamMemberList().get(2));
		assertFalse(testPlayerTeam.isFullSpeakers());
		testPlayerTeam.setFourthSpeaker(testPlayerTeam.getTeamMemberList().get(3));
		assertTrue(testPlayerTeam.isFullSpeakers());
		
	}
	
	@Test
	void removeSpeakerTest() {
		testPlayerTeam.removeTeamMember(0);
		assertEquals(4, testPlayerTeam.getTeamMemberList().size());
		testPlayerTeam.removeTeamMember(0);
		assertEquals(3, testPlayerTeam.getTeamMemberList().size());
		testPlayerTeam.removeTeamMember(0);
		testPlayerTeam.removeTeamMember(7);
		testPlayerTeam.removeTeamMember(0);
		testPlayerTeam.removeTeamMember(0);
		testPlayerTeam.removeTeamMember(0);
		assertEquals(0, testPlayerTeam.getTeamMemberList().size());
	}
	
	@Test
	void speakerClashFixerTest() {
		testPlayerTeam.setFirstSpeaker(testPlayerTeam.getTeamMemberList().get(0));
		testPlayerTeam.setSecondSpeaker(testPlayerTeam.getTeamMemberList().get(0));
		testPlayerTeam.speakerClashFixer(testPlayerTeam.getTeamMemberList().get(0));
		assertEquals(GameLogic.nullAthlete, testPlayerTeam.getFirstSpeaker());
		assertEquals(GameLogic.nullAthlete, testPlayerTeam.getSecondSpeaker());

	}
	
	@Test
	void setSpeakerPositionTest() {
		testPlayerTeam.setSpeakerPosition(1,testPlayerTeam.getTeamMemberList().get(0));
		assertEquals(testPlayerTeam.getTeamMemberList().get(0), testPlayerTeam.getFirstSpeaker());
		testPlayerTeam.setSpeakerPosition(2,testPlayerTeam.getTeamMemberList().get(0));
		assertEquals(GameLogic.nullAthlete, testPlayerTeam.getFirstSpeaker());
		assertEquals(testPlayerTeam.getTeamMemberList().get(0), testPlayerTeam.getSecondSpeaker());
		
		testPlayerTeam.setSpeakerPosition(3,testPlayerTeam.getTeamMemberList().get(2));
		assertEquals(testPlayerTeam.getTeamMemberList().get(2), testPlayerTeam.getThirdSpeaker());
		assertEquals(testPlayerTeam.getTeamMemberList().get(0), testPlayerTeam.getSecondSpeaker());
	}
	
	@Test
	void isAbleToPlayTest() {
		assertTrue(testPlayerTeam.isAbleToPlay());
		testPlayerTeam.getFirstSpeaker().setInjured(true);
		assertFalse(testPlayerTeam.isAbleToPlay());
		testPlayerTeam.getFirstSpeaker().setInjured(false);
		assertTrue(testPlayerTeam.isAbleToPlay());
	}

}
