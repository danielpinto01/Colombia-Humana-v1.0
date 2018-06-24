package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import connections.Client;
import models.Direction;
import models.Manager;
import models.User;
import views.GameMainWindow;
import views.MainWindow;

public class Controller implements ActionListener, KeyListener, IObserver {

	private Client client;
	private Manager managerGame;
	private MainWindow mainWindow;
	private Timer timer;
	
	private GameMainWindow initWindow;

	public Controller() {
		mainWindow = new MainWindow(this);
		initWindow = new GameMainWindow(this);
		mainWindow.showPanelInit();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_DIALOG_INIT_PLAYER:
			mainWindow.showDialogInitPlayer();
			break;
		case ADD_PLAYER:
		connectPlayer();
			break;
		default:
			break;
		}
	}

	private void startTimer() {
		timer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initWindow.paintGame();
			}
		});
		timer.start();
	}

	private void connectPlayer() {
		String ip = "0";
		String port = "2000";
		if (!port.equals("")) {
			newPlayer(ip, Integer.parseInt(port));
		} else {
			JOptionPane.showMessageDialog(null, "Puerto invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void newPlayer(String ip, int port) {
		try {
			String name = mainWindow.getNamePlayer();
			mainWindow.ocultDialogInitPlayer();
			mainWindow.setVisible(false);
			mainWindow.showDialogLoading();
			managerGame = new Manager(name, mainWindow.getWidth(), mainWindow.getHeight());
			client = new Client(ip, port, managerGame.getPlayer());
			client.addObserver(this);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo conectar con el servidor", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void movePlayer(int keycode) {
		if (keycode == KeyEvent.VK_RIGHT) {
			managerGame.move(Direction.RIGHT);
		} else if (keycode == KeyEvent.VK_LEFT) {
			managerGame.move(Direction.LEFT);
		} else if (keycode == KeyEvent.VK_SPACE) {
//			client.createShoot(managerGame.getPlayer().getArea().getX(), managerGame.getPlayer().getArea().getY());
		}
		client.sendMove(managerGame.getPlayer().getArea().getX(), managerGame.getPlayer().getArea().getY());
	}
	
	public int getSizeWindowInX() {
		return initWindow.getSizeWindowInX();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		movePlayer(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		movePlayer(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void startGame() {
//		mainWindow.init(managerGame.getPlayer(), managerGame.getUsers());
		mainWindow.ocultDialogLoading();
//		initWindow = new GameMainWindow(this);
		initWindow.init(managerGame.getPlayer(), managerGame.getUsers(), client.getEnemy());
		startTimer();
	}

	@Override
	public void loadUsers(ArrayList<User> users) {
		managerGame.loadUsers(users);
	}
}