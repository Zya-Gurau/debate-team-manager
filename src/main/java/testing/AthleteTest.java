 /**
 * 
 */
package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import athlete.Athlete;

/**
 * @author user
 *
 */
class AthleteTest {
	
	private Athlete testAthlete;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testAthlete = new Athlete();
	}
	
	
	@Test
	void subtractStaminaTest() {
		testAthlete.setStamina(10);
		testAthlete.subtractCurrentStamina(5);
		assertEquals(5, testAthlete.getCurrentStamina());
		testAthlete.subtractCurrentStamina(7);
		assertEquals(0, testAthlete.getCurrentStamina());
		testAthlete.subtractCurrentStamina(-3);
		assertEquals(3, testAthlete.getCurrentStamina());
	}
	
	@Test
	void fullAthleteConstructorTest() {
		Athlete newTestAthlete = new Athlete("new athlete", 5,5,5,200,"Model",5);
		assertEquals("new athlete", newTestAthlete.getName());
		assertEquals(5, newTestAthlete.getOffense());
		assertEquals(5, newTestAthlete.getCurrentStamina());
		assertEquals(5, newTestAthlete.getStamina());
		assertEquals(5, newTestAthlete.getDefense());
		assertEquals(200, newTestAthlete.getPrice());
		assertEquals(200, newTestAthlete.getContractPrice());
		assertEquals(150, newTestAthlete.getBuyBackPrice());
		assertEquals("Model", newTestAthlete.getPreferedDebateStyle());
		assertEquals(5, newTestAthlete.getSpeakingStyle());
		assertFalse(newTestAthlete.getIsInjured());		
	}
	
	@Test
	void trainAthleteTest() {
		Athlete newTestAthlete = new Athlete("new athlete", 5,5,5,200,"Model",5);
		newTestAthlete.trainAthlete();
		assertEquals(6, newTestAthlete.getOffense());
		assertEquals(6, newTestAthlete.getStamina());
		assertEquals(6, newTestAthlete.getDefense());
		assertEquals(6, newTestAthlete.getSpeakingStyle());
		newTestAthlete.setOffense(10);
		newTestAthlete.trainAthlete();
		assertEquals(10, newTestAthlete.getOffense());
		assertEquals(7, newTestAthlete.getStamina());
		assertEquals(7, newTestAthlete.getDefense());
		assertEquals(7, newTestAthlete.getSpeakingStyle());
	}

}
