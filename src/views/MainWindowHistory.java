package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Controller;
import controllers.Events;

public class MainWindowHistory extends JFrame{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Controller controller;
	
	private JPanel JPanelHistory;
	
	private JLabel lbHistory;
	private JPanel pnlNext;
	private ImageIcon imgIconNext;
	private JButton btnImageIconNext;
	
	private ImageIcon image;
	public MainWindowHistory(Controller controller) {
		this.controller = controller;
		setTitle("Colombia Humana v1.0");
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource("/images/icon.jpg")).getImage());
		setSize(1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);
		setResizable(false);
		

		
		imgIconNext = new ImageIcon("src/images/next.png");
		btnImageIconNext = new JButton(imgIconNext);
		btnImageIconNext.setBackground(Color.WHITE);
		btnImageIconNext.setFocusable(false);
		btnImageIconNext.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnImageIconNext.addActionListener(controller);
		btnImageIconNext.setActionCommand(Events.EXIT_HISTORY.toString());
		pnlNext = new JPanel();
		pnlNext.setBackground(Color.WHITE);
		pnlNext.add(btnImageIconNext);
		
		image = new ImageIcon("src/images/history.png");
		lbHistory = new JLabel(image);
		lbHistory.setBackground(Color.WHITE);
		
		JPanelHistory = new JPanel();
		JPanelHistory.setLayout(new BorderLayout());
		JPanelHistory.add(lbHistory, BorderLayout.CENTER);
		JPanelHistory.add(pnlNext, BorderLayout.SOUTH);
		add(JPanelHistory, BorderLayout.CENTER);
	}

}
