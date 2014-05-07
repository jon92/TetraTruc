package model;

public class Player {
	
	private final String pseudo;
	private int score;
	
	public Player(String pseudo){
		this.pseudo = pseudo;
		this.score = 0;
	}
	
	public String getPseudo(){
		return this.pseudo;
	}
        
    public int getScore(){
        return score;
    }
    
    public void setScore(int value){
        score = value;
    }
    
    // Ajoute au score le nombre entier passé en paramètre
    public void incrementScore(int value){
    	score += value;
	}
}
