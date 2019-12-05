/**
 * Models the controller for the application
 * @author Akshat Bansal
*/
public class Controller{
  /**
   * Constructs an instance of a controller for the given model and view
   * @param model data model of the application
   * @param view view of the application
  */
  public Controller(Model model, View view){
    this.model = model;
    this.view = view;

    this.view.addSchedulerPanelAddBtnListener(addBtnListener());
    this.view.addSchedulerPanelCloclInBtnListener(clockInBtnListener());
    this.view.addSchedulerPanelDeleteBtnListeners();
    this.view.addSchedulerPanelEditBtnListeners();
    this.view.addSchedulerPanelCompleteBtnListeners();
  }

  /**
   * 1) Show the task input panel
   * 2) Construct a task from the provided input
   * 3) Add the new task to the unfinished set
   * 4) Commit changes to database
   * 5) Reload data structures from database
   * 6) Update the UI components - graph, progress bar, list panels etc
  */
  public static ActionListener addBtnListener(){
    return new ActionListener(){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showConfirmDialog(null, taskInputPanel, taskInputPanelLabel, JOptionPane.OK_CANCEL_OPTION);
        Task task = new Task(taskInputPanel.getName(), taskInputPanel.getCategory(), 0, taskInputPanel.getNumHrs(),
                                taskInputPanel.getPriority(), taskInputPanel.getDeadline(), taskInputPanel.getNote());

        if (model.addNewUnfinishedTask(task))
          System.out.println("Task added successfully");
        else
          System.out.println("Task already exists. Increasing hours left");

        model.commitChanges();
        model.loadFromDatabase();
        view.update();
      }
    };
  }

  /**
   * 1) Show the RegisterTaskInputPanel
   * 2) Get the name of the selected task
   * 3) Find that task in the unfinished set
   * 4) Get the number of hours entered by the user
   * 5) Invest that amount of hours in the task found in 3
   * 6) Commit changes to database
   * 7) Reload data structures from database
   * 8) Update the UI components - progress bars both individual and the overall
  */
  public static ActionListener clockInBtnListener(){
    return new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String[] taskChoices = new String[model.getUnfinishedTasks().size()];
        model.getUnfinishedTasks().toArray(taskChoices);
        RegisterTaskInputPanel registerInputPanel = new RegisterTaskInputPanel(taskChoices);
        JOptionPane.showConfirmDialog(null, registerInputPanel, , JOptionPane.OK_CANCEL_OPTION);

        String selectedTaskName = registerInputPanel.getName();
        Set<Task> unfinishedTasks = model.getUnfinishedTasks();

        for (Task t: unfinishedTasks){
          if (t.getName().equals(selectedTaskName)){
            t.investHrs(registerInputPanel.getNumHrs());
            break;
          }
        }

        model.commitChanges();
        model.loadFromDatabase();
        view.update();
      }
    };
  }

    /**
     * This function represents the functionality of every delete button on the list panel
     * 1) Show the confirm dialog box
     * 2) If user clicks cancel --> do nothing
     * 2.1) Else
     * 3 Remove the task from the unifinished set
     * 4) Remove it from the list
     * 5) Recompute priorities
     * 6) Commit changes to database
     * 7) Reload data structures from the database
     * 8) Update other UI components
     * @param activityPanel the activity panel of which this button is a part of
     * @return the action listener for the delete button
    */
    public static ActionListener deleteBtnListener(JPanel activityPanel){
      return new ActionListener(){
        public void actionPerformed(ActionEvent e){
          int userChoice = JOptionPane.showConfirmDialog(null, null, "Click OK to DELETE this task", JOptionPane.OK_CANCEL_OPTION);
          if (userChoice == JOptionPane.OK_OPTION){
            JPanel listPanel = activityPanel.getParentListPanel();
            String taskName = activityPanel.getActivityNamePanel().getActivityName();
            Set<Task> unfinishedTasks = model.getUnfinishedTasks();

            Task toRemove = new Task();
            for (Task t: unfinishedTasks){
              if (t.getName().equals(taskName)){
                toRemove = t;
                break;
              }
            }

            unfinishedTasks.remove(toRemove);
            listPanel.remove(activityPanel);
            listPanel.revalidate();
            listPanel.repaint();

            model.commitChanges();
            model.loadFromDatabase();
            view.update();
          }
        }
      };
    }

    /**
     * This function represents the functionality of every edit button on the list panel
     * 1) Show the confirm dialog box
     * 2) If user clicks cancel --> do nothing
     * 2.1) Else
     * 3 Remove the task from the unifinished set
     * 4) Remove it from the list
     * 5) Recompute priorities
     * 6) Commit changes to database
     * 7) Reload data structures from the database
     * 8) Update other UI components
     * @param activityPanel the activity panel of which this button is a part of
     * @return the action listener for the delete button
    */
    public static ActionListener editBtnListener(JPanel activityPanel){
      return new ActionListener(){
        public void actionPerformed(ActionEvent e){
          int userChoice = JOptionPane.showConfirmDialog(null, taskInputPanel, taskInputPanelLabel, JOptionPane.OK_CANCEL_OPTION);
          if (userChoice == JOptionPane.OK_OPTION){
            Task task = new Task(taskInputPanel.getName(), taskInputPanel.getCategory(), 0, taskInputPanel.getNumHrs(),
                                    taskInputPanel.getPriority(), taskInputPanel.getDeadline(), taskInputPanel.getNote());
            JPanel listPanel = activityPanel.getParentListPanel();
            String taskName = activityPanel.getActivityNamePanel().getActivityName();
            Set<Task> unfinishedTasks = model.getUnfinishedTasks();

            Task toRemove = new Task();
            for (Task t: unfinishedTasks){
              if (t.getName().equals(taskName)){
                toRemove = t;
                break;
              }
            }

            unfinishedTasks.remove(toRemove);
            unfinishedTasks.add(task);
            listPanel.remove(activityPanel);
            listPanel.revalidate();
            listPanel.repaint();

            model.commitChanges();
            model.loadFromDatabase();
            view.update();
          }
        }
      };
    }
  }

  public static ActionListener completeBtnListener(JPanel activityPanel){
    return new ActionListener(){
      public void actionPerformed(ActionEvent e){
        //complete button functionality here
      }
    };
  }


  private Model model;
  private View view;

  private final static String taskInputPanelLabel = "Please fill out task details";
  private final static String registerInputPanelLabel  = "Please indicate the task you worked on";
  private final static String[] categoryChoices = {"Work", "Study", "Routine"};
  private final static String[] priorityChoices = {"Urgent", "Very high", "High", "Medium", "Low"};
  private final static TaskInputPanel taskInputPanel = new TaskInputPanel(priorityChoices, categoryChoices);

}
