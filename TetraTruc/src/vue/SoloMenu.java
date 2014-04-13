package vue;

import java.awt.Color;

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
	
	public SoloMenu(JPanel panel, int width, int height){
		super(panel);
		this.width = width;
		this.height = height;
	}
	
	public void create(){
		//Positionnement du bouton de mode solo
		int soloButtonPosX = (int)(width * 0.5) - (int)(this.buttonWidth * 0.5);
		int soloButtonPosY = (int)(height * 0.7) - (int)(this.buttonHeight * 0.5);
		playButton.setBounds(soloButtonPosX, soloButtonPosY, this.buttonWidth, this.buttonHeight);
		playButton.addActionListener(ContextManager.getSingleton().getMenuListener()); 
		
		//Champs pseudo
		JLabel pseudo = new JLabel("Pseudo");
		pseudo.setFont (pseudo.getFont ().deriveFont (24.0f));
		pseudo.setBounds((int)(width*0.5) - 100, (int)(height*0.5) - 230, 200, 30);
		pseudo.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField pseudoJTF = new JTextField();
		pseudoJTF.setForeground(Color.BLUE);
		pseudoJTF.setBounds((int)(width*0.5-70), (int)(height*0.5-180), 140, 40);
	    
		//Choix de la difficulté
		JLabel level = new JLabel("Difficulté");
		level.setFont (level.getFont ().deriveFont (24.0f));
		level.setBounds((int)(width*0.5) - 100, (int)(height*0.5) - 80, 200, 30);
		level.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonGroup bg = new ButtonGroup();
		JRadioButton  easy = new JRadioButton ("Facile");
		JRadioButton  normal = new JRadioButton ("Normal");
		JRadioButton  hard = new JRadioButton ("Difficile");
		easy.setBounds((int)(width*0.5) - 100, (int)(height*0.5) - 30, 200, 30);
		normal.setBounds((int)(width*0.5) - 100, (int)(height*0.5), 200, 30);
		hard.setBounds((int)(width*0.5) - 100, (int)(height*0.5) + 30, 200, 30);
		bg.add(easy);
		bg.add(normal);
		bg.add(hard);
		
		
		//Ajouts au content pane
		super.panel.add(playButton);
		super.panel.add(pseudoJTF);
		super.panel.add(level);
		super.panel.add(pseudo);
		super.panel.add(easy);
		super.panel.add(normal);
		super.panel.add(hard);
	}
}
