package clondike;

public enum Error {
	SUCESS("No error."),
	EMPTY_STOCK("Empty Stock error."),
	EMPTY_WASTE("Empty Waste error."),
	EMPTY_FOUNDATION("Empty Foundation error."),
	EMPTY_PILE("Empty Pile error."),
	NO_EMPTY_STOCK("No empty Stock error."),
	NO_FIT_FOUNDATION("No fit Foundation error."),
	NO_FIT_PILE("No fit Pile error."),
	SAME_PILE("Same Pile error."),
	NO_ENOUGH_CARDS_PILE("Not enough cards pile.");
	
	private String message;
	
	private Error(String message) {
		this.message = message;
	}
		
	public String getMessage() {
		return message;
	}
}
