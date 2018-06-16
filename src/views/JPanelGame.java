package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Player;

public class JPanelGame extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final Image PLAYER_IMAGE = new ImageIcon("src/images/player.png").getImage();
	private Player player;
	
	public JPanelGame() {
		setBackground(Color.RED);
		player = new Player();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (player != null) {
			g.drawImage(PLAYER_IMAGE, player.getPositionInX(), player.getPositionInY(), 80, 80, this);
			g.fillRect(1500, 200, 500, 900);
		}
	}
	
	public void setCoordinates(Player player) {
		this.player = player;
	}
}