package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Board implements ActionListener {
	private final Player player;
	private final int difficulty;
	private Grid grid;
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

		// level
		level = new Level();
		
		// timer
		timer = new Timer(level.getSpeed(), this);
	}
	
	// Getters / Setters
	public Player getPlayer(){ return this.player; }	
	public Grid getGrid(){ return this.grid; }	
	
	// Lancement/Arret du jeu
	public void stop(){ timer.stop(); }
	public void start(){ grid.newShape(); timer.start(); }
	
	// Methode appelee par le timer : fait descendre la piece automatiquement
	public void actionPerformed(ActionEvent e) {
		level.incrNbLinesRemoved(grid.moveDown());
		level.up();
		timer.setDelay(level.getSpeed());
	}
	
}
