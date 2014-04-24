package controleur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Grid;

public class Controls extends KeyAdapter {
	private Grid grid;
	
	public Controls(Grid g){
		grid = g;
	}
	
	
    public void keyPressed(KeyEvent e) {

        int keycode = e.getKeyCode();

        switch (keycode) {
	        case KeyEvent.VK_LEFT:
	            grid.moveLeft();
	            break;
	        case KeyEvent.VK_RIGHT:
	            grid.moveRight();
	            break;
	        case KeyEvent.VK_DOWN:
	            grid.moveDown();
	            break;
	        case KeyEvent.VK_UP:
	            grid.rotate();
	            break;
	        case KeyEvent.VK_SPACE:
	            grid.dropBottom();
	            break;
	    }
    }
}
