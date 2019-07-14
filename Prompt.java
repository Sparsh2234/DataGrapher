//Sparsh Pai
//Prompt Class
//Date Modified: 11/6/2018
//Holds static methods for use 


import java.io.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Prompt 
{
     private static final Scanner in = new Scanner(System.in);
     //
     // Reads console input and checks if it is the correct type (int)
     
     
     public static File getInputFile(String prompt)
     {
          while(true)
          {
               System.out.println(prompt);
               String fileName= in.nextLine();
               File inputFile= new File(fileName+".txt");
               if(inputFile.exists())
               {
                    return inputFile;
               }
               else
               {
                    System.out.println("Error: "+fileName+" does not exist");
               }
          }
     }
     
     
     
     
     
     /**Opens a Scanner for inputting from a File selected from inputFile method
       * @param prompt The prompting message for the user
       * @return A Scanner object for reading a File selected by the user
       */ 
     public static Scanner getInputScanner(String prompt)
     {
          //Open and return the Scanner for a File
          try
          {
               return (new Scanner(newFile(prompt)));
          } 
          catch (FileNotFoundException ex) //Should not be needed
          {
               System.out.println(ex.getMessage());
               System.exit(1);
          }
          return null;
     }
     
     
     /**Opens a PrintWriter for output
       * @param prompt The prompting message for the user
       * @return A PrintWriter object for output
       */ 
     public static PrintWriter getPrintWriter(String prompt)
     {
          //Open and return the Scanner for a File
          try
          {
               System.out.print(prompt);
               String name = in.nextLine().trim();  //The name of the file
               return (new PrintWriter(new File(name)));
          } 
          catch (FileNotFoundException ex) //Should not be needed
          {
               System.out.println(ex.getMessage());
               System.exit(1);
          }
          return null;
     }
     
     
     // Reads console input and checks if it is the correct type (int)
     // and validates the number is within the requested range - lowValue to highValue
     public static int getInt(String prompt, int lowValue, int highValue)
     {
          //
          // Loop until a valid entry is received
          //
          while(true)
          {
               // 
               // Get input
               //
               System.out.println(prompt + " Low Value: " + lowValue + " High Value: " + highValue );
               
               //
               // Check if it is an integer
               //
               if(Prompt.in.hasNextInt())
               {
                    // Integer inputted, return result
                    int answer = Prompt.in.nextInt();
                    Prompt.in.nextLine();
                    
                    // Check if the number is in required range
                    
                    if (answer < lowValue || answer > highValue) {
                         //Out of Range Error
                         System.out.println(answer + " is out of Range. Expected Range: Low Value: " + lowValue + " High Value: " + highValue );
                    }
                    else {
                         //answer is OK
                         return answer;
                    }
                    
               }
               else
               {
                    // Invalid data type entered
                    String input = Prompt.in.nextLine();
                    System.out.println("Error:" + input + " is not an integer.");
               }
          }
          
     }
     
     
     
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     public static int getInt(String prompt)
     {
          int answer = 0;
          while (true)
          {
               // 
               // Get input
               //
               System.out.println(prompt);
               
               //
               // Check if it is an integer
               //
               if(Prompt.in.hasNextInt())
               {
                    // Integer inputted, return result
                    answer = Prompt.in.nextInt();
                    Prompt.in.nextLine();
                    
                    if (checkRange(answer) == true)
                    {
                         break;
                    }
                    
                    else
                    {
                         // Invalid data type entered
                         System.out.println ("Error:" + answer + " is not in range");
                         
                    }
               }
               
               else
               {
                    // Invalid data type entered
                    String input = Prompt.in.nextLine();
                    System.out.println("Error:" + input + " is not an integer.");
               }
               
               
          }
          return answer;
     }
     
     
     public static double getDouble(String prompt, double lowValue, double highValue)
     {
          //
          // Loop until a valid entry is received
          //
          while(true)
          {
               // 
               // Get input
               //
               System.out.println(prompt + " Input Range: " + lowValue + " High Value: " + highValue );
               
               //
               // Check if it is a double
               //
               if(Prompt.in.hasNextDouble())
               {
                    // Double inputted, return result
                    double answer = Prompt.in.nextDouble();
                    Prompt.in.nextLine();
                    
                    // Check if the number is in required range
                    
                    if (answer < lowValue || answer > highValue) {
                         //Out of Range Error
                         System.out.println(answer + " is out of Range. Expected Range: Low Value: " + lowValue + " High Value: " + highValue );
                    }
                    else {
                         //answer is OK
                         return answer;
                    }
               }
               else
               {
                    // Invalid data type entered
                    String input = Prompt.in.nextLine();
                    System.out.println("Error:" + input + " is not a float number.");
               }
          }
     }
     
     
     
     
     
     public static String getString(String prompt)
     {
          
          
          // 
          // Get input
          //
          System.out.println(prompt);
          String answer = Prompt.in.nextLine();
          //Prompt.in.nextLine();
          return answer;
     }
     
     
     
     
     
     public static double getDouble(String prompt)
     {
          //
          // Loop until a valid entry is received
          //
          while(true)
          {
               // 
               // Get input
               //
               System.out.println(prompt);
               
               //
               // Check if it is a double
               //
               if(Prompt.in.hasNextDouble())
               {
                    // Double inputted, return result
                    double answer = Prompt.in.nextDouble();
                    Prompt.in.nextLine();
                    return answer;
               }
               else
               {
                    // Invalid data type entered
                    String input = Prompt.in.nextLine();
                    System.out.println("Error:" + input + " is not a float number.");
               }
          }
     }
     
     
     
     
     
     //Runs a try catch statement to make sure the Scanner that has been initialized can be used 
     public static Scanner checkFile (File name)
     {
          while (true)
          {
               //Open and return the Scanner for a File
               try
               {
                    Scanner newFile = new Scanner (name);
                    return newFile;
               } 
               catch (FileNotFoundException ex) //Should not be needed
               {
                    System.out.println(ex.getMessage());
                    System.exit(1);
               }
          }
     }
     
     
     
     
     //Runs a try catch statement to make sure the PrintWriter that has been initialized can be used 
     public static PrintWriter checkOutput (String name)
     {
          while (true)
          {
               //Open and return the PrintWriter for a File
               try
               {
                    PrintWriter  newFile = new PrintWriter (name);
                    return newFile;
               } 
               catch (FileNotFoundException ex) //Should not be needed
               {
                    System.out.println(ex.getMessage());
                    System.exit(1);
               }
          }
     }
     
     
     
     
     
     
     /** Opens a File
       * @param prompt The prompting message for the user
       * @return A File representing the readable file selected by the user
       */ 
     public static File newFile(String prompt)
     {
          //Continue prompting for file input until file is found
          while (true)
          {
               System.out.print(prompt);
               String name = in.nextLine().trim(); //The name of the file
               File f = new File(name); //The file
               
               if (!f.exists()) //If file does not exist
               {
                    System.out.println("Error: " + name + " does not exist.");
               }
               else if (f.isDirectory()) //If file is a directory instead of a file
               {
                    System.out.println("Error: " + name + " is a directory.");
               }
               else if (!f.canRead()) //If file is not readable
               {
                    System.out.println("Error: " + name + " is not readable.");
               }
               else //If file is found
               {
                    return f;
               }
          }
     } //end of newFile method
     
     
     
     
     
     /**Opens a PrintWriter for output
       * @param prompt The prompting message for the user
       * @return A PrintWriter object for output
       */ 
     public static PrintWriter outputFile(String prompt)
     {
          //Open and return the Scanner for a File
          try
          {
               System.out.print(prompt);
               String name = in.nextLine().trim();  //The name of the file
               return (new PrintWriter(new File(name)));
          } 
          catch (FileNotFoundException ex) //Should not be needed
          {
               System.out.println(ex.getMessage());
               System.exit(1);
          }
          return null;
     }
     
     
     
     
     //Checks range for an integer that has been input
     private static boolean checkRange (int prompt)
     {
          if (prompt <= 100 && prompt >=1)
          {
               return true;
          }
          else 
          {
               
               return false;
          }
     }
     
     
     public static void saveMessage(String message)
     {
          PrintWriter out = Prompt.getPrintWriter("Please enter the name of the file that you would like to save your coded message to.");
          out.println(message);
          out.close();
          System.out.println("File Saved");
     }
}

