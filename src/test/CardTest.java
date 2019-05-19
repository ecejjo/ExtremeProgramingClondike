package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clondike.Card;
import clondike.Color;
import clondike.Suite;
import clondike.Number;

class CardTest {
		
	@Test
	void testCardIsNextTo() {
		cardIsNextTo(Number.TWO, Number.AS);
		cardIsNextTo(Number.NINE, Number.EIGHT);
		cardIsNextTo(Number.KING, Number.QUEEN);
	}

	void cardIsNextTo(Number card1Number, Number card2Number) {
		Card card1 = new CardBuilder().number(card1Number).build();
		Card card2 = new CardBuilder().number(card2Number).build();
		assertEquals(card1.isNextTo(card2), true);
	}

	@Test
	void testCardIsNotNextTo() {
		cardIsNotNextTo(Number.AS, Number.TWO);
		cardIsNotNextTo(Number.FOUR, Number.FIVE);
		cardIsNotNextTo(Number.QUEEN, Number.KING);
	}
	
	void cardIsNotNextTo(Number card1Number, Number card2Number) {
		Card card1 = new CardBuilder().number(card1Number).build();
		Card card2 = new CardBuilder().number(card2Number).build();
		assertFalse(card1.isNextTo(card2));
	}
	
	@Test
	void testCardInitialFaceUp() {
		Card card = new CardBuilder().build();
		assertEquals(false, card.isFaceUp());
	}

	@Test
	void testCardFlip() {
		Card faceUpCard = new CardBuilder().faceUp().build();
		assertEquals(true, faceUpCard.isFaceUp());
	}
	
	@Test
	void testCardGetNumber() {
		assertEquals(Number.FIVE, new CardBuilder().number(Number.FIVE).build().getNumber());
	}

	@Test
	void testCardGetSuite() {
		assertEquals(Suite.DIAMONDS, new CardBuilder().suite(Suite.DIAMONDS).build().getSuite());
	}

	@Test
	void testCardGetColor() {
		assertEquals(Color.RED, new CardBuilder().suite(Suite.DIAMONDS).build().getColor());
	}
	
	@Test
	void testCardToString() {
		Card card = new CardBuilder().number(Number.QUEEN).suite(Suite.DIAMONDS).build();
		assertEquals("QUEEN of DIAMONDS, false", card.toString());
	}
		
	@Test
	void testCardEquals() {
		Card card1 = new CardBuilder().build();
		Card card2 = new CardBuilder().build();
		assertEquals(true, card1.equals(card2));
	}

	@Test
	void testCardNotEquals() {
		cardNotEquals(Number.FOUR, Number.EIGHT);
		cardNotEquals(Suite.CLOVERS, Suite.DIAMONDS);
	}
	
	void cardNotEquals(Number number1, Number number2) {
		Card card1 = new CardBuilder().number(number1).build();
		Card card2 = new CardBuilder().number(number2).build();
		assertEquals(false, card1.equals(card2));
	}
	
	void cardNotEquals(Suite suite1, Suite suite2) {
		Card card1 = new CardBuilder().suite(suite1).build();
		Card card2 = new CardBuilder().suite(suite2).build();
		assertEquals(false, card1.equals(card2));
	}
}
