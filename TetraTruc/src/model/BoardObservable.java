package model;

public interface BoardObservable {
	public void updateObserver();
	public void addObserver(GridObserver obs);
	public void delAllObservers();
}
