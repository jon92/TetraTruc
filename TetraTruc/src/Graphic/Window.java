package Graphic;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{
	
	public Window(){
		this.setTitle("TetraTruc");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(186, 214, 218));
		this.setContentPane(panel1);
		this.setVisible(true);
	}
}
