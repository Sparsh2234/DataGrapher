import javax.swing.*;
import java.awt.event.*;  
import java.io.File;

public class FreqGraphController implements ActionListener
{
     private Graph graph;                //The Model used to describe the game
     private JButton freqGraph;       //The button component linked to the controller
     
     public FreqGraphController(Graph aGraph, JButton button)
     {
          this.graph = aGraph;
          this.freqGraph = button;
     }
     
     public void actionPerformed(ActionEvent e)
     {
          Graph.updateView(1);
     }
}