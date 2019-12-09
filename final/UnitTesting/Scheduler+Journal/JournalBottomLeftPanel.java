import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;



public class JournalBottomLeftPanel extends JPanel{
	/**
	 * Constructs an instance of the JournalBottomLeftPanel
	*/
	public JournalBottomLeftPanel(View parentView, String label){
		this.parentView = parentView;
		setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
		setVisible(true);
		header = new JLabel(label);
		add(header);
		setBackground(new Color(172, 193, 198));
	}

	public void addStickyNote(String note){
		add(new JLabel(note));
		repaint();
		revalidate();
	}

	private View parentView;
	private JLabel header;
	private static final int NUM_ROWS = 2;
	private static final int NUM_COLS = 4;
}
