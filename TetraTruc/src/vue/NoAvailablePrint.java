package vue;

import javax.swing.JOptionPane;

public class NoAvailablePrint extends JOptionPane{
	//private JOptionPane errorMsg;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoAvailablePrint() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void alertNoAvailable(){
		this.showMessageDialog(this,"Menu non disponible. Desoles! A la place on vous offre des chouquettes!");
	}
	

}
