package clondike;

import java.util.Stack;

public class CardStack {
	
	protected Stack<Card> cards;
	
	public CardStack() {
		cards = new Stack<Card>();
	}
	
	boolean empty() {
		return cards.isEmpty();
	}
	
	Card peek() {
		return cards.peek();
	}
	
	Card pop() {
		return cards.remove(0);
	}
	
	void push(Card card) {
		cards.push(card);
	}
}
