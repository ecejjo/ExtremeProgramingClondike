package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import clondike.Pile;
import clondike.Suite;
import clondike.Card;
import clondike.Number;

public class PileTest {
	
	// TODO: falta probar aquí los métodos heredados de CardStack
	
	@Test
	void testPileFlipFirstCard() {
		Card card = new CardBuilder().build();
		Pile pile = new PileBuilder().card(card).build();
		pile.flipFirstCard();
		assertEquals(true, pile.getCards().peek().isFaceUp());
	}

	@Test
	void testPileFitsIn() {
		fitsIn(Number.AS, Number.TWO);
		fitsIn(Number.FIVE, Number.SIX);
		fitsIn(Number.QUEEN, Number.KING);
	}

	void fitsIn(Number number1, Number number2) {
		Pile pile = new PileBuilder().card(new CardBuilder().number(number1).build()).build();
		assertEquals(true, pile.fitsIn(new CardBuilder().number(number2).build()));
	}
	
	@Test
	void testPileNotFitsIn() {
		DoesNotFitIn(Number.TWO, Number.AS);
		DoesNotFitIn(Number.FIVE, Number.FOUR);
		DoesNotFitIn(Number.KING, Number.QUEEN);
	}
	
	void DoesNotFitIn(Number number1, Number number2) {
		Pile pile = new PileBuilder().card(new CardBuilder().number(number1).build()).build();
		assertEquals(false, pile.fitsIn(new CardBuilder().number(number2).build()));
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
		List<Card> cards = new ArrayList<Card>();
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
		assertEquals(true, pile.empty());
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
		
		assertEquals(2, pile.numberOfFaceUpCards());
	}
}
