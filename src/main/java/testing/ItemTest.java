package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import market.Item;
import market.Book;
import market.Refill;
import market.Timer;
import market.WaterBottle;
import athlete.Athlete;

class ItemTest {
	private Item testBook;
	private Athlete testAthlete;
	private Item testRefill;
	private Item testWaterBottle;
	private Item testTimer;

	@BeforeAll
	static void setUpBeforeClass() throws Exception{
	}
	
	@BeforeEach
	void setUp() throws Exception{
		testBook = new Book();
		testRefill = new Refill();
		testWaterBottle = new WaterBottle();
		testTimer = new Timer();
	}
	
	
	@Test
	void useItemTest() {
		testAthlete = new Athlete("new athlete", 0,5,5,5,"Model",5);
		testBook.useItem(testBook, testAthlete);
		assertEquals(testBook.getOffence(), testAthlete.getOffense());
		assertEquals(5, testAthlete.getStamina());
		assertEquals(5, testAthlete.getDefense());
		assertEquals(5, testAthlete.getSpeakingStyle());
		
		testAthlete = new Athlete("new athlete", 8,5,5,5,"Model",5);
		testBook.useItem(testBook, testAthlete);
		assertEquals(10, testAthlete.getOffense());
		
		testAthlete = new Athlete("new athlete", 5,5,8,5,"Model",5);
		testBook.useItem(testRefill, testAthlete);
		assertEquals(10, testAthlete.getDefense());
		
		testAthlete = new Athlete("new athlete", 5,5,5,5,"Model",8);
		testBook.useItem(testWaterBottle, testAthlete);
		assertEquals(10, testAthlete.getSpeakingStyle());
		
		testAthlete = new Athlete("new athlete", 5,8,5,5,"Model",5);
		testBook.useItem(testTimer, testAthlete);
		assertEquals(10, testAthlete.getStamina());
		
		
		
		
		
		
		
		
	}
	
	@Test
	void toStringTest() {
		assertEquals("Book", testBook.toString());
	}
	
	@Test
	void toStringStats() {
		assertEquals(testBook.getName()+":" + "\nOffense: "+ testBook.getOffence() +"\nStamina: " + testBook.getStamina() +"\nDefense: "+ testBook.getDefence() + "\nSpeaking Style:" + testBook.getSpeakingStyle(),testBook.toStringStats());
	}
	
	@Test
	void createItemListTest() {
		assertEquals(4,Item.createItemList().size());
	}
}