package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import model.Observer;
import model.Point;
import model.Tetrominoe;

public class GraphicEngine implements Observer {
	private Window window;
	private static GraphicEngine graphicESingleton = new GraphicEngine();
	private Menu2D currentMenu;
	//private GamePanel gamePanel;
	private ArrayList<GamePanel> gamePanels = new ArrayList<GamePanel>();
	private int nbPlayers;
	
	/*
	private void GraphicEngine(){
		
	}*/
	
	public void init(){
		//Création de la fenêtre de jeu
		this.window = new Window();
		MainMenu mainMenu = new MainMenu(this.window.getPanel(), this.window.getWidth(), this.window.getHeight());
		mainMenu.create();
		nbPlayers = 0;
	}
	
	public static GraphicEngine getSingleton(){
		return graphicESingleton;
	}
	
	public GamePanel getGamePanel(int i){
		return this.gamePanels.get(i);
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
		soloMenu.loadPrefs("media/conf/prefs.tetra");
		soloMenu.create();
		this.currentMenu = soloMenu;
		this.nbPlayers = 1;
	}
	public void goToMultiMenu(){
		MultiMenu multiMenu = new MultiMenu(this.window.getPanel(), (int)(this.window.getSize().getWidth()), (int)(this.window.getSize().getHeight()));
		multiMenu.create();
		MultiMenu multiMenu2 = new MultiMenu(this.window.getPanel(), (int)(this.window.getSize().getWidth()), (int)(this.window.getSize().getHeight()));
		multiMenu2.create();
		this.currentMenu = multiMenu;
		this.nbPlayers = 2;
	}
	public void goToOptionsMenu(){
	}
	public void goToGame(){
		this.window.getContentPane().removeAll();
		//this.window.setSize(818, 600);

		this.window.repaint();
		if(this.nbPlayers >1){
			this.window.dispose();
			this.window = new Window(818, 600);
		}
		//this.gamePanel = new GamePanel(this.window.getPanel(), this.window.getWidth(), this.window.getHeight());
		this.gamePanels.add(new GamePanel(this.window.getPanel(), this.window.getWidth(), this.window.getHeight()));
		JPanel pan = new JPanel();
		pan.setPreferredSize(new Dimension(this.window.getWidth()*2, this.window.getHeight()*2));
		this.window.setContentPane(pan);
		this.window.setLayout(new GridLayout(1, 2));
		this.window.getContentPane().add(this.gamePanels.get(0));
		
		if(this.nbPlayers >1){
			//JPanel gamePanel2 = new GamePanel(this.window.getPanel(), this.window.getWidth(), this.window.getHeight());
			this.gamePanels.add(new GamePanel(this.window.getPanel(), this.window.getWidth(), this.window.getHeight()));
			this.window.getContentPane().add(this.gamePanels.get(1));
		}
		
		//this.window.setContentPane(this.gamePanel);
		//this.gamePanel.setPanel(this.window.getPanel());
		//this.window.getContentPane().revalidate();
		this.window.repaint();
		this.window.setVisible(true);
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
