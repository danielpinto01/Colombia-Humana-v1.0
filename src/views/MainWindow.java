package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;
import models.Player;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Colombia Humana v1.0";
	private static final String URL_ICON = "src/images/icon.jpg";

	private JDialogInitPlayer jDialogInitPlayer;
	
	private JPanelInit jPanelInit;
	private JPanelHistory jPanelHistory;
	private JPanelGame jPanelGame; 

	public MainWindow(Controller controller) {
		setTitle(TITLE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.WHITE);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(URL_ICON).getImage());
		addKeyListener(controller);

		jDialogInitPlayer = new JDialogInitPlayer(this, controller);
		jPanelInit = new JPanelInit(controller);
		jPanelHistory = new JPanelHistory(controller);
		
		setVisible(true);
	}

	public void showPanelInit() {
		add(jPanelInit, BorderLayout.CENTER);
	}

	public void showDialogInitPlayer() {
		jDialogInitPlayer.setVisible(true);
	}

	public void showPanelHistory(Controller controller) {
		getContentPane().removeAll();
		add(jPanelHistory, BorderLayout.CENTER);
		getContentPane().repaint();		
		getContentPane().revalidate();
	}

	public void showPanelGame(Controller controller, Player player,ArrayList<Player> list) {
		getContentPane().removeAll();
		jPanelGame = new JPanelGame(player,list);
		add(jPanelGame, BorderLayout.CENTER);
		getContentPane().repaint();		
		getContentPane().revalidate();
	}

	public void ocultDialogInitPlayer() {
		jDialogInitPlayer.setVisible(false);
	}

	public String getNamePlayer() {
		return jDialogInitPlayer.getNamePlayer();
	}

	public String getCharacterPlayer() {
		return jDialogInitPlayer.getCharacterPlayer();
	}

	public JPanelGame getjPanelGame() {
		return jPanelGame;
	}

	public void setGame(Player player,  ArrayList<Player> list) {
		jPanelGame.setCoordinates(player, list);
		jPanelGame.repaint();
	}
}