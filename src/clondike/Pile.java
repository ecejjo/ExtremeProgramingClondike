package clondike;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pile extends CardStack {
	
	int number;
	int numberOfFaceUpCards;
	
	public Pile(int number, List<Card> cards) {
		this.number = number;
		this.numberOfFaceUpCards = cards.size();
		this.cards = (Stack<Card>) cards;
	}
	
	public void flipFirstCard() {
		this.cards.peek().flip();
	}
	
	public boolean fitsIn(Card card) {
		return (card.isNextTo(cards.peek()));
	}
	
	public List<Card> getTop(int numberOfCards) {
		List<Card> top = new ArrayList<>();
		for (int i = 0; i < numberOfCards; i++) {
			if ( ! this.cards.empty()) {
				top.add(this.cards.pop());
			}
			else {break;}
		}
		return top;
	}
	
	public void addToTop(List<Card> cards) {
		for (int i = 0; i < cards.size(); i++) {
			this.cards.add(cards.get(i));
			if(cards.get(i).isFaceUp()) {
				this.numberOfFaceUpCards ++;
			}
		}
	}
	
	public void removeTop(int numberOfCards) {
		for (int i = 0; i < numberOfCards; i++) {
			if ( ! this.cards.empty()) {
				this.cards.remove(0);				
			}
		}
	}
	
	public int numberOfFaceUpCards() {
		return numberOfFaceUpCards;
	}
	
	public boolean empty() {
		return this.cards.empty();
	}
	
	public Stack<Card> getCards() {
		return cards;
	}
	
	public int getNumber() {
		return cards.size();
	}
}
