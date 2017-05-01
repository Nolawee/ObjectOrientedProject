package blackjack.controller;

import blackjack.model.Table;

public class GameOriginator { 
	// GameOriginator
	private Table Table;
	
	public void setState(Table gameTable){
		this.Table = gameTable;
	}
	// save game method
	public Memento saveGame(){
		return new Memento(Table);
	}
	// load game method
	public void loadGame(Memento m){
		Table = m.getState();
	}
}
