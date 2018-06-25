package models;

public class Shot {
	
	private int positionInX;
	private int positionInY;
	
	public Shot(int positionInX, int positionInY) {
		this.positionInX = positionInX;
		this.positionInY = positionInY;
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
		return "Shot [positionInX=" + positionInX + ", positionInY=" + positionInY + "]";
	}
}