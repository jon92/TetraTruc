package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
		PAUSE,
		SAVE,
		EXIT;
	}
	private GameState state;
	private static GameEngine gameESingleton = new GameEngine();
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	//Contient les parametres de jeu (pseudo, difficulte...)
	private HashMap<String, String> gameParams;
	private Dictionary dico;
	private ArrayList<Board> boards;
	
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
		this.boards = new ArrayList<Board>();
		for(int i=0; i<Integer.parseInt(this.gameParams.get("players")); ++i){
			players.add(new Player(this.gameParams.get("pseudo"+(i+1))));
			this.boards.add(new Board(i, dico, players.get(i), this.gameParams.get("difficulte"), "Theme1"));
			this.boards.get(i).start();
			
			if(Integer.parseInt(this.gameParams.get("players"))>1){
				this.boards.get(i).getGrid().setAnagramAvailable(false);
			}
		}
		

		
		//Lancement du jeu
	}
	
	public void resetGame(){
		for(int i=0; i<Integer.parseInt(this.gameParams.get("players")); ++i){
				this.boards.get(i).interrupt();
				this.boards.get(i).getTimer().stop();
		}
		this.boards = null;
		System.gc();
	}
	
	public ArrayList<Board> getBoards(){
		return this.boards;
	}
	
	public Board getBoard(int i){
		if(this.boards.isEmpty() || this.boards.size()<=i)
			return null;
		else 
			return this.boards.get(i);
	}
	
	public GameState getState(){
		return this.state;
	}
	
	private void savePrefs(){
		try {
			//FileWriter file = new FileWriter("prefs.tetra");
			//BufferedWriter writer = new BufferedWriter(file);
			
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("prefs.tetra"));
			BufferedWriter writer = new BufferedWriter(osw);
			
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
				
			case "OPTIONS_MENU" :
				this.state = GameState.OPTIONS_MENU;
				break;
				
			case "GAME" :
				this.state = GameState.GAME;
				break;
				
			case "PAUSE" :
				this.state = GameState.PAUSE;				
				break;
				
			case "SAVE" : 
				this.state = GameState.SAVE;
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
		for(Observer obs : this.observers ){
		      obs.update(this.state.toString());
		}
	}

	@Override
	public void delAllObservers() {
		this.observers = new ArrayList<Observer>();
	}
	
}
