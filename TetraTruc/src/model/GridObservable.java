package model;

public interface GridObservable {
	
	public void notifyObserver(Point[] coords, Tetrominoe[] shapes);
}
