package model;

public interface GridObservable {
	public void notifyObserver();
	public void addObserver(GridObserver obs);
	public void delAllObservers();
}
