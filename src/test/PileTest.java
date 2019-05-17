package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import clondike.Pile;
import clondike.Card;
import clondike.Number;

public class PileTest {
	
	@Test
	void testPileFlipFirstCard() {
		Pile pile = new PileBuilder().build();
		pile.flipFirstCard();
		assertEquals(pile.getCards().firstElement().isFaceUp(), true);
	}

	@Test
	void testPileFitsIn() {
		fitsIn(Number.AS, Number.TWO);
		fitsIn(Number.FIVE, Number.SIX);
		fitsIn(Number.QUEEN, Number.KING);
	}

	@Test
	void fitsIn(Number number1, Number number2) {
		Pile pile = new PileBuilder().card(new CardBuilder().number(number1).build()).build();
		assertEquals(pile.fitsIn(new CardBuilder().number(number2).build()), true);
	}
	
	@Test
	void testPileNotFitsIn() {
		fitsIn(Number.TWO, Number.AS);
		fitsIn(Number.FIVE, Number.FOUR);
		fitsIn(Number.KING, Number.QUEEN);
	}
	
	@Test
	void NotfitsIn(Number number1, Number number2) {
		Pile pile = new PileBuilder().card(new CardBuilder().number(number1).build()).build();
		assertEquals(pile.fitsIn(new CardBuilder().number(number2).build()), false);
	}
	
	@Test
	void testPileGetTop() {
		Card card = new CardBuilder().build();
		Pile pile = new PileBuilder().card(card).build();
		assertEquals(card, pile.getTop(1).get(0));
	}


}
