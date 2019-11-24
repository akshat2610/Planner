import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class App extends JFrame{

	public App(){
		try{
			setVisible(true);

			navigationPanel = new NavigationPanel();
			howToPanel = new HowToPanel();
			schedulerPanel = new SchedulerBottomPanel();
			journalPanel = new JournalBottomPanel();
			assistantPanel = new SchedulerBottomPanel();
			aboutPanel = new AboutPanel();

			splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationPanel, schedulerPanel);
			splitPane.setOneTouchExpandable(true);
			splitPane.setDividerLocation(200);

			add(splitPane);
			pack();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args){
		new App();
	}

	private class NavigationPanel extends JPanel{
		public NavigationPanel(){
			setLayout(new GridLayout(5, 1));
			setVisible(true);

			howToBtn = new JButton("How to");
			schedulerBtn = new JButton("Scheduler");
			journalBtn = new JButton("Journal");
			assistantBtn = new JButton("Assistant");
			aboutBtn = new JButton("About");

			howToBtn.addActionListener(new
				ActionListener(){
					public void actionPerformed(ActionEvent event){
						splitPane.setRightComponent(howToPanel);
					}
				});
			schedulerBtn.addActionListener(new
				ActionListener(){
					public void actionPerformed(ActionEvent event){
						splitPane.setRightComponent(schedulerPanel);
					}
				});
			journalBtn.addActionListener(new
				ActionListener(){
					public void actionPerformed(ActionEvent event){
						splitPane.setRightComponent(journalPanel);
					}
				});
			assistantBtn.addActionListener(new
				ActionListener(){
					public void actionPerformed(ActionEvent event){
						splitPane.setRightComponent(schedulerPanel);
					}
				});
			aboutBtn.addActionListener(new
				ActionListener(){
					public void actionPerformed(ActionEvent event){
						splitPane.setRightComponent(aboutPanel);
					}
				});


			add(howToBtn);
			add(schedulerBtn);
			add(journalBtn);
			add(assistantBtn);
			add(aboutBtn);
		}

		private JButton howToBtn;
		private JButton schedulerBtn;
		private JButton journalBtn;
		private JButton assistantBtn;
		private JButton aboutBtn;
	}

	private JPanel navigationPanel;
	private JPanel howToPanel;
	private JPanel schedulerPanel;
	private JPanel journalPanel;
	private JPanel assistantPanel;
	private JPanel aboutPanel;
	private JSplitPane splitPane;
}
