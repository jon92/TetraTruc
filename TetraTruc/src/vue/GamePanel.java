package vue;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private Grid2D grid;
	private int width, height;
	
	public GamePanel(JPanel panel, int width, int height){
		this.panel = panel;
		this.grid = new Grid2D();
		this.width = width;	
		this.height = height;
	}
	
	public Grid2D getGrid2D(){
		return this.grid;
	}

	public void paintComponent(Graphics g){
	    grid.draw(g, this.width, this.height);
	}               
}
