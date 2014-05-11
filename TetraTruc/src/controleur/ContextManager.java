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
		if(gameEngine.getBoard(0) == null) return;
		switch (action){
			case 37 : 
				gameEngine.getBoard(0).getGrid().moveLeft();
			break;
			
			case 39 : 
				gameEngine.getBoard(0).getGrid().moveRight();
			break;
			
			case 38 : 
				gameEngine.getBoard(0).getGrid().rotate();
			break;
			
			case 40 : 
				gameEngine.getBoard(0).getGrid().moveDown();
                // on ajoute des points au joueur
                //gameEngine.getBoard().getPlayer().setScore(1);
				gameEngine.getBoard(0).incrementScore(1);
                System.out.println("score + 1 descente rapide : "+ gameEngine.getBoard(0).getPlayer().getScore());
			break;
			case 32 : 
				gameEngine.getBoard(0).getGrid().dropBottom();
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
	}
	
	public void setGameState(){
		System.out.println("Jeu lance");

		//Passage des paramètres de jeu choisis par le joueur (pseudo, difficulté...)
		HashMap<String, String> params = graphicEngine.getGameParams();
		gameEngine.setGameParams(params);
		gameEngine.setState("GAME");
		gameEngine.initGame();
		
		gameEngine.getBoard(0).addObserver(graphicEngine.getGamePanel());
		gameEngine.getBoard(0).getGrid().addObserver(graphicEngine.getGamePanel().getGrid2D());
	}
	
	public void setExitState(){
		System.out.println("Quitter le jeu");
		gameEngine.setState("EXIT");
	}
	
}
