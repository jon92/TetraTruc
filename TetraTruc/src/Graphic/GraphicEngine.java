package Graphic;

public class GraphicEngine {
	private Window window;
	private MainMenu mainMenu;
	
	public void GraphicEngine(){
		
	}
	
	public void init(){
		//Cr�ation de la fen�tre de jeu
		window = new Window();
		mainMenu = new MainMenu(window.getPanel(), window.getWidth(), window.getHeight());
	}
}
