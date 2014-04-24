
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
    
    // dictionnaire à la position "media/lang/dictionary_FR.txt"
    
    //constructeur
    Word(String[] word){
        // créer l'attribut word depuis les lettres des Brick entrées au fur et à mesure
        
        // en déduire la taille du word
        
    }
    
	// [TEST]
    Word (String word, int size){
        this.size = size;
        this.word = word;
    }
    
    
    // [TEST] parcourir le dictionnaire et afficher les mots 
    public static void browseDictionary(String file) throws FileNotFoundException{
              
        try{
            File f = new File (file);
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
    
    // trouver un mot dans le dictionaire
// TODO  : améliorer le parcours : arrêter le parcours quand on a dépassé le mot (si le mot n'existe pas)
    public static boolean findWordInDictionary(Word word, String file){
        try{
            File f = new File (file);
            FileReader fr = new FileReader (f);
            BufferedReader br = new BufferedReader (fr);

            try{
                String line = br.readLine();

                while (line != null)
                {
                    System.out.println (line);
                    // on teste si la ligne du dictionnaire correspond au mot à tester
                    if (line.equals(word.word)){
                        return true;
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
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Word word = new Word ("wesh", 5);
        boolean check = findWordInDictionary(word,"media/lang/dictionary_FR.txt");
        System.out.println("check "+ check);
    }
            
}
