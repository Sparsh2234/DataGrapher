import javax.swing.*;
import java.awt.event.*;  
import java.io.File;

public class CumulativeGraphController implements ActionListener 
{
     private Graph graph;                  //The Model used to describe the game
     private JButton cumulativeFreqGraph;  //The button component linked to the controller
     
     public CumulativeGraphController(Graph aGraph, JButton button)
     {
          this.graph = aGraph;
          this.cumulativeFreqGraph = button;
     }
     
     public void actionPerformed(ActionEvent e)
     {
          Graph.updateView(2);
     }
}