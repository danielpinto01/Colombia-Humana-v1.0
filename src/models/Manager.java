package models;

import java.util.ArrayList;

public class Manager {

	private Player player;
	private ArrayList<User> users;

	private ArrayList<Bees> bees;

	public Manager(String name, int width, int height) {
		this.player = new Player(name, new Area((int) (Math.random() * (width - 250)),
				(int) (height - 40), width, height));
		users = new ArrayList<>();
		bees = new ArrayList<>();
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

	public void loadBees(ArrayList<Bees> beesList) {
		for (int i = 0; i < beesList.size(); i++) {
			if (!setBeesPositions(beesList.get(i))) {
				bees.add(beesList.get(i));
			}
		}
		for (int i = 0; i < bees.size(); i++) {
			if (!validateBeesExist(bees.get(i), beesList)) {
				bees.remove(i);
			}
		}
	}

	private boolean validateBeesExist(Bees bees, ArrayList<Bees> beesList) {
		for (Bees bees1 : beesList) {
			if (bees1.getId() == bees.getId()) {
				return true;
			}
		}
		return false;
	}

	private boolean setBeesPositions(Bees bees1) {
		for (Bees actual : bees) {
			if (actual.getId() == bees1.getId()) {
				actual.setX(bees1.getX());
				actual.setY(bees1.getY());
				return true;
			}
		}
		return false;
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

	public ArrayList<Bees> getBees() {
		return bees;
	}
	
	

	//	public Enemy getEnemy() {
	//		return enemy;
	//	}
}