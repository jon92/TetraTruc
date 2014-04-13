package controleur;

import vue.GraphicEngine;
import model.GameEngine;

public class ContextManager {
	private static MenuListener menuListener;
	private GameEngine gameEngine = GameEngine.getSingleton();
	private GraphicEngine graphicEngine = GraphicEngine.getSingleton();
	private static ContextManager managerSingleton = new ContextManager();
	
	private ContextManager(){
		menuListener = new MenuListener();
	}
	
	public MenuListener getMenuListener(){
		return menuListener;
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
		
		//On d�tecte le mode de jeu choisi (solo ou multi)
		String previousState = gameEngine.getState().toString();
		graphicEngine.getGameParams(previousState);
		
		//Recup�rer ici les donn�es de jeu via des m�thodes du graphicEngine
		gameEngine.setState("GAME");
	}
	
	public void setExitState(){
		System.out.println("Quitter le jeu");
		gameEngine.setState("EXIT");
	}
	
}
