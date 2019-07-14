import javax.swing.*;
import java.awt.event.*;  
import java.io.File;

public class RelativeFreqGraphController implements ActionListener
{ 
     private Graph graph;                //The Model used to describe the game
     private JButton relativeFreqGraph;  //The button component linked to the controller
     
     public RelativeFreqGraphController(Graph aGraph, JButton button)
     {
          this.graph = aGraph;
          this.relativeFreqGraph = button;
     }
     
     public void actionPerformed(ActionEvent e)
     {
          Graph.updateView(3);
     }
}