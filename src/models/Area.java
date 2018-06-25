package models;

public class Area {

	private int positionInX;
	private int positionInY;
	private int width;
	private int height;
	
	public Area(int x, int y, int width, int height) {
		this.positionInX = x;
		this.positionInY = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return positionInX;
	}

	public int getY() {
		return positionInY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public void move(Direction direction) {
		switch (Direction.valueOf(direction.name())) {
		case LEFT:
			positionInX -= 10;
			break;
		case RIGHT:
			positionInX += 10;
			break;
		}
	}
	
}