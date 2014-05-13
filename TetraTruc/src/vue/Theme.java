package vue;

import java.awt.Color;
import java.util.HashMap;

import model.Tetrominoe;


// classe 'globale', les thèmes héritent de lui
public abstract class Theme {
	protected String backgroundGame; // nom de l'image de fond
	protected String backgroundMenu1; // nom de l'image de fond
	protected String backgroundMenu2; // nom de l'image de fond
	protected String gameover;
	protected HashMap<Tetrominoe, Color> shapeColor; // map qui lie le Tetrominoe à sa couleur
	
	protected String music = "";
	
	public String getBackgroundGame(){
		return backgroundGame;
	}
	public String getBackgroundMenu1(){
		return backgroundMenu1;
	}
	public String getBackgroundMenu2(){
		return backgroundMenu2;
	}
	public String getGameover(){
		return gameover;
	}
	
	
	public String getMusic(){
		return music;
	}
	
	public HashMap<Tetrominoe, Color> getShapeColor(){
		return shapeColor;
	}
	
	public Color getColorByShape(Tetrominoe shape){
		return shapeColor.get(shape);
	}
	
}
