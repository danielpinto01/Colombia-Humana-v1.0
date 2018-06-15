package models;

import java.util.ArrayList;

public class Manager {
	
	private ArrayList<Player> players;
	
	public Manager() {
		players = new ArrayList<>();
	}
	
	public static Player createPlayer(String namePlayer, String characterPlayer) {
		return new Player(namePlayer, characterPlayer);
	}
	
	public void addPlayerToList(Player player) {
		players.add(player);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
}