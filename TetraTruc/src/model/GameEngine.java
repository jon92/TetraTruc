package model;

import java.util.ArrayList;
import java.util.HashMap;

public class GameEngine implements Observable {
	public enum GameState{
		MAIN_MENU,
		SOLO_MENU,
		MULTI_MENU,
		OPTIONS_MENU,
		GAME,
		EXIT;
	}
	private GameState state;
	private static GameEngine gameESingleton = new GameEngine();
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	//Contient les paramètres de jeu (pseudo, difficulté...)
	private HashMap<String, String> gameParams;
	
	private GameEngine(){
		this.state = GameState.MAIN_MENU;
	}
	
	public static GameEngine getSingleton(){
		return gameESingleton;
	}
	
	public GameState getState(){
		return this.state;
	}
	
	public void setGameParams(HashMap<String, String> gameParams){
		this.gameParams = gameParams;
		System.out.println("--- Paramètres de la partie ---");
		System.out.println("Pseudo : " + this.gameParams.get("pseudo"));
		System.out.println("Difficulté : " + this.gameParams.get("difficulte"));
	}
	
	public void setState(String state){
		switch(state){
			case "MAIN_MENU" :
				this.state = GameState.MAIN_MENU;
				break;
				
			case "SOLO_MENU" :
				this.state = GameState.SOLO_MENU;
				break;
				
			case "MULTI_MENU" :
				this.state = GameState.MULTI_MENU;
				break;
				
			case "OPTIONS" :
				this.state = GameState.OPTIONS_MENU;
				break;
				
			case "GAME" :
				this.state = GameState.GAME;
				break;
				
			case "EXIT_MENU" :
				this.state = GameState.EXIT;
				break;
				
			default :
		}
		
		this.updateObserver();
	}

	@Override
	public void addObserver(Observer obs) {
		this.observers.add(obs);
	}

	@Override
	public void updateObserver() {
		for(Observer obs : this.observers )
		      obs.update(this.state.toString());
	}

	@Override
	public void delAllObservers() {
		this.observers = new ArrayList<Observer>();
	}
}
