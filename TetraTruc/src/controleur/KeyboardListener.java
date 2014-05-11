package controleur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
	
    public void keyPressed(KeyEvent e) {
    	//Joueur 1
    	if(e.getKeyCode() >= 32 && e.getKeyCode() <= 40){
    		ContextManager.getSingleton().doKeyAction(e.getKeyCode(), 0);
    	}else{ //Joueur 2
    		ContextManager.getSingleton().doKeyAction(e.getKeyCode(), 1);
    	}
    } 
    
}
