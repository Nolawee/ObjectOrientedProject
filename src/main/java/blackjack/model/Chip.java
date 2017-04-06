package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Chip {
	private int value = 0;
	
	public Chip(int val) {
		value = val;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Chip[] divyUpChips(int amount) { //THIS SHOULD RETURN A MAP, NOT AN ARRAY
	    List<Chip> chips = new ArrayList<Chip>();
	    int[] chipValues = new int[]{50000, 20000, 5000, 500, 100, 50, 25, 10, 5, 1};
	    
	    for (int val: chipValues) {
	        int i;
	        for (i = 0; i < amount/val; i++) {
	            chips.add(new Chip(val));
	        }
	        amount = amount - (i*val);
	    }
	    
	    
	    return chips.toArray(new Chip[chips.size()]);
	}
	
//	public static void main(String[] args) {
//	    Chip[] chips = divyUpChips(1100732);
//	    
//	    for (Chip chip: chips) {
//	        System.out.println(chip.getValue());
//	    }
//	    
//	    
//	}
}
