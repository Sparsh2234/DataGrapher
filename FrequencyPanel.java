import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

  
public class FrequencyPanel extends JPanel {

        
        private Map<Integer, Integer> counts;
        private int numberYDivisions  = 1;
        private GraphData graphData;
        private int maxFrequency;
        private int minFrequency;

        public FrequencyPanel(GraphData graphData) {
            this.graphData = graphData;
            this.counts = graphData.getDataFrequency();
            this.maxFrequency = graphData.getMaxFrequency(this.counts);
            this.minFrequency = graphData.getMinFrequency(this.counts);
           
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

           double xScale = ((double) getWidth() - (2 * GraphConstants.padding) - GraphConstants.labelPadding) / (this.counts.size() - 1);
           double yScale = ((double) getHeight() - 2 * GraphConstants.padding - GraphConstants.labelPadding) / (this.maxFrequency - this.minFrequency + 1);
           
            // draw white background
           g2.setColor(Color.WHITE);
           g2.fillRect(GraphConstants.padding + GraphConstants.labelPadding, GraphConstants.padding, getWidth() - (2 * GraphConstants.padding) - GraphConstants.labelPadding, getHeight() - 2 * GraphConstants.padding - GraphConstants.labelPadding);
           g2.setColor(Color.BLACK);
           
           numberYDivisions = graphData.getMaxFrequency(this.counts);
           System.out.println("No of divisions = " +numberYDivisions);
           
           int count=0;
           List<Point> graphPoints = new ArrayList<Point>();
           for (Integer key: this.counts.keySet()) {
            int x1 = (int) (count * xScale + GraphConstants.padding + GraphConstants.labelPadding);
            int y1 = (int) ((numberYDivisions - this.counts.get(key)) * yScale + GraphConstants.padding);
            graphPoints.add(new Point(x1, y1));
            count++;
            System.out.println("X = " + x1 + " Y = " + y1);
           }
           
             // create hatch marks and grid lines for y axis.
           for (int i = 0; i < numberYDivisions + 1; i++) {
            int x0 = GraphConstants.padding + GraphConstants.labelPadding;
            int x1 = GraphConstants.pointWidth + GraphConstants.padding + GraphConstants.labelPadding;
            int y0 = getHeight() - ((i * (getHeight() - GraphConstants.padding * 2 - GraphConstants.labelPadding)) / numberYDivisions + GraphConstants.padding + GraphConstants.labelPadding);
            System.out.println("Y = " + y0);
            int y1 = y0;
            if (this.counts.size() > 0) {
                g2.setColor(GraphConstants.gridColor);
                // Draw Grid Lines
                g2.drawLine(GraphConstants.padding + GraphConstants.labelPadding + 1 + GraphConstants.pointWidth, y0, getWidth() - GraphConstants.padding, y1);
                g2.setColor(Color.BLACK);
                String yLabel = i + "";
               // String yLabel = (((this.graphData.getMinValue() + this.graphData.getMaxValue() - this.graphData.getMinValue())) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            // Draw Hatch Marks
            g2.drawLine(x0, y0, x1, y1);
        }
        
          // and for x axis
          int i = 0;
          for (Integer key: this.counts.keySet()) {
            if (this.counts.size() > 1) {
                int x0 = i * (getWidth() - GraphConstants.padding * 2 - GraphConstants.labelPadding) / (this.counts.size() - 1) + GraphConstants.padding + GraphConstants.labelPadding;
                int x1 = x0;
                int y0 = getHeight() - GraphConstants.padding - GraphConstants.labelPadding;
                int y1 = y0 - GraphConstants.pointWidth;
               
                    // Draw Stroke
                    g2.setColor(GraphConstants.gridColor);
                    g2.drawLine(x0, getHeight() - GraphConstants.padding - GraphConstants.labelPadding - 1 - GraphConstants.pointWidth, x1, GraphConstants.padding);
                    g2.setColor(Color.BLACK);
                    
                    // Draw Label
                    String xLabel = key + "";
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                    
                    int height = getHeight() - ((this.counts.get(key) * (getHeight() - GraphConstants.padding * 2 - GraphConstants.labelPadding)) / numberYDivisions + GraphConstants.padding + GraphConstants.labelPadding);
                    g2.setColor(Color.GREEN);
                    System.out.println("height = " + height);
                   // g2.fillRect(x0, y0-height + (padding + labelPadding), BAR_WIDTH - 10, height);
                    
                    i++;
               
            }
        }
        
        // Draw Lines between points
        Stroke oldStroke = g2.getStroke();
        g2.setColor(GraphConstants.lineColor);
        g2.setStroke(GraphConstants.GRAPH_STROKE);
        for (int j = 0; j < graphPoints.size() - 1; j++) {
            int x1 = graphPoints.get(j).x;
            int y1 = graphPoints.get(j).y;
            int x2 = graphPoints.get(j + 1).x;
            int y2 = graphPoints.get(j + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }
        
        // Fill Points
        g2.setStroke(oldStroke);
        g2.setColor(GraphConstants.pointColor);
        for (int k = 0; k< graphPoints.size(); k++) {
            int x = graphPoints.get(k).x - GraphConstants.pointWidth / 2;
            int y = graphPoints.get(k).y - GraphConstants.pointWidth / 2;
            int ovalW = GraphConstants.pointWidth;
            int ovalH = GraphConstants.pointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }

        }
       
}