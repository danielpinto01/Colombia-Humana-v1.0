package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Controller;
import controllers.Events;

public class JPanelHistory extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel lbHistory;
	private JPanel pnlNext;
	private ImageIcon imgIconNext;
	private JButton btnImageIconNext;

	public JPanelHistory(Controller controller) {
		setBackground(Color.GRAY);
		setLayout(new BorderLayout());
		init(controller);
		
//		setVisible(true);
	}
	
	public void init(Controller controller) {
		lbHistory = new JLabel("Historia :v");
		add(lbHistory, BorderLayout.CENTER);
		
		imgIconNext = new ImageIcon("src/images/next.png");
		btnImageIconNext = new JButton(imgIconNext);
		btnImageIconNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnImageIconNext.setBackground(Color.WHITE);
		btnImageIconNext.setFocusable(false);
		btnImageIconNext.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//		btnImageIconNext.addActionListener(controller);
//		btnImageIconNext.setActionCommand(Events.EXIT_APP.toString());
		pnlNext = new JPanel();
		pnlNext.setBackground(Color.WHITE);
		pnlNext.add(btnImageIconNext);
		add(pnlNext, BorderLayout.SOUTH);
	}
}