package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import clondike.Pile;
import clondike.Suite;
import clondike.Card;
import clondike.Number;

public class PileTest {
	
	@Test
	public void testEmpty() {
		Pile pile = new PileBuilder().build();
		assertTrue(pile.empty());
		
		Card card = new CardBuilder().build();
		pile.push(card);
		
		assertFalse(pile.empty());
	}
	
	@Test
	public void testPush() {
		Pile pile = new PileBuilder().build();		
		Card card = new CardBuilder().build();
		
		pile.push(card);
		assertEquals(card, pile.peek());
	}

	@Test
	public void testPop() {
		Pile pile = new PileBuilder().build();		
		Card card = new CardBuilder().build();
		
		pile.push(card);
		assertEquals(card, pile.pop());
		assertTrue(pile.empty());
	}

	@Test
	public void testPeek() {
		Pile pile = new PileBuilder().build();		
		Card card = new CardBuilder().build();
		
		pile.push(card);
		assertEquals(card, pile.peek());
		assertFalse(pile.empty());
	}
	
	@Test
	void testPileFlipFirstCard() {
		Card card = new CardBuilder().build();
		Pile pile = new PileBuilder().card(card).build();
		pile.flipFirstCard();
		assertEquals(true, pile.getCards().peek().isFaceUp());
	}

	@Test
	void testPileFitsInEmpty() {
		fitsInEmpty(Number.AS, Number.TWO);
		fitsInEmpty(Number.FIVE, Number.SIX);
		fitsInEmpty(Number.QUEEN, Number.KING);
	}

	void fitsInEmpty(Number number1, Number number2) {
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
