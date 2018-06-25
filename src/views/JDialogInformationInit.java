package views;

import java.awt.Color;
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

public class JDialogInformationInit extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbIp;
	private JLabel lbPort;
	private JTextField txtIp;
	private JTextField txtPort;
	private JButton btnInit;
	
	public JDialogInformationInit(Controller controller, MainWindow mainWindow) {
		super(mainWindow, true);
		setLayout(new GridLayout(5, 1));
		setBackground(Color.WHITE);
		setTitle("Colombia Humana v1.0");
		setSize(320, 200);
		setLocationRelativeTo(null);
		
		lbIp = new JLabel("Ingrese direccion IP: ");
		lbIp.setBackground(Color.GRAY);
		lbIp.setHorizontalAlignment(SwingConstants.CENTER);
		lbIp.setFont(new Font("Century Gothic", 0, 18));
		add(lbIp);
		
		txtIp = new JTextField("0");
		txtIp.setFont(new Font("Century Gothic", 2, 16));
		txtIp.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); 
		add(txtIp);
		
		lbPort = new JLabel("Ingrese el puerto: ");
		lbPort.setBackground(Color.GRAY);
		lbPort.setHorizontalAlignment(SwingConstants.CENTER);
		lbPort.setFont(new Font("Century Gothic", 0, 18));
		add(lbPort);
		
		txtPort = new JTextField("2000");
		txtPort.setFont(new Font("Century Gothic", 2, 16));
		txtPort.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); 
		add(txtPort);
		
		btnInit = new JButton("Iniciar");
		btnInit.setBackground(Color.GRAY);
		btnInit.setForeground(Color.WHITE);
		btnInit.setFont(new Font("Century Gothic", 0, 18));
		btnInit.setFocusable(false);
		btnInit.addActionListener(controller);
		btnInit.setActionCommand(Events.INIT_APP.toString());
		add(btnInit);
	}
	
	public String getIp() {
		return txtIp.getText();
	}
	
	public int getPort() {
		return Integer.parseInt(txtPort.getText());
	}
}