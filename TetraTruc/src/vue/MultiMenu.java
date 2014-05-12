package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controleur.ContextManager;

public class MultiMenu extends Menu2D {
	
	private final int width, height;
	private final int buttonWidth = 200;
	private final int buttonHeight = 40;
	private Button2D playButton = new Button2D("Jouer");
	private JLabel pseudo1, pseudo2;
	private JTextField pseudoJTF1, pseudoJTF2;
	
	private BufferedImage backgroundImage;
	private String backgroundName;
	
	public MultiMenu(JPanel panel, int width, int height){
		super(panel);
		this.width = width;
		this.height = height;
		
		this.backgroundName = GraphicEngine.getSingleton().getTheme().getBackgroundMenu2();
		
		this.createBackgroundImage();
	}
	
	//Fonction qui renvoie un tableau contenant les choix de paramètres effectu�s par le joueur sur ce menu
	public HashMap<String, String> getMenuParams(){
		super.params = new HashMap<String, String>();
		super.params.put("mode", "multi");
		super.params.put("players", "2");
		super.params.put("pseudo1", this.pseudoJTF1.getText());
		super.params.put("pseudo2", this.pseudoJTF2.getText());
		super.params.put("difficulte", "");
		
		return super.params;
	}
	
	public void create(){
		//Positionnement du bouton de mode solo
		int multiButtonPosX = (int)(width * 0.5 -10) - (int)(this.buttonWidth * 0.5);
		int multiButtonPosY = (int)(height * 0.7) - (int)(this.buttonHeight * 0.5);
		playButton.setBounds(multiButtonPosX, multiButtonPosY, this.buttonWidth, this.buttonHeight);
		playButton.addActionListener(ContextManager.getSingleton().getMenuListener()); 
		
		//Champs pseudo1
		this.pseudo1 = new JLabel("Pseudo Joueur 1 ");
		this.pseudo1.setForeground(Color.WHITE);
		this.pseudo1.setFont (this.pseudo1.getFont ().deriveFont (20.0f));
		this.pseudo1.setBounds((int)(width*0.5) - 110, (int)(height*0.5) - 230, 200, 30);
		this.pseudo1.setHorizontalAlignment(SwingConstants.CENTER);
		this.pseudoJTF1 = new JTextField();
		this.pseudoJTF1.setFont(new Font("Helvetica",Font.BOLD, 15));
		this.pseudoJTF1.setForeground(Color.BLACK);
		this.pseudoJTF1.setBounds((int)(width*0.5-80), (int)(height*0.5-190), 140, 40);
		
		//Champs pseudo2
		this.pseudo2 = new JLabel("Pseudo Joueur 2 ");
		this.pseudo2.setForeground(Color.WHITE);
		this.pseudo2.setFont (this.pseudo2.getFont ().deriveFont (20.0f));
		this.pseudo2.setBounds((int)(width*0.5) - 110, (int)(height*0.5) - 100, 200, 30);
		this.pseudo2.setHorizontalAlignment(SwingConstants.CENTER);
		this.pseudoJTF2 = new JTextField();
		this.pseudoJTF2.setFont(new Font("Helvetica",Font.BOLD, 15));
		this.pseudoJTF2.setForeground(Color.BLACK);
		this.pseudoJTF2.setBounds((int)(width*0.5-80), (int)(height*0.5-60), 140, 40);
			
		
		//Ajouts au content pane
		super.panel.add(this.playButton);
		super.panel.add(this.pseudoJTF1);
		super.panel.add(this.pseudo1);
		super.panel.add(this.pseudoJTF2);
		super.panel.add(this.pseudo2);
		
		//appel des préférences utilisateur
		if(super.prefs != null){
			if(super.prefs.get("mode") != null){
				this.pseudoJTF1.setText(super.prefs.get("pseudo1"));
				if(super.prefs.get("mode").equals("multi")){
					this.setupPrefs();
				}
			}
		}
	}
	
	//Met en place les préférences utilisateur
	private void setupPrefs(){
		this.pseudoJTF2.setText(super.prefs.get("pseudo2"));
	}

	public void createBackgroundImage(){
		if (this.backgroundName != null){
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File(backgroundName));
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


}
