package test;

import java.util.Stack;

import clondike.Card;
import clondike.Stock;

public class StockBuilder extends CardStackBuilder {
	
	StockBuilder() {
		this.cards = new Stack<Card>();		
	}
	
	StockBuilder cards(Stack<Card> cards) {
		this.cards = cards;
		return this;
	}	
	
	StockBuilder card(Card card) {
		this.cards.add(card);
		return this;
	}
	
	Stock build() {
		return new Stock(this.cards);
	}
}
