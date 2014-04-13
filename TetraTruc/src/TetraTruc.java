import model.GameEngine;
import controleur.ContextManager;
import vue.GraphicEngine;


public class TetraTruc {

	public static void main(String[] args) {
		
		//Création du moteur graphique
		GraphicEngine graphicEngine = GraphicEngine.getSingleton();
		graphicEngine.init();
		
		//Création du moteur de jeu
		GameEngine gameEngine = GameEngine.getSingleton();
		gameEngine.addObserver(graphicEngine);
		
		//Création du contextManager
		ContextManager contextManager = ContextManager.getSingleton();
	}

}
