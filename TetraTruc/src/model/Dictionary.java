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
    
    
    // Trouver un mot dans le dictionnaire.
    // Paramètres : le mot qu'on cherche, 0 , taille du dico (nb de lignes) --> dico.getNbLines()
    public boolean containsWord(String word, int begin, int end){
        // si begin > end, le mot n'existe pas
        if (begin > end){
            return false;
        }
        
        int middle = (begin + end) / 2;
        String wordMiddleDictionary = this.getContent().get(middle);
        
        int compareWord = word.compareTo(wordMiddleDictionary);
        
        // si c'est le même mot, il est dans le dico
        if (compareWord == 0){
            return true;
        }
        // si le mot est + grand, on vérifie la moitié supérieure
        else if (compareWord < 0){
            return this.containsWord(word, begin, (middle - 1));
        }
        // si le mot est + petit, on vérifie la moitié inférieure
        else{
            return this.containsWord(word, (middle + 1), end);  
        }
    }
    
    
    // Chercher s'il existe un mot commençant par les caractères passés en paramètres
    public boolean beginningExists(String word){
    	int begin=0;
    	int end=1;
    	String letterToCheck = word.substring(begin, end);
    	
    	// On parcourt tout le dictionnaire
    	for(int dicoLine=0; dicoLine<=nbLines; ++dicoLine){
    		// Si on trouve dans le dictionnaire un mot qui commence par le mot qu'on est en train de tester, on peut passer à la lettre suivante
    		while( begin < content.get(dicoLine).length() && letterToCheck.equalsIgnoreCase(content.get(dicoLine).substring(begin, end)) ){
    			begin++;
    			end++;
    			if(begin >= word.length()){
    				return true;
    			}
    			letterToCheck = word.substring(begin, end);
    		}
    	}
    	return false;
    }
    
}
