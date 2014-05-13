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
	private ArrayList<GamePanel> gamePanels = new ArrayList<GamePanel>();
	private int nbPlayers;
	private Theme theme;
	
	/*
	private void GraphicEngine(){
		
	}*/
	
	public void init(){
		// choix du theme
		this.theme = new ThemeDefault();
		
		
		//Création de la fenêtre de jeu
		this.window = new Window();
		MainMenu mainMenu = new MainMenu(this.window.getPanel(), this.window.getWidth(), this.window.getHeight());
		mainMenu.create();
		nbPlayers = 0;
		
		this.window.getPanel().setBackgroundImage(mainMenu.getBackgroundImage());
		
		this.window.repaint();		
	}
	
	public static GraphicEngine getSingleton(){
		return graphicESingleton;
	}
	

	public Window getWindow(){return this.window; }
	public GamePanel getGamePanel(int i){ return this.gamePanels.get(i); }
	public HashMap<String, String> getGameParams(){ return(this.currentMenu.getMenuParams()); }
	public int getNbPlayers(){ return this.nbPlayers; }
	public Theme getTheme(){ return this.theme; }
	
	
	public void goToMainMenu(){
		
		int scMenu = 1;
		if(this.currentMenu.getMenuParams().get("mode") == "multi"){
			this.window.dispose();
			this.window = new Window();
			scMenu = 0;
		}
		this.window.getContentPane().removeAll();
		this.window.repaint();
		
		MainMenu mainMenu = new MainMenu(this.window.getPanel(), this.window.getWidth(), this.window.getHeight());
		mainMenu.create();
		this.currentMenu = mainMenu;
		
		this.window.getPanel().setBackgroundImage(mainMenu.getBackgroundImage());
		if(scMenu !=0)
			this.window.getContentPane().add(mainMenu.getPanel());
		
		this.window.repaint();
		this.window.setVisible(true);
	}
	public void goToSoloMenu(){
		this.window.repaint();
		SoloMenu soloMenu = new SoloMenu(this.window.getPanel(), this.window.getWidth(), this.window.getHeight());
		soloMenu.loadPrefs("media/conf/prefs.tetra");
		soloMenu.create();
		this.currentMenu = soloMenu;
		this.nbPlayers = 1;
		
		this.window.getPanel().setBackgroundImage(soloMenu.getBackgroundImage());
		
	}
	public void goToMultiMenu(){
		MultiMenu multiMenu = new MultiMenu(this.window.getPanel(), (int)(this.window.getSize().getWidth()), (int)(this.window.getSize().getHeight()));
		multiMenu.loadPrefs("media/conf/prefs.tetra");
		multiMenu.create();
		this.currentMenu = multiMenu;
		this.nbPlayers = 2;
		
		this.window.getPanel().setBackgroundImage(multiMenu.getBackgroundImage());
		
	}
	public void goToOptionsMenu(){
	}
	public void goToGame(){
		this.window.getContentPane().removeAll();

		this.window.repaint();
		if(this.nbPlayers >1){
			this.window.dispose();
			this.window = new Window(800, 560);
		}
		JPanel pan = new JPanel();
		pan.setPreferredSize(new Dimension(this.window.getWidth()*2, this.window.getHeight()*2));
		this.window.setContentPane(pan);
		GridLayout gl = new GridLayout(1,2);
		this.window.setLayout(gl);
		
		for(int i=0; i<this.nbPlayers; ++i){;
			this.gamePanels.add(new GamePanel(this.window.getPanel(), this.window.getWidth(), this.window.getHeight(), i));
			this.window.getContentPane().add(this.gamePanels.get(i));
		}
		
		this.window.repaint();
		this.window.setVisible(true);
	}

	@Override
	public void update(String param) {
		switch(param){
			case "MAIN_MENU" :
				this.goToMainMenu();
				//this.goToGame();
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
