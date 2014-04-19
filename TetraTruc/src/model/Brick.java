package model;

public class Brick {
	private String letter;		// Lettre contenue dans la brique pour le mode anagramme
	private Point point;		// Point de coordonnées dans le tetrominoe
	
	// Constructeur
	public Brick(){
		letter = "";
		point = new Point(0, 0);
	}
	
	public Brick(Point p){
		letter = "";
		point = p;
	}
	
	// Getters/Setters
	public String getLetter(){ return letter; }
	public void setLetter(String l){ letter = l; }
	public Point getPoint(){ return point; }
	public void setPoint(Point p){ point = p; }
	public int getX(){ return point.getX(); }		// Raccourci pour ne pas passer par getPoint()
	public int getY(){ return point.getY(); } 		// Raccourci pour ne pas passer par getPoint()
	
	
	public void generateRandomLetter(){
		// Récupère une lettre aléatoirement en tenant compte de la fréquence dans la langue du dictionnaire
	}
}
