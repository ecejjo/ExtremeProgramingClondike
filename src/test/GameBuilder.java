package test;

import clondike.Game;
import clondike.Stock;

public class GameBuilder {
	
	Stock stock;

	GameBuilder() {
		this.stock = new Stock();
	}
	
	GameBuilder stock(Stock stock) {
		this.stock = stock;
		return this;
	}

	Game build() {
		return new Game(this.stock);
	}

}
