import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models an individual container for the task name panel and the associated CRUD options panels
 * @author Akshat Bansal
*/
public class ActivityPanel extends JPanel{
	/**
	 * Constructs an instance of the activityPanel with the given activity name.
	 * @param activityName name of the activity
	*/
	public ActivityPanel(String activityName){
		activityNamePanel = new ActivityNamePanel(activityName);
		optionsPanel = new OptionsPanel();

		optionsPanel.setActivityPanel(this);
		optionsPanel.setListPanel(parentListPanel);

		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());

		c.fill = GridBagConstraints.BOTH;
		c.weightx = ACTIVITY_NAME_PANEL_WIDTH_RATIO;
		c.weighty = ACTIVITY_NAME_PANEL_HEIGHT_RATIO;
		add(activityNamePanel, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = OPTIONS_PANEL_WIDTH_RATIO;
		c.weighty = OPTIONS_PANEL_HEIGHT_RATIO;
		add(optionsPanel, c);

		setVisible(true);
	}

	/**
	 * Returns the activity name panel contained by this activity panel
	 * @return activityNamePanel the activity name panel contained by this activity panel
	*/
	public JPanel getActivityNamePanel(){
		return activityNamePanel;
	}

	/**
	 * Returns the list panel which contains this activity panel
	 * @return parentListPanel the list panel which contains this activity panel
	*/
	public JPanel getParentListPanel(){
		return parentListPanel;
	}

	/**
	 * Sets the parent list panel instance variable equal to the argument
	 * @param parentListPanel
	*/
	public void setParentListPanel(JPanel parentListPanel){
		this.parentListPanel = parentListPanel;
	}

	public final static double ACTIVITY_NAME_PANEL_WIDTH_RATIO = 0.7;
	public final static double OPTIONS_PANEL_WIDTH_RATIO = 0.3;
	public final static double ACTIVITY_NAME_PANEL_HEIGHT_RATIO = 1;
	public final static double OPTIONS_PANEL_HEIGHT_RATIO = 1;

	private JPanel activityNamePanel;
	private OptionsPanel optionsPanel;
	private JPanel parentListPanel;
}
