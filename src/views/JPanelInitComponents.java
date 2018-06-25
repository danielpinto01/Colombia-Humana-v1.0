package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Controller;
import controllers.Events;

public class JPanelInitComponents extends JPanel{

	private static final long serialVersionUID = 1L;
	private ImageIcon imgIconMain;
	private JLabel lbImageIconMain;
	private JButton btnCheckIn;
	private JButton btnInitGame;
	private JPanel pnlExit;
	private ImageIcon imgIconExit;
	private JButton btnImageIconExit;
	
	public JPanelInitComponents(Controller controller) {
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		init(controller);
	}
	
	public void init(Controller controller) {
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 0; i++) {
			c.gridx = i;
			add(new JLabel(""), c);
		}
		c.gridy = 1; //Inicia en Y
		c.weighty = 1;//Alto
		c.gridx = 3; //Inicia en X
		c.gridwidth= 1; //Ancho
		c.insets = new Insets(50, 0, 0, 0);
		imgIconMain = new ImageIcon("src/images/icon.jpg");
		lbImageIconMain = new JLabel(imgIconMain); 
		add(lbImageIconMain, c);
		
		
		c.gridy = 2; //Inicia en Y
		c.weighty = 1;//Alto
		c.gridx = 3; //Inicia en X
		c.gridwidth= 1; //Ancho
		c.insets = new Insets(10, 0, 0, 0);
		btnInitGame = new JButton("Tienda");
		btnInitGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnInitGame.setBackground(Color.decode("#89c037"));
		btnInitGame.setForeground(Color.WHITE);
		btnInitGame.setFont(new Font("Century Gothic", 0,16));
		btnInitGame.setFocusable(false);
		btnInitGame.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnInitGame.addActionListener(controller);
		btnInitGame.setActionCommand(Events.INIT_GAME.toString());
//		add(btnInitGame, c);
		
		c.gridy = 3; //Inicia en Y
		c.weighty = 1;//Alto
		c.gridx = 3; //Inicia en X
		c.gridwidth= 1; //Ancho
		c.insets = new Insets(20, 0, 0, 0);
		btnCheckIn = new JButton("Iniciar juego");
		btnCheckIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCheckIn.setBackground(Color.decode("#f5cb18"));
		btnCheckIn.setForeground(Color.WHITE);
		btnCheckIn.setFont(new Font("Century Gothic", 0,16));
		btnCheckIn.setFocusable(false);
		btnCheckIn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnCheckIn.addActionListener(controller);
		btnCheckIn.setActionCommand(Events.SHOW_DIALOG_INIT_PLAYER.toString());
		add(btnCheckIn, c);
		
		
		c.gridy = 4; //Inicia en Y
		c.weighty = 1;//Alto
		c.gridx = 3; //Inicia en X
		c.gridwidth= 1; //Ancho
		c.insets = new Insets(50, 0, 0, 0);
		imgIconExit = new ImageIcon("src/images/exit.png");
		btnImageIconExit = new JButton(imgIconExit);
		btnImageIconExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnImageIconExit.setBackground(Color.WHITE);
		btnImageIconExit.setFocusable(false);
		btnImageIconExit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnImageIconExit.addActionListener(controller);
		btnImageIconExit.setActionCommand(Events.EXIT_APP.toString());
		pnlExit = new JPanel();
		pnlExit.setBackground(Color.WHITE);
		pnlExit.add(btnImageIconExit);
		add(pnlExit, c);
	}
}
