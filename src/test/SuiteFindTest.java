package test;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import clondike.Suite;

public class SuiteFindTest {
		
	@Test
	void testFindOfHearts() {
		assertEquals(Suite.HEARTS.find('H'), Suite.HEARTS);
	}

	@Test
	void testFindOfDiamonds() {
		assertEquals(Suite.DIAMONDS.find('D'), Suite.DIAMONDS);
	}

	@Test
	void testFindOfClovers() {
		assertEquals(Suite.CLOVERS.find('C'), Suite.CLOVERS);
	}
	
	@Test
	void testFindOfPikes() {
		assertEquals(Suite.PIKES.find('P'), Suite.PIKES);
	}
}
