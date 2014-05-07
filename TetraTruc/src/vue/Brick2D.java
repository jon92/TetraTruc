package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Brick2D extends JPanel {
	private static final long serialVersionUID = 1L;
	private Color color;
	private String letter;
	private int pxlWidth, pxlHeight;		// Taille en pixels de la brique
	
	// Constructeur par défaut
	public Brick2D(int h, int w){
		pxlHeight = h;
		pxlWidth = w;
		letter = "";
		color = null;
	}
	
	public Brick2D(int h, int w, Color c, String l){
		pxlHeight = h;
		pxlWidth = w;
		color = c;
		letter = l;
	}
	
	// Getters / Setters
	public Color getColor(){ return color; }
	public void setColor(Color c){ color = c; }
	public String getLetter(){ return letter; }
	public void setLetter(String l){ letter = l; }

	public void draw(Graphics g, Color color, int x, int y, int zeroX, int zeroY, String letter){
		
		//efface la brique dessinée au tour d'avant
		g.clearRect(zeroX + (y-1)*pxlWidth, zeroY + (x-1)*pxlHeight, pxlWidth, pxlHeight);
		
		g.setColor(color);
		
		if(color != null){
			g.fillRect(zeroX + (y-1)*pxlWidth, zeroY + (x-1)*pxlHeight, pxlWidth, pxlHeight);
		}else{
			g.setColor(new Color(25, 25, 25));
			g.fillRect(zeroX + (y-1)*pxlWidth, zeroY + (x-1)*pxlHeight, pxlWidth, pxlHeight);
		}

		g.setColor(Color.WHITE);
		if(letter != null){
            Font police = new Font("Helvetica",Font.BOLD, 15);
            g.setFont(police);
			g.drawString(letter.toUpperCase(), (int)(zeroX + (y-1)*pxlWidth + pxlWidth*0.2), (int)(zeroY + (x-1)*pxlHeight + pxlHeight*0.8) );
		}
	}
}
