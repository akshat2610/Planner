import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PlannerFrame extends JFrame{
	public PlannerFrame(){
		setLayout(new GridBagLayout());
		setSize(WIDTH, HEIGHT);
		setTitle("My Planner");

		Container contentPane = getContentPane();
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.1;
		c.weighty = 1;
		contentPane.add(new LeftPanel(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.9;
		c.weighty = 1;
		contentPane.add(new RightPanel(), c);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	public static void main(String[] args){
		new PlannerFrame();
	}


	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;
}