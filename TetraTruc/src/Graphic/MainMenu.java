package Graphic;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu {
	private JButton soloButton = new JButton("Mode Solo");
	private JButton multiButton = new JButton("Multijoueur");
	private JButton optionsButton = new JButton("Options");
	private JButton exitButton = new JButton("Quitter");
	int buttonWidth = 250;
	int buttonHeight = 40;
	
	public MainMenu(JPanel panel, int width, int height){

		int soloButtonPosX = (int)(width * 0.5) - (int)(this.buttonWidth * 0.5);
		int soloButtonPosY = (int)(height * 0.5) - (int)(this.buttonHeight * 0.5) - 100;
		soloButton.setBounds(soloButtonPosX, soloButtonPosY, this.buttonWidth, this.buttonHeight);
		
		int multiButtonPosX = soloButtonPosX;
		int multiButtonPosY = soloButtonPosY + buttonHeight + 10;
		multiButton.setBounds(multiButtonPosX, multiButtonPosY, this.buttonWidth, this.buttonHeight);
		
		int optionsButtonPosX = multiButtonPosX;
		int optionsButtonPosY = multiButtonPosY + buttonHeight + 10;
		optionsButton.setBounds(optionsButtonPosX, optionsButtonPosY, this.buttonWidth, this.buttonHeight);
		
		int exitButtonPosX = optionsButtonPosX;
		int exitButtonPosY = optionsButtonPosY + buttonHeight + 10;
		exitButton.setBounds(exitButtonPosX, exitButtonPosY, this.buttonWidth, this.buttonHeight);
		
		
		
		
		panel.add(multiButton);
		panel.add(soloButton);
		panel.add(optionsButton);
		panel.add(exitButton);
	}
}
