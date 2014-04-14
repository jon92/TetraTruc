package model;

public class Board {
	private final Player player;
	private final int level;
	
	public Board(Player player, String level){
		this.player = player;
		
		if(level.equals("Facile"))
			this.level = 1;
		else if(level.equals("Difficile"))
			this.level = 3;
		else
			this.level = 2;
	}
	
	public Player getPlayer(){
		return this.player;
	}
}
