package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import clondike.Card;
import clondike.Error;
import clondike.Foundation;
import clondike.Game;
import clondike.Stock;
import clondike.Suite;
import clondike.Waste;
import clondike.Number;
import clondike.Pile;

public class GameTest {
	
	Stack<Card> cards;
	Stock stock;
	List<Pile> piles;
	Waste waste;
	Map<Suite, Foundation> foundations;
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
		this.game = new GameBuilder().build();
		this.stock = this.game.getStock();
		this.stock.push(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());
		this.stock.push(new CardBuilder().suite(Suite.DIAMONDS).number(Number.EIGHT).build());
		this.stock.push(new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build());
		
		// When, then
		assertEquals(Error.SUCESS, game.moveFromStockToWaste());
	}
	
	@Test
	void testMoveFromStockToWaste_EMPTY_STOCK() {

		// Given
		this.game = new GameBuilder().build();
		this.stock = this.game.getStock();
		this.stock.push(new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build());
		
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
		this.game = new GameBuilder().build();
		this.stock = this.game.getStock();
		this.stock.push(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());
		this.stock.push(new CardBuilder().suite(Suite.DIAMONDS).number(Number.EIGHT).build());
		this.stock.push(new CardBuilder().suite(Suite.CLOVERS).number(Number.TWO).build());
		
		game.moveFromStockToWaste();
		
		// When, then
		assertEquals(Error.NO_FIT_FOUNDATION, game.moveFromWasteToFoundation());
	}
	
	@Test
	void testMoveFromWasteToStock_SUCCESS() {

		// Given
		this.game = new GameBuilder().build();
		this.waste = this.game.getWaste();
		this.waste.push(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());
		
		// When, then
		assertEquals(Error.SUCESS, game.moveFromWasteToStock());
	}
	
	@Test
	void testMoveFromWasteToStock_EMPTY_WASTE() {

		// Given
		this.game = new GameBuilder().build();
		this.waste = this.game.getWaste();
		
		// When, then
		assertEquals(Error.EMPTY_WASTE, game.moveFromWasteToStock());
	}
	
	@Test
	void testMoveFromWasteToPile_SUCCESS() {
		
		// Given
		this.game = new GameBuilder().build();
		this.waste = this.game.getWaste();
		this.waste.push(new CardBuilder().suite(Suite.CLOVERS).number(Number.AS).build());
		
		// When, then
		assertEquals(Error.SUCESS, game.moveFromWasteToPile(Suite.CLOVERS.ordinal()));
	}
	
	@Test
	void testMoveFromWasteToPile_NO_FIT_PILE() {

		// Given
		this.game = new GameBuilder().build();
		this.waste = this.game.getWaste();
		this.waste.push(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());
		
		// When, then
		assertEquals(Error.NO_FIT_PILE, game.moveFromWasteToPile(Suite.DIAMONDS.ordinal()));
	}

	
	@Test
	void testMoveFromFoundationToPile_SUCESS() {

		// Given
		this.game = new GameBuilder().build();
		this.foundations = this.game.getFoundations();
		this.foundations.get(Suite.CLOVERS).push(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());
		
		// When, then
		assertEquals(Error.SUCESS, game.moveFromFoundationToPile(Suite.CLOVERS, 1));
	}

	@Test
	void testMoveFromFoundationToPile_EMPTY_FOUNDATION() {

		// Given
		this.game = new GameBuilder().build();
		
		// When, then
		assertEquals(Error.EMPTY_FOUNDATION, game.moveFromFoundationToPile(Suite.CLOVERS, 1));
	}

	@Test
	void testMoveFromFoundationToPile_NO_FIT_PILE_bySuite() {

		// Given
		this.game = new GameBuilder().build();
		
		this.foundations = this.game.getFoundations();
		this.foundations.get(Suite.CLOVERS).push(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());
		
		this.piles = this.game.getPiles();	
		this.piles.get(1).push(new CardBuilder().suite(Suite.PIKES).number(Number.THREE).build());
		
		// When, then
		assertEquals(Error.NO_FIT_PILE, game.moveFromFoundationToPile(Suite.CLOVERS, 1));
	}
	
	@Test
	void testMoveFromFoundationToPile_NO_FIT_PILE_byNumber() {

		// Given
		this.game = new GameBuilder().build();
		
		this.foundations = this.game.getFoundations();
		this.foundations.get(Suite.CLOVERS).push(new CardBuilder().suite(Suite.CLOVERS).number(Number.EIGHT).build());
		
		this.piles = this.game.getPiles();	
		this.piles.get(1).push(new CardBuilder().suite(Suite.DIAMONDS).number(Number.THREE).build());
		
		// When, then
		assertEquals(Error.NO_FIT_PILE, game.moveFromFoundationToPile(Suite.CLOVERS, 1));
	}
	
	@Test
	void testMoveFromPileToFoundation_SUCCESS() {

		// Given
		this.game = new GameBuilder().build();

		this.piles = this.game.getPiles();
		this.piles.get(1).push(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());

		this.foundations = this.game.getFoundations();
		this.foundations.get(Suite.CLOVERS).push(new CardBuilder().suite(Suite.CLOVERS).number(Number.THREE).build());
				
		// When, then
		assertEquals(Error.SUCESS, game.moveFromPileToFoundation(1, Suite.CLOVERS));
	}

	@Test
	void testMoveFromPileToFoundation_NO_FIT_FOUNDATION_bySuite() {

		// Given
		this.game = new GameBuilder().build();

		this.piles = this.game.getPiles();
		this.piles.get(1).push(new CardBuilder().suite(Suite.CLOVERS).number(Number.FOUR).build());

		this.foundations = this.game.getFoundations();
		this.foundations.get(Suite.CLOVERS).push(new CardBuilder().suite(Suite.DIAMONDS).number(Number.THREE).build());
		
		// When, then
		assertEquals(Error.NO_FIT_FOUNDATION, game.moveFromPileToFoundation(1, Suite.CLOVERS));
	}

	@Test
	void testMoveFromPileToFoundation_NO_FIT_FOUNDATION_byNumber() {

		// Given
		this.game = new GameBuilder().build();

		this.piles = this.game.getPiles();
		this.piles.get(1).push(new CardBuilder().suite(Suite.CLOVERS).number(Number.SEVEN).build());

		this.foundations = this.game.getFoundations();
		this.foundations.get(Suite.CLOVERS).push(new CardBuilder().suite(Suite.CLOVERS).number(Number.THREE).build());
		
		// When, then
		assertEquals(Error.NO_FIT_FOUNDATION, game.moveFromPileToFoundation(1, Suite.CLOVERS));
	}

	@Test
	void testMoveFromPileToPile() {
	}
}
