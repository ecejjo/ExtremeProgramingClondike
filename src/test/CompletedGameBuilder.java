package test;

import java.util.HashMap;
import java.util.Map;

import clondike.Card;
import clondike.Foundation;
import clondike.Game;
import clondike.Suite;
import clondike.Number;

public class CompletedGameBuilder {
	
	CompletedGameBuilder() {
	}
	
	Game build() {
		Game game = new Game();
		
		Map<Suite, Foundation> foundations = game.getFoundations();
		
		for (Suite suite : Suite.values()) {
			for (Number number : Number.values()) {
				foundations.get(suite).push(new CardBuilder().suite(suite).number(number).build());
			}
		}	
		return game;
	}
}
