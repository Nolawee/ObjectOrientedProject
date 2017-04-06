package blackjack.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Chip {
	private int value = 0;
	
	public Chip(int val) {
		value = val;
	}
	
	public int getValue() {
		return value;
	}
	
	/*
	 * TODO: Consider that this representation of chips 
	 *       makes the member variable "value" obsolete. 
	 */
	public static Map<Integer, Integer> divyUpChips(int amount) { 
        Map<Integer, Integer> chips = new LinkedHashMap<Integer, Integer>();
        int[] chipValues = new int[]{50000, 20000, 5000, 500, 100, 50, 25, 10, 5, 1};
        
        for (int val: chipValues) {
            int numChips = amount/val;
            chips.put(val, numChips);
            amount = amount - numChips*val;
        }
        
        chips.values().removeIf(v -> v==0);
        return chips;
    }
	
	//----Main method for testing------------------------------------------------------
	
//	public static void main(String[] args) {
//	    Map chips = divyUpChips(1100732);
//	    
//	    System.out.println(chips);
//	}
}
