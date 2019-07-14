/** Class name:          Startup
  * Author:              Nawal M.
  * Date Modified:       24/12/2018
  * Description:         Users input in any data sets and are then able to create different graphs and obtain additional info based off those values
  */


import javax.swing.*;


public class Startup{
     public static void main (String [] args){
          
          Graph model = new Graph();                   //The game model
          GraphGUI mainScreen = new GraphGUI(model);   //The game view
          
          //Initialize the Frame
          JFrame f = new JFrame("Data Management");
          f.setSize(600,150);
          f.setLocation(300,200);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setContentPane(mainScreen);
          f.setVisible(true);
     }
}