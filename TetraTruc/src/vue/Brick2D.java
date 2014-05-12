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
	private boolean clicked;
	
	// Constructeur par défaut
	public Brick2D(int length){
		pxlHeight = length;
		pxlWidth = length;
		letter = "";
		color = null;
		clicked = false;
	}
	
	public Brick2D(int length, Color c, String l){
		this(length);
		color = c;
		letter = l;
	}
	
	// Getters / Setters
	public Color getColor(){ return color; }
	public void setColor(Color c){ color = c; }
	public String getLetter(){ return letter; }
	public void setLetter(String l){ letter = l; }
	public void setClicked(boolean b){ this.clicked = b; }

	public void draw(Graphics g, int x, int y, int zeroX, int zeroY, float sizeCoeff){
		
		//efface la brique dessinée au tour d'avant
		g.clearRect((int)(zeroX + (y-1)*pxlWidth*sizeCoeff), (int)(zeroY + (x-1)*pxlHeight*sizeCoeff), (int)(pxlWidth*sizeCoeff), (int)(pxlHeight*sizeCoeff));
				
		g.setColor(color);
			
		if(color != null){
			g.fillRect((int)(zeroX + (y-1)*pxlWidth*sizeCoeff),(int)( zeroY + (x-1)*pxlHeight*sizeCoeff), (int)(pxlWidth*sizeCoeff), (int)(pxlHeight*sizeCoeff));
		}else{
			g.setColor(new Color(25, 25, 25));
			g.fillRect((int)(zeroX + (y-1)*pxlWidth*sizeCoeff), (int)(zeroY + (x-1)*pxlHeight*sizeCoeff), (int)(pxlWidth*sizeCoeff), (int)(pxlHeight*sizeCoeff));
		}

		g.setColor(Color.WHITE);
		if(this.clicked && this.color!=null)
			g.setColor(this.color.darker());
		//else if(!this.clicked && this.color!=null)
		//	g.setColor(this.color.brighter());
		
		if(letter != null){
            Font police = new Font("Helvetica",Font.BOLD, (int)(15*sizeCoeff));
            g.setFont(police);
			g.drawString(letter.toUpperCase(), (int)(zeroX + (y-1)*pxlWidth*sizeCoeff + pxlWidth*0.2*sizeCoeff), (int)(zeroY + (x-1)*pxlHeight*sizeCoeff + pxlHeight*sizeCoeff*0.8) );
		}
	}
}
