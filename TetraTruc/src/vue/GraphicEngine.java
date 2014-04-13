package vue;

import java.util.HashMap;

import model.Observer;

public class GraphicEngine implements Observer {
	private Window window;
	private Menu2D menu2D;
	private static GraphicEngine graphicESingleton = new GraphicEngine();
	private Menu2D currentMenu;
	
	private void GraphicEngine(){
		
	}
	
	public void init(){
		//Création de la fenêtre de jeu
		this.window = new Window();
		MainMenu mainMenu = new MainMenu(this.window.getPanel(), this.window.getWidth(), this.window.getHeight());
		mainMenu.create();
	}
	
	public static GraphicEngine getSingleton(){
		return graphicESingleton;
	}
	
	public HashMap<String, String> getGameParams(){
		return(this.currentMenu.getMenuParams());
	}
	
	public void goToMainMenu(){
		MainMenu mainMenu = new MainMenu(this.window.getPanel(), this.window.getWidth(), this.window.getHeight());
		mainMenu.create();
		this.currentMenu = mainMenu;
	}
	public void goToSoloMenu(){
		SoloMenu soloMenu = new SoloMenu(this.window.getPanel(), this.window.getWidth(), this.window.getHeight());
		soloMenu.create();
		this.currentMenu = soloMenu;
	}
	public void goToMultiMenu(){
	}
	public void goToOptionsMenu(){
	}
	public void goToGame(){
		this.window.getPanel().removeAll();
		this.window.repaint();
		this.window.setPanel(new GamePanel(this.window.getPanel(), this.window.getWidth(), this.window.getHeight()));
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
