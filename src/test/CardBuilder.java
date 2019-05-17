package test;

import clondike.Card;
import clondike.Number;
import clondike.Suite;

public class CardBuilder {
	
	private Number number;
	private Suite suite;
	private boolean faceUp;
	
	CardBuilder() {
		this.number = Number.THREE;
		this.suite = Suite.CLOVERS;
		this.faceUp = false;
	}

	CardBuilder suite(Suite suite) {
		this.suite = suite;
		return this;
	}
	
	CardBuilder number(Number number) {
		this.number = number;
		return this;
	}

	CardBuilder faceUp() {
		this.faceUp = true;
		return this;
	}
	
	Card build() {
		Card card = new Card(this.number, this.suite);
		if (this.faceUp) {
			card.flip();
		}
		return card;
	}
}
