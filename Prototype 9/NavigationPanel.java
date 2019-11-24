import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NavigationPanel extends JPanel{

	public NavigationPanel(){
		setLayout(new GridLayout(4, 1));	
		setVisible(true);

		howToBtn = new JButton("How to");
		schedulerBtn = new JButton("Scheduler");
		journalBtn = new JButton("Journal");
		assistantBtn = new JButton("Assistant");
		aboutBtn = new JButton("About");

		add(schedulerBtn);
		add(journalBtn);
		add(assistantBtn);
		add(aboutBtn);
	}

	public static void main(String[] main){
		JFrame testerFrame = new JFrame();
		JPanel navigationPanel = new NavigationPanel();
		testerFrame.add(navigationPanel);
		testerFrame.setVisible(true);
		testerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testerFrame.pack();
	}

	private JButton howToBtn;
	private JButton schedulerBtn;
	private JButton journalBtn;
	private JButton assistantBtn;
	private JButton aboutBtn;
}