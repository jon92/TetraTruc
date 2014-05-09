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
	private Theme theme;
	
	private Tetrominoe[] nextShapes;	// Infos concernant la pièce à venir
	private Brick2D[] nextBricks;
	
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
		this.theme = new ThemeDefault();
		this.coords = null;
		this.shapes = null;
		this.nextShapes = null;
		
		this.grid = new Brick2D[height][width]; 	// Pour obtenir une case, grid[ligne][colonne]
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				this.grid[i][j] = new Brick2D(pxlHeight/height, pxlWidth/width);
			}
		}
		
		this.nextBricks = new Brick2D[4];
		for(int i=0; i<4; ++i)
			this.nextBricks[i] = new Brick2D(pxlHeight/height, pxlWidth/width);
		
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
		
		this.nextBricks = new Brick2D[4];
		for(int i=0; i<4; ++i)
			this.nextBricks[i] = new Brick2D(pxlHeight/height, pxlWidth/width);
		
		
		clearGrid();	// Initialisation de la grille vide
	}
	
	// Getters / Setters
	public Brick2D getBrick(int line, int col){ return grid[line][col]; }
	public int getMarginLeft(){ return marginLeft; }
	public int getMarginTop(){ return marginTop; }
	public int getSquareSize(){ return squareSize; }
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }

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
				grid[x-1][y-1].draw(g, theme.getColorByShape(shapes[i]), x, y, marginLeft, marginTop, 1);	// Modifie la couleur de la brique	
			}
		}
		
		
		//pour centrer les nextShapes dans l'affichage
		int gapX = 0;
		int gapY = 0;
		if(this.nextShapes != null){
			switch(this.nextShapes[0]){
				case Z_Shape :
					gapX = 7;
					gapY = 17;
					break;
				case I_Shape:
					gapX = -1;
					gapY = 9;
					break;
				case J_Shape:
					gapX = 6;
					gapY = 2;
					break;
				case L_Shape:
					gapX = 7;
					gapY = 17;
					break;
				case No_Shape:
					break;
				case O_Shape:
					break;
				case S_Shape:
					gapX = 6;
					gapY = 1;
					break;
				case T_Shape:
					gapX = 1;
					gapY = 8;
					break;
				default:
					break;
					
			}
		}
		
		// Dessin de la nextShape
		for(int i=0; i<4; ++i){
			if(this.nextShapes != null)
				nextBricks[i].draw(g, theme.getColorByShape(nextShapes[i]), nextShapes[i].getPoint(i).getX(), nextShapes[i].getPoint(i).getY(), 329 + gapX, 106 + gapY, 0.8f);	// Modifie la couleur de la brique
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
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				grid[i][j].setLetter(letters[i*width+j]);
			}
		}
		
		this.nextShapes = nextShapes;
		for(int i=0; i<4; ++i){
			nextBricks[i].setLetter(nextLetters[i]);
		}
		
		GraphicEngine.getSingleton().getGamePanel().repaint();
	}
}
