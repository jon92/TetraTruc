package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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
	private Board board;
	
	private GameEngine(){
		this.state = GameState.MAIN_MENU;
	}
	
	public static GameEngine getSingleton(){
		return gameESingleton;
	}
	
	public void initGame(){
		
		//sauvegarde de la dernière config utilisateur
		this.savePrefs();
		
		//Création d'un joueur
		Player player = new Player(this.gameParams.get("pseudo"));
		
	
// /!\ A modifier!			
		//Création d'une board 
		this.board = new Board(player, this.gameParams.get("difficulte"), "Theme1");
		
		//Lancement du jeu
	}
	
	public GameState getState(){
		return this.state;
	}
	
	private void savePrefs(){
		try {
			FileWriter file = new FileWriter("media/conf/prefs.tetra");
			BufferedWriter writer = new BufferedWriter(file);
			
			for(Entry<String, String> entry : this.gameParams.entrySet()) {
				writer.write(entry.getKey() + " @ " + entry.getValue() + "\n");
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setGameParams(HashMap<String, String> gameParams){
		this.gameParams = gameParams;
		System.out.println("--- Paramètres de la partie ---");
		System.out.println("Mode : " + this.gameParams.get("mode"));
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
