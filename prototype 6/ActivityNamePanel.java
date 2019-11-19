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
		setLayout(new GridLayout(PANEL_NUM_ROWS, PANEL_NUM_COLS));
		activityNameLabel = new JLabel(activityName);
		add(activityNameLabel);
		setVisible(true);
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

	private JLabel activityNameLabel;
	public final static int PANEL_NUM_ROWS = 1;
	public final static int PANEL_NUM_COLS = 1;
}
