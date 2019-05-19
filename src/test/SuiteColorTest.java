package test;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import clondike.Color;
import clondike.Suite;

public class SuiteColorTest {
		
	@Test
	void testColorOfHeartsIsRed() {
		assertEquals(Color.RED, Suite.HEARTS.getColor());
	}

	@Test
	void testColorOfDiamondsIsBlack() {
		assertEquals(Color.RED, Suite.DIAMONDS.getColor());
	}

	@Test
	void testColorOfCloversIsBlack() {
		assertEquals(Color.BLACK, Suite.CLOVERS.getColor());
	}
	
	@Test
	void testColorOfPikesIsBlack() {
		assertEquals(Color.BLACK, Suite.PIKES.getColor());
	}
}
