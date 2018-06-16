package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import controllers.Controller;
import controllers.Events;

public class JDialogInitPlayer extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTextField txtNamePlayer;
	private JTextField txtCharacterPlayer;
	private JButton btnAddPlayer;
	
	public JDialogInitPlayer(MainWindow mainWindow, Controller controller) {
		super(mainWindow, true);
		setTitle("Agregar Jugador");
		setSize(500, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		init(controller);
	}
	
	public void init(Controller controller) {
		txtNamePlayer= new JTextField(12);
		txtNamePlayer.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		txtNamePlayer.setBorder(BorderFactory.createTitledBorder("Nombre:"));
		txtNamePlayer.setBackground(Color.WHITE);
		add(txtNamePlayer);
		
		txtCharacterPlayer= new JTextField(12);
		txtCharacterPlayer.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		txtCharacterPlayer.setBorder(BorderFactory.createTitledBorder("Personaje:"));
		txtCharacterPlayer.setBackground(Color.WHITE);
		add(txtCharacterPlayer);
		
		btnAddPlayer = new JButton("Agregar");
		btnAddPlayer.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAddPlayer.setBackground(Color.decode("#f5cb18"));
		btnAddPlayer.setForeground(Color.WHITE);
		btnAddPlayer.setFont(new Font("Century Gothic", 0,16));
		btnAddPlayer.setFocusable(false);
//		btnAddPlayer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnAddPlayer.addActionListener(controller);
		btnAddPlayer.setActionCommand(Events.ADD_PLAYER_TO_LIST.toString());
		add(btnAddPlayer);
	}
	
	public String getNamePlayer() {
		return txtNamePlayer.getText();
	}
	
	public String getCharacterPlayer() {
		return txtCharacterPlayer.getText();
	}
}