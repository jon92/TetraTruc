package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.Button2D;

public class MenuListener implements ActionListener {
	
	public MenuListener(){
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Button2D source = (Button2D) arg0.getSource();
		
	    switch(source.getName()){
	    
	    	case "Mode Solo" :
	    		ContextManager.getSingleton().setSoloState();
	    		break;
	    	
	    	case "Multijoueur" :
	    		ContextManager.getSingleton().setMultiState();
	    		break;
	    	
	    	case "Options" :
	    		ContextManager.getSingleton().setOptionsState();
	    		break;
	    		
	    	case "Jouer":
	    		ContextManager.getSingleton().setGameState();
	    		break;
	    		
	    	case "Quitter" :
	    		ContextManager.getSingleton().setExitState();
	    		break;
	    	default:
	    }
	}  
}
