package test;

import java.util.Stack;

import clondike.Card;
import clondike.Pile;
import clondike.Waste;

public class WasteBuilder extends CardStackBuilder {
	
	WasteBuilder() {
		this.cards = new Stack<Card>();		
	}
	
	public WasteBuilder card(Card card) {
		this.cards.add(card);
		return this;
	}
	
	public WasteBuilder cards(Stack <Card> cards) {
		this.cards = cards;
		return this;
	}
	
	Waste build() {
		return new Waste(this.cards);
	}
}
