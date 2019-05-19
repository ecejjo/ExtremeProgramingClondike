package test;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import clondike.Suite;

public class SuiteInitialsTest {
		
	@Test
	void testInitialOfHeartsIsRed() {
		assertEquals("R", Suite.HEARTS.initials());
	}

	@Test
	void testInitialOfDiamondsIsBlack() {
		assertEquals("R", Suite.DIAMONDS.initials());
	}

	@Test
	void testInitialOfCloversIsBlack() {
		assertEquals("B", Suite.CLOVERS.initials());
	}
	
	@Test
	void testInitialOfPikesIsBlack() {
		assertEquals("B", Suite.PIKES.initials());
	}
}
