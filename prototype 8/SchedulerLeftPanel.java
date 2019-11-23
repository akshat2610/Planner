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
    todayListPanel            = new ListPanel("TODAY");
    tomorrowListPanel         = new ListPanel("TOMORROW");
    dayAfterListPanel         = new ListPanel("DAY AFTER TOMORROW");
    dayAfterDayAfterListPanel = new ListPanel("DAY AFTER DAY AFTER");

    setLayout(new GridLayout(2, 2));

    add(todayListPanel);
    add(tomorrowListPanel);
    add(dayAfterListPanel);
    add(dayAfterDayAfterListPanel);

    setVisible(true);
  }

  private JPanel todayListPanel;
  private JPanel tomorrowListPanel;
  private JPanel dayAfterListPanel;
  private JPanel dayAfterDayAfterListPanel;
}
