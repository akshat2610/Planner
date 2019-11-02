import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OptionsPanel extends JPanel{
	public OptionsPanel(){
		setLayout(new FlowLayout());

		deleteBtn = new JButton("delete");
		editBtn = new JButton("edit");
		completeBtn = new JButton("complete");

		add(deleteBtn);
		add(editBtn);
		add(completeBtn);

		setVisible(true);
	}

	private JButton deleteBtn;
	private JButton editBtn;
	private JButton completeBtn;
}