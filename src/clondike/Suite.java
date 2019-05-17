package clondike;

public enum Suite {
	HEARTS(Color.RED, 'R'),
	DIAMONDS(Color.RED, 'R'),
	CLOVERS(Color.BLACK, 'B'),
	PIKES(Color.BLACK, 'B');
	
	private Color color;
	private char initial;
	
	Suite() {
	}
	
	private Suite(Color color, char initial) {
		this.color = color;
		this.initial = initial;
	}
	
	public char[] initials() {
		char [] charArray = null;
		charArray[0] = Suite.HEARTS.initial;
		charArray[1] = Suite.DIAMONDS.initial;
		charArray[2] = Suite.CLOVERS.initial;
		charArray[3] = Suite.PIKES.initial;
		return charArray;
	}
	
	public Suite find(char initial) {
		return this.find(initial);
	}
	
	public Color getColor() {
		return this.color;
	}

}
