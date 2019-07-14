import javax.swing.*;
import java.awt.*;

/**Vertical
  * A component that displays parallel, vertical lines
  * @author J.Burns
  * @since 09/03/2015*/
public class Vertical extends JComponent
{
  
  /**Basic Constructor*/
  public Vertical()
  {
    super();
    this.setPreferredSize(new Dimension(600,600));
  }
  
  /**Draw a set of parallel, vertical lines across the component
    * @param g The Graphics object to draw with*/
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    //Set Scale
    Graphics2D g2 = (Graphics2D)g; //The new Graphics object
    g2.scale(this.getWidth()/10, this.getHeight()/10);
    g2.setStroke(new BasicStroke(1.0F/this.getWidth()));
    
    //Draw Image
    for(int line = 1; line <= 10; line++)
    {
      g2.drawLine(line,1,line,9);
    }
  }
}
  
  
