
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import sun.tools.jar.Main;

public class Word {
    private String word;
    private int size;
    
// A modifier selon quel dico on chois
    private static Dictionary dico = Dictionary.FR;
    
    //constructeur
    Word(String[] word){
        // créer l'attribut word depuis les lettres des Brick entrées au fur et à mesure
        
        
        
        // en déduire la taille du word
        this.size = this.word.length();
    }
    
	// [TEST]
    Word(){
        this.size = 0;
        this.word = "";
    }
    
	// [TEST]
    Word (String word, int size){
        this.size = size;
        this.word = word;
    }
    
               
    // retourner la taille du mot (important pour anagramme)
    public int getSize(Word word){
        return word.size;
    }
    
     // retourner l'attribut word du mot 
    public String getWord(Word word){
        return word.word;
    }
    
        
    
    
    // [TEST] parcourir le dictionnaire et afficher les mots 
    public static void browseDictionary() throws FileNotFoundException{
              
        try{
            File f = new File (dico.getPath());
            FileReader fr = new FileReader (f);
            BufferedReader br = new BufferedReader (fr);

            try{
                String line = br.readLine();

                while (line != null)
                {
                    System.out.println (line);
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
        
        
    }

    /*
    // trouver un mot dans le dictionaire
// TODO  : améliorer le parcours : arrêter le parcours quand on a dépassé le mot (si le mot n'existe pas)
// Voir la fonction compareTo de char
    public static boolean findWordInDictionary(Word word){
        try{
            File f = new File (dico.getPath());
            FileReader fr = new FileReader (f);
            BufferedReader br = new BufferedReader (fr);

            try{
                String line = br.readLine();

                while (line != null)
                {
                    //System.out.println (line);
                    // on teste si la ligne du dictionnaire correspond au mot à tester
                    if (line.equals(word.word)){
                        return true;
                    }
                    
                    // si le mot est dépassé, on arrête
                    Character line1 = (Character) line.charAt(0);
                    Character word1 = (Character) word.word.charAt(0);
                    if (line1.compareTo(word1) > 0){
                        break;
                    }
                                        
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
        return false;
    };
    */
    
     /*
    <?php
        function find($mot, $dictionnaire, $begin, $end) {
            if ($begin > $end)
                return false;
            $new = floor(($begin + $end) / 2);
            $cmp = strcmp($dictionnaire[$new], $mot);
            if ($cmp == 0)
                return true;
            else if ($cmp > 0)
                return find($mot, $dictionnaire, $begin, $new - 1);
            else
                return find($mot, $dictionnaire, $new + 1, $end);
        }
        // exemple :
        $dictionnaire = array('chat', 'cheval', 'chien', 'grenouille');
        echo find('chien', $dictionnaire, 0, sizeof($dictionnaire) - 1);
        ?>    
    */
    
    public static boolean findWordInDictionary(Word wordToCheck, int begin, int end){
        if (begin > end)
            return false;
        int middle = (begin + end) / 2;
        
        String wordDictionary = dico.getContent().get(middle);
        
        int compareWord = wordToCheck.word.compareTo(wordDictionary);
        
        if (compareWord == 0)
            return true;
        else if (compareWord < 0)
            return findWordInDictionary(wordToCheck, begin, (middle - 1));
        else
            return findWordInDictionary(wordToCheck,  (middle + 1), end);
        
        
    }
    
    // trouver un mot avec des lettres mélangées (anagramme)
    public static Word findWordWithSwitchedLetters(String s1, String s2, Word longestWord)  {
        if(s1.length() == 0)    {
            //System.out.println("LONGEST WORD FINAL "+ longestWord.word);
            return longestWord;
        }
        for(int i = 0; i < s1.length(); i++) {
            longestWord = findWordWithSwitchedLetters(s1.substring(0, i) + s1.substring(i+1, s1.length()), s1.charAt(i) + s2, longestWord);
            
            Word w1 = new Word(s1, s1.length());
            Word w2 = new Word (s2, s2.length());
            
            boolean s1IsInDictionary = findWordInDictionary(w1, 0, dico.getNbLines());
            boolean s2IsInDictionary = findWordInDictionary(w2, 0, dico.getNbLines());

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
        Word word = new Word ("atta", 5);
        //boolean check = findWordInDictionary(word, 0, dico.getNbLines());
        //System.out.println("check "+ check);
        Word word2 = new Word ("", 0);
        String[] str = {"a", "b", "c", "d", "e", "f"} ;
        
        Word st1 = new Word("abcdef", 6);
        
        
        Word longestWord = new Word ("", 0);   
        //word2 = findWordWithSwitchedLetters(str, longestWord);
        
        longestWord = findWordWithSwitchedLetters("proebcgaaw", "", longestWord);
        System.out.println(longestWord.word);
    }
            
}
