import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel{
	public ButtonPanel() throws IOException{
		setLayout(new GridLayout(2,4));

		sleepBtn 		= new JButton(new ImageIcon("./images/sleep.jpeg"));
		sportsBtn 		= new JButton(new ImageIcon("./images/sports.jpeg"));
		videoGameBtn 	= new JButton(new ImageIcon("./images/videoGame.jpeg"));
		socialBtn 		= new JButton(new ImageIcon("./images/entertainment.jpeg"));
		
		socialMediaBtn 	= new JButton(new ImageIcon("./images/sleep.jpeg"));
		entertainmentBtn= new JButton(new ImageIcon("./images/entertainment.jpeg"));
		travelBtn 		= new JButton(new ImageIcon("./images/travel.jpeg"));
		homeBtn 		= new JButton(new ImageIcon("./images/home.jpeg"));

		sleepBtn.setPreferredSize(new Dimension(40, 40));
		sportsBtn.setPreferredSize(new Dimension(40, 40));
		videoGameBtn.setPreferredSize(new Dimension(40, 40));
		socialBtn.setPreferredSize(new Dimension(40, 40));

		socialMediaBtn.setPreferredSize(new Dimension(40, 40));
		entertainmentBtn.setPreferredSize(new Dimension(40, 40));
		travelBtn.setPreferredSize(new Dimension(40, 40));
		homeBtn.setPreferredSize(new Dimension(40, 40));


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
	public static void main(String[] args){
		try{
			JFrame frame = new JFrame();
			ButtonPanel btnPanel = new ButtonPanel();
			frame.setLayout(new FlowLayout());
			frame.add(btnPanel);
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
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