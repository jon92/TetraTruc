package model;

public class Level {
	private int level;	// Niveau actuel
	private int speed;	// Vitesse du jeu actuel
	private int nbLinesRemoved;		// Nombre de lignes ayant été détruites dans le niveau
	private int nbLinesRequired;	// Nombre de lignes requises pour passer au niveau supérieur
	
	// Constructeur par defaut
	public Level(){
		level = 1;
		speed = 1000;
		nbLinesRequired = 4;
		nbLinesRemoved = 0;
	}
	
	// Getters / Setters
	public int getLevel(){ return level; }
	public void setLevel(int l){ level=l; calcSpeed(); }
	public int getSpeed(){ return speed; }
	public void incrNbLinesRemoved(int n){ nbLinesRemoved+=n; }		// Incrémente le nombre de lignes détruites
	
	// Fonction de calcul de la vitesse en fonction du niveau
	private void calcSpeed(){ speed = 1000 - level*45; }
	
	// Fonction de calcul du nombre de lignes requises en fonction du niveau
	private void calcNbLinesRequired(){ nbLinesRequired = 4*level - 3*(level-1); }
	
	// Passer au niveau superieur
	public void up(){
		if(level<20 && nbLinesRemoved >= nbLinesRequired){
			level++;
			nbLinesRemoved = 0;
		}
		calcSpeed();
		calcNbLinesRequired();
	}
}
