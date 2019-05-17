package test;

import java.util.Stack;

import clondike.Card;
import clondike.CardStack;
import clondike.Pile;

public class PileBuilder extends CardStackBuilder {
	
	int number;
	int numberOfFaceUpCards;
	
	PileBuilder() {
		this.cards = new Stack<Card>();		
		this.number = 0;
		this.numberOfFaceUpCards = 0;
	}
	
	public PileBuilder card(Card card) {
		this.cards.add(card);
		this.number++;		
		if (card.isFaceUp()) {
				this.numberOfFaceUpCards++;
		}
		return this;
	}
	
	public PileBuilder cards(Stack <Card> cards) {
		this.cards = cards;
		this.number = this.cards.size();
		this.numberOfFaceUpCards = 0;
		for (int i = 0; i < this.cards.size(); i++) {
			if (this.cards.get(i).isFaceUp()) {
				this.numberOfFaceUpCards++;
			}
		}
		return this;
	}
	
	Pile build() {
		Pile pile = new Pile(this.number, this.cards);
		return pile;
	}


}
