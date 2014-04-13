package vue;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	
	public GamePanel(JPanel panel){
		this.panel = panel;
	}

	public void paintComponent(Graphics g){
		System.out.println("test");
	    g.fillOval(20, 20, 75, 75);  

	}               
}
