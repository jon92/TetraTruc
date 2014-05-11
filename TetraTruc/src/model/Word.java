package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Word {
    private String word;
    private int size;
    private static Dictionary dico = Dictionary.FR;		// A modifier selon quel dico on chois
    
    // Constructeur par défaut
    Word(){
        this.size = 0;
        this.word = "";
    }
    
    Word(String word){
        this.word = word;
        this.size = this.word.length();
    }
    
    // Getters / Setters
    public int getSize(){ return size; }
    public String getWord(){ return word; }        


    
    
    
    // trouver un mot avec des lettres mélangées (anagramme)
    // Paramètres : String contenant les lettres mélangées, "", un Word vide 
    public static Word findWordWithSwitchedLetters(String s1, String s2, Word longestWord)  {
        if(s1.length() == 0)    {
            //System.out.println("LONGEST WORD FINAL "+ longestWord.word);
            return longestWord;
        }
        for(int i = 0; i < s1.length(); i++) {
            longestWord = findWordWithSwitchedLetters(s1.substring(0, i) + s1.substring(i+1, s1.length()), s1.charAt(i) + s2, longestWord);
            
            Word w1 = new Word(s1);
            Word w2 = new Word (s2);
            
            boolean s1IsInDictionary = wordIsInDictionary(w1, 0, dico.getNbLines());
            boolean s2IsInDictionary = wordIsInDictionary(w2, 0, dico.getNbLines());

            // on vérifie qu'il est dans le dictionnaire et qu'il est plus long
            if (s1IsInDictionary && s1.length() > longestWord.size){
                longestWord.word = s1;
                longestWord.size = s1.length();
                System.out.println("LONGEST WORD "+ longestWord.word);
            }
            else if(s2IsInDictionary && s2.length() > longestWord.size){
                longestWord.word = s2;
                longestWord.size = s2.length();
                System.out.println("LONGEST WORD "+ longestWord.word);
            }
            
           
        }
        
        return longestWord;
    }

    
    
    
    // [TEST]
    public static void main(String[] args) throws FileNotFoundException {        
        Word word = new Word ("atta");
        //boolean check = findWordInDictionary(word, 0, dico.getNbLines());
        //System.out.println("check "+ check);
        Word word2 = new Word ("");
        String[] str = {"r", "b", "a", "d", "a", "c", "a", "r", "b", "a"} ;
        
        Word st1 = new Word("abracadabra");
        
        
        Word longestWord = new Word ("");   
        //word2 = findWordWithSwitchedLetters(str, longestWord);
        
        longestWord = findWordWithSwitchedLetters("abracadabra", "", longestWord);
        System.out.println(longestWord.word);
    }
            
}