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
import views.MainWindow;

public class Controller implements ActionListener, KeyListener, IObserver {

	private Client client;
	private Manager managerGame;
	private MainWindow mainWindow;
	private Timer timer;

	public Controller() {
		mainWindow = new MainWindow(this);
		mainWindow.showPanelInit();
//		connectPlayer();
	}
	

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		switch (Events.valueOf(e.getActionCommand())) {
//		case LOG_ING:
//			break;
//		case SIGN_IN:
//			break;
//			
//			
//		}
//	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_DIALOG_INIT_PLAYER:
			mainWindow.showDialogInitPlayer();
			break;
		case ADD_PLAYER:
			newPlayer();
			mainWindow.setVisible(false);
//			mainWindow.showDialogLoading();
			mainWindow.removeAll();
			break;
		case INIT_GAME:
//			mainWindow.removeAll();
			break;
		default:
			break;
		}
	}

	private void startTimer() {
		timer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.paintGame();
			}
		});
		timer.start();
	}

	private void connectPlayer() {
//		mainWindow.setVisible(false);
//		String ip = JOptionPane.showInputDialog("Ingrese la IP del servidor", "0");
//		String port = JOptionPane.showInputDialog("Ingrese el puerto", "2000");
//		if (!port.equals("")) {
//			newPlayer(ip, Integer.parseInt(port));
//		} else {
//			JOptionPane.showMessageDialog(null, "Puerto invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
//		}
		newPlayer();
	}

//	private void newPlayer(String ip, int port) {
		private void newPlayer() {
		try {
//			String name = JOptionPane.showInputDialog("Nombre de usuario");
			//			mainWindow.showDialog();
			managerGame = new Manager(mainWindow.getNamePlayer(), mainWindow.getWidth(), mainWindow.getHeight());
			mainWindow.ocultDialogInitPlayer();
			mainWindow.showDialogLoading();
			client = new Client("0", 2000, managerGame.getPlayer());
			client.addObserver(this);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo conectar con el servidor", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void movePlayer(int keycode) {
		//		if (keycode == KeyEvent.VK_UP) {
		//			managerGame.move(Direction.UP);
		//		} else if (keycode == KeyEvent.VK_DOWN) {
		//			managerGame.move(Direction.DOWN);
		if (keycode == KeyEvent.VK_RIGHT) {
			managerGame.move(Direction.RIGHT);
		} else if (keycode == KeyEvent.VK_LEFT) {
			managerGame.move(Direction.LEFT);
		} else if (keycode == KeyEvent.VK_SPACE) {
//			client.createShoot(managerGame.getPlayer().getArea().getX(), managerGame.getPlayer().getArea().getY());
		}
		client.sendMove(managerGame.getPlayer().getArea().getX(), managerGame.getPlayer().getArea().getY());
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
		mainWindow.init(managerGame.getPlayer(), managerGame.getUsers());
		startTimer();
	}

	@Override
	public void loadUsers(ArrayList<User> users) {
		managerGame.loadUsers(users);
	}
}