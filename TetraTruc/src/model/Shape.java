package model;

import java.util.Random;
import model.Tetrominoe;

public class Shape {
	private Tetrominoe pieceShape; 	// Forme de la piece
	
	// Constructeur par defaut : No_Shape
	public Shape(){
		pieceShape = Tetrominoe.No_Shape;
	}
	
	// Selectionne un tetrominoe aleatoirement
	public void randomShape(){
		// Tirage au sort de la piece
		/*Random r = new Random();
        int z = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoe[] values = Tetrominoe.values(); 
        pieceShape = values[z];*/
		pieceShape = Tetrominoe.Z_Shape;
	}
	
	// Getters / Setters
	public Tetrominoe getTetrominoe(){ return pieceShape; }
	public void setTetrominoe(Tetrominoe shape){ pieceShape = shape; }
	
	// Taille minimale de la pièce
	public int minX(){
		int min = 0;
		for(int i=0; i<4; ++i){
			min = Math.min(min, pieceShape.getBrick(i).getX());
		}
		return min;
	}
	
	public int minY(){
		int min = 0;
		for(int i=0; i<4; ++i){
			min = Math.min(min, pieceShape.getBrick(i).getY());
		}
		return min;
	}
	
	// Deplacements des pieces
	public Shape rotate(){
		if (pieceShape == Tetrominoe.O_Shape)
            return this;

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
        	System.out.println("av X n�" + i + " " + pieceShape.getBrick(i).getPoint().getX());
            System.out.println("av Y n�" + i + " " + pieceShape.getBrick(i).getPoint().getY());
        	
            int tempX = pieceShape.getBrick(i).getPoint().getX();
        	System.out.println("tempX = " + tempX);
        	
        	result.pieceShape.getBrick(i).getPoint().setX(this.pieceShape.getBrick(i).getPoint().getY());
        	result.pieceShape.getBrick(i).getPoint().setY(-tempX);
        	
        	System.out.println("tempX = " + tempX);
            System.out.println("  X n�" + i + " " + result.pieceShape.getBrick(i).getPoint().getX());
            System.out.println("  Y n�" + i + " " + result.pieceShape.getBrick(i).getPoint().getY());
        }
        
        return result;
	}
	

	
}
