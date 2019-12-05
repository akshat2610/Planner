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
		setBackground(new Color(74, 74, 74));
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

		/**
     * 1) Show the confirm dialog box
     * 2) If user clicks cancel --> do nothing
     * 2.1) Else
     * 3 Remove the task from the unifinished set
     * 4) Remove it from the list
     * 5) Recompute priorities
     * 6) Commit changes to database
     * 7) Reload data structures from the database
     * 8) Update other UI components
     * @param activityPanel the activity panel of which this button is a part of
     * @return the action listener for the delete button
    */
		deleteBtn.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int userChoice = JOptionPane.showConfirmDialog(null, null, "Click OK to DELETE this task", JOptionPane.OK_CANCEL_OPTION);
					if (userChoice == JOptionPane.OK_OPTION){
						JPanel listPanel = activityPanel.getParentListPanel();
						String taskName = activityPanel.getActivityNamePanel().getActivityName();
						Set<Task> unfinishedTasks = model.getUnfinishedTasks();

						Task toRemove = new Task();
						for (Task t: unfinishedTasks){
							if (t.getName().equals(taskName)){
								toRemove = t;
								break;
							}
						}

						unfinishedTasks.remove(toRemove);
						listPanel.remove(activityPanel);
						listPanel.revalidate();
						listPanel.repaint();

						model.commitChanges();
						model.loadFromDatabase();
						view.update();
					}
				}
			}
		);

		/**
     * 1) Show the confirm dialog box
     * 2) If user clicks cancel --> do nothing
     * 2.1) Else
     * 3 Remove the task from the unifinished set
     * 4) Remove it from the list
     * 5) Recompute priorities
     * 6) Commit changes to database
     * 7) Reload data structures from the database
     * 8) Update other UI components
    */
		editBtn.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
          int userChoice = JOptionPane.showConfirmDialog(null, taskInputPanel, taskInputPanelLabel, JOptionPane.OK_CANCEL_OPTION);
          if (userChoice == JOptionPane.OK_OPTION){
            Task task = new Task(taskInputPanel.getName(), taskInputPanel.getCategory(), 0, taskInputPanel.getNumHrs(),
                                    taskInputPanel.getPriority(), taskInputPanel.getDeadline(), taskInputPanel.getNote());
            JPanel listPanel = activityPanel.getParentListPanel();
            String taskName = activityPanel.getActivityNamePanel().getActivityName();
            Set<Task> unfinishedTasks = model.getUnfinishedTasks();

            Task toRemove = new Task();
            for (Task t: unfinishedTasks){
              if (t.getName().equals(taskName)){
                toRemove = t;
                break;
              }
            }

            unfinishedTasks.remove(toRemove);
            unfinishedTasks.add(task);
            listPanel.remove(activityPanel);
            listPanel.revalidate();
            listPanel.repaint();

            model.commitChanges();
            model.loadFromDatabase();
            view.update();
          }
        }
			}
		);


		completeBtn.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//complete button functionality here
				}
			}
		);

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
	private View parentView;
}
