package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class JDialogLoading extends JDialog{

	private static final long serialVersionUID = 1L;
	private JLabel lbLoading;
	private ImageIcon image;
	
	public JDialogLoading() {
		setBackground(Color.WHITE);
		setTitle("Loading...");
		setSize(500, 400);
		setUndecorated(true);
		setLocationRelativeTo(null);
		image = new ImageIcon(getClass().getResource("/images/loading.gif"));
		lbLoading = new JLabel(image);
		add(lbLoading);
	}
}