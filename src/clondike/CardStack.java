package clondike;

import java.util.Stack;

public class CardStack {
	
	protected Stack<Card> cards;
	
	public CardStack() {	
	}
	
	boolean empty() {
		return cards.isEmpty();
	}
	
	Card peek() {
		return cards.firstElement();
	}
	
	Card pop() {
		return cards.lastElement();
	}
}
