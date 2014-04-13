package vue;

import javax.swing.JPanel;

import controleur.ContextManager;

public class SoloMenu {
	private JPanel panel;
	private final int width, height;
	private final int buttonWidth = 250;
	private final int buttonHeight = 40;
	private Button2D playButton = new Button2D("Jouer");
	
	public SoloMenu(JPanel panel, int width, int height){
		this.panel = panel;
		this.width = width;
		this.height = height;
	}
	
	public void create(){
		//Positionnement du bouton de mode solo
				int soloButtonPosX = (int)(width * 0.7) - (int)(this.buttonWidth * 0.5);
				int soloButtonPosY = (int)(height * 0.8) - (int)(this.buttonHeight * 0.5);
				playButton.setBounds(soloButtonPosX, soloButtonPosY, this.buttonWidth, this.buttonHeight);
				playButton.addActionListener(ContextManager.getSingleton().getMenuListener()); 

				panel.add(playButton);
	}
}
