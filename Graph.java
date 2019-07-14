/** Class name:          Graph
  * Author:              Nawal M.
  * Date Modified:       24/12/2018
  * Description:         The model for storing and obtaining additional info from data sets
  */

import javax.swing.*;
import java.awt.event.*;  
import java.io.File;
import java.util.*;
import java.text.*;
public class Graph extends Object
{
     
     //Variable Declaration
     private static GraphGUI graphView;          //The view for the game
     
     private ArrayList <Double> dataValues = new ArrayList <Double> ();
     private double [] orderedValues;
     private double [] newOrder;
     private double [][] calculatedFrequency;
     private double [][] calculatedRelativeFrequency;
     private double [][] calculatedCumulativeFrequency;
     private double mean;
     private double median;
     private ArrayList <Double> mode = new ArrayList <Double> ();
     private double maxFreq;
     private double standardDeviation;
     private double quartileTwo;
     private double quartileOne;
     private double quartileThree;
     private double zScore;
     private double semiIQR;
     private int numValues;
     private double interval;
     private double interRange;
     private static double maxValue;
     private static double minValue;
     private boolean error = false;
     
     public Graph()
     {
          super();
     }
     
     private void intervals()
     {
          DecimalFormat value = new DecimalFormat("0.0");
          maxValue= this.newOrder[numValues];
          minValue= this.newOrder[0];
          
          if (maxValue > 20)
          {
               interval = Double.parseDouble(value.format(maxValue/20));
          }
          else if (maxValue <= 20)
          {
               interval = 1;
          }
     }
     
     public static double getMinValue()
     {
          return minValue;
     }
     
     public static double getMaxValue()
     {
          return maxValue;
     }
     
     public double getInterval()
     {
          return interval;
     }
     
     public void setGUI(GraphGUI currentGUI)
     {
          this.graphView = currentGUI;
     }
     
     public void addData (double x)
     {
          dataValues.add(x);
     }
     
     private void calculateFreq(int [] array)
     {
          int counter =0;
          int repeat = 0;
          for (int x = 0; x < numValues; x++)
          {
               int num = array [x];
               for (int i = 0; i < numValues; i++)
               {
                    if (array [i] == num)
                    {
                         counter ++;
                    }
               }
               if (counter > 1)
               {
                    repeat++;
               }
          }
          
          int rows= numValues- repeat;
          calculatedFrequency= new double [rows][2];
          
          double freq = 0;
          for (int x = 0; x < numValues; x++)
          {
               double num = array [x];
               for (int i = 0; i < numValues; i++)
               {
                    if (array [i] == num)
                    {
                         freq++;
                         
                    }
               }
               calculatedFrequency[x][0]=num;
               calculatedFrequency[x][1]=freq;
               freq=0;
          }
     }
     
     
     
     public double [][] getFreq()
     {
          return calculatedFrequency;
     }
     
     
     private void calculateRelativeFreq()
     {
          
          calculatedRelativeFrequency= new double [calculatedFrequency.length][2];
          
          for (int x = 0; x < calculatedFrequency.length; x++)
          {
               calculatedRelativeFrequency[x][0]= calculatedFrequency[x][0];
               calculatedRelativeFrequency[x][1]= (calculatedFrequency[x][1])/numValues;
          }
     }
     
     
     public double [][] getRelativeFreq()
     {
          return calculatedRelativeFrequency;
     }
     
     
     private void calculateCumulativeFreq (double [][] freq)
     {
          for (int x = 0; x < calculatedFrequency.length; x++)
          {
               calculatedCumulativeFrequency[x][0]= calculatedFrequency[x][0];
               for (int i = 0; i < calculatedFrequency.length; i++)
               {
                    calculatedRelativeFrequency[i][1]= (calculatedFrequency[i][1])/numValues;
               }
          }
          
     }
     
     
     private void calculateMean()
     {
          
          double total=0;
          
          for (double temp : dataValues)
          {
               total = total + temp;
               numValues++;
          }
          
          mean = total/numValues;
          
     }
     
     
     public double getMean()
     {
          return mean;
     }
     
     
     private void calculateMedian()
     {
          orderedValues = new double [numValues];
          int counter = 0;
          for (double temp : dataValues)
          {
               orderedValues[counter] = temp;
               counter++;
          }
          
          newOrder = bubbleSort(orderedValues);
          
          if (numValues % 2 ==0)
          {
               median = (newOrder[numValues/2] + newOrder [(numValues/2 +1)])/2;
          }
          else
          {
               median = newOrder[numValues/2] + 0.5;
          }
     }
     
     
     
     
     public double getMedian()
     {
          return median;
     }
     
     
     private void calculateMode()
     {
          maxFreq= calculatedFrequency[0][1];
          for (int x = 1; x < calculatedFrequency.length -1; x++)
          {
               maxFreq= Math.max(maxFreq, calculatedFrequency[x][1]);
          }
          
          for (int x = 1; x < calculatedFrequency.length -1; x++)
          {
               if (maxFreq== calculatedFrequency[x][1])
               {
                    mode.add(calculatedFrequency[x][0]);
               }
          }    
     }
     
     
     public ArrayList<Double> getMode()
     {
          return mode;
     }
     
     
     private void calculateStandardDeviation()
     {
          for (int x = 0; x < numValues; x++)
          {
               standardDeviation = standardDeviation + (Math.pow(orderedValues[x] - mean,2));
          }
          
          standardDeviation = Math.sqrt(standardDeviation/(numValues-1));
     }
     
     
     public double getStandardDeviation()
     {
          return standardDeviation;
     }
     
     
     private void calculateZScore(int standardDeviation)
     {
          double dataPoint = Prompt.getInt("Enter the data point you want the Z-Score for");
          zScore = (dataPoint - this.getMean())/this.getStandardDeviation();
     }
     
     
     public double getZScore()
     {
          return zScore;
     }
     
     
     public void calculateFirstQuartile()
     {
          ArrayList<Double> temp = new ArrayList<Double>();
          double median = getMedian();
          for (Double x: this.newOrder)
          {
               while (x <= median)
               {
                    temp.add(x);
               }
          }
          int index;
          if (temp.size() % 2 == 1)
          {
               index = (temp.size() + 1)/2 - 1;
               quartileOne = new Double(temp.get(index));
          }
          else
          {
               int startIndex = (temp.size()/2) - 1;
               int endIndex = startIndex + 1;
               
               quartileOne = new Double((temp.get(startIndex) + temp.get(endIndex))/2.0);
          }
     }
     
     
     
     public Double getFirstQuartile()
     {
          return quartileOne;
     }
     
     
     public void calculateThirdQuartile()
     {
          double median  = getMedian();
          ArrayList<Double> temp = new ArrayList<Double>();
          for (Double x: this.newOrder)
          {
               while (x >= median)
               {
                    temp.add(x);
               }
          }
          quartileThree = 0.0;
          int index;
          if (temp.size() % 2 == 1)
          {
               index = (temp.size() + 1)/2 - 1;
               quartileThree = new Double(temp.get(index));
          }
          else
          {
               int startIndex = (temp.size()/2) - 1;
               int endIndex = startIndex + 1;
               
               quartileThree = new Double((temp.get(startIndex) + temp.get(endIndex))/2.0);
          }
     }
     
     
     
     public double getThirdQuartile()
     {
          return quartileThree;
     }
     
     public void calculateIQR()
     {
          interRange = getThirdQuartile() - getFirstQuartile();
     }
     
     public double getIQR()
     {
          return interRange;
     }
     
     
     public void calculateSemiIQR()
     {
          semiIQR = getIQR()/2;
     }
     
     public Double getSemiIQR()
     {
          return semiIQR;
     }
     
     
     public static void updateView(int userChoice)
     {
          switch (userChoice)
          {
               
               case 1:
                    graphView.displayFrequencyGraph();
               case 2:
                    graphView.displayCumulativeFrequencyGraph();
               case 3:
                    graphView.displayRelativeFrequencyGraph();
////////////////////////               case 4:
////////////////////////                    graphView.updateAdditional();
////////////////////////               case 5:
////////////////////////                    graphView.displayGraphChoices(); 
          }
     }
      
     public static double [] bubbleSort( double [] array )
     {
          
          boolean flag = true;   // set flag to true to begin first pass
          double temp;   //holding variable
          
          while ( flag )
          {
               flag= false;    //set flag to false awaiting a possible swap
               for(int j=0;  j < array.length -1;  j++ )
               {
                    if ( array[ j ] < array[j+1] )   // change to > for ascending sort
                    {
                         temp = array[ j ];                //swap elements
                         array[ j ] = array[ j+1 ];
                         array[ j+1 ] = temp;
                         flag = true;              //shows a swap occurred  
                    } 
               } 
          }
          
          return array;
     }
     
     public void SetGraphData(ArrayList<Double> data)
     {
          this.dataValues = data;  
     }
     
     public boolean validateData()
     {
          for (int x = 1; x < graphView.model.getRowCount(); x++)
          {
               try 
               {
                    int value = 0;
                    value = Integer.parseInt(graphView.model.getValueAt(x,1));
               }
               catch (Exception ex)
               {
                    error = true;
               }
          }
          return error;
     }
}





