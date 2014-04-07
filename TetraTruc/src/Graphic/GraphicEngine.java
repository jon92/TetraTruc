package Graphic;

public class GraphicEngine {
	private Window window;
	private Menu2D menu2D;
	private static GraphicEngine graphicESingleton = new GraphicEngine();
	
	public void GraphicEngine(){
		
	}
	
	public void init(){
		//Création de la fenêtre de jeu
		window = new Window();
		menu2D = new Menu2D(window.getPanel());
		menu2D.createMainMenu(window.getWidth(), window.getHeight());
	}
	
	public static GraphicEngine getSingleton(){
		return graphicESingleton;
	}
}
