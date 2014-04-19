package model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


// classe 'globale', les thèmes héritent de lui
public abstract class Theme {
	protected String background = ""; // nom de l'image de fond
	protected HashMap<Tetrominoe, Color> shapeColor; // map qui lie le Tetrominoe à sa couleur
	
	protected String music = "";
	
	public String getBackground(){
		return background;
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
