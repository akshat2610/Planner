import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LeftPanel extends JPanel implements ActionListener{
	public LeftPanel(){
		setLayout(new GridLayout(4, 1));	//Constructs a layout with 4 rows and 1 column
		setVisible(true);

		schedulerBtn = new JButton("Scheduler");
		journalBtn = new JButton("Journal");
		assistantBtn = new JButton("Assistant");
		aboutBtn = new JButton("About");

		schedulerBtn.addActionListener(this);
		journalBtn.addActionListener(this);
		assistantBtn.addActionListener(this);
		aboutBtn.addActionListener(this);

		add(schedulerBtn);
		add(journalBtn);
		add(assistantBtn);
		add(aboutBtn);
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		JOptionPane.showMessageDialog(null, "Soon");
	}

	private JButton schedulerBtn;
	private JButton journalBtn;
	private JButton assistantBtn;
	private JButton aboutBtn;
}