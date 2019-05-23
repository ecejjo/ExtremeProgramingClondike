package clondike;

import java.util.Stack;

public class CardStack {
	
	protected Stack<Card> cards;
	
	public CardStack() {
		cards = new Stack<Card>();
	}
	
	public boolean empty() {
		return cards.isEmpty();
	}
	
	public Card peek() {
		return cards.peek();
	}
	
	public Card pop() {
		return cards.remove(0);
	}
	
	public void push(Card card) {
		cards.push(card);
	}
}
