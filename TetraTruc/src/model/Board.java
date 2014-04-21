package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Board implements ActionListener {
	private final Player player;
	private final int difficulty;
	private Grid grid;
	private Theme theme;
	private Timer timer;
	private Level level;
	
	// Constructeur
	public Board(Player player, String difficulty, String chosenTheme){
		// joueur
		this.player = player;
		
		// niveau de difficulte
		if(difficulty.equals("Facile"))
			this.difficulty = 1;
		else if(difficulty.equals("Difficile"))
			this.difficulty = 3;
		else
			this.difficulty = 2;
		
		// grille de jeu
		this.grid = new Grid();
		
		// theme
		if (chosenTheme.equals("Theme2")){
			this.theme = new Theme2();
		}
		else{
			this.theme = new Theme1(); // par defaut, le theme est le Theme1
		}
		
		// level
		level = new Level();
		
		// timer
		timer = new Timer(level.getSpeed(), this);
		
	}
	
	// Getters / Setters
	public Player getPlayer(){ return this.player; }	
	public Grid getGrid(){ return this.grid; }	
	public Theme getTheme(){ return this.theme; }
	
	// Methode appelee par le timer : fait descendre la piece automatiquement
	public void actionPerformed(ActionEvent e) {
		grid.moveDown();
	}
	
	// Lancement/Arret du jeu
	public void start(){ timer.start(); }
	public void stop(){ timer.stop(); }
	
}
