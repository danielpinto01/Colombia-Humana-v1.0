package views;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Area;
import models.Bees;
import models.Enemy;
import models.Shot;
import models.User;
import view.UtilityList;

public class JPanelGame extends JPanel {

	private static final Image IMAGE_MARRANIN = new ImageIcon("src/images/marranin.png").getImage();
	private static final Image IMAGE_LORD = new ImageIcon("src/images/lord.png").getImage();
	private static final Image IMAGE_BEES = new ImageIcon("src/images/next.png").getImage();
	private static final long serialVersionUID = 1L;
	private ImageIcon imagePlayer;
	private ArrayList<User> users;
	private Area area;
	
	private Enemy enemy;
	
	private ArrayList<Bees> bees;
	
	public JPanelGame(KeyListener keyListener, Area area, ArrayList<User> users, Enemy enemy, ArrayList<Bees> bees) {
		this.area = area;
		this.users = users;
		this.enemy = enemy;
		this.bees = bees;
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
		
		if (enemy.getPositionInX() >0 && enemy.getPositionInX() < 1000 && enemy != null) {
			g.drawImage(IMAGE_LORD, enemy.getPositionInX(), enemy.getPositionInY(), 150, 150, this);
		}
		
		
		
		g.drawString("Jugador", area.getX() + 20, this.getHeight() - 150);
		g.drawImage(IMAGE_MARRANIN,  area.getX(), this.getHeight() - 150, 150, 150, this);
		for (User user : users) {
			g.drawImage(imagePlayer.getImage(), user.getPositionX(), this.getHeight() - 150, 150, 150 , this);
		}
		
		for (int i = 0; i < bees.size(); i++) {
			if (bees.get(i).getType() == 3) {
				g.drawImage(IMAGE_BEES, bees.get(i).getX(), bees.get(i).getY(), this);
			} else if (bees.get(i).getType() == 1) {
				g.drawImage(IMAGE_BEES, bees.get(i).getX(), bees.get(i).getY(), this);
			} else {
				g.drawImage(IMAGE_BEES, bees.get(i).getX(), bees.get(i).getY(), this);
			}
		}
	}
	
	public int getSizeWindowInX() {
		return this.getWidth();
	}
}