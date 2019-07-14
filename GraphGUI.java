/** Class name:          graphGUI
  * Author:              Nawal M.
  * Date Modified:       24/12/2018
  * Description:         The GUI View for displaying the graphs and additional info
  */

/*     
 import javax.swing.*;
 import java.awt.*;  
 import java.io.File;
 
 public class GraphGUI extends JPanel{
 
 //Instance Variables
 private Graph graphModel;                  //The game Model 
 
 
 
 private JPanel fileInput= new JPanel();
 private JFileChooser chooseData= new JFileChooser();
 private JLabel enterFile= new JLabel("Enter data from a file:");
 private JButton fileInputted= new JButton("Choose File");
 private JPanel manualInput= new JPanel();
 private JLabel enterPoints= new JLabel("Enter in the data points:");
 private JTextField dataInputted= new JTextField(10);
 private JPanel graphButton= new JPanel();
 private JLabel pickGraph= new JLabel("Create Graph:");
 private JButton graph= new JButton("Choose graph");
 private JButton freqGraph= new JButton("Frequency Graph");
 private JButton cumulativeFreqGraph= new JButton("Cumulative Frequency Graph");
 private JButton relativeFreqGraph= new JButton("Relative Frequency Graph");
 private JButton additionalInfo= new JButton("Additional Info");
 private JPanel graphFreqDisplay= new JPanel();
 private  JPanel graphRelativeDisplay= new JPanel();
 private JPanel graphCumulativeDisplay= new JPanel();
 
 //Graph Display Components
 private JPanel title= new JPanel();  
 private JLabel titleFreq= new JLabel("Frequency Graph");
 private JLabel titleCumulativeFreq= new JLabel("Cumulative Frequency  Graph");
 private JLabel titleRelativeFreq= new JLabel("Relative Frequency Graph");
 private JPanel display= new JPanel();
 private JPanel otherOptions= new JPanel();
 
 
 public GraphGUI(Graph newGraph)
 {
 super();
 this.graphModel = newGraph;
 this.graphModel.setGUI(this);
 this.layoutView();
 this.registerControllers();
 }
 
 
 private void layoutView()
 {
 fileInput.add(fileInputted);
 
 manualInput.add(enterPoints);
 manualInput.add(dataInputted);
 
 graphButton.add(pickGraph);
 graphButton.add(graph);
 
 
 this.setLayout(new BorderLayout());
 this.add(this.fileInput, BorderLayout.NORTH);
 this.add(this.manualInput, BorderLayout.CENTER);
 this.add(this.graphButton, BorderLayout.SOUTH);
 }
 
 
 private void registerControllers()
 {
 FreqGraphController freqController = new FreqGraphController(this.graphModel, this.freqGraph);
 this.freqGraph.addActionListener(freqController);
 
 CumulativeGraphController cumulativeController = new CumulativeGraphController(this.graphModel, this.cumulativeFreqGraph);
 this.cumulativeFreqGraph.addActionListener(cumulativeController);
 
 RelativeFreqGraphController relativeController = new RelativeFreqGraphController(this.graphModel, this.relativeFreqGraph);
 this.relativeFreqGraph.addActionListener(relativeController);
 
 AdditionalInfoController additionalController = new AdditionalInfoController(this.graphModel, this.additionalInfo);
 this.additionalInfo.addActionListener(additionalController); 
 
 GraphController graphController = new GraphController(this.graphModel, this.graph);
 this.graph.addActionListener(graphController);
 
 DataInputController inputController = new DataInputController(this.graphModel, this.dataInputted);
 this.dataInputted.addActionListener(inputController);
 
 FileInputController fileController = new FileInputController(this.graphModel, this.fileInputted);
 this.fileInputted.addActionListener(fileController);
 }
 
 
 public void displayGraphChoices()
 {
 graphFreqDisplay.add(freqGraph);
 
 graphRelativeDisplay.add(relativeFreqGraph);
 
 graphCumulativeDisplay.add(cumulativeFreqGraph);
 
 this.setLayout(new BorderLayout());
 this.add(this.graphFreqDisplay, BorderLayout.NORTH);
 this.add(this.graphRelativeDisplay, BorderLayout.CENTER);
 this.add(this.graphCumulativeDisplay, BorderLayout.SOUTH);
 }
 
 
 public void displayCumulativeFrequencyGraph()
 {
 
 title.add(titleCumulativeFreq);
 //display.add(drawnFreqGraph);
 otherOptions.add(freqGraph);
 otherOptions.add(relativeFreqGraph);
 otherOptions.add(additionalInfo);
 this.setLayout(new BorderLayout());
 this.add(this.title, BorderLayout.NORTH);
 this.add(this.display, BorderLayout.CENTER);
 this.add(this.otherOptions, BorderLayout.SOUTH);
 
 }
 
 
 public void displayRelativeFrequencyGraph()
 {
 /*
 title.add(titleRelativeFreq);
 //display.add(drawnFreqGraph);
 otherOptions.add(freqGraph);
 otherOptions.add(cumulativeFreqGraph);
 otherOptions.add(additionalInfo);
 this.setLayout(new BorderLayout());
 this.add(this.title, BorderLayout.NORTH);
 this.add(this.display, BorderLayout.CENTER);
 this.add(this.otherOptions, BorderLayout.SOUTH);
 
 }
 
 
 public void displayFrequencyGraph()
 {
 //Variable Declarations
 Startup.f.setVisible(false);
 JFrame frame = new JFrame();                            //The Frame
 JPanel contents = new JPanel();                         //The Content Pane
 JButton cumulativeFreqGraph= new JButton("Cumulative Frequency Graph");
 JButton relativeFreqGraph= new JButton("Relative Frequency Graph");
 JButton additionalInfo= new JButton("Additional Info");
 DrawFreqGraph drawnFreqGraph= new DrawFreqGraph();
 
 //Add components to panels
 title.add(titleFreq);
 display.add(drawnFreqGraph);
 
 otherOptions.setLayout(new FlowLayout());
 otherOptions.add(relativeFreqGraph);
 otherOptions.add(additionalInfo);
 otherOptions.add(cumulativeFreqGraph);
 
 contents.setLayout(new BorderLayout());
 contents.add(title, BorderLayout.NORTH);
 
 contents.add(display, BorderLayout.CENTER);
 
 contents.add(otherOptions, BorderLayout.SOUTH);
 
 //Display frame
 frame.setContentPane(contents);
 frame.setTitle("");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.pack();
 frame.setLocation(0,0);
 frame.setVisible(true);
 }
 
 
 public static void updateAdditional()
 {
 }
 
 
 }
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.TableModel;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class GraphGUI extends JPanel
{
     private Graph graphData;
     
     JButton fileInput = new JButton("Choose a file");
     JButton generateGraph = new JButton("Generate Graph");
     JFileChooser chooseFile = new JFileChooser();
     JPanel buttons = new JPanel();
     JTabbedPane data = new JTabbedPane();
     JPanel tab1 = new JPanel();
     JPanel tab2 = new JPanel();
     JPanel tab3 = new JPanel();
     JPanel tab4 = new JPanel();
     JPanel tab5 = new JPanel();
     JPanel dataDisplay = new JPanel();
     JPanel statusPanel = new JPanel();
     DefaultTableModel model = new DefaultTableModel();
     JTable numbers = new JTable(model);
     JScrollPane scrollTable;
     JLabel text = new JLabel("Please either choose a file or enter numbers into the table to get Statistical metrics on it.");
     JLabel mean = new JLabel("Mean:");
     JLabel median = new JLabel("Median:");
     JLabel mode = new JLabel("Mode:");
     JLabel sd = new JLabel("Standard Deviation:");
     JLabel dataPoints = new JLabel("# of data points:");
     JLabel meanValue = new JLabel("___");
     JLabel medianValue = new JLabel("___");
     JLabel modeValue = new JLabel("___");
     JLabel sdValue = new JLabel("___");
     JLabel dataPointsValue = new JLabel("___");
     JLabel statusLabel = new JLabel();
     int fileSelected = 0;
     private JPanel title= new JPanel();  
     private JLabel titleFreq= new JLabel("Frequency Graph");
     private JLabel titleCumulativeFreq= new JLabel("Cumulative Frequency  Graph");
     private JLabel titleRelativeFreq= new JLabel("Relative Frequency Graph");
     private JPanel display= new JPanel();
     private JPanel otherOptions= new JPanel();
     private JButton freqGraph= new JButton("Frequency Graph");
     private JButton cumulativeFreqGraph= new JButton("Cumulative Frequency Graph");
     private JButton relativeFreqGraph= new JButton("Relative Frequency Graph");
     private JButton additionalInfo= new JButton("Additional Info");
     
     public GraphGUI(Graph newGraph)
     {
          super();
          this.graphData = new Graph();
          this.graphData.setGUI(this);
          this.layoutView();
          this.registerControllers();
     }
     
     private void layoutView()
     {
          this.setLayout(new BorderLayout());
          dataDisplay.setLayout(new GridLayout(2,2));
          buttons.add(text);
          buttons.add(fileInput);
          buttons.add(generateGraph);
          this.add(buttons, BorderLayout.NORTH);
//          dataDisplay.setLayout(new GridLayout(3,4));
//          dataDisplay.add(mean);
//          dataDisplay.add(meanValue);
//          dataDisplay.add(median);
//          dataDisplay.add(medianValue);
//          dataDisplay.add(mode);
//          dataDisplay.add(modeValue);
//          dataDisplay.add(sd);
//          dataDisplay.add(sdValue);
//          dataDisplay.add(dataPoints);
//          dataDisplay.add(dataPointsValue);
          tab1.setLayout(new BorderLayout());
          model.addColumn("Data");
          TableColumn column = null;
          for (int x = 0; x < 25; x++)
          {
               model.addRow(new Object[]{});
          }
          tab1.add(dataDisplay, BorderLayout.CENTER);
          dataDisplay.add(freqGraph);
          dataDisplay.add(cumulativeFreqGraph);
          dataDisplay.add(relativeFreqGraph);
          dataDisplay.add(additionalInfo);
          column = numbers.getColumnModel().getColumn(0);
          column.setPreferredWidth(100);
          
          scrollTable = new JScrollPane(numbers);
          scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
          tab1.add(scrollTable, BorderLayout.WEST);
          dataDisplay.setBorder(BorderFactory.createTitledBorder("Options"));
          data.add(tab1);
          data.setTitleAt(0,"Data & Statistical Metrics");
          this.add(data, BorderLayout.CENTER);
          data.add(tab2);
          data.add(tab3);
          data.add(tab4);
          data.add(tab5);
          data.setTitleAt(1, "Frequency Graph");
          data.setTitleAt(2, "Relative Frequency Graph");
          data.setTitleAt(3, "Cumulative Frequency Graph");
          data.setTitleAt(4, "Additional Information");
          
//      statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
//      statusPanel.setPreferredSize(new Dimension(this.getWidth(), 16));
//      statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
//      statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
//      statusPanel.add(statusLabel);
          // this.add(statusPanel,BorderLayout.SOUTH);
     }
     
     private void registerControllers()
     {
          GraphController controller = new GraphController(graphData, fileInput);
          this.fileInput.setActionCommand("LOADFILE");
          this.fileInput.addActionListener(controller);
          
          
          this.generateGraph.setActionCommand("GENGRAPH");
          this.generateGraph.addActionListener(controller);
          
          
          FreqGraphController freqController = new FreqGraphController(this.graphData, this.freqGraph);
          this.freqGraph.addActionListener(freqController);
          
          CumulativeGraphController cumulativeController = new CumulativeGraphController(this.graphData, this.cumulativeFreqGraph);
          this.cumulativeFreqGraph.addActionListener(cumulativeController);
          
          RelativeFreqGraphController relativeController = new RelativeFreqGraphController(this.graphData, this.relativeFreqGraph);
          this.relativeFreqGraph.addActionListener(relativeController);
          
//          AdditionalInfoController additionalController = new AdditionalInfoController(this.graphModel, this.additionalInfo);
//          this.additionalInfo.addActionListener(additionalController); 
     }
     /*
      public void UpdateStatMetrics(ArrayList<Double> data)
      {
      graphData.SetGraphData(data);
      meanValue.setText(graphData.getMean().toString());
      medianValue.setText(graphData.getMedian().toString());
      modeValue.setText(graphData.getMode().toString());
      sdValue.setText(graphData.getStandardDeviation().toString());
      dataPointsValue.setText(new Integer(data.size()).toString());
      }
      */
     public void UpdateData()
     {
          // Iterate through JTable and build ArrayList
          ArrayList<Integer> lstValues = new ArrayList<Integer>();
          
          for (int i=0; i < this.numbers.getRowCount(); i++)
          {
               Object value = ((DefaultTableModel)this.numbers.getModel()).getValueAt(i,0);
               if (value != null)
               {
                    try {
                         lstValues.add(Integer.parseInt(value.toString()));
                    }
                    catch (NumberFormatException ex)
                    {
                         continue;
                    }
                    
               }
               
          }
          // Update Stat Metrics 
          //if (lstValues.size() > 0)
          //UpdateStatMetrics(lstValues);
     }
     
     
     
     public void LoadFileData()
     {
          fileSelected = chooseFile.showOpenDialog(null);
          if (fileSelected == chooseFile.APPROVE_OPTION)
          {
               File myFile = chooseFile.getSelectedFile();
               BufferedReader reader = null;
               String fileContent = "";
               String line;
               try
               {
                    reader = new BufferedReader(new FileReader(myFile));
                    while ((line = reader.readLine()) != null)
                    {
                         fileContent+=line;
                    }
                    reader.close(); 
               }catch (Exception ex) {}
               
               String[] fileArray = fileContent.split(",");
               
               ArrayList<Integer> lstValues = new ArrayList<Integer>();
               int value;
               for (int i=0; i < fileArray.length; i++)
               {
                    try 
                    {
                         value = Integer.parseInt(fileArray[i]);
                         lstValues.add(value);
                    }
                    catch (NumberFormatException ex)
                    {
                         continue;
                    }
               }
               
               // Update JTable - Clear existing rows
               ( (DefaultTableModel) this.numbers.getModel()).setRowCount(0);
               
               // Add data from File
               for (Integer tmp: lstValues)
               {
                    // Append a row 
                    ((DefaultTableModel) this.numbers.getModel()).addRow(new Object[]{tmp});
               }
               
               //if (lstValues.size() > 0)
               //UpdateStatMetrics(lstValues);
          }
     }
     
     public void displayFrequencyGraph()
     {  
          JPanel contents = new JPanel();                        
          DrawFreqGraph drawnFreqGraph= new DrawFreqGraph();
          contents.add(drawnFreqGraph);
          tab2.add(contents);
          data.setSelectedIndex(1);
     }
     
     public void displayCumulativeFrequencyGraph()
     { 
          JPanel contents = new JPanel();                        
          DrawCumulativeGraph drawnCumGraph= new DrawCumulativeGraph();
          contents.add(drawnCumGraph);
          tab4.add(contents);
          data.setSelectedIndex(3);
     }
     public void displayRelativeFrequencyGraph()
     {                 
          JPanel contents = new JPanel();                        
          DrawRelativeGraph drawnRelGraph= new DrawRelativeGraph();
          contents.add(drawnRelGraph);
          tab3.add(contents);
          data.setSelectedIndex(2);
     }
     
     public void updateAdditional()
     {
          JPanel contents = new JPanel();
          tab5.add(contents);
     }
     
}     
