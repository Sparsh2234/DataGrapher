import javax.swing.*;
import java.awt.event.*;  
import java.io.File;

public class FileInputController implements ActionListener
{
     private Graph graph;                //The Model used to describe the game
     private JButton fileInputted;       //The button component linked to the controller
     
     public FileInputController(Graph aGraph, JButton button)
     {
          this.graph = aGraph;
          this.fileInputted = button;
     }
     
     public void actionPerformed(ActionEvent e)
     {
          // create the dialog box and set up filters for what it displays
          JFileChooser chooser = new JFileChooser();
          
          chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
          
          while (true)
          {
               // show the dialog
               int result = chooser.showOpenDialog(null);
               if (result == JFileChooser.APPROVE_OPTION)
               {  
                    break;
               } 
               
               else 
               {  
                    System.out.println("No file selected.");
               } 
          }
          
     }
}