package vue;

import java.awt.Color;
import java.awt.Graphics;

import model.GridObserver;
import model.Observer;
import model.Point;
import model.Tetrominoe;


// TO DO : récupérer les infos de Grid pour squareNumberW et squareNumberH
// TO DO : récupérer le thème choisi depuis le menu


public class Grid2D implements GridObserver{
	private int height, width; 	// Dimensions de la grille, en cases
	private int pxlHeight, pxlWidth;	// Dimensions de la grille, en pixels
	private Brick2D[][] grid; 			// Grille de briques
	private Point[] coords;
	private Tetrominoe[] shapes;
	private String[] letters;
	private Theme theme;
	
	private Tetrominoe[] nextShapes;	// Infos concernant la pièce à venir
	private String[] nextLetters;
	
	// ------- a supprimer plus tard ---------------
		private final int marginLeft = 46;
		private final int marginTop = 82;
		private final int squareSize = 20;
		private int squareNumberW = 10;
		private int squareNumberH = 20;

	// Constructeur par défaut
	public Grid2D(){
		this.height = 20;
		this.width = 10;
		this.pxlHeight = 400;
		this.pxlWidth = 200;
		this.theme = new Theme1();
		this.coords = null;
		this.shapes = null;
		this.nextShapes = null;
		
		this.grid = new Brick2D[height][width]; 	// Pour obtenir une case, grid[ligne][colonne]
		
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				this.grid[i][j] = new Brick2D(pxlHeight/height, pxlWidth/width);
			}
		}
		
		clearGrid();	// Initialisation de la grille vide
	}
	
	// Constructeur personnalisé
	public Grid2D(int h, int w, int pxlH, int pxlW, Theme t){
		this.height = h;
		this.width = w;
		this.pxlHeight = pxlH;
		this.pxlWidth = pxlW;
		this.theme = t;
		this.coords = null;
		this.shapes = null;
		this.nextShapes = null;
		
		this.grid = new Brick2D[height][width]; 	// Pour obtenir une case, grid[ligne][colonne]
		
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				this.grid[i][j] = new Brick2D(pxlHeight/height, pxlWidth/width);
			}
		}
		
		clearGrid();	// Initialisation de la grille vide
	}

	// Nettoyage de la grille
	public void clearGrid(){
		for(int line=0; line<height; ++line){
			for(int col=0; col<width; ++col){
				grid[line][col].setColor(null);
			}
		}
	}
	
	public void draw(Graphics g, int width, int height){
		// Dessin des briques de la grille
		if(this.shapes != null && this.coords != null){
			for(int i=0; i<this.coords.length; ++i){
				int x = this.coords[i].getX();
				int y = this.coords[i].getY();
				grid[x-1][y-1].draw(g, theme.getColorByShape(shapes[i]), x, y, marginLeft, marginTop, letters[i]);	// Modifie la couleur de la brique	
			}
		}
		
		// Dessin de la nextShape
		for(int i=0; i<4; ++i){
			grid[i][i].draw(g, theme.getColorByShape(nextShapes[i]), i, i, margins, nextLetters[i]);	// Modifie la couleur de la brique
		}
		
		// ---------- A supprimer plus tard -----------
			g.setColor(new Color(30, 30, 30));
	
			//Dessin des lignes verticales
			int originX = marginLeft;
			int originY = marginTop;
			int destX = marginLeft;
			int destY = this.squareNumberH * this.squareSize + marginTop-1;
	
			for(int i=0; i <= this.squareNumberW; ++i){
				if(i>0 && i<this.squareNumberW)
					g.drawLine(originX, originY, destX, destY);
			    originX += this.squareSize;
			    destX += this.squareSize;
			}
	
			//Dessin des lignes horizontales
			originX = marginLeft;
			originY = marginTop;
			destX = this.squareNumberW * this.squareSize + marginLeft-1;
			destY = marginTop;
	
			for(int i=0; i <= this.squareNumberH; ++i){
				if(i>0 && i< this.squareNumberH)
					g.drawLine(originX, originY, destX, destY);
			    originY += this.squareSize;
			    destY += this.squareSize;
			}
	}
	
	@Override
	public void update(Point[] coords, Tetrominoe[] shapes, String[] letters, Tetrominoe[] nextShapes, String[] nextLetters) {
		this.coords = coords;
		this.shapes = shapes;
		this.letters = letters;
		
		this.nextShapes = nextShapes;
		this.nextLetters = nextLetters;
		
		GraphicEngine.getSingleton().getGamePanel().repaint();
	}
}
