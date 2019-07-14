/**GuessGUI Class
  * The GUI View for the Guess Name
  * Date Created:  Nov 18, 2018
  * @author      W. Couch
  */

import javax.swing.*;
import java.awt.*;

public class GuessGUI extends JPanel
{
     //Instance Variables
     private GuessGame game;                        //The game Model
     
     // ** Define your GUI components here
     JPanel info = new JPanel();
     JPanel userGuide = new JPanel();
     JPanel hintOut = new JPanel();
     
     JTextField playerGuess = new JTextField(5);
     JLabel instructions = new JLabel("");
     JLabel hint = new JLabel("");
     
     /** Default constructor for the GUI.  Assigns Model and View, identifies controllers
       * and draws the layout
       * @param newGame        The Model for the game
       */ 
     public GuessGUI(GuessGame newGame)
     {
          super();
          this.game = newGame;
          this.game.setGUI(this);
          this.layoutView();
          this.registerControllers();
          this.update();
     }
     
     /** Draws the initial layout for the game board
       */ 
     private void layoutView()
     {
          // ** enter your code here
          
          //Code to guide user 
          userGuide.setLayout (new GridLayout (4,3,0,0));
          userGuide.add(instructions);
          
          //Code to get number
          info.setLayout(new GridLayout (4,3,0,0));
          info.add(playerGuess);
          info.setBorder(BorderFactory.createTitledBorder("Enter Guess"));
          
          //Hint code
          hintOut.setLayout (new GridLayout(2,4,0,0));
          hintOut.add(hint);
          
          //Overall layout
          this.setLayout(new BorderLayout());
          this.add(this.userGuide, BorderLayout.NORTH);
          this.add(this.info, BorderLayout.CENTER);
          this.add(this.hintOut, BorderLayout.SOUTH);
          
          
          
          
          
     }// end of layoutView()
     
     /**Assigns the controller to the respond guess entry.
       */ 
     private void registerControllers()
     {
          //Responds to entry of a guess
          GuessController controller = new GuessController(this.game, playerGuess);   //assumes text box is named playerGuess
          playerGuess.addActionListener(controller);
     }
     
     /** Redraws the game board according to the current game situation.  Requires data
       * from the Model.
       */ 
     public void update()
     {
          //Sets the text for individual labels 
          this.instructions.setText(game.getState());
          this.hint.setText(game.getHint());
          playerGuess.setText("");
         
     }//end of update()
} 
