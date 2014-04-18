package model;

import javax.naming.directory.InvalidAttributeValueException;

import model.Point;

public enum Tetrominoe {
	No_Shape(new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0)),
	O_Shape(new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1)),
	L_Shape(new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1)),
	J_Shape(new Point(1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1)),
	S_Shape(new Point(0, -1), new Point(0, 0), new Point(1, 0), new Point(1, 1)),
	Z_Shape(new Point(0, -1), new Point(0, 0), new Point(-1, 0), new Point(-1, 1)),
	T_Shape(new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1)),
	I_Shape(new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2));
	
	private Brick brick1, brick2, brick3, brick4;		// Emplacements des différentes cases du tétrominoe
	
	// Constructeur
	Tetrominoe(Point a, Point b, Point c, Point d){
		brick1 = new Brick(a);
		brick2 = new Brick(b);
		brick3 = new Brick(c);
		brick4 = new Brick(d);
	}
	
	// Getters / Setters
	public Brick getBrick(int index){
		switch(index){
			case 1: 
				return brick1;
			case 2: 
				return brick2;
			case 3:
				return brick3;
			case 4:
				return brick4;
			default:
				break;
		}
		System.err.println("Error : Invalid brick number, must be contained between 1 and 4.");
		return null;
		
	}
}
