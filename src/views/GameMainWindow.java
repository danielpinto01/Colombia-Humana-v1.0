package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;
import models.Bees;
import models.Enemy;
import models.Player;
import models.User;

public class GameMainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private Controller controller;
	
	private JPanelGame panelGame;
	
	public GameMainWindow(Controller controller) {
		this.controller = controller;
		setTitle("Colombia Humana v1.0");
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource("/images/icon.jpg")).getImage());
		setSize(1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void init(Player player, ArrayList<User> users, Enemy enemy, ArrayList<Bees> bees) {
		getContentPane().removeAll();
		panelGame = new JPanelGame(controller, player.getArea(), users, enemy, bees);
		add(panelGame, BorderLayout.CENTER);
		getContentPane().repaint();		 
		getContentPane().revalidate();
		setVisible(true);
	}
	
	public void paintGame() {
		panelGame.repaint();
		revalidate();
	}
	
	public int getSizeWindowInX() {
		return panelGame.getSizeWindowInX();
	}
}