import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class View extends JFrame{
  public View(Model model){
    this.model = model;
    schedulerPanel = new SchedulerPanel(this);
    add(schedulerPanel);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
  }

  public Model getModel(){
    return model;
  }

  public void update(){
    schedulerPanel.getRightPanel().getGraphPanel().refresh();
  }

  /**
  * Attaches an action listener to the add button in the scheduler panel
  */
  public void addSchedulerPanelAddBtnListener(ActionListener e){
    schedulerPanel.getRightPanel().getButtonPanel().getAddBtn().addActionListener(e);
  }

  /**
   * Attaches an action listener to the clock in button in the scheduler panel
  */
  public void addSchedulerPanelCloclInBtnListener(ActionListener e){
      schedulerPanel.getRightPanel().getButtonPanel().getClockInBtn().addActionListener(e);
  }

  private Model model;
  private SchedulerPanel schedulerPanel;
}
