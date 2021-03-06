package test;

import java.util.Stack;

import clondike.Card;
import clondike.CardStack;

public class CardStackBuilder {
	
	Stack <Card> cards;
	
	CardStackBuilder() {
		cards = new Stack<Card>();
	}
	
	CardStackBuilder cards(Stack <Card> cards) {
		this.cards = cards;
		return this;
	}
	
	CardStack build() {
		return new CardStack();
	}
}
