package model;

import java.util.Random;

import model.Tetrominoe;

public class Shape {
	private Tetrominoe pieceShape; 	// Forme de la piece
	private Brick[] bricks = new Brick[4];
	
	// Constructeur par defaut : No_Shape
	public Shape(){
		pieceShape = Tetrominoe.No_Shape;
		
		for(int i=0; i<4; ++i){
			this.bricks[i] = new Brick(new Point(0,0));
		}
	}
	
	public void generateRandomLetter(){
		for(int i=0; i<4; ++i){
			this.getBrick(i).generateRandomLetter(Dictionary.FR);
		}
	}
	
	public Brick getBrick(int index){
		if(index>=0 && index<=3){
			return bricks[index];
		}
		else{
			System.err.println("Error : Invalid brick number, must be contained between 0 and 3.");
			return null;
		}
	}
		
	// Selectionne un tetrominoe aleatoirement
	public void randomShape(){
		// Tirage au sort de la piece
		Random r = new Random();
        int z = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoe[] values = Tetrominoe.values(); 
        pieceShape = values[z];
        
        for(int i=0; i<4; ++i){
			this.bricks[i].setPoint(pieceShape.getPoint(i));
		}
        
        this.generateRandomLetter();
	}
	
	// Getters / Setters
	public Tetrominoe getTetrominoe(){ 
		return pieceShape; 
	}
	public void setTetrominoe(Tetrominoe shape){ 
		pieceShape = shape;
	}
	
	// Taille minimale de la pièce
	public int minX(){
		int min = 0;
		for(int i=0; i<4; ++i){
			min = Math.min(min, getBrick(i).getX());
		}
		return min;
	}
	
	public int minY(){
		int min = 0;
		for(int i=0; i<4; ++i){
			min = Math.min(min, getBrick(i).getY());
		}
		return min;
	}
	
	// Deplacements des pieces
	public Shape rotate(){

        for (int i = 0; i < 4; ++i) {
            int tempX = getBrick(i).getPoint().getX();
        	this.getBrick(i).getPoint().setX(this.getBrick(i).getPoint().getY());
        	this.getBrick(i).getPoint().setY(-tempX);
        }
        
        return this;
	}
	

	
}
