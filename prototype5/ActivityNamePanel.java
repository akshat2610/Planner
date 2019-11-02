import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
	Models an individual container for activity name
*/
public class ActivityNamePanel extends JPanel{
	public ActivityNamePanel(String activityName){
		setLayout(new FlowLayout());
		activityNameLabel = new JLabel(activityName);
		add(activityNameLabel);
		setVisible(true);
	}

	private JLabel activityNameLabel;
}