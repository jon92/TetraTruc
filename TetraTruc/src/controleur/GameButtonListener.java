package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.GameButton2D;

public class GameButtonListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		GameButton2D source = (GameButton2D) e.getSource();
	
		switch(source.getName()){
	    
	    	case "PAUSE" :
	    	case "pause" :
	    	case "Pause" : 
	    		ContextManager.getSingleton().setPauseState(-1);
	    		break;
	    	
	    	case "ENREGISTRER" :
	    	case "Enregistrer" :
	    	case "enregistrer" :
	    	case "SAUVEGARDER" :
	    	case "Sauvegarder" :
	    	case "sauvegarder" :
	    		ContextManager.getSingleton().setSaveState();
	    		break;
	    		
	    	case "RETOUR MENU" :
	    	case "Retour Menu" :
	    	case "retour menu" :
	    		ContextManager.getSingleton().setMainMenuState();
	    		break;
	 
	    	case "QUITTER" :
	    	case "Quitter" :
	    	case "quitter" :
	    		ContextManager.getSingleton().setExitState();
	    		break;
	    	default:
    }
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
