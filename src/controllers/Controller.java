package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.SwingWorker;

import org.json.simple.parser.ParseException;

import connections.Client;
import models.Manager;
import models.Player;
import persistence.FileManager;
import views.MainWindow;

public class Controller implements ActionListener, KeyListener{

	private MainWindow mainWindow;
	private Manager manager;
	private FileManager fileManager;

	private Client client;

	public Controller() {
		fileManager = new FileManager();
		manager = new Manager("Player");
		mainWindow = new MainWindow(this);
		mainWindow.showPanelInit();
	}

	public void initConnection() {
		try {
			client = new Client("localHost", 2000);
			setNamePlayerToClient();
//			client.sendMessage("Al servidor" + manager.getPlayer().getNamePlayer());
			client.sendInformationPlayer();
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			writeJsonOnePlayer();

			initConnection();

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
			try {
				mainWindow.showPanelGame(this, fileManager.readTotalListFromServer());
			} catch (IOException | ParseException e1) {
				e1.printStackTrace();
			}
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

	public void writeJsonOnePlayer() {
		try {
			fileManager.writeJsonOnePlayer(manager.getPlayer());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		manager.movePlayer(e.getKeyCode(), 500, 600);
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
				//				while (!manager.isStop()) {
				while (true) {
					mainWindow.setGame(manager.getPlayer());
					Thread.sleep(100);
				}
//				return null;
			}
		};
		refreshBoard.execute();
	}

	public void setNamePlayerToClient() {
		client.setNameConnection(manager.getPlayer().getNamePlayer());
	}
}