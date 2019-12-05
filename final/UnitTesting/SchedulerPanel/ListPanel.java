import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


/**
 * Models a top-level container for individual activity panels
 * @author Akshat Bansal
*/
public class ListPanel extends JPanel{
	/**
	 * Constructs an instance of the ListPanel
	*/
	public ListPanel(View parentView, String label){
		this.parentView = parentView;
		header = new JLabel(label);
		activityPanels = new ArrayList<>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		//vertical arrangement of activity panels
		add(header);
		setBackground(new Color(204, 226, 227));
		setVisible(true);

		load();
	}

	public void refresh(){
		load();
		for (ActivityPanel activityPanel: activityPanels)
			activityPanel.refresh();

		revalidate();
		repaint();
	}

	public void load(){
		removeAll();
		activityPanels.clear();
		repaint();
		revalidate();

		Set<Task> unfinished = parentView.getModel().getUnfinishedTasks();
		for (Task t: unfinished){
			ActivityPanel activityPanel = new ActivityPanel(parentView, t);
			activityPanels.add(activityPanel);
			add(activityPanel);
		}
		revalidate();
		repaint();
	}

	private View parentView;
	private JLabel header;
	private final ArrayList<ActivityPanel> activityPanels;
}
