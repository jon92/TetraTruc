package model;

public enum Dictionary {
	FR("/media/lang/dictionary_FR.txt", "Français");
	
	private String language;		// Langue du dictionnaire
	private String freqLetters;		// Fréquence d'apparition des lettres dans la langue du dictionnaire
	
	// Constructeur
	Dictionary(String path, String language){
		// Charger le dictionnaire
		this.language = language;
	}
	
	// Getters
	public String getLanguage(){ return language; }
	public String getFreqLetters(){ return freqLetters; }
}
