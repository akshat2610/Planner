import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;

public class RoundButton extends JButton {
	private BufferedImage img;

	public RoundButton(String label, BufferedImage img) {
		super(label);

		setBackground(Color.BLUE);
		setFocusable(false);

		/*
		 * These statements enlarge the button so that it becomes a circle rather than
		 * an oval.
		 */
		Dimension size = new Dimension(70,70);
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

	public static void main(String[] args) throws IOException {

		BufferedImage sleep					= ImageIO.read(new File("sleep.jpeg"));
		BufferedImage sports				= ImageIO.read(new File("sports.jpeg"));
		BufferedImage videoGame			= ImageIO.read(new File("videoGame.jpeg"));
		BufferedImage home					= ImageIO.read(new File("home.jpeg"));
		BufferedImage travel				= ImageIO.read(new File("travel.jpeg"));
		BufferedImage entertainment	= ImageIO.read(new File("entertainment.jpeg"));


		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Rounded Button Example");
		frame.setLayout(new FlowLayout());

		JButton b1 = new RoundButton("", sleep);
		JButton b2 = new RoundButton("", sports);
		JButton b3 = new RoundButton("", videoGame);
		JButton b4 = new RoundButton("", sleep );
		JButton b5 = new RoundButton("", sleep);
		JButton b6 = new RoundButton("", entertainment);
		JButton b7 = new RoundButton("", home);
		JButton b8 = new RoundButton("", travel);

		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.add(b6);
		frame.add(b7);
		frame.add(b8);

		frame.setSize(300, 150);
		frame.setVisible(true);

	}
}
