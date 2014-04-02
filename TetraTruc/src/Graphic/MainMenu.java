package Graphic;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu {
	private MainButton soloButton = new MainButton("Mode Solo");
	private MainButton multiButton = new MainButton("Multijoueur");
	private MainButton optionsButton = new MainButton("Options");
	private MainButton exitButton = new MainButton("Quitter");
	private final int buttonWidth = 250;
	private final int buttonHeight = 40;
	
	public MainMenu(JPanel panel, int width, int height){

		//Positionnement du bouton de mode solo
		int soloButtonPosX = (int)(width * 0.5) - (int)(this.buttonWidth * 0.5);
		int soloButtonPosY = (int)(height * 0.5) - (int)(this.buttonHeight * 0.5) - 100;
		soloButton.setBounds(soloButtonPosX, soloButtonPosY, this.buttonWidth, this.buttonHeight);
		
		//Positionnement du bouton de mode multijoueur
		int multiButtonPosX = soloButtonPosX;
		int multiButtonPosY = soloButtonPosY + buttonHeight + 10;
		multiButton.setBounds(multiButtonPosX, multiButtonPosY, this.buttonWidth, this.buttonHeight);
		
		//Positionnement du bouton Options
		int optionsButtonPosX = multiButtonPosX;
		int optionsButtonPosY = multiButtonPosY + buttonHeight + 10;
		optionsButton.setBounds(optionsButtonPosX, optionsButtonPosY, this.buttonWidth, this.buttonHeight);
		
		//Positionnement du bouton Quitter
		int exitButtonPosX = optionsButtonPosX;
		int exitButtonPosY = optionsButtonPosY + buttonHeight + 10;
		exitButton.setBounds(exitButtonPosX, exitButtonPosY, this.buttonWidth, this.buttonHeight);	
		
		//Ajout des boutons au content pane de la fenêtre
		panel.add(multiButton);
		panel.add(soloButton);
		panel.add(optionsButton);
		panel.add(exitButton);
	}
}
