package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Player;

public class JPanelGame extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final Image PLAYER_IMAGE = new ImageIcon("src/images/marranin.png").getImage();
	private static final Image IMAGE = new ImageIcon("src/images/lord.png").getImage();
	private Player player;

	private ArrayList<Player> list;


	public JPanelGame(Player player,ArrayList<Player> list) {
//		player = new Player();
		this.player = player;
		this.list = list;
		setBackground(Color.GRAY);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (player != null) {
			g.drawImage(PLAYER_IMAGE, player.getPositionInX(), player.getPositionInY(), 200, 200, this);
			g.drawString(player.getNamePlayer(), player.getPositionInX()+30, player.getPositionInY());
			
			g.drawImage(IMAGE, 1500, 0, 200, 200, this);
			g.fillRect(1500, 200, 500, 900);
			
			g.drawString("Porqui", 30, 30);
			for (Player player : list) {
				g.drawString(player.getNamePlayer(), player.getPositionInX()+30, player.getPositionInY());
				g.drawImage(PLAYER_IMAGE, player.getPositionInX(), player.getPositionInY(), 200, 200, this);
			}
		}
	}

//	public void setCoordinates(Player player, ArrayList<Player> players ) {
//		this.player = player;
//		list = players;
//	}
}