package controleur;

import java.util.HashMap;

import vue.GraphicEngine;
import model.GameEngine;

public class ContextManager {
	private static MenuListener menuListener;
	private static KeyboardListener keyListener;
	private GameEngine gameEngine = GameEngine.getSingleton();
	private GraphicEngine graphicEngine = GraphicEngine.getSingleton();
	private static ContextManager managerSingleton = new ContextManager();
	
	private ContextManager(){
		menuListener = new MenuListener();
		keyListener = new KeyboardListener();
	}
	
	public void doKeyAction(int action){
		if(gameEngine.getBoard() == null) return;
		switch (action){
			case 37 : 
				gameEngine.getBoard().getGrid().moveLeft();
			break;
			
			case 39 : 
				gameEngine.getBoard().getGrid().moveRight();
			break;
			
			case 38 : 
				gameEngine.getBoard().getGrid().rotate();
			break;
			
			case 40 : 
				gameEngine.getBoard().getGrid().moveDown();
			break;
		}
	}
	
	public MenuListener getMenuListener(){
		return menuListener;
	}
	
	public KeyboardListener getKeyListener(){
		return keyListener;
	}
	
	public static ContextManager getSingleton(){
		return managerSingleton;
	}
	
	public void setSoloState(){
		System.out.println("Menu Solo activ�");
		gameEngine.setState("SOLO_MENU");
	}
	
	public void setMultiState(){
		System.out.println("Menu Multi activ�");
		gameEngine.setState("MULTI_MENU");
	}
	
	public void setOptionsState(){
		System.out.println("Options activ�es");
		gameEngine.setState("OPTIONS_MENU");
	}
	
	public void setGameState(){
		System.out.println("Jeu lanc�");

		//Passage des param�tres de jeu choisis par le joueur (pseudo, difficult�...)
		HashMap<String, String> params = graphicEngine.getGameParams();
		gameEngine.setGameParams(params);
		gameEngine.setState("GAME");
		gameEngine.initGame();
		
		gameEngine.getBoard().getGrid().addObserver(graphicEngine.getGamePanel().getGrid2D());
	}
	
	public void setExitState(){
		System.out.println("Quitter le jeu");
		gameEngine.setState("EXIT");
	}
	
}
