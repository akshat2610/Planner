import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the scheduler panel in the main frame of the planner application
 * @author Akshat Bansal
*/
public class SchedulerPanel extends JPanel{
  /**
   * Constructs an instance of the Scheduler panel
  */
  public SchedulerPanel(){
    schedulerTopPanel = new SchedulerTopPanel();
    schedulerBottomPanel = new SchedulerBottomPanel();

    GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());

		c.fill = GridBagConstraints.BOTH;
		c.weightx = TOP_PANEL_WIDTH_RATIO;
		c.weighty = TOP_PANEL_HEIGHT_RATIO;
		add(schedulerTopPanel, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = BOTTOM_PANEL_WIDTH_RATIO;
		c.weighty = BOTTOM_PANEL_HEIGHT_RATIO;
		add(schedulerBottomPanel, c);

		setVisible(true);
  }

  public static void main(String[] args){
    JFrame app = new JFrame("Tester for Scheduler Panel");
    JPanel schedulerPanel = new SchedulerPanel();
    app.setLayout(new FlowLayout());
    app.add(schedulerPanel);

    app.setVisible(true);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.pack();
  }

  /**
   * Models the main panel
   * @author Akshat Bansal
  */
  public class SchedulerBottomPanel extends JPanel{
    public SchedulerBottomPanel(){
      schedulerLeftPanel = new SchedulerLeftPanel();
      schedulerRightPanel = new SchedulerRightPanel();

      setLayout(new GridLayout(1, 2));
      add(schedulerLeftPanel);
      add(schedulerRightPanel);
      setVisible(true);
    }

    private JPanel schedulerLeftPanel;
    private JPanel schedulerRightPanel;
  }
  



  public final static double TOP_PANEL_WIDTH_RATIO = 1;
  public final static double TOP_PANEL_HEIGHT_RATIO = 0.2;
  public final static double BOTTOM_PANEL_WIDTH_RATIO = 1;
  public final static double BOTTOM_PANEL_HEIGHT_RATIO = 0.8;

  private JPanel schedulerTopPanel;
  private JPanel schedulerBottomPanel;
}
