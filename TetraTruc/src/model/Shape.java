package model;

import java.util.Random;
import model.Tetrominoe;

public class Shape {
	private Tetrominoe pieceShape; 	// Forme de la pièce
	private Point coords;		// Coordonnées dans la grille
	
	public Shape(){
		coords = new Point(0,0);
		pieceShape = Tetrominoe.No_Shape;
	}
	
	public Shape(Grid grid){
		// Placement de la pièce en haut au centre de la grille
		coords = new Point(grid.getWidth()/2 - 1, 2);	
		
		// Tirage au sort de la pièce
		Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoe[] values = Tetrominoe.values(); 
        pieceShape = values[x];
	}
	
	public Shape rotate(){
		if (pieceShape == Tetrominoe.O_Shape)
            return this;

        Shape result = new Shape();
        result.coords = this.coords;
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
        	result.pieceShape.getBrick(i).setX(this.pieceShape.getBrick(i).getY());
        	result.pieceShape.getBrick(i).setY(-this.pieceShape.getBrick(i).getX());
        }
        
        return result;
	}
}
