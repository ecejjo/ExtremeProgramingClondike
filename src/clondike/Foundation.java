package clondike;

public class Foundation extends CardStack {
	
	private Suite suite;
	
	public Foundation(Suite suite) {
		this.suite = suite;
	}
	
	boolean isComplete() {
		return cards.peek().getNumber() == Number.KING;
	}
	
	boolean fitsIn(Card card) {
		return ((this.getSuit() == card.getSuite()) &
				(card.isNextTo(cards.peek())));
	}
	
	Suite getSuit() {
		return this.suite;
	}
}
