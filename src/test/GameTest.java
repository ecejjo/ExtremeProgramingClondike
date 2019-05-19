package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import clondike.Card;
import clondike.Error;
import clondike.Game;
import clondike.Stock;
import clondike.Suite;
import clondike.Number;

public class GameTest {
	
	Card card;
	Stack<Card> cards;
	Stock stock;
	Game game;
	
	@Test
	void testClear() {
		assertTrue(false);
	}
	
	@Test
	void testIsFinished() {
		assertTrue(false);
	}
	
	@Test
	void testMoveFromStockToWaste_SUCCESS() {

		// Given
		cards = new Stack<>();

		card = new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build();
		cards.add(card);

		card = new CardBuilder().suite(Suite.DIAMONDS).number(Number.EIGHT).build();
		cards.add(card);
		
		card = new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build();
		cards.add(card);

		stock = new StockBuilder().cards(cards).build();
		game = new GameBuilder().stock(stock).build();
		
		// When, then
		assertEquals(Error.SUCESS, game.moveFromStockToWaste());
	}
	
	@Test
	void testMoveFromStockToWaste_EMPTY_STOCK() {

		// Given
		cards = new Stack<>();

		card = new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build();
		cards.add(card);

		card = new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build();
		cards.add(card);

		stock = new StockBuilder().cards(cards).build();
		game = new GameBuilder().stock(stock).build();
		
		// When, then
		assertEquals(Error.EMPTY_STOCK, game.moveFromStockToWaste());
	}

	@Test
	void testMoveFromWasteToFoundation_SUCCESS() {
		
		// Given
		testMoveFromStockToWaste_SUCCESS();
		
		// When, then
		assertEquals(Error.SUCESS, game.moveFromWasteToFoundation());
	}
	
	@Test
	void testMoveFromWasteToFoundation_NO_FIT_FOUNDATION() {

		// Given
		cards = new Stack<>();

		card = new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build();
		cards.add(card);

		card = new CardBuilder().suite(Suite.DIAMONDS).number(Number.EIGHT).build();
		cards.add(card);
		
		card = new CardBuilder().suite(Suite.CLOVERS).number(Number.TWO).build();
		cards.add(card);

		stock = new StockBuilder().cards(cards).build();
		game = new GameBuilder().stock(stock).build();
		game.moveFromStockToWaste();
		
		// When, then
		assertEquals(Error.NO_FIT_FOUNDATION, game.moveFromWasteToFoundation());
	}
}
