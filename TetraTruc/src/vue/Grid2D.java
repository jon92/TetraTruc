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
	
	// ------- a supprimer plus tard ---------------
		private final int margins = 30;
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
		
		if(this.shapes != null && this.coords != null){
			for(int i=0; i<this.coords.length; ++i){
				int x = this.coords[i].getX();
				int y = this.coords[i].getY();
				grid[x-1][y-1].draw(g, theme.getColorByShape(shapes[i]), x, y, margins, letters[i]);	// Modifie la couleur de la brique	
			}
		}
		
		// ---------- A supprimer plus tard -----------
			g.setColor(Color.WHITE);
	
			//Dessin des lignes verticales
			int originX = margins;
			int originY = margins;
			int destX = margins;
			int destY = this.squareNumberH * this.squareSize + margins-1;
	
			for(int i=0; i <= this.squareNumberW; ++i){
			    g.drawLine(originX, originY, destX, destY);
			    originX += this.squareSize;
			    destX += this.squareSize;
			}
	
			//Dessin des lignes horizontales
			originX = margins;
			originY = margins;
			destX = this.squareNumberW * this.squareSize + margins-1;
			destY = margins;
	
			for(int i=0; i <= this.squareNumberH; ++i){
			    g.drawLine(originX, originY, destX, destY);
			    originY += this.squareSize;
			    destY += this.squareSize;
			}
	}
	
        // retourne la hauteur de la grille
        public int getHeight(){
            return height;
        }
        
        // retourne la largeur de la grille
        public int getWidth(){
            return width;
        }
        
        // retourne le tableau de Brick2D
        public Brick2D[][] getGrid(){
            return grid;
        }
        
        // retourne coords
        public Point[] getCoords(){
            return coords;
        }
             
	@Override
	public void update(Point[] coords, Tetrominoe[] shapes, String[] letters) {
		this.coords = coords;
		this.shapes = shapes;
		this.letters = letters;
		GraphicEngine.getSingleton().getGamePanel().repaint();
	}
}
