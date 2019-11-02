
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;

public class RoundButton extends JButton {
	private BufferedImage img;
	public RoundButton(BufferedImage img) {
		//super(label);

		setBackground(Color.BLUE);
		setFocusable(false);

		/*
		* These statements enlarge the button so that it becomes a circle rather than
		* an oval.
		*/
		Dimension size = new Dimension(125,125);
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		this.img = img;
		setButtonImage(img);

		/*
		* This call causes the JButton not to paint the background. This allows us to
		* paint a round background.
		*/
		setContentAreaFilled(false);
	}

	public void setButtonImage(BufferedImage pbim) {
		img = pbim;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		g.setClip(new Ellipse2D.Double(0, 0, getWidth(), getHeight())); // set the area that shall be painted
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null); // draw the image, if available
		if (getModel().isArmed()) { // show a slight gray shading when pressing the button
			g.setColor(new Color(127, 127, 127, 80)); // gray with 80 as alpha
			g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		}
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	}

	// Hit detection.
	Shape shape;

	public boolean contains(int x, int y) {
		// If the button has changed size, make a new shape object.
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}

	private static JPanel listPanel = new ListPanel();
	public static ActionListener createAL(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent event){
				String newActivity = JOptionPane.showInputDialog("Enter name");
				if (newActivity != null){
					JPanel activityPanel = new ActivityPanel(newActivity);
					listPanel.add(activityPanel);
					listPanel.repaint();
					listPanel.revalidate();
				}
			}
		};
	}

	public static void main(String[] args) throws IOException{

		BufferedImage sleep					= ImageIO.read(new File("./dp.heif"));
		BufferedImage sports				= ImageIO.read(new File("./sports.jpeg"));
		BufferedImage videoGame			= ImageIO.read(new File("./videoGame.jpeg"));
		BufferedImage home					= ImageIO.read(new File("./home.jpeg"));
		BufferedImage travel				= ImageIO.read(new File("./travel.png"));
		BufferedImage entertainment	= ImageIO.read(new File("./entertainment.jpeg"));
		BufferedImage socialMedia		= ImageIO.read(new File("./socialMedia.jpg"));
		BufferedImage social				= ImageIO.read(new File("./social.jpg"));

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Chal kyu nahi raha madarchod");
		frame.setLayout(new FlowLayout());


		JButton b1 = new RoundButton(sleep);
		b1.addActionListener(createAL());

		JButton b2 = new RoundButton(sports);
		b2.addActionListener(createAL());

		JButton b3 = new RoundButton(videoGame);
		b3.addActionListener(createAL());

		JButton b4 = new RoundButton(socialMedia );
		b4.addActionListener(createAL());

		JButton b5 = new RoundButton(social);
		b5.addActionListener(createAL());

		JButton b6 = new RoundButton(entertainment);
		b6.addActionListener(createAL());

		JButton b7 = new RoundButton(home);
		b7.addActionListener(createAL());

		JButton b8 = new RoundButton(travel);
		b8.addActionListener(createAL());

		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.add(b6);
		frame.add(b7);
		frame.add(b8);
		frame.add(listPanel);
		frame.setSize(300, 150);
		frame.setVisible(true);

	}
}
