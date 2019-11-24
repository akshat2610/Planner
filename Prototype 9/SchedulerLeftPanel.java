import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the wall with all the list panels in the scheduler panel
 * @author Akshat Bansal
*/
public class SchedulerLeftPanel extends JPanel{

  public SchedulerLeftPanel(){

    //setBackground(new Color(22, 226, 124));
    todayListPanel            = new ListPanel("TODAY");
    tomorrowListPanel         = new ListPanel("TOMORROW");

    setLayout(new GridLayout(2, 2));

    add(todayListPanel);
    add(tomorrowListPanel);

    setVisible(true);
  }

  private JPanel todayListPanel;
  private JPanel tomorrowListPanel;
}
