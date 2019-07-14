import javax.swing.*;
import java.awt.event.*;  
import java.io.File;

public class GraphController implements ActionListener
{
     private Graph graph;                //The Model used to describe the game
     private JButton graphButton;  //The button component linked to the controller
     
     public GraphController(Graph aGraph, JButton button)
     {
          this.graph = aGraph;
          this.graphButton = button;
     }
     
     public void actionPerformed(ActionEvent e)
     {
          //Graph.updateView(5);
     }
}