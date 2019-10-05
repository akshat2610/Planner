import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class TaskListPanel extends JPanel implements ActionListener{
	public TaskListPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setVisible(true);

		tasks = new ArrayList<>();
		addBtn = new JButton("Add task");
		addBtn.addActionListener(this);

		add(addBtn);
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		String task = JOptionPane.showInputDialog("Enter task name");
		if (task != null){
			JLabel label = new JLabel(task);
			label.setFont(new Font("Courier New", Font.ITALIC, 17));
			add(label);
			repaint();
			revalidate();
		}
	}
	public static void main(String[] args){
		JFrame mainFrame = new JFrame("TaskListPanel");
		JPanel taskListPanel = new TaskListPanel();
		mainFrame.add(taskListPanel);

		mainFrame.setLayout(new FlowLayout());
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
	}

	private List<String> tasks;
	private JButton addBtn;
}