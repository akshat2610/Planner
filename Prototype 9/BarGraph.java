import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public class BarGraph extends JPanel {
  private double[] values;
  private String[] labels;
  private Color[] colors;
  private String title;
  private String y_axis_label;

  public BarGraph(String y_axis_label,double[] values, String[] labels, Color[] colors, String title) {
    this.y_axis_label = y_axis_label;
    this.labels = labels;
    this.values = values;
    this.colors = colors;
    this.title = title;

    for (int i = 0; i < labels.length; i++)
      labels[i] += " - " + (int)values[i] + " hrs";
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (values == null || values.length == 0) {
      return;
    }

    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minValue > values[i]) {
        minValue = values[i];
      }
      if (maxValue < values[i]) {
        maxValue = values[i];
      }
    }

    Dimension dim = getSize();
    int panelWidth = dim.width;
    int panelHeight = dim.height;
    int barWidth = panelWidth / values.length;

    Font titleFont = new Font("Book Antiqua", Font.BOLD, 40);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);

    Font labelFont = new Font("Book Antiqua", Font.BOLD, 16);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

    int titleWidth = titleFontMetrics.stringWidth(title);
    int stringHeight = titleFontMetrics.getAscent();
    int stringWidth = (panelWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, stringWidth, stringHeight);

    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue) {
      return;
    }
    double scale = (panelHeight - top - bottom) / (maxValue - minValue);
    stringHeight = panelHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);
    for (int j = 0; j < values.length; j++) {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      int height = (int) (values[j] * scale);
      if (values[j] >= 0) {
        valueQ += (int) ((maxValue - values[j]) * scale);
      } else {
        valueQ += (int) (maxValue * scale);
        height = -height;
      }

      g.setColor(colors[j]);
      g.fillRect(valueP, valueQ, barWidth - 2, height);
      //g.setColor(Color.black);
      g.drawRect(valueP, valueQ, barWidth - 2, height);

      int labelWidth = labelFontMetrics.stringWidth(labels[j]);
      stringWidth = j * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(labels[j], stringWidth, stringHeight);
    }
  }



/*
  public static void main(String[] Args)
  {
    JFrame frame = new JFrame();
      SwingUtilities.invokeLater(new Runnable() {

          @Override
          public void run() {
              new VerticalTextDrawingExample().setVisible(true);
          }
      });

    frame.setLayout(new GridLayout(1, 3));
    frame.setVisible(true);
    JPanel spacer = new JPanel();

    spacer.setPreferredSize(new Dimension(50, 20));
   // frame.add(spacer);
   /*
    BarGraph bar1 = new BarGraph("No. of Hours",new double[]{20,30,12,23,43,12,10},new String[]{"Mon","Tue","Wed","Thur","Fri","Sat","Sun"},new Color[] {Color.red, Color.blue, Color.green,Color.LIGHT_GRAY,Color.MAGENTA,Color.DARK_GRAY,Color.orange},"Daily" ) ;
    BarGraph bar2 = new BarGraph("No. of Hours",new double[]{10,20,30,50},new String[]{"Week1","Week2","Week3","Week4"},new Color[] {Color.black, Color.blue, Color.green,Color.LIGHT_GRAY},"Weekly" ) ;
    BarGraph bar3 = new BarGraph("No. of Hours",new double[]{10,20,30,50,65,34,76,12,34,54,8,6},new String[]{Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"},new Color[] {new Color(0,0,0,0),Color.DARK_GRAY, Color.blue, Color.green,Color.LIGHT_GRAY,Color.orange,Color.red,Color.yellow,Color.pink,Color.YELLOW,Color.CYAN,Color.white,Color.WHITE},"Monthly" ) ;
*/
/*
    bar1.setPreferredSize(new Dimension(100, 500));
    bar2.setPreferredSize(new Dimension(100, 500));
    frame.add(bar1);
    frame.add(spacer);
    frame.add(bar2);
    frame.add(spacer);

    frame.add(bar3);
    frame.add(spacer);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  */
}
