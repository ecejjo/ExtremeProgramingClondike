package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import clondike.Card;
import clondike.Waste;

public class WasteTest {
	
	@Test
	public void testEmpty() {
		Waste waste = new Waste();
		assertTrue(waste.empty());
		
		Card card = new CardBuilder().build();
		waste.push(card);
		
		assertFalse(waste.empty());
	}
	
	@Test
	public void testPush() {
		Waste waste = new Waste();		
		Card card = new CardBuilder().build();
		
		waste.push(card);
		assertEquals(card, waste.peek());
	}

	@Test
	public void testPop() {
		Waste waste = new Waste();		
		Card card = new CardBuilder().build();
		
		waste.push(card);
		assertEquals(card, waste.pop());
		assertTrue(waste.empty());
	}

	@Test
	public void testPeek() {
		Waste waste = new Waste();		
		Card card = new CardBuilder().build();
		
		waste.push(card);
		assertEquals(card, waste.peek());
		assertFalse(waste.empty());
	}
}
