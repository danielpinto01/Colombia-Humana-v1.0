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
import models.User;
import view.UtilityList;

public class JPanelGame extends JPanel {

	private static final Image IMAGE_MARRANIN = new ImageIcon("src/images/marranin.png").getImage();
	private static final Image IMAGE_LORD = new ImageIcon("src/images/lord.png").getImage();
	private static final Image IMAGE_BEES = new ImageIcon("src/images/abeja.png").getImage();
	private static final Image IMAGE_MON = new ImageIcon("src/images/mon.png").getImage();
	private static final Image IMAGE_FON = new ImageIcon("src/images/fon2.jpg").getImage();
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
		g.setFont(new Font("Century Gothic", 1,16));
		
		g.drawImage(IMAGE_FON, 0, 0, this.getWidth(), this.getHeight() , this);
		g.drawImage(IMAGE_MON, this.getWidth()- 200, this.getHeight() - 480, 200, 500 , this);
		
		
		g.drawString("Duque", this.getWidth()- 950, this.getHeight() - 620);
		g.fillRect(this.getWidth()- 900, this.getHeight() - 640, 200, 20);
		
		g.drawString("Petro", this.getWidth()- 950, this.getHeight() - 590);
		g.fillRect(this.getWidth()- 900, this.getHeight() - 610, 200, 20);
		
		if (enemy.getPositionInX() >0 && enemy.getPositionInX() < 1000 && enemy != null) {
			g.drawImage(IMAGE_LORD, enemy.getPositionInX(), enemy.getPositionInY(), 150, 150, this);
		}
		
		g.drawImage(IMAGE_MARRANIN,  area.getX(), this.getHeight() - 150, 150, 150, this);
		for (User user : users) {
			g.drawImage(imagePlayer.getImage(), user.getPositionX(), this.getHeight() - 150, 150, 150 , this);
			g.drawString(user.getName(), area.getX() + 20, this.getHeight() - 150);
		}
		
		for (int i = 0; i < bees.size(); i++) {
			if (bees.get(i).getType() == 3) {
				g.drawImage(IMAGE_BEES, bees.get(i).getX(), bees.get(i).getY(), 50, 50, this);
			} else if (bees.get(i).getType() == 1) {
				g.drawImage(IMAGE_BEES, bees.get(i).getX(), bees.get(i).getY(), 50, 50,  this);
			} else {
				g.drawImage(IMAGE_BEES, bees.get(i).getX(), bees.get(i).getY(), 50, 50,  this);
			}
		}
		
		
	}
	
	public int getSizeWindowInX() {
		return this.getWidth();
	}
}