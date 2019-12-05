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
		JLabel a = new JLabel();
		a.setText("Akshat Bansal 			Github: https://github.com/akshat2610");
		JLabel ap = new JLabel();
		ap.setIcon(new ImageIcon("./images/aboutPics/akshatAbout.JPEG"));
		JLabel j = new JLabel();
		j.setText("Jyoti Suri 				Github: https://github.com/JyotiSuri");
		JLabel jp = new JLabel();
		jp.setIcon(new ImageIcon("./images/aboutPics/jyotiAbout.JPEG"));
		JLabel s = new JLabel();
		s.setText("Shruti Panchal 			Github: https://github.com/shrutipanchal7699");
		JLabel sp = new JLabel();
		sp.setIcon(new ImageIcon("./images/aboutPics/shrutiAbout.JPG"));
		JLabel t = new JLabel();
		t.setText("Tirth Patel 				Github: https://github.com/tirthnpatel");
		JLabel tp = new JLabel();
		tp.setIcon(new ImageIcon("./images/aboutPics/tirthAbout.JPG"));

		add(a);
		add(ap);
		add(j);
		add(jp);
		add(s);
		add(sp);
		add(t);
		add(tp);
		setLayout(new GridLayout(2,2));
		//add(textArea);
		setVisible(true);
	}

	/**
	 * Tester for about panel. Test for different layouts and sizes here.
	*/
	public static void main(String[] args){
		JPanel aboutPanel = new AboutPanel();
		JFrame app = new JFrame();

		app.setPreferredSize(new Dimension(500,300));
		app.add(aboutPanel);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
	}

//	private JTextArea textArea;
//	public final static int TEXT_AREA_WITDH = 50;
//	public final static int TEXT_AREA_HEIGHT = 100;
//	public final static int PANEL_NUM_ROWS = 1;
//	public final static int PANEL_NUM_COLS = 4;
}
