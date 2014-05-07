package vue;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private Grid2D grid;
	private int width, height;
	
	public GamePanel(JPanel panel, int width, int height){
		this.panel = panel;
		this.grid = new Grid2D();
		this.width = width;	
		this.height = height;
		this.addMouseListener(this);
	}
	
	public Grid2D getGrid2D(){
		return this.grid;
	}

	public void paintComponent(Graphics g){
	    grid.draw(g, this.width, this.height);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX());
		
		for (int i = 0; i < 20; i++){
			System.out.println(grid.getCoords()[i].getX());
		}
		
		// trouver les coordonnées des briques  (tester la couleur)
		// tester coord
		// bla
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}               
}
