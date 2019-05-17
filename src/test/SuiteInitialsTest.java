package test;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import clondike.Suite;

public class SuiteInitialsTest {
		
	@Test
	void testInitialOfHeartsIsRed() {
		assertEquals(Suite.HEARTS.initials(), "H");
	}

	@Test
	void testInitialOfDiamondsIsBlack() {
		assertEquals(Suite.DIAMONDS.initials(), "D");
	}

	@Test
	void testInitialOfCloversIsBlack() {
		assertEquals(Suite.CLOVERS.initials(), "B");
	}
	
	@Test
	void testInitialOfPikesIsBlack() {
		assertEquals(Suite.PIKES.initials(), "P");
	}
}
