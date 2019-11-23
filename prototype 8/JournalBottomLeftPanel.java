import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;



public class JournalBottomLeftPanel extends JPanel{
	/**
	 * Constructs an instance of the JournalBottomLeftPanel
	*/
	public JournalBottomLeftPanel(String label){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		//vertical arrangement of activity panels
		setVisible(true);
		header = new JLabel(label);
		add(header);
		//activityPanels = new ArrayList<>();
		setBackground(new Color(172, 193, 198));

        /*
		try{
			File file = new File("./data/tasks.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			TaskReader taskReader = new TaskReader(br);

			boolean done = false;
			System.out.println("Starting to read tasks...");
			while (!done){
				Task task = taskReader.readRecord();
				if (task == null){
					done = true;
					break;
				}
				System.out.println("***");
				task.print();
				System.out.println("***");
				add(new ActivityPanel(task.getName()));
			}
			br.close();
			fr.close();

			repaint();
			revalidate();
		}
		catch(Exception e){
			System.out.println("Stress: " + e.getMessage());
			e.printStackTrace();
		}
        */
	}

	public static void main(String[] args){
		JFrame app = new JFrame("Tester for list panel");
		JPanel JournalBottomLeftPanel = new JournalBottomLeftPanel("Add Reminders");
		//JButton addBtn = new JButton(new ImageIcon("./images/buttons/add.png"));

		/*addBtn.setPreferredSize(new Dimension(25, 25));
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String activityName = JOptionPane.showInputDialog("Enter name of the task");
				JournalBottomLeftPanel.add(new ActivityPanel(activityName));
				JournalBottomLeftPanel.repaint();
				JournalBottomLeftPanel.revalidate();
			}
		});
        */

		app.setLayout(new GridLayout(1, 1));
		app.add(JournalBottomLeftPanel);
		//app.add(addBtn);

		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
	}

	private JLabel header;
	//private final List<ActivityPanel> activityPanels;
}
