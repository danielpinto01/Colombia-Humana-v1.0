package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingWorker;
import javax.swing.Timer;

import org.json.simple.parser.ParseException;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import connections.Client;
import models.Manager;
import models.Player;
import persistence.FileManager;
import views.MainWindow;

public class Controller implements IObserver, ActionListener, KeyListener{

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
			client.addObserver(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e){
		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_DIALOG_INIT_PLAYER:
			showDialogInitPlayer();
			break;
		case ADD_PLAYER_TO_LIST:
			manager.setPlayer(getPlayerToWindow());
//			System.out.println(manager.getPlayer());
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
			mainWindow.showPanelGame(this, manager.getPlayer(), manager.getPlayers());
			startGame();
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
				manager.getPositionInX(), manager.getPositionInY(), manager.getPlayer().getLifePlayer());
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
		manager.movePlayer(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		manager.movePlayer(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	private void startGame() {
		SwingWorker<Void, Void> refreshBoard = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				while (!manager.isStop()) {
					mainWindow.repaint();
//					mainWindow.setGame(manager.getPlayer(), fileManager.readTotalListFromServer());
					Thread.sleep(100);
				}
				return null;
			}
		};
		refreshBoard.execute();
	}

	public void setNamePlayerToClient() {
		client.setNameConnection(manager.getPlayer().getNamePlayer());
	}

	@Override
	public void updateUsers(ArrayList<Player> players) {
		manager.checkPositions(players);
	}
	
	
//	public void addPlayerToListViews() throws IOException, ParseException {
//		ArrayList<Player> list = fileManager.readTotalListFromServer();
//		for (Player player : list) {
//			manager.addPlayerToList(player);
//		}
//	}
}