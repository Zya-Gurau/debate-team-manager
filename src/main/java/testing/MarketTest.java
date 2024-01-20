package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import market.Market;
import market.Item;
import market.Book;
import athlete.Athlete;
import GameEnviroment.GameLogic;
import team.PlayerTeam;

class MarketTest {
	
	private Market testMarket;
	private Athlete testAthlete;
	private Item testBook;
	PlayerTeam testTeam;

	@BeforeAll
	static void setUpBeforeClass() throws Exception{
	}
	
	@BeforeEach
	void setUp() throws Exception{
		testMarket = new Market();
		testTeam = new PlayerTeam(100,"Test PlayerTeam");
		GameLogic.playerTeam = testTeam;
	}
	
	@Test
	void sellAthletesTest() {
		testAthlete = new Athlete("new athlete", 5,5,5,200,"Model",5);
		testTeam.addTeamMember(testAthlete);
		testMarket.sellAthletes(testAthlete);
		assertEquals(250, testTeam.getMoney());
		assertEquals(0, testTeam.getTeamMemberList().size());
		
		
		
	}
	
	@Test
	void sellItemsTest() {
		testBook = new Book();
		testTeam.addItem(testBook);
		testMarket.sellItems(testBook);
		assertEquals((100 + testBook.getPrice()), testTeam.getMoney());
		assertEquals(0, testTeam.getInventory().size());
		
		
	}
	
	@Test
	void purchaseItemTest() {
		testBook = new Book();
		testMarket.purchaseItem(testBook);
		assertEquals(100 - testBook.getPrice(), testTeam.getMoney());
		assertEquals(1, testTeam.getInventory().size());
		
	}
	
	@Test
	void purchaseAthleteTest() {
		testAthlete = new Athlete("new athlete", 5,5,5,5,"Model",5);
		testMarket.purchaseAthlete(testAthlete);
		assertEquals(95, testTeam.getMoney());
		assertEquals(1, testTeam.getTeamMemberList().size());
	}
	
	@Test
	void initialAthletesTest() {
		assertEquals(4, testMarket.initialAthletes().size());
		
	}
	

}