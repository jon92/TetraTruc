package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	
	public void draw(){
		// cette ligne à définir, j'ai pas tout compris
		Graphics2D g = (Graphics2D) super.getGraphics();
		
		g.setColor(color);
        g.fillRect(1, 1, pxlWidth-2, pxlHeight-2);

        g.setColor(color.brighter());
        g.drawLine(0, pxlHeight-1, 0, 0);
        g.drawLine(0, 0, pxlWidth-1, 0);

        g.setColor(color.darker());
        g.drawLine(1, pxlHeight-1, pxlWidth-1, pxlHeight-1);
        g.drawLine(pxlWidth-1, pxlHeight-1, pxlWidth-1, 1);
	}
	
	public static void main(String[] args) {
		Color c = new Color(200, 100, 100);
		Brick2D b = new Brick2D(20, 20, c, "a");
		b.draw();
	}
}
