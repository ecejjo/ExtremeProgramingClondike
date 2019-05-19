package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import clondike.Card;
import clondike.Error;
import clondike.Game;
import clondike.Stock;
import clondike.Suite;
import clondike.Waste;
import clondike.Number;

public class GameTest {
	
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

		Stack<Card> cards = new Stack<>();

		Card card = new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build();
		cards.add(card);

		card = new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build();
		cards.add(card);

		card = new CardBuilder().suite(Suite.DIAMONDS).number(Number.EIGHT).build();
		cards.add(card);

		Stock stock = new StockBuilder().cards(cards).build();
		Waste waste = new Waste();
		
		Game game = new GameBuilder().stock(stock).waste(waste).build();
		
		assertEquals(game.moveFromStockToWaste(), Error.SUCESS);
	}
	
	@Test
	void testMoveFromStockToWaste_EMPTY_STOCK() {

		Stack<Card> cards = new Stack<>();

		Card card = new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build();
		cards.add(card);

		card = new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build();
		cards.add(card);

		Stock stock = new StockBuilder().cards(cards).build();
		Game game = new GameBuilder().stock(stock).build();
		
		assertEquals(game.moveFromStockToWaste(), Error.EMPTY_STOCK);
	}
}
