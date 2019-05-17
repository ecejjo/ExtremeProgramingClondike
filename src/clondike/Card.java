package clondike;

public class Card {
	
	private Number number;
	private Suite suite;
	private boolean faceUp;
	
	public Card(Number number, Suite suite) {
		this.number = number;
		this.suite = suite;
		this.faceUp = false;
	}
	
	public Card flip() {
		this.faceUp = ! this.faceUp;
		return this;
	}
	
	public boolean isNextTo(Card card) {
		return (this.number.getValue() == card.getNumber().getValue() + 1);
	}
	
	public boolean isFaceUp() {
		return (this.faceUp == true);
	}
	
	public Number getNumber() {
		return number;	
	}
	
	public Suite getSuite() {
		return suite;
	}
	
	public Color getColor() {
		return null;
	}
	
	public String toString() {
		return null;
	}
	
	public int hashCode() {
		return 0;
	}
	
	public boolean equals(Object obj) {
		return false;
	}

}
