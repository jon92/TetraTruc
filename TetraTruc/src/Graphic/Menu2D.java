package Graphic;

import javax.swing.JPanel;

public class Menu2D {


	private JPanel panel;
	
	public Menu2D(JPanel panel){
		this.panel = panel;
	}
	
	//Creation du menu Principal
	public void createMainMenu(int width, int height){
			MainMenu mainMenu = new MainMenu(this.panel, width, height);
			mainMenu.create();
	}
	
	//Creation du menu Solo
	public void createSoloMenu(int width, int height){
		this.panel.removeAll();
		this.panel.repaint();
		System.out.println("Menu Solo créé");
	}
}
