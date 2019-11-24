import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the wall with all the list panels in the scheduler panel
 * @author Akshat Bansal
*/
public class JournalTopLeftPanel extends JPanel{

  public JournalTopLeftPanel(){
      
    todayActivityListPanel            = new ActivityListPanel("TODAY");
    tomorrowActivityListPanel         = new ActivityListPanel("TOMORROW");
  

    setLayout(new GridLayout(1, 2));

    add(todayActivityListPanel);
    add(tomorrowActivityListPanel);
    /*add(dayAfterListPanel);
    add(dayAfterDayAfterListPanel);
    */

    setVisible(true);
  }

  private JPanel todayActivityListPanel;
  private JPanel tomorrowActivityListPanel;
  /*
  private JPanel dayAfterListPanel;
  private JPanel dayAfterDayAfterListPanel;
  */
}
