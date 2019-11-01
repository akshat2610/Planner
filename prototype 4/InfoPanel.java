import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InfoPanel extends JPanel{
	public InfoPanel(){
		setLayout(new FlowLayout());
		listPanel = new ListPanel();
		JButton addBtn = new JButton("Add");

		add(listPanel);
		add(addBtn);

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


	private ListPanel listPanel;
	//private BarGraphPanel graphPanel; // add later
}