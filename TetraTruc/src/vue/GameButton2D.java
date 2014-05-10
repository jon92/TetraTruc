package vue;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameButton2D extends JButton{
	
	private static final long serialVersionUID = 1L;
	private static final String LIGHT_GRADIENT = null;
	private final String name;
	
	public GameButton2D(String name){
		super(name);
		this.name = name;
	}
	
	public void paintComponent (Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		
		Color colorButton = new Color(0,10,80);
		
		RenderingHints renderHints =
            new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            renderHints.put(RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(renderHints);
       
        int w = getWidth(), h = getHeight();
        /*Initial Graphics clip is the full bounds of the component:
         *create a rounded clip LARGER than the compolor.r*/
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float( 0, 0, w - 1, h - 1,h, h);
        /*intersect this with the existing clip*/
        g2d.clip(r2d);
        
        /* fill the clipped area*/
        g2d.setPaint(colorButton);
        
        g2d.fillRoundRect(0, 0, w - 1, h - 1, h, h);
        /* restore original clip
         * paint outer border*/

        g2d.setPaint(colorButton);
        g2d.drawRoundRect(0, 0, w - 2, h - 2, h, h);
        /* paint inner border*/

        g2d.setPaint(colorButton);
        g2d.drawRoundRect(1, 1, w -4, h - 4,h-2, h-2);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));

        /* paint the text and icon*/
        super.paintComponent(g);
		
	    //int stringLen = (int) g2d.getFontMetrics().getStringBounds(this.name, g2d).getWidth();  
        
	    //g2d.drawString(this.name, (int) (this.getWidth()*0.5 - stringLen*0.5), (this.getHeight() / 2) + 5);
	}
	
	public String getName(){
		return this.name;
	}
	
	
	// [TEST]
	 public static void main(String[] args) {
	        new JFrame(){
	            {
	                //setLayout(new FlowLayout());
	                //setLayout(null);
	                GameButton2D b = new GameButton2D("coucou");
	                b.setBounds(12,12, 400,200);
	                add(b);
	                setSize(300,500);
	                setDefaultCloseOperation(EXIT_ON_CLOSE);
	                setVisible(true);
	 
	            }
	        };
	    }
	 

}



