package model;

public class Level {
	private int level;
	private int speed;
	
	// Constructeur par defaut
	public Level(){
		level = 1;
		speed = 400;
	}
	
	public int getLevel(){ return level; }
	public int getSpeed(){ return speed; }
}
