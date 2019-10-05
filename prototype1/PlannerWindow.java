import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PlannerWindow extends JFrame{

	public PlannerWindow(){
		setLayout(new GridBagLayout());
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setTitle("My Planner");

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.1;
		c.weighty = 1;
		add(new LeftWindow(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.9;
		c.weighty = 1;
		add(new RightWindow(), c);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String[] args){
		PlannerWindow app = new PlannerWindow();
	}

	public static final int WIDTH = 1500;
	public static final int HEIGHT = 1000;
	private LeftWindow leftPane;
	private RightWindow rightPane;
}