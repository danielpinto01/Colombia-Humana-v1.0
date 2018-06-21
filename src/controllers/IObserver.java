package controllers;

import java.util.ArrayList;

import models.Player;

public interface IObserver {

	void updateUsers(ArrayList<Player> players);
}