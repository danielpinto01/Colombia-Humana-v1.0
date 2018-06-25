package models;

import java.util.ArrayList;

public class Enemy {
	
	private int positionInX;
	private int positionInY;
	
	@SuppressWarnings("unused")
	private ArrayList<Shot> shots;
	
	public Enemy() {
		positionInY = 20;
		shots = new ArrayList<>();
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