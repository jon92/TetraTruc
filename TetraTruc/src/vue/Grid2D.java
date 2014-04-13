package vue;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Grid2D extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		System.out.println("test");
	    g.fillOval(20, 20, 75, 75);
	}               
}
