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
	
	//private Brick[] bricks;		// Emplacements des différentes cases du tétrominoe
	private Point[] points;
	
	// Constructeur
	Tetrominoe(Point a, Point b, Point c, Point d){
		points = new Point[4];
		points[0] = a;
		points[1] = b;
		points[2] = c;
		points[3] = d;
		
		/*bricks = new Brick[4];
		bricks[0] = new Brick(a);
		bricks[1] = new Brick(b);
		bricks[2] = new Brick(c);
		bricks[3] = new Brick(d);*/
	}
	
	// Getters / Setters
	/*public Brick getBrick(int index){
		if(index>=0 && index<=3){
			return bricks[index];
		}
		else{
			System.err.println("Error : Invalid brick number, must be contained between 0 and 3.");
			return null;
		}
	}*/
	
	public Point getPoint(int index){
		if(index>=0 && index<=3){
			return points[index];
		}
		else{
			System.err.println("Error : Invalid point number, must be contained between 0 and 3.");
			return null;
		}
	}
}
