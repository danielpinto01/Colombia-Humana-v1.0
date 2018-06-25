package controllers;

import java.util.ArrayList;

import models.Bees;
import models.User;

public interface IObserver {

	void startGame();
	
	void loadUsers(ArrayList<User> users);
	
	void loadBees(ArrayList<Bees> bees);
}