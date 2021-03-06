package test;

import java.util.List;
import java.util.Map;

import clondike.Foundation;
import clondike.Game;
import clondike.Pile;
import clondike.Stock;
import clondike.Suite;
import clondike.Waste;

public class GameBuilder {
	
	Stock stock;
	Waste waste;
	List<Pile> piles;
	Map<Suite, Foundation> foundations;	

	GameBuilder() {
		this.stock = new Stock();
		this.waste = new Waste();
		
	}
	
	GameBuilder stock(Stock stock) {
		this.stock = stock;
		return this;
	}

	GameBuilder waste(Waste waste) {
		this.waste = waste;
		return this;
	}

	GameBuilder piles(List<Pile> piles) {
		this.piles = piles;
		return this;
	}

	GameBuilder foundations(Map<Suite, Foundation> foundations) {
		this.foundations = foundations;
		return this;
	}

	Game build() {
		return new Game();
	}
}
