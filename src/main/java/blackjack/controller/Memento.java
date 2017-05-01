package blackjack.controller;

import blackjack.model.Table;

public class Memento { 
	//Memento
	private Table Table;
	
	//save state
	public Memento(Table state){ 
		Table = state; 
	}
	//get state
	public Table getState(){
		return Table;
	}
	
	

	
}
