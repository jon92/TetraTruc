package vue;

import java.awt.Color;

public class Brick2D {
	private Color color;
	private String letter;
	private int pxlWidth, pxlHeight;		// Taille en pixels de la brique
	
	// Constructeur par défaut
	public Brick2D(int h, int w){
		pxlHeight = h;
		pxlWidth = w;
		letter = "";
		color = null;
	}
	
	public Brick2D(int h, int w, Color c, String l){
		pxlHeight = h;
		pxlWidth = w;
		color = c;
		letter = l;
	}
	
	// Getters / Setters
	public Color getColor(){ return color; }
	public void setColor(Color c){ color = c; }
	public String getLetter(){ return letter; }
	public void setLetter(String l){ letter = l; }
	
	public void draw(){
		// TO-DO
	}
}
