import javax.swing.*;
import java.awt.event.*;  
import java.io.File;

public class AdditionalInfoController implements ActionListener 
{
     private Graph graph;                //The Model used to describe the game
     private JButton additionalInfo;     //The button component linked to the controller
     
     public AdditionalInfoController(Graph aGraph, JButton button)
     {
          this.graph = aGraph;
          this.additionalInfo = button;
     }
     
     public void actionPerformed(ActionEvent e)
     {
         Graph.updateView(4);
     }
}