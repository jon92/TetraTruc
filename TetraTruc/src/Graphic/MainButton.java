package Graphic; 

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class MainButton extends JButton {
	private final String name;
	
	public MainButton(String name){
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
	    g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
	}
}
