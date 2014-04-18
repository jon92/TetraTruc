package model;

import java.util.Random;
import model.Tetrominoe;

public class Shape {
	private Tetrominoe pieceShape; 	// Forme de la pièce
	
	// Constructeur par défaut : No_Shape
	public Shape(){
		pieceShape = Tetrominoe.No_Shape;
	}
	
	// Sélectionne un tétrominoe aléatoirement
	public void randomShape(){
		// Tirage au sort de la pièce
		Random r = new Random();
        int z = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoe[] values = Tetrominoe.values(); 
        pieceShape = values[z];
	}
	
	// Getters / Setters
	public Tetrominoe getTetrominoe(){ return pieceShape; }
	public void setTetrominoe(Tetrominoe shape){ pieceShape = shape; }
	
	// Déplacements des pièces
	public Shape rotate(){
		if (pieceShape == Tetrominoe.O_Shape)
            return this;

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
        	result.pieceShape.getBrick(i).setX(this.pieceShape.getBrick(i).getY());
        	result.pieceShape.getBrick(i).setY(-this.pieceShape.getBrick(i).getX());
        }
        
        return result;
	}
	

	
}
