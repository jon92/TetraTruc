package model;

import java.util.Vector;

import controleur.ContextManager;

public class Grid implements GridObservable {
	private int id;
	private int height, width;		// Dimensions de la grille
	private Shape[][] grid;
	private Shape curShape;			// Piece en train de tomber
	private Shape nextShape;		// Pièce qui va venir après
	private int curX, curY;			// Emplacement de la piece en train de tomber
	private GridObserver observer;	// Observateur pour la vue
	private Dictionary dico;		// Dictionnaire pour les fonctions worddle et anagramme
	private String anagramWord;
	private boolean anagramAvailable;
	private String[] unvalidatedLines;
	
	// Constructeur par defaut
	public Grid(){
		this.height = 20;
		this.width = 10;
		this.curShape = new Shape();
		this.nextShape = new Shape();
		this.grid = new Shape[height][width]; 	// Pour obtenir une case, grid[ligne][colonne]
		this.anagramAvailable = true;
		this.unvalidatedLines = new String[20];
		
		for(int i=0; i<height; ++i){
			for(int j=0; j<width; ++j){
				this.grid[i][j] = new Shape();
			}
		}
		
		clearGrid();	// Initialisation de la grille vide
	}
	
	// Constructeur personnalise
	public Grid(int id, int h, int w, Dictionary dico){
		this(); // appel du constructeur de base
		this.height = h;
		this.width = w;
		this.dico = dico;
		this.id = id;
	}
	
	
	
	// Getters/Setters
	public Shape getCurShape(){ return curShape; }
	public Shape getNextShape(){ return nextShape; }
	public int getCurX(){ return curX; }
	public int getCurY(){ return curY; }
	public int getHeight(){ return height; }
	public int getWidth(){ return width; }
	public Dictionary getDico(){ return dico; }
	public Shape shapeAt(int line, int col){ return grid[line][col]; }
	public void setAnagramWord(String word){ this.anagramWord=word; }
	public void setAnagramAvailable(boolean b){ this.anagramAvailable = b;}
	
	
	
	// Generer une nouvelle piece
	public void newShape(){
		if(nextShape.getTetrominoe() == Tetrominoe.No_Shape)
			this.nextShape.randomShape();
		this.curShape = nextShape;
		this.nextShape = new Shape();
		this.nextShape.randomShape();
		this.curX = this.width/2 - 1;
		this.curY = -curShape.minY();

		if(!canMoveTo(curX, curY+1))
			ContextManager.getSingleton().setGameOverState(id);
		
		putCurShape();
	}
	
	// Remplit les cases de la grille concernees par la piece actuelle
	private void putCurShape(){
		for(int brick=0; brick<4; ++brick){
			// Affecte a la case occupee par la brique la shape courante
			grid[curY + curShape.getBrick(brick).getY()][curX + curShape.getBrick(brick).getX()].setTetrominoe(curShape.getTetrominoe());
		}
	}
	
	// Vide les cases de la grille occupees par la piece actuelle
	private void clearCurShape(){
		for(int brick=0; brick<4; ++brick){
			// Affecte a la case occupee par la brique la shape courante
			grid[curY + curShape.getBrick(brick).getY()][curX + curShape.getBrick(brick).getX()].setTetrominoe(Tetrominoe.No_Shape);
		}
	}

	// Teste si la piece passee en parametres peut se deplacer aux nouvelles coordonnees
	private boolean shapeCanMoveTo(Shape newShape, int newX, int newY){
		for(int brick=0; brick<4; ++brick){
			// Nouvelles coordonnees de la brique
			int x = newX + newShape.getBrick(brick).getX();
			int y = newY + newShape.getBrick(brick).getY();
			
			// Tester si la case est dans la grille
			if( x<0 || x>=width || y<0 || y>=height ){
				return false;
			}
			// Tester si la case est libre
			if(grid[y][x].getTetrominoe() != Tetrominoe.No_Shape){
				return false;
			}
		}
		return true;
	}
	
	// Teste si la piece courante peut se deplacer aux nouvelles coordonnees
	private boolean canMoveTo(int newX, int newY){
		clearCurShape();
		if(shapeCanMoveTo(curShape, newX, newY)){
			putCurShape();
			return true;
		}
		putCurShape();
		return false;
	}

	// Teste si la piece courante peut tourner
	private boolean canRotate(){
		clearCurShape();
		
		Shape curShapeRotated = curShape.rotate();
		
		if(shapeCanMoveTo(curShapeRotated, curX, curY)){
			curShapeRotated.rotate();
			curShapeRotated.rotate();
			curShapeRotated.rotate();
			curShape = curShapeRotated;
			putCurShape();
			return true;
		}
		curShapeRotated.rotate();
		curShapeRotated.rotate();
		curShapeRotated.rotate();
		putCurShape();
		return false;
	}
	
	// Deplacer la piece courante
	public boolean moveTo(int newX, int newY){
		if(canMoveTo(newX, newY) && newY>=curY ){	// On verifie que la piece peut effectuer le deplacement et qu'il se fait bien vers le bas
			clearCurShape();	// Supprime la piece de son emplacement actuel
			curX = newX;		// Affecte les nouvelles coordonnees de la piece
			curY = newY;
			putCurShape();		// Place la piece a son nouvel emplacement
			return true;
		}
		return false;
	}
	
	// Deplacements joueur
	public void moveLeft(){ 
		if(moveTo(curX-1, curY))
			updateObserver();	// Notifier la vue
	}
	
	public void moveRight(){ 
		if(moveTo(curX+1, curY))
			updateObserver();	// Notifier la vue
	}
	
	// Retourne le nombre de lignes détruites
	public int moveDown(){ 
		// Si la piece peut descendre d'une ligne
		if(moveTo(curX, curY+1)){
			updateObserver();	// Notifier la vue
			return 0;
		}
		else{	// Sinon, c'est qu'elle posee
			int fullLines = removeFullLines(false);
			newShape();
			updateObserver();	// Notifier la vue
			return fullLines;
		}
	}
	
	// Tourner la piece courante
	public void rotate(){
		if(canRotate()){
			clearCurShape();	// Supprime la piece de son emplacement actuel
			curShape.rotate();	// Tourne la piece
			putCurShape();		// Place la piece a son nouvel emplacement
			updateObserver();	// Notifier la vue
			return;
		}
	}
	
	// Faire tomber la piece directement tout en bas
	public void dropBottom(){
		while(canMoveTo(curX, curY+1)){
			moveDown();
		}
	}
	
	
	// Affecte a toutes les cases de la grille le Tetrominoe vide
	private void clearGrid(){
		for(int line=0; line<height; ++line){
			for(int col=0; col<width; ++col){
				grid[line][col].setTetrominoe(Tetrominoe.No_Shape);
			}
		}
	}
	
	// Supprime une brique et fait tomber toutes les lignes superieures
	private void removeBrick(int line, int col){
		// Parcourir toutes les lignes superieures
		for(int currLine=line; currLine>0; --currLine){
			grid[currLine][col] = grid[currLine-1][col];
		}
		
		ContextManager.getSingleton().incrementScore(2, this.id);
		
		// Traitement spécifique à la premiere ligne
		grid[0][col] = new Shape();
	}
	
	// Supprime une ligne et fait tomber toutes les lignes superieures
	private void removeLine(int line){
		// Parcourir toute la ligne
		for(int currCol=0; currCol<width; ++currCol){
			removeBrick(line, currCol);
		}
		ContextManager.getSingleton().incrementScore(8, this.id);
	}
	
	// Supprime toutes les lignes pleines
	public int removeFullLines( boolean anagramChecked ){
		boolean lineIsFull = true;
		int nbFullLines = 0;
		// Parcourir toutes les lignes
		for(int currLine=0; currLine<height; ++currLine){
			// Parcourir toutes les cases de la ligne
			for(int currCol=0; currCol<width; ++currCol){
				// Si une case est vide
				if(grid[currLine][currCol].getTetrominoe() == Tetrominoe.No_Shape)
					lineIsFull = false;
			}
			
			// Si la ligne est pleine, on la supprime
			if(lineIsFull){
				// Interruption du jeu
				if(this.unvalidatedLines[currLine] == null){
					if(!anagramChecked && this.anagramAvailable){
						ContextManager.getSingleton().setPauseState(currLine);
						ContextManager.getSingleton().setAnagramState();
					}
					
					if(anagramChecked == true || (!this.anagramAvailable)){
						clearCurShape();
						removeLine(currLine);
						nbFullLines++;
					}
				}
			}
			lineIsFull = true;
		}
		
		return nbFullLines;
	}
	
	
	// Envoie à la Grid2D un tableau de coordonnées contenant les cases ayant été modifiées, et un tableau correspondant aux shapes à ces coordonnées
	@Override
	public void updateObserver() {
		Point coords[] = new Point[height*width];
		Tetrominoe shapes[] = new Tetrominoe[height*width];
		String letters[] = new String[height*width];
		
		Tetrominoe nextShape[] = new Tetrominoe[4];
		String nextLetters[] = new String[4];
		
		for(int i=0; i<height; ++i){
			for (int j=1; j<=width; ++j){
				coords[i*width + j -1] = new Point(i+1, j);
				shapes[i*width + j -1] = grid[i][j-1].getTetrominoe();
				
				
				//Creation du tableau de lettres 
				for(int z =0; z<4; ++z){
					if(grid[i][j-1].getTetrominoe() != Tetrominoe.No_Shape)
						letters[i*width + j -1] = grid[i][j-1].getBrick(z).getLetter();
				}
		
				if(curShape != null){
					for(int l=0; l<4; ++l){
						if(curY + curShape.getBrick(l).getPoint().getY() == i && curX + curShape.getBrick(l).getPoint().getX() == j-1){
							for(int m=0; m<4; ++m){
								grid[i][j-1].getBrick(m).setLetter(curShape.getBrick(l).getLetter());
							}
							letters[i*width + j -1] = grid[i][j-1].getBrick(l).getLetter();
						}
					}
				}
				
			}
		}
		
		for(int i=0; i<4; ++i){
			nextShape[i] = this.nextShape.getTetrominoe();
			nextLetters[i] = this.nextShape.getBrick(i).getLetter();
		}
		
		observer.update(coords, shapes, letters, nextShape, nextLetters);	

	}
	
	public void checkAnagramWord(int id){
		if(dico.containsWord(this.anagramWord, 0, dico.getNbLines())){
			removeFullLines(true);
			ContextManager.getSingleton().setPauseState(-2);
		}else{
			this.unvalidatedLines[id] = this.anagramWord;
			ContextManager.getSingleton().setPauseState(-2);
			ContextManager.getSingleton().incrementScore(-2, this.id);
		}
	}
	
	public void checkWorddleWord(int id, Vector<Integer> coords){
		if(dico.containsWord(this.anagramWord, 0, dico.getNbLines())){
			clearCurShape();	// Enleve la curShape de la grille pour éviter les mauvaises interactions le temps de supprimer les briques
			for(int i=0; i<coords.size(); i+=2){
				removeBrick(coords.get(i), coords.get(i+1));
			}
			putCurShape();
			ContextManager.getSingleton().setPauseState(-2);
		}else{
			this.unvalidatedLines[id] = this.anagramWord;
			ContextManager.getSingleton().setPauseState(-2);
		}
	}

	@Override
	public void addObserver(GridObserver obs) {
		this.observer = obs;
	}

	@Override
	public void delAllObservers() {
		this.observer = null;
	}
}
