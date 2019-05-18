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
		return this.number.toString() + " de " + this.suite.toString() + ", " + this.faceUp;
	}
	
	public int hashCode() {
		return this.number.hashCode() + this.suite.hashCode() + this.faceUp.hashCode();
	}
	
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

}
