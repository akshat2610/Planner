import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
public class JournalButtonPanel extends JPanel{

	public JournalButtonPanel() {
		addBtn = new JButton("Add Activity");
	    noteBtn = new JButton("Add Note");
	    String[] categoryChoices = {"Sport", "Video game", "Social Media", "Travel", "Netflix", "Sleep"};
	    activityInputPanel = new ActivityInputPanel(categoryChoices);

	    addBtn.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){
	        JOptionPane.showConfirmDialog(null, activityInputPanel, "Please fill out activity details", JOptionPane.OK_CANCEL_OPTION);
	        Activity activity = new Activity(activityInputPanel.getName(), activityInputPanel.getCategory(), activityInputPanel.getNumHrs(),
	                              activityInputPanel.getNote());

	        try{
	          File file = new File("./data/activities.txt");
	    			FileWriter fw = new FileWriter(file, true);
	    			PrintWriter pw = new PrintWriter(fw);
	    			ActivityWriter activityWriter = new ActivityWriter(pw);

	          activityWriter.writeActivity(activity);
	          pw.close();
	          fw.close();
	        }
	        catch(Exception exc){
	          System.out.println("Stress: " + exc.getMessage());
	          exc.printStackTrace();
	        }
	      }
	    });

	    setLayout(new GridLayout(3,1));
	    add(addBtn);
	    add(noteBtn);

	    setVisible(true);
	    setBackground(Color.DARK_GRAY);
	}
	
	  private JButton addBtn;
	  private JButton noteBtn;
	  private ActivityInputPanel activityInputPanel;

}
