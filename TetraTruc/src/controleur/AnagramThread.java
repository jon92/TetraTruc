package controleur;

import vue.GraphicEngine;
import model.GameEngine;
import model.GameEngine.GameState;

public class AnagramThread extends Thread {

	public void run(){
		GameState currentState = GameEngine.getSingleton().getState();
		while(currentState == GameState.PAUSE){
			currentState = GameEngine.getSingleton().getState();
		}
	}
}
