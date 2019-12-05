import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the view of the planner application
 * @author Akshat Bansal
*/
public class View extends JFrame{
  /**
   * Constructs a view for the given model
   * @param model the data model
  */
  public View(Model model){
    this.model = model;
    try{
			navigationPanel = new NavigationPanel();
			howToPanel = new HowToPanel();
			schedulerPanel = new SchedulerPanel();
			journalPanel = new JournalPanel();
			aboutPanel = new AboutPanel();

			splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationPanel, schedulerPanel);
			splitPane.setOneTouchExpandable(true);

			add(splitPane);
      setVisible(true);
			pack();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
  }

  private class NavigationPanel extends JPanel{
		public NavigationPanel(){
			setLayout(new GridLayout(NUM_ROWS, NUM_COLS));

			howToBtn = new JButton(HOW_TO_BTN_LABEL);
			schedulerBtn = new JButton(SCHEDULER_BTN_LABEL);
			journalBtn = new JButton(JOURNAL_BTN_LABEL);
			aboutBtn = new JButton(ABOUT_BTN_LABEL);

			add(howToBtn);
			add(schedulerBtn);
			add(journalBtn);
			add(aboutBtn);

      setVisible(true);
		}

    howToBtn.addActionListener(new
			ActionListener(){
				public void actionPerformed(ActionEvent event){
					splitPane.setRightComponent(howToPanel);
				}
			});
	  schedulerBtn.addActionListener(new
			 ActionListener(){
				public void actionPerformed(ActionEvent event){
					splitPane.setRightComponent(schedulerPanel);
				}
			});
		journalBtn.addActionListener(new
			ActionListener(){
				public void actionPerformed(ActionEvent event){
					splitPane.setRightComponent(journalPanel);
				}
			});
		aboutBtn.addActionListener(new
			ActionListener(){
				public void actionPerformed(ActionEvent event){
					splitPane.setRightComponent(aboutPanel);
				}
			});

		private JButton howToBtn;
		private JButton schedulerBtn;
		private JButton journalBtn;
		private JButton aboutBtn;

    private final static int NUM_ROWS = 4;
    private final static int NUM_COLS = 1;
    private final static String HOW_TO_BTN_LABEL = "How to";
    private final static String SCHEDULER_BTN_LABEL = "Scheduler";
    private final static String JOURNAL_BTN_LABEL = "Journal";
    private final static String ABOUT_BTN_LABEL = "About";
	}

  /**
  * Attaches an action listener to the add button in the scheduler panel
  */
  public void addSchedulerPanelAddBtnListener(ActionListener e){
    schedulerPanel.getRightPanel().getButtonPanel().getAddBtn().addActionListener(e);
  }

  /**
   * Attaches an action listener to the clock in button in the scheduler panel
  */
  public void addSchedulerPanelCloclInBtnListener(ActionListener e){
      schedulerPanel.getRightPanel().getButtonPanel().getClockInBtn().addActionListener(e);
  }


  /**
   * Returns the data model represented by this view
   * @return model
  */
  public Model getModel(){
    return model;
  }

  /**
   * Updates the UI components according to changes in database
  */
  public void update(){
    schedulerPanel.update();
    journalPanel.update();
  }

  private Model model;
  private JPanel navigationPanel;
  private JPanel howToPanel;
  private JPanel schedulerPanel;
  private JPanel journalPanel;
  private JPanel aboutPanel;
  private JSplitPane splitPane;
}
