package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class JDialogInitPlayer extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTextField txtNamePlayer;
	private JTextField txtCharacterPlayer;
	private JButton btnAddPlayer;
	
	public JDialogInitPlayer(MainWindow mainWindow) {
		super(mainWindow, true);
		setTitle("Agregar Jugador");
		setSize(500, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		init();
	}
	
	public void init() {
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
		btnAddPlayer.setBackground(Color.BLUE);
		btnAddPlayer.setForeground(Color.WHITE);
		btnAddPlayer.setFont(new Font("Arial", 1, 12));
//		btnAddPlayer.addActionListener(controlador);
//		btnAddPlayer.setActionCommand(Eventos.AGREGAR_USUARIOS_A_LA_LISTA_DE_USUARIOS.toString());
		add(btnAddPlayer);
	}
	
	public String getNamePlayer() {
		return txtNamePlayer.getText();
	}
	
	public String getCharacterPlayer() {
		return txtCharacterPlayer.getText();
	}
}