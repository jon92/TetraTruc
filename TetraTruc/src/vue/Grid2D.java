package vue;

import java.awt.Color;
import java.awt.Graphics;

import model.Tetrominoe;


// TO DO : récupérer les infos de Grid pour squareNumberW et squareNumberH
// TO DO : récupérer le thème choisi depuis le menu


public class Grid2D{

	//marges autour de la grille
	private final int margins = 30;
	
	//Taille d'une case
	private final int squareSize = 25;
	
	//Nombre de cases en largeur
// /!\ A modifier : il faut que ça corresponde au nb de cases dans Grid	
	private int squareNumberW = 10;
	private int squareNumberH = 20;
	
	
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
	
/*	
	public void paintShapes(Graphics g){
		super.paint(g);
		
		int boardTop = (int) size.getHeight() - squareNumberH * squareSize;


        for (int line = 0; line < squareNumberW; line++){
			for (int column = 0; column < squareNumberH; column++){
                Tetrominoe shape = shapeAt(column, squareNumberH - line - 1);
                if (shape != Tetrominoe.No_Shape)
                    drawBrick(g, 0 + column * squareSize,
                               boardTop + line * squareSize, shape);
            }
        }

        if (curPiece.getShape() != Tetrominoe.No_Shape) {
            for (int i = 0; i < 4; ++i) {
                int x = curX + curPiece.x(i);
                int y = curY - curPiece.y(i);
                drawBrick(g, 0 + x * squareSize,
                           boardTop + (squareNumberH - y - 1) * squareSize,
                           curPiece.getShape());
            }
        }
		
					
	}
	
	// Color récupérée dans Theme
	private void drawBrick(Graphics g, int x, int y, Tetrominoe shape){
        
//		Color color = theme.getColorByShape(shape) // theme à récupérer depuis quelquepart
		
		
        // couleur
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareSize - 2, squareSize - 2);

        // bordures
        g.setColor(color.brighter());
        g.drawLine(x, y + squareSize - 1, x, y);
        g.drawLine(x, y, x + squareSize - 1, y);

//      //lettre 
// TO DO : fonction pour avoir directement la lettre depuis 
        //g.drawString(shape.getTetrominoe().getBrick(TROUVER_INDEX).getLetter(), 0, 0);
         
        // bordures
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareSize - 1,
                         x + squareSize - 1, y + squareSize - 1);
        g.drawLine(x + squareSize - 1, y + squareSize - 1,
                         x + squareSize - 1, y + 1);

    }
*/	
}
