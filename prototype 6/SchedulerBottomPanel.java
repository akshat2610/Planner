import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

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

  public static void main(String[] args){
    JFrame app = new JFrame("Tester for Bottom panel");
    JPanel schedulerBottomPanel = new SchedulerBottomPanel();

    app.setLayout(new GridLayout(1,1));
    app.add(schedulerBottomPanel);
    app.setVisible(true);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.pack();
  }

  private JPanel schedulerLeftPanel;
  private JPanel schedulerRightPanel;
}
