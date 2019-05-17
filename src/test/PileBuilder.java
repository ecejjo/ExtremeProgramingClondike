package test;

import java.util.Stack;

import clondike.Card;
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
	
	Pile build() {
		Pile pile = new Pile(this.number, this.cards);
		return pile;
	}


}
