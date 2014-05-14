package model;

public class Brick {
	private String letter;		// Lettre contenue dans la brique pour le mode anagramme
	private Point point;		// Point de coordonnees dans le tetrominoe
	private boolean placed;
	
	// Constructeur
	public Brick(){
        this.letter = "";
		this.point = new Point(0, 0);
		this.placed = false;
	}
	
	public Brick(Point p){
        //this.generateRandomLetter(Dictionary.FR);
		this.point = p;
		this.placed = false;
	}
	
	// Getters/Setters
	public String getLetter(){ return letter; }
	public void setLetter(String l){ letter = l; }
	public boolean getPlaced(){ return this.placed; }
	public void setPlaced(boolean value){ this.placed = value;}
	public Point getPoint(){ return point; }
	public void setPoint(Point p){ point = p; }
	public int getX(){ return point.getX(); }		// Raccourci pour ne pas passer par getPoint()
	public int getY(){ return point.getY(); } 		// Raccourci pour ne pas passer par getPoint()
	
        
	// Recupere une lettre aleatoirement en tenant compte de la frequence dans la langue du dictionnaire
	public void generateRandomLetter(Dictionary dico){   
            int nombreAleatoire = (int)(Math.random() * (dico.getFreqLetters().length() - 1));
            char tmp = dico.getFreqLetters().charAt(nombreAleatoire);
            this.letter = Character.toString(tmp);                
	}
        
}
