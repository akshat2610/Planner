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
  public SchedulerRightPanel(){
    setLayout(new GridLayout(2, 1));
    Color mon = new Color(255, 135, 135);
    Color tue = new Color(89, 186, 255);
    Color wed = new Color(154, 145, 255);
    Color thu = new Color(255, 179, 247);
    Color fri = new Color(255, 153, 94);
    graphPanel = new BarGraph("No. of Hours",
                              new double[]{20,30,12,23,43},
                              new String[]{"M","T","W","Th","F"},
                              new Color[] {mon, tue, wed, thu, fri},"SAMPLE" ) ;
    //Color.red, Color.blue, Color.green,Color.LIGHT_GRAY,Color.MAGENTA,Color.DARK_GRAY,Color.orange
    buttonPanel = new ButtonPanel();

    //graphPanel.setBackground(new Color(230, 255, 250));
    graphPanel.setBackground(new Color(74, 74, 74));

    add(graphPanel);
    add(buttonPanel);
    setVisible(true);
  }

  private JPanel graphPanel;
  private JPanel buttonPanel;
}
