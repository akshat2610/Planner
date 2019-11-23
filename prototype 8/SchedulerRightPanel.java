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
    graphPanel = new BarGraph("No. of Hours",new double[]{0,20,30,12,23,43,12,10},new String[]{"","Mon","Tue","Wed","Thur","Fri","Sat","Sun"},new Color[] {new Color(0,0,0,0),Color.red, Color.blue, Color.green,Color.LIGHT_GRAY,Color.MAGENTA,Color.DARK_GRAY,Color.orange},"SAMPLE" ) ;
    buttonPanel = new ButtonPanel();

    graphPanel.setBackground(new Color(21, 47, 53));

    add(graphPanel);
    add(buttonPanel);
    setVisible(true);
  }

  private JPanel graphPanel;
  private JPanel buttonPanel;
}
