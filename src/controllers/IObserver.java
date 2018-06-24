package controllers;

import java.util.ArrayList;

import models.User;

public interface IObserver {

	void startGame();
	
	void loadUsers(ArrayList<User> users);
}