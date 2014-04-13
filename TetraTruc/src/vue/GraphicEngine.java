package vue;

import model.Observer;

public class GraphicEngine implements Observer {
	private Window window;
	private Menu2D menu2D;
	private static GraphicEngine graphicESingleton = new GraphicEngine();
	
	private void GraphicEngine(){
		
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
	
	public void goToMainMenu(){
		this.menu2D.createMainMenu(this.window.getWidth(), this.window.getHeight());
	}
	public void goToSoloMenu(){
		this.menu2D.createSoloMenu(this.window.getWidth(), this.window.getHeight());
	}
	public void goToMultiMenu(){
	}
	public void goToOptionsMenu(){
	}
	public void goToGame(){
		this.window.getPanel().removeAll();
		this.window.repaint();
		this.window.setPanel(new GamePanel(this.window.getPanel()));
	}

	@Override
	public void update(String param) {
		switch(param){
			case "MAIN_MENU" :
				this.goToMainMenu();
			break;
			
			case "SOLO_MENU" :
				this.goToSoloMenu();
				break;
				
			case "MULTI_MENU" :
				this.goToMultiMenu();
				break;
				
			case "OPTIONS_MENU" :
				this.goToOptionsMenu();
				break;
				
			case "GAME" :
				this.goToGame();
				break;
				
			case "Exit" :
				break;
				
			default:
		}
	}
}
