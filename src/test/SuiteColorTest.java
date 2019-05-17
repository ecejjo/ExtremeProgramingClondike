package test;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import clondike.Color;
import clondike.Suite;

public class SuiteColorTest {
		
	@Test
	void testColorOfHeartsIsRed() {
		assertEquals(Suite.HEARTS.getColor(), Color.RED);
	}

	@Test
	void testColorOfDiamondsIsBlack() {
		assertEquals(Suite.DIAMONDS.getColor(), Color.BLACK);
	}

	@Test
	void testColorOfCloversIsBlack() {
		assertEquals(Suite.CLOVERS.getColor(), Color.BLACK);
	}
	
	@Test
	void testColorOfPikesIsBlack() {
		assertEquals(Suite.PIKES.getColor(), Color.RED);
	}
}
