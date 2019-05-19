package clondike;

public enum Suite {
	HEARTS(Color.RED, 'H'),
	DIAMONDS(Color.RED, 'D'),
	CLOVERS(Color.BLACK, 'C'),
	PIKES(Color.BLACK, 'P');
	
	private Color color;
	private char initial;
	
	Suite() {
	}
	
	private Suite(Color color, char initial) {
		this.color = color;
		this.initial = initial;
	}
	
	public char[] initials() {
		char [] charArray = new char[4];
		charArray[0] = Suite.HEARTS.initial;
		charArray[1] = Suite.DIAMONDS.initial;
		charArray[2] = Suite.CLOVERS.initial;
		charArray[3] = Suite.PIKES.initial;
		return charArray;
	}
	
	public Suite find(char initial) {
		switch (initial) {
		case 'H':
			return Suite.HEARTS;
		case 'D':
			return Suite.DIAMONDS;
		case 'C':
			return Suite.CLOVERS;
		case 'P':
			return Suite.PIKES;
		default:
			return null;
		}
	}
	
	public Color getColor() {
		return this.color;
	}

}
