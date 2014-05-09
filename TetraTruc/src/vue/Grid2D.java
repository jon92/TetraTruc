package vue;

import java.awt.Color;
import java.awt.Graphics;

import model.GridObserver;
import model.Point;
import model.Tetrominoe;


// TO DO : recuperer les infos de Grid pour squareNumberW et squareNumberH
// TO DO : recuperer le theme choisi depuis le menu


public class Grid2D implements GridObserver{
	private int height, width; 	// Dimensions de la grille, en cases
	private int pxlHeight, pxlWidth;	// Dimensions de la grille, en pixels
	private final int squareSize; //Dimension d'une brique
	private final int originGridLeft; //position de l'origine du repere de la grille
	private final int originGridTop;
	private final int originNextShapeLeft; //position de l'origine du repere de l'encart nextShape
	private final int originNextShapeTop;
	private int squareNumberW;
	private int squareNumberH;
	
	private Brick2D[][] grid; // Grille de briques
	private Point[] coords;
	private Tetrominoe[] shapes;
	private Theme theme;
	private Tetrominoe[] nextShapes;	// Infos concernant la piece a venir
	private Brick2D[] nextBricks;


	// Constructeur par defaut
	public Grid2D(){
		this.height = 20;
		this.width = 10;
		this.pxlHeight = 400;
		this.pxlWidth = 200;
		this.originGridLeft = 46;
		this.originGridTop = 82;
		this.originNextShapeLeft = 329;
		this.originNextShapeTop = 106;
		this.squareSize = this.pxlHeight / this.height;
		this.squareNumberW = this.pxlWidth / this.squareSize;
		this.squareNumberH = this.pxlHeight / this.squareSize;
		
		this.theme = new ThemeDefault();
		this.coords = null;
		this.shapes = null;
		this.nextShapes = null;
		
		//Initialisation des briques de la grille
		this.grid = new Brick2D[height][width]; 	// Pour obtenir une case, grid[ligne][colonne]
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				this.grid[i][j] = new Brick2D(this.squareSize);
			}
		}
		
		//Initialisation des briques de la piece suivante
		this.nextBricks = new Brick2D[4];
		for(int i=0; i<4; ++i)
			this.nextBricks[i] = new Brick2D(this.squareSize);
		
		clearGrid();	// Initialisation de la grille vide
	}
	
	// Constructeur personnalise
	public Grid2D(int h, int w, int pxlH, int pxlW, Theme t){
		this.height = h;
		this.width = w;
		this.pxlHeight = pxlH;
		this.pxlWidth = pxlW;
		this.squareSize = this.pxlHeight / this.height;
		this.originGridLeft = 46;
		this.originGridTop = 82;
		this.originNextShapeLeft = 329;
		this.originNextShapeTop = 106;
		this.squareNumberW = this.pxlWidth / this.squareSize;
		this.squareNumberH = this.pxlHeight / this.squareSize;
		
		this.theme = t;
		this.coords = null;
		this.shapes = null;
		this.nextShapes = null;
		
		//Initialisation des briques de la grille
		this.grid = new Brick2D[height][width]; 	// Pour obtenir une case, grid[ligne][colonne]
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				this.grid[i][j] = new Brick2D(this.squareSize);
			}
		}
		
		//Initialisation des briques de la piece suivante
		this.nextBricks = new Brick2D[4];
		for(int i=0; i<4; ++i)
			this.nextBricks[i] = new Brick2D(this.squareSize);
		
		clearGrid();	// Initialisation de la grille vide
	}
	
	// Getters / Setters
	public Brick2D getBrick(int line, int col){ return grid[line][col]; }
	public int getOriginGridLeft(){ return originGridLeft; }
	public int getOriginGridTop(){ return originGridTop; }
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
		
		// ---------- Dessin des briques ----------
		if(this.shapes != null && this.coords != null){
			for(int i=0; i<this.coords.length; ++i){
				int x = this.coords[i].getX();
				int y = this.coords[i].getY();
				grid[x-1][y-1].draw(g, theme.getColorByShape(shapes[i]), x, y, originGridLeft, originGridTop, 1);	// Modifie la couleur de la brique	
			}
		}
		
		// ---------- Dessin de la grille -----------
		g.setColor(new Color(30, 30, 30));

		//lignes verticales
		int originX = originGridLeft;
		int originY = originGridTop;
		int destX = originGridLeft;
		int destY = this.squareNumberH * this.squareSize + originGridTop-1;

		for(int i=0; i <= this.squareNumberW; ++i){
			if(i>0 && i<this.squareNumberW)
				g.drawLine(originX, originY, destX, destY);
		    originX += this.squareSize;
		    destX += this.squareSize;
		}

		//lignes horizontales
		originX = originGridLeft;
		originY = originGridTop;
		destX = this.squareNumberW * this.squareSize + originGridLeft-1;
		destY = originGridTop;

		for(int i=0; i <= this.squareNumberH; ++i){
			if(i>0 && i< this.squareNumberH)
				g.drawLine(originX, originY, destX, destY);
		    originY += this.squareSize;
		    destY += this.squareSize;
		}
		
		// ---------- Dessin de la nextShape ----------
		//Centre la nextShape dans son conteneur
		int offsetX = 0;
		int offsetY = 0;
		if(this.nextShapes != null){
			switch(this.nextShapes[0]){
				case Z_Shape :
					offsetX = 7;
					offsetY = 17;
					break;
				case I_Shape:
					offsetX = -1;
					offsetY = 9;
					break;
				case J_Shape:
					offsetX = 6;
					offsetY = 2;
					break;
				case L_Shape:
					offsetX = 7;
					offsetY = 17;
					break;
				case No_Shape:
					break;
				case O_Shape:
					break;
				case S_Shape:
					offsetX = 6;
					offsetY = 1;
					break;
				case T_Shape:
					offsetX = 1;
					offsetY = 8;
					break;
				default:
					break;				
			}
		}
		
		// Dessin des briques de la nextShape
		for(int i=0; i<4; ++i){
			if(this.nextShapes != null)
				nextBricks[i].draw(g, theme.getColorByShape(nextShapes[i]), nextShapes[i].getPoint(i).getX(), nextShapes[i].getPoint(i).getY(), 329 + offsetX, 106 + offsetY, 0.8f);	// Modifie la couleur de la brique
		}
	}
	
	@Override
	public void update(Point[] coords, Tetrominoe[] shapes, String[] letters, Tetrominoe[] nextShapes, String[] nextLetters) {
		this.coords = coords;
		this.shapes = shapes;
		
		//Lettres de la grille
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				grid[i][j].setLetter(letters[i*width+j]);
			}
		}
		
		//Lettres de la nextShape
		this.nextShapes = nextShapes;
		for(int i=0; i<4; ++i){
			nextBricks[i].setLetter(nextLetters[i]);
		}
		
		GraphicEngine.getSingleton().getGamePanel().repaint();
	}
}
