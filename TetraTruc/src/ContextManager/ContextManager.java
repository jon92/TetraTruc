package ContextManager;

public class ContextManager {
	public static MenuListener menuListener;
	private static ContextManager managerSingleton = new ContextManager();
	
	public ContextManager(){
		menuListener = new MenuListener();
	}
	
	public MenuListener getMenuListener(){
		return menuListener;
	}
	
	public static ContextManager getSingleton(){
		return managerSingleton;
	}
	
	public void setSoloState(){
		System.out.println("Mode Solo activ�");
	}
	
	public void setMultiState(){
		System.out.println("Mode Multi activ�");
	}
	
	public void setOptionsState(){
		System.out.println("Options activ�es");
	}
	
	public void setExitState(){
		System.out.println("Quitter le jeu");
	}
	
}
