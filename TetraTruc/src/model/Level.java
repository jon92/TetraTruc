package model;

public class Level {
	private int level;		// Niveau actuel
	private int speed;		// Vitesse du jeu (delay du timer)

	
	// Constructeur par defaut
	public Level(){
		level = 1;
		speed = 1000;
	}
	
	// Getters / Setters
	public int getLevel(){ return level; }
	public void setLevel(int l){ level=l; calcSpeed(); }
	public int getSpeed(){ return speed; }
	
	// Fonction de calcul de la vitesse en fonction du niveau
	private void calcSpeed(){ speed = 1000 - level*45; }
	
	// Passer au niveau superieur
	public void up(){
		if(level<20)
			level++;
		calcSpeed();
	}
}
