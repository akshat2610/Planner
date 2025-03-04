import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the input panel that pops up when user clicks the add task button
 * @author Akshat Bansal
*/
public class TaskInputPanel extends ActivityInputPanel{
  /**
   * Constructs an instance of the TaskInputPanel
  */
  public TaskInputPanel(String[] priorityChoices, String[] categoryChoices){
    super(categoryChoices);
    priorityDropDown = new JComboBox<>(priorityChoices);
    deadlineTF = new JTextField();
    calendarInputBtn = new JButton("Select deadline");

    calendarInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deadlineTF.setText(new DatePicker(parentPanel).setPickedDate());
			}
		});

    add(priorityDropDown);
    add(deadlineTF);
    add(calendarInputBtn);
  }

  /**
   * Sets the parentPanel instance variable equal to the argument
   * @param parentPanel
  */
  public void setParentPanel(JPanel parentPanel){
    this.parentPanel = parentPanel;
  }

  /**
   * Returns the parent panel
   * @return parentPanel parent panel
  */
  public JPanel getParentPanel(){
    return parentPanel;
  }

  /**
   * Returns the deadline of the task
   * @return deadline of the task
  */
  public String getDeadline(){
    return deadlineTF.getText();
  }

  /**
   * Returns the priority of the task
   * @return priority of the task
  */
  public String getPriority(){
    return (String)priorityDropDown.getSelectedItem();
  }

  /**
   * Tester for task input panel
  */
  public static void main(String[] args){
    JFrame app = new JFrame("Tester for TaskInputPanel");
    String[] categoryChoices = {"Work", "Study", "Routine"};
    String[] priorityChoices = {"Urgent", "Very high", "High", "Medium", "Low"};
    TaskInputPanel taskInputPanel = new TaskInputPanel(priorityChoices, categoryChoices);
    JPanel mainPanel = new JPanel();
    taskInputPanel.setParentPanel(mainPanel);
    JButton addBtn = new JButton("Add Task");

    addBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showConfirmDialog(null, taskInputPanel, "Please fill task details", JOptionPane.OK_CANCEL_OPTION);
      }
    });
    mainPanel.add(addBtn);
    app.add(mainPanel);

    app.setLayout(new FlowLayout());
    app.pack();
    app.setVisible(true);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * Models the date picker dialog
   * @author [UNKNOWN]
  */
  public class DatePicker{
		int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
		int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
		JLabel l = new JLabel("", JLabel.CENTER);
		String day = "";
		JDialog d;
		JButton[] button = new JButton[49];

		public DatePicker(JPanel parent) {
			d = new JDialog();
			d.setModal(true);
			String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
			JPanel p1 = new JPanel(new GridLayout(7, 7));
			p1.setPreferredSize(new Dimension(430, 120));

			for (int x = 0; x < button.length; x++) {
				final int selection = x;
				button[x] = new JButton();
				button[x].setFocusPainted(false);
				button[x].setBackground(Color.white);
				if (x > 6)
					button[x].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae) {
							day = button[selection].getActionCommand();
							d.dispose();
						}
					});
				if (x < 7) {
					button[x].setText(header[x]);
					button[x].setForeground(Color.red);
				}
				p1.add(button[x]);
			}
			JPanel p2 = new JPanel(new GridLayout(1, 3));
			JButton previous = new JButton("<< Previous");
			previous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					month--;
					displayDate();
				}
			});
			p2.add(previous);
			p2.add(l);
			JButton next = new JButton("Next >>");
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					month++;
					displayDate();
				}
			});
			p2.add(next);
			d.add(p1, BorderLayout.CENTER);
			d.add(p2, BorderLayout.SOUTH);
			d.pack();
			d.setLocationRelativeTo(parent);
			displayDate();
			d.setVisible(true);
	  }

  	public void displayDate() {
  		for (int x = 7; x < button.length; x++)
  			button[x].setText("");
  		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
  				"MMMM yyyy");
  		java.util.Calendar cal = java.util.Calendar.getInstance();
  		cal.set(year, month, 1);
  		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
  		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
  		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
  			button[x].setText("" + day);
  		l.setText(sdf.format(cal.getTime()));
  		d.setTitle("Date Picker");
  	}

  	public String setPickedDate() {
  		if (day.equals(""))
  			return day;
  		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
  				"dd-MM-yyyy");
  		java.util.Calendar cal = java.util.Calendar.getInstance();
  		cal.set(year, month, Integer.parseInt(day));
  		return sdf.format(cal.getTime());
  	}
	}

  private JComboBox<String> priorityDropDown;
  private JTextField deadlineTF;
  private JButton calendarInputBtn;
  private JPanel parentPanel;
}
