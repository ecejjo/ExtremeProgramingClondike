package clondike;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
	
	private static final int NUMBER_OF_CARDS_FROM_STOCK_TO_WASTE = 3;
	private static final int NUMBER_OF_PILES = 4;

	Stock stock;
	Waste waste;
	List<Pile> piles;
	Map<Suite, Foundation> foundations;
	
	public Game() {
		clear();
	}
	
	public Game(Stock stock) {
		this.clear();
		this.stock = stock;
	}
	
	public void clear() {
		stock = new Stock();
		waste = new Waste();
		foundations = new HashMap<Suite, Foundation>();
		foundations.put(Suite.CLOVERS, new Foundation(Suite.CLOVERS));
		foundations.put(Suite.DIAMONDS, new Foundation(Suite.DIAMONDS));
		foundations.put(Suite.HEARTS, new Foundation(Suite.HEARTS));
		foundations.put(Suite.PIKES, new Foundation(Suite.PIKES));		
	}
	
	public boolean isFinished() {
		for (int i = 0; i < Suite.values().length; i++) {
			if (foundations.get(Suite.values()[i]).empty()) {
				return false;
			}
			if (foundations.get(Suite.values()[i]).cards.firstElement().getNumber() != Number.KING) {
				return false;
			}
		}
		return true;
	}
	
	public Error moveFromStockToWaste() {
		for (int i = 0; i < NUMBER_OF_CARDS_FROM_STOCK_TO_WASTE; i++) {
			if (stock.empty()) {
				return Error.EMPTY_STOCK;
			}
			waste.push(stock.pop());
		}
		return Error.SUCESS;
	}

	public Error moveFromWasteToFoundation() {
		if (foundations.get(waste.peek().getSuite()).cards.empty()) {
			if (waste.peek().getNumber() != Number.AS ) {
				return Error.NO_FIT_FOUNDATION;
			}
		}
		else if ( ! waste.peek().isNextTo(foundations.get(waste.peek().getSuite()).cards.firstElement())) {
			return Error.NO_FIT_FOUNDATION;
		}
		foundations.get(waste.peek().getSuite()).push(waste.pop());
		return Error.SUCESS;
	}
	
	public Error moveFromWasteToStock() {
		return null;
	}
	public Error moveFromWasteToPile(int pileIndex) {
		if (waste.peek().isNextTo(piles.get(pileIndex).peek())) {
			piles.get(pileIndex).push(waste.pop());
			return Error.SUCESS;
		}
		return Error.NO_FIT_PILE;
	}
	
	public Error moveFromFoundationToPile(Suite suite, int pileIndex) {
		if (foundations.get(suite).peek().isNextTo(piles.get(pileIndex).peek())) {
			piles.get(pileIndex).push(foundations.get(suite).pop());
		}
		return null;
	}
	public Error moveFromPileToFoundation(int pileIndex, Suite suite) {
		return null;
	}
	public Error moveFromPileToPile(int orginIndex, int destinationIndex) {
		return null;
	}
	
	Stock getStock() {
		return null;
	}
	
	Waste getWaste() {
		return null;
	}
	
	Map<Suite, Foundation> getFoundations() {
		return foundations;
	}
	
	List<Pile> getPiles() {
		return null;
	}

}
