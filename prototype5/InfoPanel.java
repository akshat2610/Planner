import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InfoPanel extends JPanel{
	public InfoPanel(){
		setLayout(new GridLayout(1, 3));
		listPanel = new ListPanel();
		JButton addBtn = new JButton("Add");

		//Sample data for graph
		double[] values = new double[]{18, 20, 15, 12, 16};
		String[] labels = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		Color[] colors = new Color[]{Color.red, Color.green, Color.blue, Color.black, Color.yellow};

		graphPanel = new BarGraph(values, labels, colors, "Sample Data");

		add(listPanel);
		add(addBtn);
		add(graphPanel);

		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				String newActivity = JOptionPane.showInputDialog("Enter name");
				if (newActivity != null){
					JPanel activityPanel = new ActivityPanel(newActivity);
					listPanel.add(activityPanel);
					listPanel.repaint();
					listPanel.revalidate();
				}
			}
		});

		setVisible(true);
	}


	private JPanel listPanel;
	private JPanel graphPanel;
}