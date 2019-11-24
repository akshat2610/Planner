import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the main panel
 * @author Akshat Bansal
*/
public class JournalBottomPanel extends JPanel{
  public JournalBottomPanel(){
    journalLeftPanel = new JournalLeftPanel();
    //
    journalRightPanel = new JournalRightPanel();

    setLayout(new GridLayout(1, 2));
    add(journalLeftPanel);
    //
    add(journalRightPanel);
    setVisible(true);
  }

  public static void main(String[] args){
    JFrame app = new JFrame("Tester for Bottom panel");
    JPanel journalBottomPanel = new JournalBottomPanel();

    app.setLayout(new GridLayout(1,2));
    app.add(journalBottomPanel);
    app.setVisible(true);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.pack();
  }

  private JPanel journalLeftPanel;
  private JPanel journalRightPanel;
}
