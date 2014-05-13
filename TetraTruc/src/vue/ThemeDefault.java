package vue;

import java.awt.Color;
import java.util.HashMap;

import model.Tetrominoe;


// Theme par defaut
public class ThemeDefault extends Theme{
	
	public ThemeDefault(){
		this.backgroundGame = "media/img/BG_Game.jpg";
		this.backgroundMenu1 = "media/img/BG_Menu.jpg";
		this.backgroundMenu2 = "media/img/BG_MenuSolo.jpg";
		this.gameover = "media/img/GameOver.png";
		
		
		this.music = "";
		
		
		this.shapeColor = new HashMap<Tetrominoe, Color>();
		shapeColor.put(Tetrominoe.I_Shape, Color.BLUE);
		shapeColor.put(Tetrominoe.J_Shape, Color.CYAN);
		shapeColor.put(Tetrominoe.L_Shape, Color.GREEN);
		shapeColor.put(Tetrominoe.O_Shape, Color.ORANGE);
		shapeColor.put(Tetrominoe.S_Shape, Color.YELLOW);
		shapeColor.put(Tetrominoe.T_Shape, Color.RED);
		shapeColor.put(Tetrominoe.Z_Shape, Color.MAGENTA);
		shapeColor.put(Tetrominoe.No_Shape, null);
		
	}
	
}
