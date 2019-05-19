package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import clondike.Pile;
import clondike.Suite;
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
		DoesNotFitIn(Number.TWO, Number.AS);
		DoesNotFitIn(Number.FIVE, Number.FOUR);
		DoesNotFitIn(Number.KING, Number.QUEEN);
	}
	
	@Test
	void DoesNotFitIn(Number number1, Number number2) {
		Pile pile = new PileBuilder().card(new CardBuilder().number(number1).build()).build();
		assertEquals(pile.fitsIn(new CardBuilder().number(number2).build()), false);
	}
	
	@Test
	void testPileGetTop() {
		Card card = new CardBuilder().build();
		Pile pile = new PileBuilder().card(card).build();
		assertEquals(card, pile.getTop(1).get(0));
	}

	@Test
	void testPileAddToTop() {
		Card card = new CardBuilder().build();
		List<Card> cards = new ArrayList<>();
		cards.add(card);
		
		Pile pile = new PileBuilder().build();
		pile.addToTop(cards);
		assertEquals(card, pile.getTop(1).get(0));
	}

	@Test
	void testPileRemoveTopEmpty() {
		List<Card> cards = new ArrayList<>();

		Card card = new CardBuilder().build();
		cards.add(card);
		cards.add(card);
		cards.add(card);
		
		Pile pile = new PileBuilder().build();
		pile.addToTop(cards);
		
		pile.removeTop(3);
		assertEquals(pile.empty(), true);
	}
	
	@Test
	void testPileNumberOfFaceUpCards() {
		List<Card> cards = new ArrayList<>();

		Card card = new Card(Number.AS, Suite.CLOVERS);
		cards.add(card);
		
		card = new Card(Number.TWO, Suite.DIAMONDS);
		card.flip();
		cards.add(card);
		
		card = new Card(Number.EIGHT, Suite.HEARTS);
		card.flip();
		cards.add(card);
		
		Pile pile = new PileBuilder().build();
		pile.addToTop(cards);
		
		assertEquals(pile.numberOfFaceUpCards(), 2);
	}


}
