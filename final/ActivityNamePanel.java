import java.awt.*;
import javax.swing.*;

/**
 * Models a container for activity name
 * @author Akshat Bansal
*/
public class ActivityNamePanel extends JPanel{
	/**
	 * Constructs an instance of the activity name panel
	 * @param activityName name of the activity
	*/
	public ActivityNamePanel(String activityName){
		this.activityName = activityName;

		setLayout(new GridLayout(PANEL_NUM_ROWS, PANEL_NUM_COLS));
		setBackground(new Color(74, 74, 74));

		taskProgressBar = new JProgressBar(0, 100);
		taskProgressBar.setStringPainted(true);
		taskProgressBar.setString(activityName);
		Color color = new Color(50, 168, 82);
		taskProgressBar.setStringPainted(true);

		taskProgressBar.setValue(69);
		add(taskProgressBar);
		setVisible(true);
	}

	/**
	 * Sets the value of the progres bar
	 * @param val the value to be set for the progress bar
	*/
	public void setProgressBarValue(int val){
		taskProgressBar.setValue(val);
	}


	public String getActivityName(){
		return activityName;
	}

	/**
	 * Tester for activity panel. Test here for different layouts and sizes
	*/
	public static void main(String[] args){
		JFrame app = new JFrame("Tester for activity panel");
		JPanel activityPanel1 = new ActivityPanel("Study 157A");
		JPanel activityPanel2 = new ActivityPanel("CHOOSE 174 project");

		app.setLayout(new GridLayout(2, 1));
		app.add(activityPanel1);
		app.add(activityPanel2);

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		app.pack();
	}

	private JProgressBar taskProgressBar;
	private String activityName;
	public final static int PANEL_NUM_ROWS = 1;
	public final static int PANEL_NUM_COLS = 1;
}
