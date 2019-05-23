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
	
	Stack<Card> cards;
	Stock stock;
	Waste waste;
	Game game;

	@Test
	void testIsFinished_TRUE() {
		Game game = new CompletedGameBuilder().build();
		assertTrue(game.isFinished());
	}

	@Test
	void testIsFinished_FALSE() {
		testMoveFromStockToWaste_SUCCESS();
		assertFalse(game.isFinished());
	}
	
	@Test
	void testMoveFromStockToWaste_SUCCESS() {

		// Given
		cards = new Stack<>();
		cards.add(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());
		cards.add(new CardBuilder().suite(Suite.DIAMONDS).number(Number.EIGHT).build());
		cards.add(new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build());

		stock = new StockBuilder().cards(cards).build();
		game = new GameBuilder().stock(stock).build();
		
		// When, then
		assertEquals(Error.SUCESS, game.moveFromStockToWaste());
	}
	
	@Test
	void testMoveFromStockToWaste_EMPTY_STOCK() {

		// Given
		cards = new Stack<>();
		cards.add(new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build());
		cards.add(new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build());

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
		cards.add(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());
		cards.add(new CardBuilder().suite(Suite.DIAMONDS).number(Number.EIGHT).build());
		cards.add(new CardBuilder().suite(Suite.CLOVERS).number(Number.TWO).build());

		stock = new StockBuilder().cards(cards).build();
		game = new GameBuilder().stock(stock).build();
		game.moveFromStockToWaste();
		
		// When, then
		assertEquals(Error.NO_FIT_FOUNDATION, game.moveFromWasteToFoundation());
	}
	
	@Test
	void testMoveFromWasteToStock_SUCCESS() {

		// Given
		cards = new Stack<>();
		cards.add(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());
		waste = new WasteBuilder().cards(cards).build();
		game = new GameBuilder().waste(waste).build();
		
		// When, then
		assertEquals(Error.SUCESS, game.moveFromWasteToStock());
	}
	
	@Test
	void testMoveFromWasteToStock_EMPTY_WASTE() {
		// Given
		cards = new Stack<>();
		waste = new WasteBuilder().cards(cards).build();
		game = new GameBuilder().waste(waste).build();
		
		// When, then
		assertEquals(Error.EMPTY_WASTE, game.moveFromWasteToStock());
	}
	
	@Test
	void testMoveFromWasteToPile() {
	}
	
	@Test
	void testMoveFromFoundationToPile() {
	}
	
	@Test
	void testMoveFromPileToFoundation() {
	}
	
	@Test
	void testMoveFromPileToPile() {
	}




}
