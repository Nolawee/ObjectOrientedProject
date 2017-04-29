package blackjack.controller;

import blackjack.model.Table;

public class Memento { 
	//Memento
	private Table Table;
	
	public Memento(Table state){ 
		Table = state; 
	}
	
	public Table getState(){
		return Table;
	}
	
	

	
}
