package model;

public interface GridObserver {
	
	public void update(Point[] coords, Tetrominoe[] shapes, String[] letters, Tetrominoe[] nextShapes, String[] nextLetters);

}
