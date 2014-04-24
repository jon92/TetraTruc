package vue;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.ContextManager;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private final int width = 800;
	private final int height = 600;
	
	public Window(){
		this.setTitle("TetraTruc");
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel.setLayout(null);
		panel.setBackground(new Color(186, 214, 218));
		
		this.setContentPane(panel);
		this.setVisible(true);
		
		setFocusable(true);
		this.addKeyListener(ContextManager.getSingleton().getKeyListener());
	}
	
	public JPanel getPanel(){
		return this.panel;
	}
	
	public void setPanel(JPanel panel){
		this.panel = panel;
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
