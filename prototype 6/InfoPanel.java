import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InfoPanel extends JPanel{
	public InfoPanel(){
		setLayout(new GridLayout(1, 3));
		listPanel = new ListPanel("REMOVE THIS CLASS LATER");

		//Sample data for graph

		double[] values = new double[]{0,18, 20, 15, 12, 16};
		String[] labels = new String[]{"","Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		Color[] colors = new Color[]{new Color(255,255,255),Color.red, Color.green, Color.blue, Color.black, Color.yellow};

		graphPanel = new BarGraph("Number of hours", values, labels, colors, "Sample Data");

		add(listPanel);
		add(graphPanel);
		setVisible(true);
	}

	private JPanel listPanel;
	private JPanel graphPanel;
}