import java.awt.*;
import javax.swing.*;

/**
 * Models the about panel in the main application JFrame
 * @author Akshat Bansal
*/
public class AboutPanel extends JPanel{
	/**
	 * Constructs an instance of the about panel
	*/
	public AboutPanel(){
		textArea = new JTextArea("About text here",TEXT_AREA_WITDH, TEXT_AREA_HEIGHT);
		setLayout(new GridLayout(PANEL_NUM_ROWS, PANEL_NUM_COLS));
		add(textArea);
		setVisible(true);
	}

	/**
	 * Tester for about panel. Test for different layouts and sizes here.
	*/
	public static void main(String[] args){
		JPanel aboutPanel = new AboutPanel();
		JFrame app = new JFrame();

		app.setPreferredSize(new Dimension(TEXT_AREA_WITDH*2, TEXT_AREA_HEIGHT*4));
		app.add(aboutPanel);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
	}

	private JTextArea textArea;
	public final static int TEXT_AREA_WITDH = 50;
	public final static int TEXT_AREA_HEIGHT = 100;
	public final static int PANEL_NUM_ROWS = 1;
	public final static int PANEL_NUM_COLS = 1;
}
