package vue;

import java.awt.Color;
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

	public void draw(Graphics g, Color color, int x, int y, int zero, String letter){
		
		//efface la brique dessin�e au tour d'avant
		g.clearRect(zero + (y-1)*pxlWidth, zero + (x-1)*pxlHeight, pxlWidth, pxlHeight);
		
		g.setColor(color);
		
		if(color != null){
			g.fillRect(zero + (y-1)*pxlWidth, zero + (x-1)*pxlHeight, pxlWidth, pxlHeight);
		}

		g.setColor(Color.BLACK);
		if(letter != null){
			g.drawString(letter, (int)(zero + (y-1)*pxlWidth + pxlWidth*0.5), (int)(zero + (x-1)*pxlHeight + pxlHeight*0.5) );
		}
	}
}
