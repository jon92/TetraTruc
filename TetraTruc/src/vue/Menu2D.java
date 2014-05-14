package vue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import javax.swing.JPanel;

public class Menu2D {
	protected JPanel panel;
	protected HashMap<String, String> params;
	protected HashMap<String, String> prefs;
	
	public Menu2D(JPanel panel){
		this.panel = panel;
		this.panel.removeAll();
		this.panel.repaint();
		this.params = new HashMap<String, String>();
		this.prefs = new HashMap<String, String>();
	}
	
	public JPanel getPanel(){
		return this.panel;
	}
	
	public HashMap<String, String> getMenuParams(){
		return this.params;
	}
	
	public void loadPrefs(URL file) throws IOException{
		try {
			InputStreamReader isr = null;
			
			File testFile = new File("prefs.tetra");
			if( !testFile.exists() ){
				isr = new InputStreamReader(file.openStream());
			}else{
				isr = new InputStreamReader(new FileInputStream("prefs.tetra"));
			}
			

			BufferedReader br = new BufferedReader (isr);
			
			//InputStream ips=new FileInputStream(file);
			//InputStreamReader ipsr=new InputStreamReader(ips);
			//BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			
			try {
				while ((ligne=br.readLine())!=null){
					String[] parts = ligne.split(" @ ");
					if(parts.length > 1)
						this.prefs.put(parts[0], parts[1]);
					else
						this.prefs.put(parts[0], "");
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
