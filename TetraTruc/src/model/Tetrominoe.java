package model;

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
	
	private Point brick1, brick2, brick3, brick4;		// Emplacements des différentes cases du tétrominoe
	
	// Constructeur
	Tetrominoe(Point a, Point b, Point c, Point d){
		brick1 = a;
		brick2 = b;
		brick3 = c;
		brick4 = d;
	}
}
