import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class JournalRightPanel extends JPanel {

	public JournalRightPanel() {
		setLayout(new GridLayout(2, 1));
		graphPanel = new BarGraph("No. of Hours", new double[] { 0, 20, 30, 12, 23, 43, 12, 10 },
				new String[] { "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" },
				new Color[] { new Color(0, 0, 0, 0), new Color(237,85,47), new Color(255,255,255), Color.green, Color.LIGHT_GRAY,
						Color.MAGENTA, new Color(44, 242, 196), Color.orange },
				"SAMPLE");
		journalButtonPanel = new JournalButtonPanel();

		graphPanel.setBackground(new Color(21, 47, 53));

		add(graphPanel);
		add(journalButtonPanel);
		setVisible(true);
	}

	private JPanel graphPanel;
	private JPanel journalButtonPanel;
}
