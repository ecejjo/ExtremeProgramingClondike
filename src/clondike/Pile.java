package clondike;

import java.util.List;
import java.util.Stack;

public class Pile extends CardStack {
	
	int number;
	int numberOfFaceUpCards;
	
	public Pile(int number, List<Card> cards) {
		this.number = number;
		this.numberOfFaceUpCards = cards.size();
	}
	
	public void flipFirstCard() {
		this.cards.firstElement().flip();
	}
	
	public boolean fitsIn(Card card) {
		return false;
	}
	
	public List<Card> getTop(int numberOfCards) {
		return null;
	}
	
	public void addToTop(List<Card> cards) {
	}
	
	public void removeTop(int numberOfCards) {
	}
	
	public int numberOfFaceUpCards() {
		return 0;
	}
	
	public boolean empty() {
		return false;
	}
	
	public Stack<Card> getCards() {
		return cards;
	}
	
	public int getNumber() {
		return cards.size();
	}
}
