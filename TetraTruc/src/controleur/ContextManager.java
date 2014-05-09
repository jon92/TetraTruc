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
                // on ajoute des points au joueur
                gameEngine.getBoard().incrementScore(1);
                System.out.println("score + 1 descente rapide : "+ gameEngine.getBoard().getPlayer().getScore());
			break;
			case 32 : 
				gameEngine.getBoard().getGrid().dropBottom();
				
				gameEngine.getBoard().incrementScore(5);
                System.out.println("score + 5 descente rapide : "+ gameEngine.getBoard().getPlayer().getScore());
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
		System.out.println("Menu Solo activé");
		gameEngine.setState("SOLO_MENU");
	}
	
	public void setMultiState(){
		System.out.println("Menu Multi activé");
		gameEngine.setState("MULTI_MENU");
	}
	
	public void setOptionsState(){
		System.out.println("Options activées");
		gameEngine.setState("OPTIONS_MENU");
	}
	
	public void setGameState(){
		System.out.println("Jeu lancé");

		//Passage des paramètres de jeu choisis par le joueur (pseudo, difficulté...)
		HashMap<String, String> params = graphicEngine.getGameParams();
		gameEngine.setGameParams(params);
		gameEngine.setState("GAME");
		gameEngine.initGame();
		
		gameEngine.getBoard().addObserver(graphicEngine.getGamePanel());
		gameEngine.getBoard().getGrid().addObserver(graphicEngine.getGamePanel().getGrid2D());
	}
	
	public void setExitState(){
		System.out.println("Quitter le jeu");
		gameEngine.setState("EXIT");
	}
	
}
