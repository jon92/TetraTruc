package Logic;

import Graphic.GraphicEngine;

public class GameEngine {
	private enum GameState{
		MAIN_MENU,
		SOLO_MENU,
		MULTI_MENU,
		OPTIONS_MENU,
		EXIT,
		GAME;
	}
	
	private GameState state;
	private static GameEngine gameESingleton = new GameEngine();
	
	public GameEngine(){
		this.state = GameState.MAIN_MENU;
	}
	
	public static GameEngine getSingleton(){
		return gameESingleton;
	}
	
	public GameState getState(){
		return this.state;
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
				
			case "EXIT_MENU" :
				this.state = GameState.EXIT;
				break;
				
			case "GAME" :
				this.state = GameState.GAME;
				break;
				
			default :
		}
	}
}
