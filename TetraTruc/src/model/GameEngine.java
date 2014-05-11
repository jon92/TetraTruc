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
	//Contient les parametres de jeu (pseudo, difficulte...)
	private HashMap<String, String> gameParams;
	private Dictionary dico;
	private ArrayList<Board> boards = new ArrayList<Board>();
	
	private GameEngine(){
		this.state = GameState.MAIN_MENU;
		this.dico = Dictionary.FR;
	}
	
	public static GameEngine getSingleton(){
		return gameESingleton;
	}
	
	public void initGame(){
		
		//sauvegarde de la derniere config utilisateur
		this.savePrefs();
		//Creation des joueurs
		ArrayList<Player> players = new ArrayList<Player>();
				
		//Creation des boards
		for(int i=0; i<Integer.parseInt(this.gameParams.get("players")); ++i){
			players.add(new Player(this.gameParams.get("pseudo"+(i+1))));
			this.boards.add(new Board(dico, players.get(i), this.gameParams.get("difficulte"), "Theme1"));
			this.boards.get(i).start();
		}
		
		//Lancement du jeu
	}
	
	public Board getBoard(int i){
		return this.boards.get(i);
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
		System.out.println("--- Parametres de la partie ---");
		System.out.println("Mode : " + this.gameParams.get("mode"));
		System.out.println("Pseudo : " + this.gameParams.get("pseudo"));
		System.out.println("Difficulte : " + this.gameParams.get("difficulte"));
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
