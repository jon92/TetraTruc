package model;

public class Grid {
	private int height, width;		// Dimensions de la grille
	
	// Constructeur par défaut
	public Grid(){
		height = 20;
		width = 10;
	}
	
	// Constructeur personnalisé
	public Grid(int h, int w){
		height = h;
		width = w;
	}
	
	// Getters/Setters
	public int getHeight(){ return height; }
	public int getWidth(){ return width; }
	
}
