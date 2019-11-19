import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


/**
 * Models a top-level container for individual activity panels
 * @author Akshat Bansal
*/
public class ListPanel extends JPanel{
	/**
	 * Constructs an instance of the ListPanel
	*/
	public ListPanel(String label){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		//vertical arrangement of activity panels
		setVisible(true);
		header = new JLabel(label);
		add(header);
		activityPanels = new ArrayList<>();
		setBackground(new Color(172, 193, 198));
	}

	public static void main(String[] args){
		JFrame app = new JFrame("Tester for list panel");
		JPanel listPanel = new ListPanel("Today");
		JButton addBtn = new JButton(new ImageIcon("./images/buttons/add.png"));

		addBtn.setPreferredSize(new Dimension(25, 25));
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String activityName = JOptionPane.showInputDialog("Enter name of the task");
				listPanel.add(new ActivityPanel(activityName));
				listPanel.repaint();
				listPanel.revalidate();
			}
		});

		app.setLayout(new GridLayout(2, 1));
		app.add(listPanel);
		app.add(addBtn);

		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
	}

	private JLabel header;
	private final List<ActivityPanel> activityPanels;
}
