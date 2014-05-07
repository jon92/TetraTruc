package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class Brick2D extends JPanel implements MouseListener {
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
		
		//efface la brique dessinée au tour d'avant
		g.clearRect(zero + (y-1)*pxlWidth, zero + (x-1)*pxlHeight, pxlWidth, pxlHeight);
		
		g.setColor(color);
		
		if(color != null){
			g.fillRect(zero + (y-1)*pxlWidth, zero + (x-1)*pxlHeight, pxlWidth, pxlHeight);
		}

		g.setColor(Color.WHITE);
		if(letter != null){
            Font police = new Font("Helvetica",Font.BOLD, 15);
            g.setFont(police);
			g.drawString(letter.toUpperCase(), (int)(zero + (y-1)*pxlWidth + pxlWidth*0.2), (int)(zero + (x-1)*pxlHeight + pxlHeight*0.8) );
		}
	}

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
