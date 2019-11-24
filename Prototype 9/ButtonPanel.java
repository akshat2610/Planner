import java.io.*;
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
    String[] categoryChoices = {"Work", "Study", "Routine"};
    String[] priorityChoices = {"Urgent", "Very high", "High", "Medium", "Low"};

    ///
    String[] tasks = {"Task1", "Task2", "Task3", "Task4"};
    taskInputPanel = new TaskInputPanel(priorityChoices, categoryChoices);

    registerInputPanel = new RegisterTaskInputPanel(tasks);

    progressBar.setStringPainted(true);
    progressBar.setValue(68);
    taskInputPanel.setParentPanel(this);

    addBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showConfirmDialog(null, taskInputPanel, "Please fill out task details", JOptionPane.OK_CANCEL_OPTION);
        Task task = new Task(taskInputPanel.getName(), taskInputPanel.getCategory(), 0, taskInputPanel.getNumHrs(),
                              taskInputPanel.getPriority(), taskInputPanel.getDeadline(), taskInputPanel.getNote());

        try{
          File file = new File("./data/tasks.txt");
    			FileWriter fw = new FileWriter(file, true);
    			PrintWriter pw = new PrintWriter(fw);
    			TaskWriter taskWriter = new TaskWriter(pw);

          taskWriter.writeTask(task);
          pw.close();
          fw.close();
        }
        catch(Exception exc){
          System.out.println("Stress: " + exc.getMessage());
          exc.printStackTrace();
        }
      }
    });

// clock in button functionality

    clockInBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showConfirmDialog(null, registerInputPanel, "Please register number of hours works on a particular task", JOptionPane.OK_CANCEL_OPTION);
        //Task task = unifinished.find(registerInputPanel.getName()));
        //task.investHrs(registerInputPanel.getNumHrs());

       /*
        try{
          File file = new File("./data/tasks.txt");
    			FileWriter fw = new FileWriter(file, true);
    			PrintWriter pw = new PrintWriter(fw);
    			TaskWriter taskWriter = new TaskWriter(pw);

          taskWriter.writeTask(task);
          pw.close();
          fw.close();
        }
        catch(Exception exc){
          System.out.println("Stress: " + exc.getMessage());
          exc.printStackTrace();
        }
        */
      }
    });


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
  private TaskInputPanel taskInputPanel;
  private RegisterTaskInputPanel registerInputPanel;
}
