package controleur;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import vue.GraphicEngine;
import vue.NoAvailablePrint;
import model.GameEngine;
import model.GameEngine.GameState;

public class ContextManager {
	private static MenuListener menuListener;
	private static KeyboardListener keyListener;
	private GameEngine gameEngine = GameEngine.getSingleton();
	private GraphicEngine graphicEngine = GraphicEngine.getSingleton();
	private static ContextManager managerSingleton = new ContextManager();
	private static GameButtonListener gameButtonListener;
	private ArrayList<ArrayList<Integer>> configs = new ArrayList<ArrayList<Integer>>();
	private AnagramThread anagramThread = new AnagramThread();
	private int pauseId;
	private ContextManager(){
		menuListener = new MenuListener();
		keyListener = new KeyboardListener();
		gameButtonListener = new GameButtonListener();
		
		this.pauseId = -1;

		ArrayList<Integer> config1 = new ArrayList<Integer>();
		config1.add(37);
		config1.add(39);
		config1.add(38);
		config1.add(40);
		config1.add(32);
		this.configs.add(config1);

		ArrayList<Integer> config2 = new ArrayList<Integer>();
		config2.add(81);
		config2.add(68);
		config2.add(90);
		config2.add(83);
		config2.add(16);
		this.configs.add(config2);
	}

	public void doKeyAction(int action, int config){
		if(gameEngine.getBoard(0) == null) return;
		if(gameEngine.getBoard(config) == null && action!=10) return;
		
		int left = this.configs.get(config).get(0);
		int right = this.configs.get(config).get(1);
		int up = this.configs.get(config).get(2);
		int down = this.configs.get(config).get(3);
		int bottom = this.configs.get(config).get(4);
		
		if(action == 10 && graphicEngine.getGamePanel(0).getSelectedLetters().length()>0 ){
			
			String selectedLetters = graphicEngine.getGamePanel(0).getSelectedLetters();
			graphicEngine.getGamePanel(0).resetSelectedLetters();
			graphicEngine.getGamePanel(0).setAnagram(false);
			gameEngine.getBoard(0).getGrid().setAnagramWord(selectedLetters);
			gameEngine.getBoard(0).getGrid().checkAnagramWord(this.pauseId);
			anagramThread.interrupt();
			this.pauseId = -1;
			
		}
		
		if(this.gameEngine.getState() == GameState.PAUSE)
			return;
		
		if(action == left){
			
			gameEngine.getBoard(config).getGrid().moveLeft();
			
		}else if(action == right){
			
			gameEngine.getBoard(config).getGrid().moveRight();
			
		}else if(action == up){
			
			gameEngine.getBoard(config).getGrid().rotate();
			
		}else if(action == down){
			
			gameEngine.getBoard(config).getGrid().moveDown();
			gameEngine.getBoard(config).incrementScore(1);
			
		}else if(action == bottom){
			
			gameEngine.getBoard(config).incrementScore( 20-gameEngine.getBoard(config).getGrid().getCurY() +5 );
			gameEngine.getBoard(config).getGrid().dropBottom();
			
		}else{
			return;
		}
	}
	
	public MenuListener getMenuListener(){
		return menuListener;
	}
	
	public GameButtonListener getGameButtonListener(){
		return gameButtonListener;
	}
	
	public KeyboardListener getKeyListener(){
		return keyListener;
	}
	
	public static ContextManager getSingleton(){
		return managerSingleton;
	}
	
	public void setSoloState(){
		System.out.println("Menu Solo actif");
		gameEngine.setState("SOLO_MENU");
	}
	
	public void setMultiState(){
		System.out.println("Menu Multi actif");
		gameEngine.setState("MULTI_MENU");
	}
	
	public void setOptionsState(){
		System.out.println("Options actives");
		gameEngine.setState("OPTIONS_MENU");
		
		NoAvailablePrint error = new NoAvailablePrint();
		error.alertNoAvailable();
		
	}
	
	public void setGameState(){
		System.out.println("Jeu lance");

		//Passage des paramètres de jeu choisis par le joueur (pseudo, difficulté...)
		HashMap<String, String> params = graphicEngine.getGameParams();
		gameEngine.setGameParams(params);
		gameEngine.setState("GAME");
		gameEngine.initGame();
		
		for(int i =0; i< Integer.parseInt(params.get("players")); ++i){
			gameEngine.getBoard(i).addObserver(graphicEngine.getGamePanel(i));
			gameEngine.getBoard(i).getGrid().addObserver(graphicEngine.getGamePanel(i).getGrid2D());
		}
	}
	
	public void setAnagramState(){
		if (!anagramThread.isAlive()){
			graphicEngine.getGamePanel(0).setAnagram(true);
			anagramThread.start();
		}
	}
	
	// Etat quitter
	public void setExitState(){
		System.out.println("Quitter le jeu");
		gameEngine.setState("EXIT");
		System.exit(0);
	}
	
	// Etat pause
	
	public void setPauseState(int id){
		//System.out.println("id + " + id);
		//System.out.println("pauseid " + pauseId);
		if(id != pauseId && pauseId != -1 && id != -2)
			return;
					
		this.pauseId = id;
		HashMap<String, String> params = graphicEngine.getGameParams();

		
		if (this.gameEngine.getState() == GameState.GAME ){
		
			System.out.println("Pause");
	
			for(int i =0; i< Integer.parseInt(params.get("players")); ++i){
				this.gameEngine.getBoard(i).pause();
			}
			this.gameEngine.setState("PAUSE");
			return;
		}
		else if (this.gameEngine.getState() == GameState.PAUSE ){
			System.out.println("Fin de la pause");
		
			for(int i =0; i< Integer.parseInt(params.get("players")); ++i){
				this.gameEngine.getBoard(i).restart();
			}
			
			this.gameEngine.setState("GAME");
			return;
		}
	}
	
	// Sauvegarder
	public void setSaveState(){
		System.out.println("Sauvegarde");
		NoAvailablePrint error = new NoAvailablePrint();
		error.alertNoAvailable();
	}
	
}
