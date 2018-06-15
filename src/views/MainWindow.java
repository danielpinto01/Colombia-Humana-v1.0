package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Colombia Humana v1.0";
	private static final String URL_ICON = "src/images/icon.jpg";
	
	private JPanelInit jPanelInit;
	
	private JDialogInitPlayer jDialogInitPlayer;
	
	public MainWindow(Controller controller) {
		setTitle(TITLE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.WHITE);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(URL_ICON).getImage());
		
		jDialogInitPlayer = new JDialogInitPlayer(this, controller);
		
		jPanelInit = new JPanelInit(controller);
		add(jPanelInit, BorderLayout.CENTER);

		setVisible(true);
	}
	
	public void showDialogInitPlayer() {
		jDialogInitPlayer.setVisible(true);
	}
	
	public void ocultDialogInitPlayer() {
		jDialogInitPlayer.setVisible(false);
	}
	
	public String getNamePlayer() {
		return jDialogInitPlayer.getNamePlayer();
	}
	
	public String getCharacterPlayer() {
		return jDialogInitPlayer.getCharacterPlayer();
	}
}