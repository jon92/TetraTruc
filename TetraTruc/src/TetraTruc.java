import ContextManager.ContextManager;
import Graphic.GraphicEngine;
import Logic.GameEngine;


public class TetraTruc {

	public static void main(String[] args) {
		
		//Création du moteur graphique
		GraphicEngine graphicEngine = new GraphicEngine();
		graphicEngine.init();
		
		//Création du moteur de jeu
		GameEngine gameEngine = new GameEngine();
		
		//Création du contextManager
		ContextManager contextManager = new ContextManager();
	}

}
