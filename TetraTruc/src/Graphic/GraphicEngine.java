package Graphic;

import Logic.Observer;

public class GraphicEngine implements Observer {
	private Window window;
	private Menu2D menu2D;
	private static GraphicEngine graphicESingleton = new GraphicEngine();
	
	public void GraphicEngine(){
		
	}
	
	public void init(){
		//Création de la fenêtre de jeu
		this.window = new Window();
		this.menu2D = new Menu2D(this.window.getPanel());
		this.menu2D.createMainMenu(this.window.getWidth(), this.window.getHeight());
	}
	
	public static GraphicEngine getSingleton(){
		return graphicESingleton;
	}
	
	public void createSoloMenu(){
		this.menu2D.createSoloMenu(this.window.getWidth(), this.window.getHeight());
	}

	@Override
	public void update(String param) {
		switch(param){
			case "SOLO_MENU" :
				this.createSoloMenu();
				break;
				
			default:
		}
	}
}
