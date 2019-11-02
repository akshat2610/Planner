import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class SchedulerPanel extends JPanel{
	public SchedulerPanel() throws IOException{
		setLayout(new GridLayout(3, 1));

		infoPanel = new InfoPanel();
		JPanel spacer = new JPanel();
		spacer.setPreferredSize(new Dimension(100, 100));
		buttonPanel = new ButtonPanel();

		add(infoPanel);
		add(spacer);
		add(buttonPanel);
	}

	public static void main(String[] args){
		try{
			JFrame frame = new JFrame();
			JPanel scheduler = new SchedulerPanel();
			frame.setVisible(true);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(scheduler);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	private JPanel infoPanel;
	private JPanel buttonPanel;

	public final static double FRACTIONAL_INFO_PANEL_WIDTH = 1;
	public final static double FRACTIONAL_INFO_PANEL_HEIGHT = 0.7;
	public final static double FRACTIONAL_BUTTON_PANEL_WIDTH = 1;
	public final static double FRACTIONAL_BUTTON_PANEL_HEIGHT = 0.3;	
}