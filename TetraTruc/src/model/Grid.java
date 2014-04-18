package model;

public class Grid {
	private int height, width;		// Dimensions de la grille
	private Shape[][] grid;
	
	// Constructeur par défaut
	public Grid(){
		height = 20;
		width = 10;
		grid = new Shape[height][width]; 	// Pour obtenir une case, grid[ligne][colonne] 
		clearGrid();	// Initialisation de la grille vide
	}
	
	// Constructeur personnalisé
	public Grid(int h, int w){
		height = h;
		width = w;
		grid = new Shape[height][width];
		clearGrid();	// Initialisation de la grille vide
	}
	
	
	
	// Getters/Setters
	public int getHeight(){ return height; }
	public int getWidth(){ return width; }
	public Shape shapeAt(int x, int y){ return grid[x][y]; }
	
	
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
	
	// Supprime toutes les lignes vides
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
