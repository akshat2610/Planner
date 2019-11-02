import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class AboutPanel extends JPanel{
	public AboutPanel(){
		textArea = new JTextArea("About text here", 50, 100);
		setPreferredSize(new Dimension(100, 200));
		setLayout(new GridLayout(1, 1));
		add(textArea);
		setVisible(true);
	}
	public static void main(String[] args){
		JPanel aboutPanel = new AboutPanel();
		JFrame app = new JFrame();
		app.add(aboutPanel);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
	}

	private JTextArea textArea;
}