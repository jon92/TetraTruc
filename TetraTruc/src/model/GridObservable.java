package model;

public interface GridObservable {
	public void updateObserver();
	public void addObserver(GridObserver obs);
	public void delAllObservers();
}
