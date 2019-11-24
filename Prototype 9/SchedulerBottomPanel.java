import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the main panel
 * @author Akshat Bansal
*/
public class SchedulerBottomPanel extends JPanel{
  public SchedulerBottomPanel(){
    //setBackground(new Color(22, 226, 124));
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
