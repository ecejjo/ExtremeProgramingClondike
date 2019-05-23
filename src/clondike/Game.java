package clondike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
	
	public Game(Stock stock, Waste waste) {
		this.clear();
		this.stock = stock;
		this.waste = waste;
		this.piles = new ArrayList<Pile>();
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
		for (Suite suite : Suite.values()) {
			if (foundations.get(suite).empty()) {
				return false;
			}
			if ( ! foundations.get(suite).isComplete()) {
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
		if (this.getWaste().cards.empty()) {
			return Error.EMPTY_WASTE;
		}
		for (int i = 0; i < this.getWaste().cards.size(); i++) {
			this.stock.push(this.waste.pop());
		}
		return Error.SUCESS;
	}
	
	public Error moveFromWasteToPile(int pileIndex) {
		if (piles.size() < pileIndex) {
			return Error.NO_FIT_PILE;
		}
		if (piles.get(pileIndex).empty()) {
			if (waste.peek().getNumber() != Number.AS) {
				return Error.NO_FIT_PILE;
			}
			piles.get(pileIndex).push(waste.pop());
			return Error.SUCESS;
		}
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
	
	public Stock getStock() {
		return this.stock;
	}
	
	public Waste getWaste() {
		return this.waste;
	}
	
	public Map<Suite, Foundation> getFoundations() {
		return this.foundations;
	}
	
	public List<Pile> getPiles() {
		return this.piles;
	}

}
