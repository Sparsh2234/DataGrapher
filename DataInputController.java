import javax.swing.*;
import java.awt.event.*;  
import java.io.File;

public class DataInputController implements ActionListener
{
     private Graph graph;                //The Model used to describe the game
     private JTextField dataInputted;    //The textField linked to the controller
     
     public DataInputController(Graph aGraph, JTextField aTextField)
     {
          this.graph = aGraph;
          this.dataInputted = aTextField;
     }
     
     public void actionPerformed(ActionEvent e)
     {
          String text = dataInputted.getText();
          if (text != null)
          {
               try
               {
                    int temp = Integer.parseInt(text);
                    this.graph.addData(temp);
                    dataInputted.setText("");
               } 
               
               catch (NumberFormatException ex)
               {
                    this.dataInputted.selectAll();
               }
          }
          
     }
}