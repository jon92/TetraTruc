package vue;

import java.awt.Color;
import java.util.HashMap;

import model.Tetrominoe;

public class Theme2 extends Theme{

	public Theme2(){
		this.backgroundGame = null;
		this.backgroundMenu1 = null;
		this.backgroundMenu2 = null;
		
		this.music = "";
		
		
		this.shapeColor = new HashMap<Tetrominoe, Color>();
		shapeColor.put(Tetrominoe.I_Shape, Color.WHITE);
		shapeColor.put(Tetrominoe.J_Shape, Color.WHITE);
		shapeColor.put(Tetrominoe.L_Shape, Color.WHITE);
		shapeColor.put(Tetrominoe.O_Shape, Color.WHITE);
		shapeColor.put(Tetrominoe.S_Shape, Color.WHITE);
		shapeColor.put(Tetrominoe.T_Shape, Color.WHITE);
		shapeColor.put(Tetrominoe.Z_Shape, Color.WHITE);
		shapeColor.put(Tetrominoe.No_Shape, null);
		
	}
	
}
