import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;

public class JournalPanel extends JPanel{
	public JournalPanel() {
		//schedulerTopPanel = new SchedulerTopPanel();
	    journalBottomPanel = new JournalBottomPanel();

//	    	GridBagConstraints c = new GridBagConstraints();
			setLayout(new GridLayout(1,1));
			add(journalBottomPanel);
//			c.fill = GridBagConstraints.BOTH;
//			c.weightx = TOP_PANEL_WIDTH_RATIO;
//			c.weighty = TOP_PANEL_HEIGHT_RATIO;
//			add(schedulerTopPanel, c);

//			c.fill = GridBagConstraints.BOTH;
//			c.weightx = BOTTOM_PANEL_WIDTH_RATIO;
//			c.weighty = BOTTOM_PANEL_HEIGHT_RATIO;
//			add(journalBottomPanel, c);

			setVisible(true);
	}
	
	public static void main(String[] args){
		 JFrame app = new JFrame("Tester for Journal Panel");
		    JPanel journalPanel = new JournalPanel();
		    app.setLayout(new GridLayout(1,1));
		    app.add(journalPanel);
		    app.setVisible(true);
		    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    app.pack();
	}
	
	  
//	  public final static double TOP_PANEL_WIDTH_RATIO = 1;
//	  public final static double TOP_PANEL_HEIGHT_RATIO = 0.2;
//	  public final static double BOTTOM_PANEL_WIDTH_RATIO = 1;
//	  public final static double BOTTOM_PANEL_HEIGHT_RATIO = 0.8;

	  //private JPanel schedulerTopPanel;
	  private JPanel journalBottomPanel;
	  
}