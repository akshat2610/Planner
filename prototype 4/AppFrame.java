import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

/**
	Models the main frame of the application.
	@author Akshat Bansal 
*/
public class AppFrame extends JFrame{

	public AppFrame() throws IOException{
		navigationPanel = new NavigationPanel();
		howToPanel = new HowToPanel();
		schedulerPanel = new SchedulerPanel();
		journalPanel = new JournalPanel();
		assistantPanel = new SchedulerPanel();
		aboutPanel = new AboutPanel();

		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setTitle("My Planner");
		add(navigationPanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	/**
		Models the navigation panel in the main frame of the application
		@author Akshat Bansal
	*/
	private class NavigationPanel extends JPanel{
		public NavigationPanel(){
			tabbedPane 		= new JTabbedPane(JTabbedPane.LEFT);

			howToIcon 		= new ImageIcon("images/howTo.gif");
			schedulerIcon 	= new ImageIcon("images/scheduler.gif");
			journalIcon 	= new ImageIcon("images/journal.gif");
			assistantIcon 	= new ImageIcon("images/assistant.gif");
			aboutIcon 		= new ImageIcon("images/about/gif");

			tabbedPane.add("How To", howToPanel); //howToPanel, "Learn how to use this software");
			tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

			tabbedPane.add("Scheduler", schedulerPanel);//schedulerPanel, "Plan your day/week/month");
			tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

			tabbedPane.add("Journal", journalPanel);// journalPanel, "Write about your day here");
			tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

			tabbedPane.add("Assistant", assistantPanel);//assistantPanel, "Look at your daily/monthly/weekly past work sessions");
			tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

			tabbedPane.add("About", aboutPanel);// aboutPanel, "Read about the devs here");
			tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);

			setVisible(true);
		}

		private JTabbedPane tabbedPane;
		private Icon howToIcon;
		private Icon schedulerIcon;
		private Icon journalIcon;
		private Icon assistantIcon;
		private Icon aboutIcon;
	}

	public static void main(String[] args){
		try{
			new AppFrame();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public final static int HEIGHT = 1000;
	public final static int WIDTH = 600;

	private JPanel navigationPanel;
	private JPanel howToPanel;
	private JPanel schedulerPanel;
	private JPanel journalPanel;
	private JPanel assistantPanel;
	private JPanel aboutPanel;
}