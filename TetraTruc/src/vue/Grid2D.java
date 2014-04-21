package vue;

import java.awt.Color;
import java.awt.Graphics;

import model.GridObserver;
import model.Observer;
import model.Point;
import model.Shape;
import model.Tetrominoe;
import model.Theme;


// TO DO : récupérer les infos de Grid pour squareNumberW et squareNumberH
// TO DO : récupérer le thème choisi depuis le menu


public class Grid2D implements GridObserver {
	private int height, width; 	// Dimensions de la grille
	private Brick2D[][] grid; 			// Grille de briques

	// Constructeur par défaut
	public void Grid2D(){
		this.height = 20;
		this.width = 10;
		this.grid = new Brick2D[height][width]; 	// Pour obtenir une case, grid[ligne][colonne]
		
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				this.grid[i][j] = new Brick2D();
			}
		}
		
		clearGrid();	// Initialisation de la grille vide
	}
	
	// Constructeur personnalisé
	public void Grid2D(int h, int w){
		this.height = h;
		this.width = w;
		this.grid = new Brick2D[height][width]; 	// Pour obtenir une case, grid[ligne][colonne]
		
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				this.grid[i][j] = new Brick2D();
			}
		}
		
		clearGrid();	// Initialisation de la grille vide
	}

	// Nettoyage de la grille
	public void clearGrid(){
		// Parcourir toute la grid et la remplir de Brick2D vide (transparentes, invisibles, NULL ou je ne sais quoi)
	}
	
	public void draw(){
		// TO-DO
	}
	
	
	// Récupérer la couleur en fonction du thème et du shape
	public Color getColorForShape(Tetrominoe shape){
		// Regarde le shape passé en paramètre, regarde dans le thème et retourne la bonne couleur
		return null;
	}
	
	
	
	@Override
	public void update(Point[] coords, Tetrominoe[] shapes) {
		for(int i=0; i<coords.length; ++i){
			int x = coords[i].getX();
			int y = coords[i].getY();
			
			grid[y][x].setColor(getColorForShape(shapes[i]));	// Modifie la couleur de la brique	
		}
	}
}
