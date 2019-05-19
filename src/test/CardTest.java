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
		assertEquals(card.isFaceUp(), false);
	}

	@Test
	void testCardFlip() {
		Card faceUpCard = new CardBuilder().faceUp().build();
		assertEquals(faceUpCard.isFaceUp(), true);
	}
	
	@Test
	void testCardGetNumber() {
		assertEquals(new CardBuilder().number(Number.FIVE).build().getNumber(), Number.FIVE);
	}

	@Test
	void testCardGetSuite() {
		assertEquals(new CardBuilder().suite(Suite.DIAMONDS).build().getSuite(), Suite.DIAMONDS);
	}

	@Test
	void testCardGetColor() {
		assertEquals(new CardBuilder().suite(Suite.DIAMONDS).build().getColor(), Color.RED);
	}
	
	@Test
	void testCardToString() {
		Card card = new CardBuilder().number(Number.QUEEN).suite(Suite.DIAMONDS).build();
		assertEquals(card.toString(), "QUEEN of DIAMONDS, false");
	}
	
	@Test
	void testCardHashCode() {
		assertEquals(new CardBuilder().build().hashCode(), 123);
	}
	
	@Test
	void testCardEquals() {
		Card card1 = new CardBuilder().build();
		Card card2 = new CardBuilder().build();
		assertEquals(card1.equals(card2), true);
	}

	@Test
	void testCardNotEquals() {
		cardNotEquals(Number.FOUR, Number.EIGHT);
		cardNotEquals(Suite.CLOVERS, Suite.DIAMONDS);
	}
	
	void cardNotEquals(Number number1, Number number2) {
		Card card1 = new CardBuilder().number(number1).build();
		Card card2 = new CardBuilder().number(number2).build();
		assertEquals(card1.equals(card2), false);
	}
	
	void cardNotEquals(Suite suite1, Suite suite2) {
		Card card1 = new CardBuilder().suite(suite1).build();
		Card card2 = new CardBuilder().suite(suite2).build();
		assertEquals(card1.equals(card2), false);
	}
}
