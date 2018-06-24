package views;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Area;
import models.Enemy;
import models.User;
import view.UtilityList;

public class JPanelGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imagePlayer;
	private ArrayList<User> users;
	private Area area;
	
	private Enemy enemy;
	
	public JPanelGame(KeyListener keyListener, Area area, ArrayList<User> users, Enemy enemy) {
		this.area = area;
		this.users = users;
		this.enemy = enemy;
		addKeyListener(keyListener);
		setFocusable(true);
		ImageIcon image = new ImageIcon(getClass().getResource("/images/marranin.png"));
		imagePlayer = UtilityList.scaledImage(image, 250, 250);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("Agency FB", Font.BOLD, 25));
		
//		g.drawString("Duque", this.getWidth()- 950, this.getHeight() - 620);
//		g.fillRect(this.getWidth()- 900, this.getHeight() - 640, 200, 20);
//		
//		g.drawString("Petro", this.getWidth()- 950, this.getHeight() - 590);
//		g.fillRect(this.getWidth()- 900, this.getHeight() - 610, 200, 20);
		
		g.fillRect(this.getWidth()- 200, this.getHeight() - 500, 200, 500);
		
		if (enemy.getPositionInX() >0 && enemy.getPositionInX() < 1000 && enemy != null) {
//			g.drawImage(new ImageIcon("src/images/lord.png").getImage(), this.getWidth()- 200, this.getHeight()- 650, 150, 150, this);
			g.drawImage(new ImageIcon("src/images/lord.png").getImage(), enemy.getPositionInX(), enemy.getPositionInY(), 150, 150, this);
		}
		
		
		
//		g.drawImage(new ImageIcon("src/images/marranin.png").getImage(), this.getWidth()- 800, this.getHeight()- 150, 150, 150, this);
		g.drawString("Jugador", area.getX() + 20, this.getHeight() - 150);
		g.drawImage(new ImageIcon("src/images/marranin.png").getImage(),  area.getX(), this.getHeight() - 150, 150, 150, this);
		for (User user : users) {
			g.drawImage(imagePlayer.getImage(), user.getPositionX(), this.getHeight() - 150, 150, 150 , this);
		}
	}
	
	public int getSizeWindowInX() {
		return this.getWidth();
	}
}