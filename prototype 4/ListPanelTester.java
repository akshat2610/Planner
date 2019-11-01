import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ListPanelTester{
	public static void main(String[] args){
		JFrame app = new JFrame("List Panel Tester");
		app.setLayout(new GridLayout(2, 1));
		JPanel listPanel = new ListPanel();
		JButton addBtn = new JButton("Add");

		app.add(listPanel);
		app.add(addBtn);		

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

		app.setVisible(true);
		app.pack();
	}
}