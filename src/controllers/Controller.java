package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingWorker;

import models.Manager;
import models.Player;
import persistence.FileManager;
import views.MainWindow;

public class Controller implements ActionListener, KeyListener{

	private MainWindow mainWindow;
	private Manager manager;
//	private FileManager fileManager;

	public Controller() {
		manager = new Manager("Player");
		mainWindow = new MainWindow(this);
		mainWindow.showPanelInit();
//		fileManager = new FileManager();
		start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_DIALOG_INIT_PLAYER:
			showDialogInitPlayer();
			break;
		case ADD_PLAYER_TO_LIST:
			manager.setPlayer(getPlayerToWindow());
			System.out.println(manager.getPlayer());
			manager.getPositions();
			break;
		case EXIT_APP:
			mainWindow.setVisible(false);
			System.out.println("Exit");
			System.exit(0);
			break;
		case INIT_GAME:
			mainWindow.showPanelHistory(this);
			break;
		case NEXT_PAGE:
			System.out.println("Next");
			mainWindow.showPanelGame(this);
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

	public Player getPlayerToWindow() {
		ocultDialogInitPlayer();
		return new Player(mainWindow.getNamePlayer(), mainWindow.getCharacterPlayer(), 
				manager.getPositionInX(), manager.getPositionInY());
	}

	//	public void writeJsonPlayers() {
	//		try {
	//			fileManager.writeJsonPlayer(manager.getPlayers());
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//	}

	@Override
	public void keyPressed(KeyEvent e) {
		manager.movePlayer(e.getKeyCode(), mainWindow.getjPanelGame().getWidth(), mainWindow.getjPanelGame().getHeight());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	private void start() {
		SwingWorker<Void, Void> refreshBoard = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				while (!manager.isStop()) {
					mainWindow.setGame(manager.getPlayer());
					Thread.sleep(1000);
				}
				return null;
			}
		};
		refreshBoard.execute();
	}
}