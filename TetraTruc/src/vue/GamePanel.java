package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controleur.ContextManager;

import model.BoardObserver;
import model.GameEngine;

public class GamePanel extends JPanel implements BoardObserver, MouseListener {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private JPanel panel;
	private Grid2D grid;
	private int width, height;
	private BufferedImage background;
	private int score;
	private int level;
	private String pseudo;
	private Theme theme;
	private GameButton2D pauseButton;
	private GameButton2D saveButton;
	private GameButton2D exitButton;
	private String selectedLetters;
	private boolean anagram;
	
	public GamePanel(JPanel panel, int width, int height, int i){
		this.id = i;
		this.panel = panel;
		this.setBackground(Color.RED);
		this.width = width;	
		this.height = height;
		this.background = null;
		this.score = 0;
		this.level = 1;
		this.pseudo = "";
		this.theme = new ThemeDefault();
		this.grid = new Grid2D(20, 10, 400, 200, theme, this.id);
		this.selectedLetters = "";
		this.anagram = false;
		
		// création et placement des boutons 		
		setLayout(null);
		this.pauseButton = new GameButton2D("PAUSE");
		this.saveButton = new GameButton2D("ENREGISTRER");
		this.exitButton = new GameButton2D("QUITTER");
		
		this.pauseButton.setBounds(285, 310, 85, 25);
		this.saveButton.setBounds(285, 340, 85, 25);
		this.exitButton.setBounds(285, 370, 85, 25);
		

		
        add(this.pauseButton);
        add(this.saveButton);
        add(this.exitButton);
        
        this.pauseButton.addMouseListener(ContextManager.getSingleton().getGameButtonListener()); 
        this.saveButton.addMouseListener(ContextManager.getSingleton().getGameButtonListener());
        this.exitButton.addMouseListener(ContextManager.getSingleton().getGameButtonListener());
        

		this.drawBackground();
		this.addMouseListener(this);
		
	}
	
	// Getters / Setters
	public GameButton2D getPauseButton(){ return pauseButton; }
	public GameButton2D getExitButton(){ return exitButton; }
	public GameButton2D getSaveButton(){ return saveButton; }
	
	public void setAnagram(boolean b){
		this.anagram =b;
	}
	
	public JPanel getPanel(){ return this.panel; }
	public void setPanel(JPanel panel){ this.panel = panel; }
	
	public Grid2D getGrid2D(){ return this.grid; }
	public void setBackground(BufferedImage bg){ this.background = bg; }
	
	public String getSelectedLetters(){ return selectedLetters; }
	
	public void resetSelectedLetters(){ 
		selectedLetters = new String(); 
		for(int i=0; i<grid.getHeight(); ++i){
			for(int j=0; j<grid.getWidth(); ++j){
				grid.getBrick(i, j).setClicked(false);
			}
		}
	}
	
	
	private void drawBackground(){
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(theme.getBackgroundGame()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setBackground(img);
	}

	public void paintComponent(Graphics g){
		g.drawImage(this.background, 0, 0, null);
	    grid.draw(g, this.width, this.height);
	    
	    /*Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("media/font/Prime_Regular.ttf"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
        font = font.deriveFont(15);*/
        
	    //Dessin du score
		g.setColor(Color.WHITE);
	    Font police = new Font("Helvetica",Font.PLAIN, 15);
        g.setFont(police);
		g.drawString(Integer.toString(this.score), 74, 37);
		
		//Dessin du pseudo
		if(this.pseudo != "")
			g.drawString("Yo " + this.pseudo + " !", 296, 32);
		
		//Dessin du level
		g.setColor(new Color(16, 77, 91));
		g.drawString("Niveau "+Integer.toString(this.level), 115, 525);
		
		//Dessin des lettres cliquï¿½es
		police = new Font("Helvetica",Font.PLAIN, 30);
		g.setFont(police);
		g.setColor(Color.WHITE);
		g.drawString(this.getSelectedLetters(), 100, 300);
	}

	@Override
	public void update(int score, int level, String pseudo) {
		this.score = score;
		this.level = level;
		this.pseudo = pseudo;
		GraphicEngine.getSingleton().getGamePanel(this.id).repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.anagram == true){
			int line = (e.getY()-grid.getOriginGridTop()) / grid.getSquareSize();
			int col = (e.getX() - grid.getOriginGridLeft()) / grid.getSquareSize();
			
			// Test si on clique en dehors de la grille
			if(line<0 || line>grid.getHeight() || col<0 || col>grid.getWidth()){
				return;
			}	
		
			String letter = grid.getBrick(line, col).getLetter();
			grid.getBrick(line, col).setClicked(true);
			GraphicEngine.getSingleton().getGamePanel(0).repaint();
			System.out.println(letter);
			//System.out.println(grid.getBrick(line, col).getColor());
			// Test si la case est vide
			if(letter == null)
				return;
			else
				selectedLetters = new String(selectedLetters + letter);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}    
	
}
