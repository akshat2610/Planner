import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


/**
 * Models a top-level container for individual activity panels
 * @author Akshat Bansal
*/
public class ActivityListPanel extends JPanel{
	/**
	 * Constructs an instance of the ActivityListPanel
	*/
	public ActivityListPanel(String label){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		//vertical arrangement of activity panels
		setVisible(true);
		header = new JLabel(label);
		add(header);
		activityPanels = new ArrayList<>();
		setBackground(new Color(172, 193, 198));

		try{
			File file = new File("./data/activities.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			ActivityReader activityReader = new ActivityReader(br);

			boolean done = false;
			System.out.println("Starting to read tasks...");
			while (!done){
				Activity activity = activityReader.readRecord();
				if (activity == null){
					done = true;
					break;
				}
				System.out.println("***");
				activity.print();
				System.out.println("***");
				add(new ActivityPanel(activity.getName()));
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
	}

	public static void main(String[] args){
		JFrame app = new JFrame("Tester for list panel");
		JPanel ActivityListPanel = new ActivityListPanel("Today");
		JButton addBtn = new JButton(new ImageIcon("./images/buttons/add.png"));

		addBtn.setPreferredSize(new Dimension(25, 25));
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String activityName = JOptionPane.showInputDialog("Enter name of the task");
				ActivityListPanel.add(new ActivityPanel(activityName));
				ActivityListPanel.repaint();
				ActivityListPanel.revalidate();
			}
		});

		app.setLayout(new GridLayout(2, 1));
		app.add(ActivityListPanel);
		app.add(addBtn);

		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
	}

	private JLabel header;
	private final List<ActivityPanel> activityPanels;
}
