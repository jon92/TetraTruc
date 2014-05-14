package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controleur.ContextManager;

public class SoloMenu extends Menu2D {
	
	private final int width, height;
	private final int buttonWidth = 200;
	private final int buttonHeight = 40;
	private Button2D playButton = new Button2D("Jouer");
	private JLabel pseudo;
	private JTextField pseudoJTF;
	private ButtonGroup bg;
	private JRadioButton  easy;
	private JRadioButton  normal;
	private JRadioButton  hard;
	
	private BufferedImage backgroundImage;
	private String backgroundName;
	
	
	public SoloMenu(JPanel panel, int width, int height){
		super(panel);
		this.width = width;
		this.height = height;
		
		this.backgroundName = GraphicEngine.getSingleton().getTheme().getBackgroundMenu2();
		
		this.createBackgroundImage();
	}
	
	public void create(){
		//Positionnement du bouton de mode solo
		int soloButtonPosX = (int)(width * 0.5 -10) - (int)(this.buttonWidth * 0.5);
		int soloButtonPosY = (int)(height * 0.7) - (int)(this.buttonHeight * 0.5);
		playButton.setBounds(soloButtonPosX, soloButtonPosY, this.buttonWidth, this.buttonHeight);
		playButton.addActionListener(ContextManager.getSingleton().getMenuListener()); 
		
		//Champs pseudo
		this.pseudo = new JLabel("Pseudo");
		this.pseudo.setForeground(Color.WHITE);
		this.pseudo.setFont (this.pseudo.getFont ().deriveFont (24.0f));
		this.pseudo.setBounds((int)(width*0.5) - 110, (int)(height*0.5) - 230, 200, 30);
		this.pseudo.setHorizontalAlignment(SwingConstants.CENTER);
		this.pseudoJTF = new JTextField();
		this.pseudoJTF.setFont(new Font("Helvetica",Font.BOLD, 15));
		this.pseudoJTF.setForeground(Color.BLACK);
		this.pseudoJTF.setBounds((int)(width*0.5-80), (int)(height*0.5-180), 140, 40);
		//pseudoJTF.addKeyListener(ContextManager.getSingleton().getKeyListener());
	    
		//Choix de la difficulté
		JLabel level = new JLabel("Difficulté");
		level.setForeground(Color.WHITE);
		level.setFont (level.getFont ().deriveFont (24.0f));
		level.setBounds((int)(width*0.5) - 110, (int)(height*0.5) - 80, 200, 30);
		level.setHorizontalAlignment(SwingConstants.CENTER);
		this.bg = new ButtonGroup();
		this.easy = new JRadioButton ("Facile");
		this.normal = new JRadioButton ("Normal");
		this.hard = new JRadioButton ("Difficile");
		this.easy.setBounds((int)(width*0.5) - 110, (int)(height*0.5) - 30, 200, 30);
		this.normal.setBounds((int)(width*0.5) - 110, (int)(height*0.5), 200, 30);
		this.hard.setBounds((int)(width*0.5) - 110, (int)(height*0.5) + 30, 200, 30);
		this.bg.add(easy);
		this.bg.add(normal);
		this.bg.add(hard);
		
		
		//Ajouts au content pane
		super.panel.add(this.playButton);
		super.panel.add(this.pseudoJTF);
		super.panel.add(level);
		super.panel.add(this.pseudo);
		super.panel.add(this.easy);
		super.panel.add(this.normal);
		super.panel.add(this.hard);
		
		//appel des préférences utilisateur
		if(super.prefs != null){
			this.pseudoJTF.setText(super.prefs.get("pseudo1"));
			if(super.prefs.get("mode").equals("solo")){
				this.setupPrefs();
			}
		}
	}
	
	//Fonction qui renvoie un tableau contenant les choix de paramètres effectués par le joueur sur ce menu
	public HashMap<String, String> getMenuParams(){
		super.params = new HashMap<String, String>();
		super.params.put("mode", "solo");
		super.params.put("players", "1");
		super.params.put("pseudo1", this.pseudoJTF.getText());
		
		if(this.getSelectedButton(this.bg) != null)
			super.params.put("difficulte", this.getSelectedButton(this.bg).getText());
		else
			super.params.put("difficulte", "");
		
		return super.params;
	}
	
	public  JRadioButton getSelectedButton(ButtonGroup group) {
		Enumeration<AbstractButton> e = group.getElements();
		while (e.hasMoreElements()) {
			AbstractButton b =  e.nextElement();
			if (b.isSelected()) return (JRadioButton) b;
		}
		return null;
	}
	
	//Met en place les préférences utilisateur
	private void setupPrefs(){
		
		if(super.prefs.get("difficulte").equals("Facile")){
			this.easy.setSelected(true);
		}else if(super.prefs.get("difficulte").equals("Difficile")){
			this.hard.setSelected(true);
		}else{
			this.normal.setSelected(true);
		}
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
			System.err.println("Erreur : Pas d'image de fond");
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
