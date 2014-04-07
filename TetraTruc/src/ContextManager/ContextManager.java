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
		System.out.println("Mode Solo activé");
	}
	
	public void setMultiState(){
		System.out.println("Mode Multi activé");
	}
	
	public void setOptionsState(){
		System.out.println("Options activées");
	}
	
	public void setExitState(){
		System.out.println("Quitter le jeu");
	}
	
}
