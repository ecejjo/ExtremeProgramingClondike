package clondike;

public class Card {
	
	private Number number;
	private Suite suite;
	private Boolean faceUp;
	
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
		return this.getSuite().getColor();
	}
	
	public String toString() {
		return this.number.toString() + " of " + this.suite.toString() + ", " + this.faceUp;
	}
	
	public int hashCode() {
		int hash = 7;
	    hash = 31 * hash + (this.number == null ? 0 : this.number.hashCode());
	    hash = 31 * hash + (this.suite == null ? 0 : this.suite.hashCode());
	    hash = 31 * hash + (this.faceUp == null ? 0 : this.faceUp.hashCode());
	    return hash;
	}
	
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

}
