package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Board extends Thread implements ActionListener, BoardObservable {
	private final Player player;
	private final int difficulty;
	private Grid grid;
	private Timer timer;
	private Level level;
	private BoardObserver observer;
	
	// Constructeur
	public Board(Dictionary dico, Player player, String difficulty, String chosenTheme){
		// joueur
		this.player = player;
		
		// niveau de difficulte
		if(difficulty != null){
			if(difficulty.equals("Facile"))
				this.difficulty = 1;
			else if(difficulty.equals("Difficile"))
				this.difficulty = 3;
			else
				this.difficulty = 2;
		}else{
			this.difficulty = 0;
		}
		
		// grille de jeu
		this.grid = new Grid(20, 10, dico);

		// level
		level = new Level();
		
		// timer
		timer = new Timer(level.getSpeed(), this);
	}
	
	// Getters / Setters
	public Player getPlayer(){ return this.player; }	
	public Grid getGrid(){ return this.grid; }	
	
	// Lancement/Arret du jeu
	public void pause(){ timer.stop(); }
	public void run(){ grid.newShape(); timer.start(); }
	public void restart(){ timer.start(); }
	
	// Methode appelee par le timer : fait descendre la piece automatiquement
	public void actionPerformed(ActionEvent e) {
		level.incrNbLinesRemoved(grid.moveDown());
		level.up();
		timer.setDelay(level.getSpeed());
		this.updateObserver();
	}
	
	public void incrementScore(int value){
		this.getPlayer().incrementScore(value);
		this.updateObserver();
	}

	@Override
	public void updateObserver() {
		this.observer.update(this.player.getScore(), this.level.getLevel(), this.player.getPseudo());
	}

	@Override
	public void addObserver(BoardObserver obs) {
		this.observer = obs;	
	}

	@Override
	public void delAllObservers() {
		this.observer = null;
	}
	
}
