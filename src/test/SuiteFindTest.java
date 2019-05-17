package test;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import clondike.Suite;

public class SuiteFindTest {
		
	@Test
	void testColorOfHeartsIsRed() {
		assertEquals(Suite.HEARTS.find('H'), Suite.HEARTS);
	}

	@Test
	void testColorOfDiamondsIsBlack() {
		assertEquals(Suite.DIAMONDS.find('D'), Suite.DIAMONDS);
	}

	@Test
	void testColorOfCloversIsBlack() {
		assertEquals(Suite.CLOVERS.find('C'), Suite.CLOVERS);
	}
	
	@Test
	void testColorOfPikesIsBlack() {
		assertEquals(Suite.PIKES.find('P'), Suite.PIKES);
	}
}
