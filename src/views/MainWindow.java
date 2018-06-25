package views;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller;
	
	private JDialogInformationInit jDialogInformationInit;
	
	private JDialogInitPlayer jDialogInitPlayer;
	
	private JPanelInit jPanelInit;
	private JDialogLoading jDialogLoading;

	public MainWindow(Controller controller) {
		this.controller = controller;
		setTitle("Colombia Humana v1.0");
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource("/images/icon.jpg")).getImage());
		setSize(1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setResizable(false);
		
		jDialogInformationInit = new JDialogInformationInit(controller, this);
		jDialogInitPlayer = new JDialogInitPlayer(this, controller);
		jDialogLoading = new JDialogLoading();
		
	}
	
	public void showPanelInit() {
		jPanelInit = new JPanelInit(controller);
		add(jPanelInit, BorderLayout.CENTER);
		getContentPane().repaint();		
		getContentPane().revalidate();
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

//	public void init(Player player, ArrayList<User> users) {
//		jDialogLoading.setVisible(false);
//		getContentPane().removeAll();
//		panelGame = new JPanelGame(controller, player.getArea(), users);
//		add(panelGame, BorderLayout.CENTER);
//		getContentPane().repaint();		 
//		getContentPane().revalidate();
//		setVisible(true);
//	}
	
	public void showDialogLoading() {
		jDialogLoading.setVisible(true);
	}
	
	public void ocultDialogLoading() {
		jDialogLoading.setVisible(false);
	}
	
	public void showDialogInformationInit() {
		jDialogInformationInit.setVisible(true);
	}
	
	public void ocultDialogInformationInit() {
		jDialogInformationInit.setVisible(false);
	}
	
	public String getIp() {
		return jDialogInformationInit.getIp();
	}
	
	public int getPort() {
		return jDialogInformationInit.getPort();
	}
	
//	public void paintGame() {
//		panelGame.repaint();
//		revalidate();
//	}
}