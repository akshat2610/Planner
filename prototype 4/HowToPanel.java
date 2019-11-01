import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class HowToPanel extends JPanel{
	public HowToPanel() throws IOException{
		textArea = new JTextArea("How to text here", 150, 200);
		setLayout(new GridLayout(1,1));
		add(textArea);
		setVisible(true);
	}

	private JTextArea textArea;
}