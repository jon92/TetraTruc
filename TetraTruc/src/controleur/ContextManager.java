package controleur;

import model.GameEngine;

public class ContextManager {
	private static MenuListener menuListener;
	private GameEngine gameEngine = GameEngine.getSingleton();
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
		gameEngine.setState("GAME");
	}
	
	public void setExitState(){
		System.out.println("Quitter le jeu");
		gameEngine.setState("EXIT");
	}
	
}
