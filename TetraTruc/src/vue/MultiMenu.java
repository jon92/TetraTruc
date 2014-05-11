package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JPanel;

import controleur.ContextManager;

public class MultiMenu extends Menu2D {
	
	private final int width, height;
	private final int buttonWidth = 200;
	private final int buttonHeight = 40;
	private Button2D playButton = new Button2D("Jouer");
	
	public MultiMenu(JPanel panel, int width, int height){
		super(panel);
		this.width = width;
		this.height = height;
	}
	
	//Fonction qui renvoie un tableau contenant les choix de paramètres effectués par le joueur sur ce menu
	public HashMap<String, String> getMenuParams(){
		super.params = new HashMap<String, String>();
		super.params.put("mode", "multi");
		super.params.put("players", "1");
		super.params.put("pseudo", "");
		super.params.put("difficulte", "");
		
		return super.params;
	}
	
	public void create(){
		//Positionnement du bouton de mode solo
		int multiButtonPosX = (int)(width * 0.5) - (int)(this.buttonWidth * 0.5);
		int multiButtonPosY = (int)(height * 0.7) - (int)(this.buttonHeight * 0.5);
		playButton.setBounds(multiButtonPosX, multiButtonPosY, this.buttonWidth, this.buttonHeight);
		playButton.addActionListener(ContextManager.getSingleton().getMenuListener()); 
		
		
		//Ajouts au content pane
		super.panel.add(this.playButton);
	}
}
