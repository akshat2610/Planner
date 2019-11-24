
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the wall with all the list panels in the scheduler panel
 * @author Akshat Bansal
*/
public class JournalLeftPanel extends JPanel{

  public JournalLeftPanel(){

    topPanel = new JournalTopLeftPanel();
    bottomPanel = new JournalBottomLeftPanel("Add Reminders");



    setLayout(new GridLayout(2, 1));

   
    add(topPanel);
    add(bottomPanel);

    setVisible(true);
  }

  public static void main(String[] args)
  {
    JFrame app = new JFrame("Tester for Bottom panel");
    JPanel journalLeftPanel = new JournalLeftPanel();

    app.setLayout(new GridLayout(2,1));
    app.add(journalLeftPanel);
    app.setVisible(true);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.pack();
  }


  
  private JPanel topPanel;
  private JPanel bottomPanel;
}



