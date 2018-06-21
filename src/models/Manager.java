package models;

import java.util.ArrayList;

public class Manager extends MyThread{

	private Player player;

	private ArrayList<Player> players;

	public Manager(String name) {
		super(name);
		player = new Player();
		start();
		players = new ArrayList<>();
	}

	public static Player createPlayer(String namePlayer, String characterPlayer, int positionX, int positionY, int lifePlayer) {
		return new Player(namePlayer, characterPlayer, positionX, positionY, lifePlayer);
	}

	public int getPositionInX() {
		return (int)(Math.random()*1000);
	}

	public int getPositionInY() {
		return 700;
	}

	public void setPlayer(Player playerOne) {
		this.player = playerOne;
	}

	public Player getPlayer() {
		return player;
	}

	public void getPositions() {
		System.out.println(player.getPositionInX() +  "-" + player.getPositionInY());
	}

	public void addList(ArrayList<Player> list) {
		for (Player player : list) {
			players.add(player);
		}
	}

	public void addCheckList(ArrayList<Player> list) {
		
		if (players.get(0).getNamePlayer() == list.get(0).getNamePlayer()) {
			
		}
	}

	public void movePlayer(int code){
		switch (code) {
		case 37:
			player.movePlayer(DirectionPlayer.LEFT);
			break;
		case 39:
			player.movePlayer(DirectionPlayer.RIGHT);
			break;
		}
	}

	public void addPlayerToList(Player player) {
		players.add(player);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void validatePlayer(Player player) {
		for (Player player2 : players) {
			if (player2.getNamePlayer().equals(player.getNamePlayer())) {
				player2.setPositionInX(player.getPositionInX());
				player2.setPositionInY(player.getPositionInY());
				break;
			}else {
				System.out.println("No son iguales :v");
				break;
			}
		}
	}	

	public void checkPositions(ArrayList<Player> players) {
		if (players.isEmpty()) {
			for (Player player : players) {
				players.add(player);
			}
		}else {
			for (Player player : players) {
				validatePlayer(player);
			}
		}
	}

	@Override
	void executeTask() {

	}
}