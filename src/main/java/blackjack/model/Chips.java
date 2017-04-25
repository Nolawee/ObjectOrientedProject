package blackjack.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Chips { 
	private Map<Integer, Integer> chips;
	
	/*
	 * Poker chips represented as a Map that maintains 
	 * a count of how many of each chip is possessed. 
	 * (Mapping: chip's value -> number of those chips)
	 */
	public Chips(int amount) { 
		chips = divyUpChips(amount);
	}
	
	public Map<Integer, Integer> getChips() {
        return chips;
    }
	
	public void addChip(int chipVal) {
	    int currentChipCount;
	    if (chips.containsKey(chipVal)) currentChipCount = chips.get(chipVal);
	    else currentChipCount = 0;
	    
	    chips.put(chipVal, currentChipCount+1);
	}
	
	public int getTotalValueOfChips() {
	    int sum = 0;
        for (Map.Entry<Integer, Integer> entry : chips.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
	}
	
	public void combineChips(Chips chips) { 
	    Map<Integer,Integer> newChips = chips.getChips();
	    for (int chipVal: newChips.keySet()) {
	        for (int i = 0; i < newChips.get(chipVal); i++) {
	            addChip(chipVal);
	        }
	    }
	}
	
	public int takeChip(int chipVal) throws IllegalStateException {
        if (chips.containsKey(chipVal)) {
            int currentChipCount = chips.get(chipVal);
            chips.put(chipVal, currentChipCount-1);
            chips.values().removeIf(v -> v==0);
            return chipVal;
        }
        else throw new IllegalStateException("That chip is not among the current chips: " + chipVal);
	}
	
	public boolean isEmpty() {
	    return chips.isEmpty();
	}
	
	private static Map<Integer, Integer> divyUpChips(int amount) { 
        Map<Integer, Integer> chips = new LinkedHashMap<Integer, Integer>();
        int[] chipValues = new int[]{50000, 20000, 5000, 500, 100, 50, 25, 10, 5, 1}; //These chips are fairly arbitrary 
        
        for (int chipVal: chipValues) {
            int numChips = amount/chipVal;
            chips.put(chipVal, numChips);
            amount = amount - numChips*chipVal;
        }
        
        chips.values().removeIf(v -> v==0);
        return chips;
    }
	
	public void printChips() {
	    getChips().forEach((k, v) -> {
	        System.out.println("" + v + " chips worth $" + k);
	    });
	}

	
	//----Temp main method for testing--------------------------------------------------
	
//	public static void main(String[] args) {
//	    Chips chips = new Chips(1100732);
//	    
//	    chips.printChips();
//	}
}
