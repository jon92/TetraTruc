package vue;

import java.awt.Color;
import java.awt.Graphics;

public class Grid2D{

	//marges autour de la grille
	private final int margins = 30;
	
	//Taille d'une case
	private final int squareSize = 25;
	
	//Nombre de cases en largeur
	private final int squareNumberW = 10;
	private final int squareNumberH = 20;
	
	public void drawGrid(Graphics g, int width, int height){
		g.setColor(Color.RED);
		
		//Dessin des lignes verticales
		int originX = margins;
		int originY = margins;
		int destX = margins;
		int destY = this.squareNumberH * this.squareSize + margins-1;
		
		for(int i=0; i <= this.squareNumberW; ++i){
		    g.drawLine(originX, originY, destX, destY);
		    originX += this.squareSize;
		    destX += this.squareSize;
		}
		
		//Dessin des lignes horizontales
		originX = margins;
		originY = margins;
		destX = this.squareNumberW * this.squareSize + margins-1;
		destY = margins;
		
		for(int i=0; i <= this.squareNumberH; ++i){
		    g.drawLine(originX, originY, destX, destY);
		    originY += this.squareSize;
		    destY += this.squareSize;
		}
	}               
}
