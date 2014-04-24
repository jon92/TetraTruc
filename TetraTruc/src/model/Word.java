
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
        this.size = this.word.length();
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
// Voir la fonction compareTo de char
    public static boolean findWordInDictionary(Word word, String file){
        try{
            File f = new File (file);
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
    
    
    // trouver un mot avec des lettres mélangées (anagramme)
    public static Word findWordWithSwitchedLetters (String[] letters, String file){
        
        // initialisation du mot le plus long au mot vide
        Word longestWord = new Word ("", 0);        
        Word tmp = new Word ("", 0);                
        boolean isInDictionary = true;  
        
        int[] indexAlreadyToken = new int[letters.length];        
        int compteur = 0;      
        boolean isInIndex = false;
        
        
        
     
        
            while (compteur != letters.length){

                int cptIndex = 0;

                // on "vide" le tableau indexAlreadyToken
                for (int l=0; l<indexAlreadyToken.length; ++l){
                    indexAlreadyToken[l] = -1;
                }

                indexAlreadyToken[0] = compteur;            

                tmp.word = letters[compteur];          

                for (int i = 0 ; i < letters.length; ++i){

                   // on vérifie que la lettre n'est pas dans le tableau des index déjà pris
                   for (int k = 0; k< indexAlreadyToken.length; ++k){                    
                       if (i == indexAlreadyToken[k]){
                           isInIndex = true;
                           break;
                       }
                   }

                   if (isInIndex == false){
                       tmp.word = tmp.word.concat(letters[i]);                    
                       System.out.println(tmp.word);                    
                       cptIndex++;                    
                       indexAlreadyToken[cptIndex] = i;

                       isInDictionary = findWordInDictionary(tmp, file);

                       // on vérifie qu'il est dans le dictionnaire et qu'il est plus long
                       if (isInDictionary && tmp.word.length() > longestWord.size){
                           longestWord.word = tmp.word;
                           longestWord.size = tmp.size;
                           System.out.println("LONGEST WORD "+ longestWord.word);
                       }
                   }

                   isInIndex = false;

                }

                compteur ++;
            }
        
        
   
        
        /*while (compteur != letters.length){
            
                String lettreActuelle = letters[compteur];

                tmp.word = letters[compteur];

                for (int i = compteur + 1 ; i < letters.length; ++i){
                    tmp.word = lettreActuelle.concat(letters[i]);
                    tmp.size = tmp.word.length();
                    
                    for (int j = i+1; j< letters.length; ++j){
                        tmp.word = tmp.word.concat(letters[j]);
                        tmp.size = tmp.word.length();
                        

                        System.out.println(tmp.word);

                        isInDictionary = findWordInDictionary(longestWord, file);

                        // on vérifie qu'il est dans le dictionnaire et qu'il est plus long
                        if (isInDictionary && tmp.size > longestWord.size){
                            longestWord.word = tmp.word;
                            longestWord.size = tmp.size;
                        }
                    }
                }

                compteur ++;
              
        }
        */  
        
        
        return longestWord;
    }
    
    
    
    
    
    
    // [TEST]
    public static void main(String[] args) throws FileNotFoundException {        
        Word word = new Word ("wesh", 5);
        //boolean check = findWordInDictionary(word,"media/lang/dictionary_FR.txt");
        //System.out.println("check "+ check);
        
        String[] str = {"a", "b", "c", "d", "e", "f"} ;
        
        word = findWordWithSwitchedLetters(str, "media/lang/dictionary_FR.txt");
        
    }
            
}
