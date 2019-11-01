import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel{
	public ButtonPanel() throws IOException{
		setLayout(new GridLayout(2,4));

		BufferedImage sleep= ImageIO.read(new File("./sleep.jpeg"));
		BufferedImage sports= ImageIO.read(new File("./sports.jpeg"));
		BufferedImage videoGame= ImageIO.read(new File("./videoGame.jpeg"));
		BufferedImage home= ImageIO.read(new File("./home.jpeg"));
		BufferedImage travel= ImageIO.read(new File("./travel.jpeg"));
		BufferedImage entertainment= ImageIO.read(new File("./entertainment.jpeg"));

		sleepBtn = new RoundButton("", sleep);
		sportsBtn = new RoundButton("", sports);
		videoGameBtn = new RoundButton("", videoGame);
		socialBtn = new RoundButton("", sleep);
		
		socialMediaBtn = new RoundButton("", sleep);
		entertainmentBtn = new RoundButton("", entertainment);
		travelBtn = new RoundButton("", travel);
		homeBtn = new RoundButton("", home);

		add(sleepBtn);
		add(sportsBtn);
		add(videoGameBtn);
		add(socialBtn);

		add(socialMediaBtn);
		add(entertainmentBtn);
		add(travelBtn);
		add(homeBtn);

		setVisible(true);
	}

	private JButton sleepBtn;
	private JButton sportsBtn;
	private JButton videoGameBtn;
	private JButton socialBtn;

	private JButton socialMediaBtn;
	private JButton entertainmentBtn;
	private JButton travelBtn;
	private JButton homeBtn;
}