import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestingView extends JFrame{
  public TestingView(Model model){
    this.model = model;
    graphPanel = new BarGraph(this, "Workload for the week");
  }

  private Model model;
  private JPanel graphPanel;
}
