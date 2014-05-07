package model;

public interface BoardObservable {
	public void updateObserver();
	public void addObserver(BoardObserver obs);
	public void delAllObservers();
}
