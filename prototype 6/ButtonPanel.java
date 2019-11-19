import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the panel with the progress bar and the buttons in the scheduler panel
 * @author Akshat Bansal
*/
public class ButtonPanel extends JPanel{
  /**
   * Constructs an instance of the ButtonPanel
  */
  public ButtonPanel(){
    progressBar = new JProgressBar(0, 100);
    addBtn = new JButton("Add task");
    clockInBtn = new JButton("Clock in");

    progressBar.setStringPainted(true);
    progressBar.setValue(50);

    setLayout(new GridLayout(3,1));
    add(progressBar);
    add(addBtn);
    add(clockInBtn);

    setVisible(true);
    setBackground(Color.DARK_GRAY);
  }

  private JProgressBar progressBar;
  private JButton addBtn;
  private JButton clockInBtn;
}
