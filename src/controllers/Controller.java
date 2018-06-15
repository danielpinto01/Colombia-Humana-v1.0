package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Manager;
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
}