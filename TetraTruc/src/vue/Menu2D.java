package vue;

import javax.swing.JPanel;

public class Menu2D {
	protected JPanel panel;
	
	public Menu2D(JPanel panel){
		this.panel = panel;
		this.panel.removeAll();
		this.panel.repaint();
	}
	
	public void getMenuParams(){
		
	}
	
}
