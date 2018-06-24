package models;

public class Enemy {
	
	private int positionInX;
	private int positionInY;
	
	public Enemy() {
	}

	public int getPositionInX() {
		return positionInX;
	}

	public void setPositionInX(int positionInX) {
		this.positionInX = positionInX;
	}

	public int getPositionInY() {
		return positionInY;
	}

	public void setPositionInY(int positionInY) {
		this.positionInY = positionInY;
	}

	@Override
	public String toString() {
		return "Enemy [positionInX=" + positionInX + ", positionInY=" + positionInY + "]";
	}
}