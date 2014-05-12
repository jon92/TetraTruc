package vue;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class WindowPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage background;

	public void paintComponent (Graphics g){
		super.paintComponents(g);
		System.out.println("WindowPanel background : " + background);
		g.drawImage(background, 0, 0, null);
			
	}
	
	public BufferedImage getBackgroundImage(){
		return this.background;
	}
	
	public void setBackgroundImage(BufferedImage bg2){
		this.background = bg2;
		this.repaint();
	}
}
