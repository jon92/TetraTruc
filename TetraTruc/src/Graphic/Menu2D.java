package Graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ContextManager.ContextManager;

public class Menu2D {
	private Button2D soloButton = new Button2D("Mode Solo");
	private Button2D multiButton = new Button2D("Multijoueur");
	private Button2D optionsButton = new Button2D("Options");
	private Button2D exitButton = new Button2D("Quitter");
	private final int buttonWidth = 250;
	private final int buttonHeight = 40;
	private JPanel panel;
	
	public Menu2D(JPanel panel){
		this.panel = panel;
	}
	
	//Creation du menu Principal
	public void createMainMenu(int width, int height){

		//Positionnement du bouton de mode solo
		int soloButtonPosX = (int)(width * 0.5) - (int)(this.buttonWidth * 0.5);
		int soloButtonPosY = (int)(height * 0.5) - (int)(this.buttonHeight * 0.5) - 100;
		soloButton.setBounds(soloButtonPosX, soloButtonPosY, this.buttonWidth, this.buttonHeight);
		soloButton.addActionListener(ContextManager.getSingleton().getMenuListener()); 
		
		//Positionnement du bouton de mode multijoueur
		int multiButtonPosX = soloButtonPosX;
		int multiButtonPosY = soloButtonPosY + buttonHeight + 10;
		multiButton.setBounds(multiButtonPosX, multiButtonPosY, this.buttonWidth, this.buttonHeight);
		multiButton.addActionListener(ContextManager.getSingleton().getMenuListener()); 
		
		//Positionnement du bouton Options
		int optionsButtonPosX = multiButtonPosX;
		int optionsButtonPosY = multiButtonPosY + buttonHeight + 10;
		optionsButton.setBounds(optionsButtonPosX, optionsButtonPosY, this.buttonWidth, this.buttonHeight);
		optionsButton.addActionListener(ContextManager.getSingleton().getMenuListener()); 
		
		//Positionnement du bouton Quitter
		int exitButtonPosX = optionsButtonPosX;
		int exitButtonPosY = optionsButtonPosY + buttonHeight + 10;
		exitButton.setBounds(exitButtonPosX, exitButtonPosY, this.buttonWidth, this.buttonHeight);	
		exitButton.addActionListener(ContextManager.getSingleton().getMenuListener()); 
		
		//Ajout des boutons au content pane de la fenêtre
		panel.add(multiButton);
		panel.add(soloButton);
		panel.add(optionsButton);
		panel.add(exitButton);
	}
	
	
}
