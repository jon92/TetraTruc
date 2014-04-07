import ContextManager.ContextManager;
import Graphic.GraphicEngine;
import Logic.GameEngine;


public class TetraTruc {

	public static void main(String[] args) {
		
		//Cr�ation du moteur graphique
		GraphicEngine graphicEngine = new GraphicEngine();
		graphicEngine.init();
		
		//Cr�ation du moteur de jeu
		GameEngine gameEngine = new GameEngine();
		
		//Cr�ation du contextManager
		ContextManager contextManager = new ContextManager();
	}

}
