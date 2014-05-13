package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import controleur.ContextManager;

public enum Dictionary {
    
	FR("media/lang/dictionary_FR.txt", "Français", 336529, 
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
	
	public boolean foundAnAnagram(int line){
		String word = new String();
		
		
		System.out.println("Mode Anagramme activé !");
		
		// Attendre que le joueur ait validé en appuyant sur Entrée
		
		// Récupérer les lettres cliquées
			
		// Vérifier qu'elles sont bien sur la bonne ligne pour les prendre en compte ou non
		System.out.println("Boucle");
		
		// Si le mot existe, TRUE, sinon FALSE
		if(containsWord(word, 0, nbLines))
			return true;
		else
			return false;
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
    
    
    public Vector<String> findAllAnagrams(Vector<String> allAnagrams, String word, String letters){
    	
    	if( containsWord(word, 0, nbLines) ){
    		allAnagrams.add(word);
    	}
    	
    	if( letters.length() == 0 ){
    		return allAnagrams;
    	}
    	
    	for(int i=0; i<letters.length(); ++i){
    		String anagram = new String( word.concat(letters.substring(i, i+1)) );
    		if(this.beginningExists(anagram)){
    			if(i==0){
    				System.out.println("1111111111");
    				System.out.println(anagram);
    				allAnagrams.addAll(findAllAnagrams(allAnagrams, anagram, letters.substring(1, letters.length())));
    			}
    			else if(i==letters.length()-1){
    				System.out.println("33333333333");
    				System.out.println(anagram);
    				allAnagrams.addAll(findAllAnagrams(allAnagrams, anagram, letters.substring(0, i)));
    			}
    			else{
    				System.out.println("2222222222");
    				System.out.println(anagram);
    				allAnagrams.addAll(findAllAnagrams(allAnagrams, anagram, letters.substring(0, i).concat(letters.substring(i+1, letters.length()))));
    			}
    			System.out.println("Coucou !");
    		}	
    	}
    	
    	return allAnagrams;
    }
    
    public static void main(String[] args) {
		Dictionary dico = Dictionary.FR;
		if(dico.beginningExists("feru")){
			System.out.println("Ca existe");
		}
		else{
			System.out.println("Ca existe pas");
		}
		
		Vector<String> anagrams = new Vector<String>();
		anagrams = dico.findAllAnagrams(anagrams, "", "etre");
		System.out.println("_____________________________________________________");
		for(int i=0; i<anagrams.size(); ++i){
			System.out.println(anagrams.get(i));
		}
		System.out.println("Fini !");
	}
    
}
