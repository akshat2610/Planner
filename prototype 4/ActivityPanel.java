import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
	Models an individual container for the task name panel and the associated CRUD options panels
*/
public class ActivityPanel extends JPanel{
	public ActivityPanel(String activityName){
		activityNamePanel = new ActivityNamePanel(activityName);
		optionsPanel = new OptionsPanel();

		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.7;
		c.weighty = 1;
		add(activityNamePanel, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.3;
		c.weighty = 1;
		add(optionsPanel, c);

		setVisible(true);
	}

	private JPanel activityNamePanel;
	private JPanel optionsPanel;
}