package clondike;

public class Foundation extends CardStack {
	
	private Suite suite;
	
	public Foundation(Suite suite) {
		this.suite = suite;
	}
	
	boolean isComplete() {
		if (this.empty()) {
			return false;
		}
		return this.peek().getNumber() == Number.KING;
	}
	
	boolean fitsIn(Card card) {
		return ((this.getSuit() == card.getSuite()) &
				(card.isNextTo(this.peek())));
	}
	
	Suite getSuit() {
		return this.suite;
	}
}
