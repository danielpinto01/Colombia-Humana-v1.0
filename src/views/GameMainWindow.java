package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;
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
	}
	
	public void init(Player player, ArrayList<User> users) {
//		jDialogLoading.setVisible(false);
		getContentPane().removeAll();
		panelGame = new JPanelGame(controller, player.getArea(), users);
		add(panelGame, BorderLayout.CENTER);
		getContentPane().repaint();		 
		getContentPane().revalidate();
		setVisible(true);
	}
	
	public void paintGame() {
		panelGame.repaint();
		revalidate();
	}
	
	

}
