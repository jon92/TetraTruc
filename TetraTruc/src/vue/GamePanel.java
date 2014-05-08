package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.BoardObserver;

public class GamePanel extends JPanel implements BoardObserver{
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private Grid2D grid;
	private int width, height;
	private BufferedImage background;
	private int score;
	private Theme theme;
	
	public GamePanel(JPanel panel, int width, int height){
		this.panel = panel;
		this.setBackground(Color.RED);
		this.width = width;	
		this.height = height;
		this.background = null;
		this.score = 0;
		this.theme = new ThemeDefault();
		this.grid = new Grid2D(20, 10, 400, 200, theme);
		
		this.drawBackground();
	}
	
	public JPanel getPanel(){
		return this.panel;
	}
	
	public void setPanel(JPanel panel){
		this.panel = panel;
	}
	
	public Grid2D getGrid2D(){
		return this.grid;
	}
	
	public void setBackground(BufferedImage bg){
		this.background = bg;
	}
	
	private void drawBackground(){
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(theme.getBackground()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setBackground(img);
	}

	public void paintComponent(Graphics g){
		g.drawImage(this.background, 0, 0, null);
	    grid.draw(g, this.width, this.height);
	    
	    
	    //Dessin du score
		g.setColor(Color.WHITE);
	    Font police = new Font("Helvetica",Font.BOLD, 15);
        g.setFont(police);
		g.drawString(Integer.toString(this.score), 74, 38);
	
	}

	@Override
	public void update(int score) {
		this.score = score;
		GraphicEngine.getSingleton().getGamePanel().repaint();
	}    
	
}
