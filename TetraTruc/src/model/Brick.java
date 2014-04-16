package model;

public class Brick {
	private String letter;
	
	// Constructeur
	public Brick(){
		letter = "";
	}
	
	// Getters/Setters
	public String getLetter(){ return letter; }
	public void setLetter(String l){ letter = l; }
	
	
	public void generateRandomLetter(){
		// Récupère une lettre aléatoirement en tenant compte de la fréquence dans la langue du dictionnaire
	}
}
