import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Models the search panel at the top of the scheduler and journal panels
 * @author Akshat Bansal
*/
public class SearchPanel extends JPanel{
  /**
   * Constructs an instacne of the SearchPanel
  */
  public SearchPanel(){
    searchTF = new JTextField("Search");
    searchBtn = new JButton(new ImageIcon("./images/buttons/search.png"));

    GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());

    c.fill = GridBagConstraints.BOTH;
		c.weightx = TEXT_FIELD_WIDTH_RATIO;
		c.weighty = TEXT_FIELD_HEIGHT_RATIO;
		add(searchTF, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = SEARCH_BUTTON_WIDTH_RATIO;
		c.weighty = SEARCH_BUTTON_HEIGHT_RATIO;
		add(searchBtn, c);

		setVisible(true);
  }

  public static void main(String[] args){
    JFrame app = new JFrame("Tester for Search panel");
    JPanel searchPanel = new SearchPanel();
    JPanel listPanel = new ListPanel("TODAY");
    JButton addBtn = new JButton(new ImageIcon("./images/buttons/add.png"));

    addBtn.setPreferredSize(new Dimension(25, 25));
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String activityName = JOptionPane.showInputDialog("Enter name of the task");
				listPanel.add(new ActivityPanel(activityName));
				listPanel.repaint();
				listPanel.revalidate();
			}
		});

    app.setLayout(new GridLayout(3, 1));
    app.add(searchPanel);
    app.add(listPanel);
    app.add(addBtn);

    app.setVisible(true);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.pack();
  }


  public final static double TEXT_FIELD_WIDTH_RATIO = 0.8;
  public final static double TEXT_FIELD_HEIGHT_RATIO = 1;
  public final static double SEARCH_BUTTON_WIDTH_RATIO = 0.2;
  public final static double SEARCH_BUTTON_HEIGHT_RATIO = 1;

  private JTextField searchTF;
  private JButton searchBtn;
}
