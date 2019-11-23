import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the options panel for each activity
 * @author Akshat Bansal
*/
public class OptionsPanel extends JPanel{

	/**
	 * Constructs an instance of the options panel
	*/
	public OptionsPanel(){
		setLayout(new GridLayout(PANEL_NUM_ROWS, PANEL_NUM_COLS));

		try{
			deleteBtn = new JButton(new ImageIcon("./images/buttons/delete.png"));
			editBtn = new JButton(new ImageIcon("./images/buttons/edit.png"));
			completeBtn = new JButton(new ImageIcon("./images/buttons/complete.png"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		deleteBtn.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		editBtn.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		completeBtn.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

		add(deleteBtn);
		add(editBtn);
		add(completeBtn);

		setVisible(true);
	}

	/**
	 * Returns the activity panel associated with this options panel
	 * @return activityPanel activity panel associated with this options panel
	*/
  public JPanel getActivityPanel(){
		return activityPanel;
	}

	/**
	 * Returns the list panel associated with this options panel
	 * @return listPanel the list panel associated with this options panel
	*/
	public JPanel getListPanel(){
		return listPanel;
	}

	/**
	 * Sets the activityPanel instance variable equal to the argument
	 * @param activityPanel
	*/
	public void setActivityPanel(JPanel activityPanel){
		this.activityPanel = activityPanel;
	}

	/**
	 * Sets the list panel instance variable equal to the argument
	 * @param listPanel
	*/
	public void setListPanel(JPanel listPanel){
		this.listPanel = listPanel;
	}

	public final static int PANEL_NUM_COLS = 3;
	public final static int PANEL_NUM_ROWS = 1;
	public final static int BUTTON_WIDTH = 25;
	public final static int BUTTON_HEIGHT = 25;

	private JButton deleteBtn;
	private JButton editBtn;
	private JButton completeBtn;
	private JPanel activityPanel;
	private JPanel listPanel;
}
