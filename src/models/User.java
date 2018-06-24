package models;

public class User {

	private String name;
	private int positionInX;
	private int positionInY;
	
	public User(String name, int positionX, int positionY) {
		this.name = name;
		this.positionInX = positionX;
		this.positionInY = positionY;
	}
	
	public String getName() {
		return name;
	}

	public int getPositionX() {
		return positionInX;
	}

	public void setPositionX(int positionX) {
		this.positionInX = positionX;
	}

	public int getPositionY() {
		return positionInY;
	}

	public void setPositionY(int positionY) {
		this.positionInY = positionY;
	}
}