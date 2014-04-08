import ContextManager.ContextManager;
import Graphic.GraphicEngine;
import Logic.GameEngine;


public class TetraTruc {

	public static void main(String[] args) {
		
		//Création du moteur graphique
		GraphicEngine graphicEngine = GraphicEngine.getSingleton();
		graphicEngine.init();
		
		//Création du moteur de jeu
		GameEngine gameEngine = GameEngine.getSingleton();
		
		//Création du contextManager
		ContextManager contextManager = ContextManager.getSingleton();
	}

}
