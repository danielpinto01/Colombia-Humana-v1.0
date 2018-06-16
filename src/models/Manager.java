package models;

import java.util.ArrayList;

public class Manager {
	
	private ArrayList<Player> players;
	
	public Manager() {
		players = new ArrayList<>();
	}
	
	public static Player createPlayer(String namePlayer, String characterPlayer, int positionX, int positionY) {
		return new Player(namePlayer, characterPlayer, positionX, positionY);
	}
	
	public void addPlayerToList(Player player) {
		players.add(player);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public int getPositionInX() {
		return (int)(Math.random()*1000);
	}

	public int getPositionInY() {
		return (int)(Math.random()*800);
	}
}