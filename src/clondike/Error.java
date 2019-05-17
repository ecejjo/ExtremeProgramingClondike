package clondike;

public enum Error {
	EMPTY_STOCK(0, "Empty Stock error."),
	EMPTY_WASTE(1, "Empty Waste error."),
	EMPTY_FOUNDATION(2, "Empty Foundation error."),
	EMPTY_FILE(3, "Empty File error."),
	NO_EMPTY_STOCK(4, "No empty Stock error."),
	NO_FIT_FOUNDATION(5, "No fit Foundation error."),
	NO_FIT_PILE(6, "No fit Pile error."),
	SAME_PILE(7, "Same Pile error."),
	NO_ENOUGH_CARDS_PILE(8, "Not enough cards pile.");
	
	private int value;
	private String message;
	
	private Error(int value, String message) {
		this.value = value;
		this.message = message;
	}
	
	Error(String message) {
	}
	
	public String getMessage() {
		return null;
	}
}
