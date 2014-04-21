package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Board implements ActionListener {
	private final Player player;
	private final int level;
	private Grid grid;
	private Theme theme;
	private Timer timer;
	
	public Board(Player player, String level, String chosenTheme){
		// joueur
		this.player = player;
		
		// niveau de difficulte
		if(level.equals("Facile"))
			this.level = 1;
		else if(level.equals("Difficile"))
			this.level = 3;
		else
			this.level = 2;
		
		// theme
		if (chosenTheme.equals("Theme2")){
			this.theme = new Theme2();
		}
		else{
			this.theme = new Theme1(); // par defaut, le theme est le Theme1
		}	
		
		// grille de jeu
		this.grid = new Grid();
		
		timer = new Timer(2000, this);	
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
	
	public void start(){
		this.grid.newShape();
		//this.grid.getCurShape();
		this.timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.grid.oneLineDown();
		System.out.println(this.grid.getCurShape().getTetrominoe());
	}
	
}
