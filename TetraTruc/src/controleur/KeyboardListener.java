package controleur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {

    public void keyPressed(KeyEvent e) {
        ContextManager.getSingleton().doKeyAction(e.getKeyCode());
        System.out.println("yahouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    } 
    
}
