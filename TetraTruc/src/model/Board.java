package model;

public class Board {
	private final Player player;
	private final int level;
	private Grid grid;
	private Theme theme;
	
	public Board(Player player, String level, String chosenTheme){
		// joueur
		this.player = player;
		
		// niveau de difficulté
		if(level.equals("Facile"))
			this.level = 1;
		else if(level.equals("Difficile"))
			this.level = 3;
		else
			this.level = 2;
		
		// grille de jeu
		this.grid = new Grid();
		
		// theme
		if (chosenTheme.equals("Theme2")){
			this.theme = new Theme2();
		}
		else{
			this.theme = new Theme1(); // par défaut, le thème est le Theme1
		}
		
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public Grid getGrid(){
		return this.grid;
	}
	
	public Theme getTheme(){
		return this.theme;
	}
	
}
