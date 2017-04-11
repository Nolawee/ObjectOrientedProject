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
	    
	    chips.put(chipVal, currentChipCount++);
	}
	
	public int takeChip(int chipVal) throws IllegalStateException {
        if (chips.containsKey(chipVal)) {
            int currentChipCount = chips.get(chipVal);
            chips.put(chipVal, currentChipCount--);
            return chipVal;
        }
        else throw new IllegalStateException("That chip is not among the current chips: " + chipVal);
	}
	
	private static Map<Integer, Integer> divyUpChips(int amount) { 
        Map<Integer, Integer> chips = new LinkedHashMap<Integer, Integer>();
        int[] chipValues = new int[]{50000, 20000, 5000, 500, 100, 50, 25, 10, 5, 1}; //These chips are fairly arbitrary 
        
        for (int val: chipValues) {
            int numChips = amount/val;
            chips.put(val, numChips);
            amount = amount - numChips*val;
        }
        
        chips.values().removeIf(v -> v==0);
        return chips;
    }

	
	//----Temp main method for testing--------------------------------------------------
	
//	public static void main(String[] args) {
//	    Map chips = divyUpChips(1100732);
//	    
//	    System.out.println(chips);
//	}
}
