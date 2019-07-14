import javax.swing.*;
import java.awt.*;

public class  DrawRelativeGraph  extends JComponent
{

 /**Default Constructor*/
 public DrawRelativeGraph()
 {       
     super ();
     this.setPreferredSize(new Dimension(1339, 620));
 }

 /** Overrides paintComponent to paint a smiley face
 @param g The Graphics component used to display the smiley face*/
 public void paintComponent(Graphics g)
 {   
     super.paintComponent(g);

     //Axis 
     g.drawLine (100,550, 1240,550);
     g.drawLine (100,550, 100,100);
     
     if (Graph.getMaxValue()>=20){
          for (int x =1; x<= 20; x++)
          {
               int spaceX= 57;
               g.drawLine (100+(x*spaceX), 560, 100+(x*spaceX), 540);
          }
     }
     else
     {
            for (int x =1; x<= Graph.getMaxValue() ; x++)
          {
               int spaceX= (int)(Math.round((1140.0/Graph.getMaxValue())));
               g.drawLine (100+(x*spaceX), 560, 100+(x*spaceX), 540);
          }
     }
        
 }  
}
