package model;

public enum Dictionary {
	FR("media/lang/dictionary_FR.txt", "Français");
	
        private String path;
	private String language;		// Langue du dictionnaire
	private String freqLetters;		// Fréquence d'apparition des lettres dans la langue du dictionnaire
	
	// Constructeur
	Dictionary(String path, String language){
                this.path = path;
		// Charger le dictionnaire
		this.language = language;
	}
	
	// Getters
	public String getLanguage(){ return language; }
	public String getFreqLetters(){ return freqLetters; }
        public String getPath(){ return path; }

    String FR(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
