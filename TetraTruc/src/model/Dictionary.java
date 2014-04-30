package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public enum Dictionary {
    
	FR("media/lang/dictionary_FR.txt", "Français", 22739, 
            "eeeeeeeeeeeeeessssssssaaaaaaaaiiiiiiiitttttttnnnnnnnrrrrrrruuuuuullllloooooddddcccpppmmmvvqqfbghjxyzwk"
        );
	
    private String path;
	private String language;		// Langue du dictionnaire
	private String freqLetters;		// Fréquence d'apparition des lettres dans la langue du dictionnaire
	private int nbLines;
    private Vector<String> content;
        
	// Constructeur
	Dictionary(String path, String language, int nbLines, String freqletters){
            this.path = path;
            // Charger le dictionnaire
            this.language = language;
            this.nbLines = nbLines;
            this.content = constructVector();
            this.freqLetters = freqletters;
	}
        
        private Vector<String> constructVector(){
            Vector<String> constructContent = new Vector<String>();
            try{
                File f = new File (this.getPath());
                FileReader fr = new FileReader (f);
                BufferedReader br = new BufferedReader (fr);

                try{
                    String line = br.readLine();

                    while (line != null)
                    {
                        constructContent.add(line);
                        line = br.readLine();
                    }

                    br.close();
                    fr.close();
                }
                catch (IOException exception){
                    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                }
            
            }
            catch (FileNotFoundException exception){
                System.out.println ("Le fichier n'a pas été trouvé");
            }
        
            return constructContent;
        }
	
	// Getters
	public String getLanguage(){ return language; }
	public String getFreqLetters(){ return freqLetters; }
    public String getPath(){ return path; }
    public int getNbLines(){ return nbLines; }
    public Vector<String> getContent(){ return content; }

    String FR(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
