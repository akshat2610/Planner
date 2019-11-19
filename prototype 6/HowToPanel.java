import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class HowToPanel extends JPanel{
	public HowToPanel(){
		textArea = new JTextArea("How to text here", 150, 200);
		setLayout(new GridLayout(1,1));
		add(textArea);
		setVisible(true);
		setPreferredSize(new Dimension(100, 200));
	}
	public static void main(String[] args){
		JPanel howToPanel = new HowToPanel();
		JFrame app = new JFrame();
		app.add(howToPanel);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
	}

	private JTextArea textArea;
}