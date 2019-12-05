import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the panel with the graph and the buttons on the scheduler panel
 * @author Akshat Bansal
*/
public class SchedulerRightPanel extends JPanel{
  /**
   * Constructs an instance of the SchedulerRightPanel
  */
  public SchedulerRightPanel(View parentView){
    this.parentView = parentView;

    Color mon = new Color(255, 135, 135);
    Color tue = new Color(89, 186, 255);
    Color wed = new Color(154, 145, 255);
    Color thu = new Color(255, 179, 247);
    Color fri = new Color(255, 153, 94);
    graphPanel = new BarGraph("",
                              new double[]{20,30,12,23,43},
                              new String[]{"M","T","W","Th","F"},
                              new Color[] {mon, tue, wed, thu, fri}, GRAPH_TITLE) ;

    graphPanel.setBackground(new Color(74, 74, 74));
    buttonPanel = new ButtonPanel(parentView);

    setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    add(graphPanel);
    add(buttonPanel);
    setVisible(true);
  }

  /**
   * Returns the graph panel
   * @return graphPanel
  */
  public JPanel getGraphPanel(){
    return graphPanel;
  }

  /**
   * Returns the button panel
   * @return buttonPanel
  */
  public JPanel getButtonPanel(){
    return buttonPanel;
  }

  private JPanel graphPanel;
  private JPanel buttonPanel;
  private View parentView;

  private final static int NUM_ROWS = 2;
  private final static int NUM_COLS = 1;
  private final static String GRAPH_TITLE = "Workload per day";
}
