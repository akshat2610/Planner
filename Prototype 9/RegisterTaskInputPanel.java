import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the input panel that pops up when user clicks the add activity button
 * @author Akshat Bansal
*/
public class RegisterTaskInputPanel extends JPanel {
  /**
   * Constructs an instance of the RegisterTaskInputPanel

   * @param categoryChoices activity categories
  */
  public RegisterTaskInputPanel(String[] categoryChoices){
    setLayout(new GridLayout(INPUT_PANEL_NUM_ROWS, INPUT_PANEL_NUM_COLS));


    tasksDropDown  = new JComboBox<>(categoryChoices);
    numHrsTF          = new JTextField("Hours worked ");

    add(tasksDropDown);
    add(numHrsTF);


    setVisible(true);
  }

  /**
   * Tester for activity input panel
  */
  public static void main(String[] args){
    JFrame app = new JFrame("Tester for RegisterTaskInputPanel ");
    String[] choices = {"Task1", "Task2", "Task3", "Task4"};
    RegisterTaskInputPanel RegisterTaskInputPanel= new RegisterTaskInputPanel (choices);
    JButton addBtn = new JButton("Register Hours ");

    addBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showConfirmDialog(null, RegisterTaskInputPanel
        , "Please activity details", JOptionPane.OK_CANCEL_OPTION);

        System.out.println("Tasks: " + RegisterTaskInputPanel
        .getName());
        System.out.println("#Hours: " + RegisterTaskInputPanel
        .getNumHrs());

      }
    });
    app.add(addBtn);

    app.setLayout(new FlowLayout());
    app.pack();
    app.setVisible(true);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


  /**
   * Returns the category of the activity
   * @return category of the activity
  */
  public String getName(){
    return (String)tasksDropDown.getSelectedItem();
  }

  /**
   * Returns the number of hours
   * @return the number of hours
  */
  public int getNumHrs(){
    return Integer.parseInt(numHrsTF.getText());
  }



  private final static int INPUT_PANEL_NUM_ROWS = 4;
  private final static int INPUT_PANEL_NUM_COLS = 1;


  private JComboBox<String> tasksDropDown;
  private JTextField numHrsTF;

}
