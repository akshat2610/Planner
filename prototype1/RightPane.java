import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RightPane extends JPanel{
	public RightPane(){
		setLayout(new FlowLayout());
		add(new TaskListPanel());
        setVisible(true);
	}
}