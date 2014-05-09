package vue; 

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;

public class Button2D extends JButton{
	
	private static final long serialVersionUID = 1L;
	private final String name;
	
	public Button2D(String name){
		super(name);
		this.name = name;
	}
	
	public void paintComponent (Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		
		//Création d'un dégradé
	    GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
	    g2d.setPaint(gp);
	    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	    g2d.setColor(Color.white);
	    
	    int stringLen = (int) g2d.getFontMetrics().getStringBounds(this.name, g2d).getWidth();  
        
	    g2d.drawString(this.name, (int) (this.getWidth()*0.5 - stringLen*0.5), (this.getHeight() / 2) + 5);
	}
	
	public String getName(){
		return this.name;
	}
}
