package vue;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class Menu2D {
	protected JPanel panel;
	protected HashMap<String, String> params;
	
	public Menu2D(JPanel panel){
		this.panel = panel;
		this.panel.removeAll();
		this.panel.repaint();
		this.params = new HashMap<String, String>();
	}
	
	public HashMap<String, String> getMenuParams(){
		System.out.println("classe mère");
		return this.params;
	}
	
}
