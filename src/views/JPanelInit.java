package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelInit extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public JPanelInit() {
		setBackground(Color.WHITE);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 11; i++) {
			c.gridx = i;
			add(new JLabel(""), c);
		}
		
		c.gridy = 1;
		c.weighty = 1;
		c.gridx = 5; 
		c.gridwidth= 1;
		add(new JPanelInitComponents(), c);
	}
}