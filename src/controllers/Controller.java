package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Manager;
import models.Player;
import views.MainWindow;

public class Controller implements ActionListener{
	
	private MainWindow mainWindow;
	private Manager manager;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		manager = new Manager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_DIALOG_INIT_PLAYER:
			showDialogInitPlayer();
			break;
		case ADD_PLAYER_TO_LIST:
			addPlayerToList();
			System.out.println(manager.getPlayers());
			break;
		default:
			break;
		}
	}
	
	public void showDialogInitPlayer() {
		mainWindow.showDialogInitPlayer();
	}
	
	public void ocultDialogInitPlayer() {
		mainWindow.ocultDialogInitPlayer();
	}
	
	public void addPlayerToList() {
		Player player = new Player(mainWindow.getNamePlayer(), mainWindow.getCharacterPlayer());
		manager.addPlayerToList(player);
		ocultDialogInitPlayer();
	}
}