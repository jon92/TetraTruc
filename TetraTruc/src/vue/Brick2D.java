package vue;

import java.awt.Color;

public class Brick2D {
	private Color color;
	private String letter;
	
	// Constructeur par défaut
	public void Brick2D(){
		// Brique vide, transparente
	}
	
	public void Brick2D(Color c, String l){
		color = c;
		letter = l;
	}
	
	// Getters / Setters
	public Color getColor(){ return color; }
	public void setColor(Color c){ color = c; }
	
	public void draw(){
		// TO-DO
	}
}
