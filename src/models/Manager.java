package models;

import java.util.ArrayList;

public class Manager {

	private Player player;
	private ArrayList<User> users;
//	private Enemy enemy;

	public Manager(String name, int width, int height) {
		this.player = new Player(name, new Area((int) (Math.random() * (width - 250)),
				(int) (height - 40), width, height));
		users = new ArrayList<>();
//		enemy = new Enemy();
	}
	
	public void move(Direction direction) {
		player.move(direction);
	}
	
	public void loadUsers(ArrayList<User> players) { 
		if (users.isEmpty()) {
			for (User user : players) {
				users.add(user);
			}
		} else {
			for (User user : players) {
				setInfo(user);
			}
		}
	}

	private void setInfo(User player) {
		for (User user : users) {
			if (user.getName().equals(player.getName())) {
				user.setPositionX(player.getPositionX());
				user.setPositionY(player.getPositionY());
				break;
			}
		}
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

//	public Enemy getEnemy() {
//		return enemy;
//	}
}