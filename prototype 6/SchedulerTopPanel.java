import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the top panel, which contains the search panel, in the scheduler panel
 * @author Akshat Bansal
*/
public class SchedulerTopPanel extends JPanel{
  /**
   * Constructs an instance of the SchedulerTopPanel
  */
  public SchedulerTopPanel(){
    searchPanel = new SearchPanel();
    setLayout(new FlowLayout());
    add(searchPanel);
    setVisible(true);
  }

  private JPanel searchPanel;
}
