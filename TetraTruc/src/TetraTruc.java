import model.GameEngine;
import controleur.ContextManager;
import vue.GraphicEngine;


public class TetraTruc {

	public static void main(String[] args) {
		
		//Cr�ation du moteur graphique
		GraphicEngine graphicEngine = GraphicEngine.getSingleton();
		graphicEngine.init();
		
		//Cr�ation du moteur de jeu
		GameEngine gameEngine = GameEngine.getSingleton();
		gameEngine.addObserver(graphicEngine);
		
		//Cr�ation du contextManager
		ContextManager contextManager = ContextManager.getSingleton();
	}

}
