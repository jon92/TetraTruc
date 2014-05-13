package vue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controleur.ContextManager;

public class MainMenu extends Menu2D {
	private final int width, height;
	private final int buttonWidth = 250;
	private final int buttonHeight = 40;
	private Button2D soloButton = new Button2D("Mode Solo");
	private Button2D multiButton = new Button2D("Multijoueur");
	private Button2D optionsButton = new Button2D("Options");
	private Button2D exitButton = new Button2D("Quitter");
	private BufferedImage backgroundImage;
	private String backgroundName;
	
	public MainMenu(JPanel panel, int width, int height){
		super(panel);
				
		this.width = width;
		this.height = height;
		
		this.backgroundName = GraphicEngine.getSingleton().getTheme().getBackgroundMenu1();
				
		this.createBackgroundImage();

	}
	
	public void createBackgroundImage(){
		if (this.backgroundName != null){
			BufferedImage img = null;
			try {
				img = ImageIO.read(new FileInputStream(new File(backgroundName)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			this.setBackground(img);
		}
		else{
			System.out.println("Pas d'image de fond");
		}
	}
	
	public BufferedImage getBackgroundImage(){
		return this.backgroundImage ;
	}
	
	public String getBackgroundName(){
		return this.backgroundName;
	}
	
	public void setBackground(BufferedImage bg){ this.backgroundImage = bg; }
	
	public void create(){
		//Positionnement du bouton de mode solo
		int soloButtonPosX = (int)(width * 0.5) - (int)(this.buttonWidth * 0.5);
		int soloButtonPosY = (int)(height * 0.5) - (int)(this.buttonHeight * 0.5);
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
		
		//Ajout des boutons au content pane de la fen�tre
		super.panel.add(multiButton);
		super.panel.add(soloButton);
		super.panel.add(optionsButton);
		super.panel.add(exitButton);

	}

}
