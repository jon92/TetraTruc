
package model;

public class Word {
    private String word;
    private int size;
    
    //constructeur
    Word(String[] word){
        // créer l'attribut word depuis les lettres des Brick entrées au fur et à mesure
        
        
        // en déduire la taille du word
        
    }
    
    
    // trouver un mot dans le dictionaire
    public boolean findWordInDictionnary(Word word){
        return false;
    };
    
    // retourner la taille du mot (important pour anagramme)
    public int getSize(Word word){
        return 0;
    }
    
     // retourner l'attribut word du mot 
    public String getWord(Word word){
        return "";
    }
    
    // trouver un mot avec des lettres mélangées (anagramme)
    // retourner une String ou un Word?
    public String findWordWithSwitchedLetters (char[] letters){
        return "";
    }
}
