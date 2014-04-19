package model;

public class Grid {
	private int height, width;		// Dimensions de la grille
	private Shape[][] grid;
	private Shape curShape;			// Pièce en train de tomber
	private int curX, curY;			// Emplacement de la pièce en train de tomber
	
	// Constructeur par défaut
	public Grid(){
		height = 20;
		width = 10;
		grid = new Shape[height][width]; 	// Pour obtenir une case, grid[ligne][colonne]
		
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				grid[i][j] = new Shape();
			}
		}
		
		clearGrid();	// Initialisation de la grille vide
	}
	
	// Constructeur personnalisé
	public Grid(int h, int w){
		height = h;
		width = w;
		grid = new Shape[height][width];
		
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				grid[i][j] = new Shape();
			}
		}
		
		clearGrid();	// Initialisation de la grille vide
	}
	
	
	
	// Getters/Setters
	public int getHeight(){ return height; }
	public int getWidth(){ return width; }
	public Shape shapeAt(int x, int y){ return grid[x][y]; }
	
	
	// Remplit les cases de la grille concernées par la pièce actuelle
	private void putCurShape(){
		// Parcourir les 4 briques du tetrominoe
		for(int brick=0; brick<4; ++brick){
			// Affecte à la case occupée par la brique la shape courante
			grid[curY + curShape.getTetrominoe().getBrick(brick).getY()][curX + curShape.getTetrominoe().getBrick(brick).getX()] = curShape;
		}
	}
	
	// Vide les cases de la grille occupées par la pièce actuelle
	private void clearCurShape(){
		// Parcourir les 4 briques du tetrominoe
		for(int brick=0; brick<4; ++brick){
			// Affecte à la case occupée par la brique la shape courante
			grid[curY + curShape.getTetrominoe().getBrick(brick).getY()][curX + curShape.getTetrominoe().getBrick(brick).getX()].setTetrominoe(Tetrominoe.No_Shape);
		}
	}
	
	// Met à jour la position de la pièce courante
	private void updateCurShape(int newX, int newY){
		clearCurShape();	// Supprime la pièce de son emplacement actuel
		curX = newX;		// Affecte les nouvelles coordonnées de la pièce
		curY = newY;
		putCurShape();		// Place la pièce à son nouvel emplacement
	}

	
	// Affecte à toutes les cases de la grille le Tetrominoe vide
	private void clearGrid(){
		for(int line=0; line<height; ++line){
			for(int col=0; col<width; ++col){
				grid[line][col].setTetrominoe(Tetrominoe.No_Shape);
			}
		}
	}
	
	// Supprime une ligne et fait tomber toutes les lignes supérieures
	public void removeLine(int line){
		// Parcourir toutes les lignes supérieures
		for(int currLine=line; currLine>0; --currLine){
			// Parcourir la ligne
			for(int i=0; i<width; ++i){
				grid[currLine][i] = grid[currLine-1][i];
			}
		}
	}
	
	// Supprime toutes les lignes pleines
	public void removeFullLines(){
		boolean lineIsFull = true;
		// Parcourir toutes les lignes
		for(int currLine=0; currLine<height; ++currLine){
			// Parcourir toutes les cases de la ligne
			for(int currCol=0; currCol<width; ++currCol){
				// Si une case est vide
				if(grid[currLine][currCol].getTetrominoe() == Tetrominoe.No_Shape)
					lineIsFull = false;
			}
			
			// Si la ligne est pleine, on la supprime
			if(lineIsFull)
				removeLine(currLine);
			lineIsFull = true;
		}
	}

}
