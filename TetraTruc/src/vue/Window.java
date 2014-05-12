package vue;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.ContextManager;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	private WindowPanel panel = new WindowPanel();
	private int width = 401;
	private int height = 590;
	
	public Window(){
		this.setTitle("TetraTruc");
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel.setLayout(null);
		panel.setBackground(new Color(186, 214, 218));
		panel.setPreferredSize(new Dimension(this.width, this.height));
		
		this.setContentPane(panel);
		this.setVisible(true);
		
		setFocusable(true);
		this.addKeyListener(ContextManager.getSingleton().getKeyListener());
	}
	
	public Window(int width, int height){
		this.setTitle("TetraTruc");
		this.width = width;
		this.height = height;
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel.setLayout(null);
		panel.setBackground(new Color(186, 214, 218));
		panel.setPreferredSize(new Dimension(this.width, this.height));
		
		this.setContentPane(panel);
		this.setVisible(true);
		
		setFocusable(true);
		this.addKeyListener(ContextManager.getSingleton().getKeyListener());
	}
	
	public WindowPanel getPanel(){
		return this.panel;
	}
	
	public void setPanel(JPanel panel){
		this.panel = (WindowPanel) panel;
		this.setContentPane(this.panel);
		this.setVisible(true);
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}

}
