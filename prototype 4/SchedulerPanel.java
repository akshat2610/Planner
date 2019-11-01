import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SchedulerPanel extends JPanel{
	public SchedulerPanel(){
		infoPanel = new InfoPanel();
		buttonPanel = new ButtonPanel();

		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());

		c.fill = GridBagConstraints.BOTH;
		c.weightx = FRACTIONAL_INFO_PANEL_WIDTH;
		c.weighty = FRACTIONAL_INFO_PANEL_HEIGHT;
		add(infoPanel, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = FRACTIONAL_BUTTON_PANEL_WIDTH;
		c.weighty = FRACTIONAL_BUTTON_PANEL_HEIGHT;
		add(buttonPanel, c);

		setVisible(true);
	}

	private JPanel infoPanel;
	private JPanel buttonPanel;

	public final static double FRACTIONAL_INFO_PANEL_WIDTH = 1;
	public final static double FRACTIONAL_INFO_PANEL_HEIGHT = 0.7;
	public final static double FRACTIONAL_BUTTON_PANEL_WIDTH = 1;
	public final static double FRACTIONAL_BUTTON_PANEL_HEIGHT = 0.3;	
}