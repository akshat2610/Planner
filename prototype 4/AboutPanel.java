import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class AboutPanel extends JPanel{
	public AboutPanel() throws IOException{
		textArea = new JTextArea("About text here", 150, 200);
		setLayout(new GridLayout(1, 1));
		add(textArea);
		setVisible(true);
	}

	private JTextArea textArea;
}