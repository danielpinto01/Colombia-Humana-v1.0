package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.Controller;
import controllers.Events;

public class JDialogInitPlayer extends JDialog{

	private static final long serialVersionUID = 1L;
	private JLabel lbInformation;
	private JTextField txtNamePlayer;
	private JButton btnAddPlayer;
	
	public JDialogInitPlayer(MainWindow mainWindow, Controller controller) {
		super(mainWindow, true);
		setTitle("Agregar Jugador");
		setSize(320, 200);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new GridLayout(3, 1));;
		setLocationRelativeTo(null);
		
		init(controller);
	}
	
	public void init(Controller controller) {
		
		lbInformation = new JLabel("Nombre:");
		lbInformation.setFont(new Font("Century Gothic", 0,16));
		lbInformation.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbInformation);
		
		txtNamePlayer= new JTextField(12);
		txtNamePlayer.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		txtNamePlayer.setBackground(Color.WHITE);
		add(txtNamePlayer);
		
		btnAddPlayer = new JButton("Agregar");
		btnAddPlayer.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAddPlayer.setBackground(Color.decode("#f5cb18"));
		btnAddPlayer.setForeground(Color.WHITE);
		btnAddPlayer.setFont(new Font("Century Gothic", 0,16));
		btnAddPlayer.setFocusable(false);
		btnAddPlayer.addActionListener(controller);
		btnAddPlayer.setActionCommand(Events.ADD_PLAYER.toString());
		add(btnAddPlayer);
	}
	
	public String getNamePlayer() {
		return txtNamePlayer.getText();
	}
}