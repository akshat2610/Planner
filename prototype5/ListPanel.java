import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


/**
	Models a top-level container for individual activity panels
*/
public class ListPanel extends JPanel{
	public ListPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		//vertical arrangement of activity panels
		setVisible(true);
		
		activityPanels = new ArrayList<>();
	}

	private final List<ActivityPanel> activityPanels;
}