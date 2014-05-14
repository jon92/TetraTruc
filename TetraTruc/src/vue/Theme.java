package vue;

import java.awt.Color;
import java.net.URL;
import java.util.HashMap;

import model.Tetrominoe;


// classe 'globale', les thèmes héritent de lui
public abstract class Theme {
	protected URL backgroundGame; // nom de l'image de fond
	protected URL backgroundMenu1; // nom de l'image de fond
	protected URL backgroundMenu2; // nom de l'image de fond
	protected URL gameover;
	protected HashMap<Tetrominoe, Color> shapeColor; // map qui lie le Tetrominoe à sa couleur
	
	protected String music = "";
	
	public URL getBackgroundGame(){
		return backgroundGame;
	}
	public URL getBackgroundMenu1(){
		return backgroundMenu1;
	}
	public URL getBackgroundMenu2(){
		return backgroundMenu2;
	}
	public URL getGameover(){
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
