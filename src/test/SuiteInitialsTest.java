package test;


import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import clondike.Suite;

public class SuiteInitialsTest {
		
	@Test
	void testInitialOfHeartsIsH() {
		assertArrayEquals(new char[] {'H', 'D', 'C', 'P'}, Suite.HEARTS.initials());
	}

	@Test
	void testInitialOfDiamondsIsD() {
		assertArrayEquals(new char[] {'H', 'D', 'C', 'P'}, Suite.DIAMONDS.initials());

	}

	@Test
	void testInitialOfCloversIsC() {
		assertArrayEquals(new char[] {'H', 'D', 'C', 'P'}, Suite.CLOVERS.initials());
	}
	
	@Test
	void testInitialOfPikesIsP() {
		assertArrayEquals(new char[] {'H', 'D', 'C', 'P'}, Suite.PIKES.initials());
	}
}
