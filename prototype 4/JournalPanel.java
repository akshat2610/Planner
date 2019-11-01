import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class JournalPanel extends JPanel{
	public JournalPanel() throws IOException{
		infoPanel = new InfoPanel();
		buttonPanel = new ButtonPanel();

		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 0.7;
		add(infoPanel, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 0.3;
		add(buttonPanel, c);

		setVisible(true);
	}
	


	private InfoPanel infoPanel;
	private ButtonPanel buttonPanel;
}