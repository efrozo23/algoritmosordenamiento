package com.burbuja;

import java.awt.BasicStroke;
import java.awt.Color;
 
import javax.swing.JFrame;
 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
 
public class Init
{
 
    public static void main(String[] args) {
 
        //Informacion
 
        XYSeries carro = new XYSeries("Automovil");
        carro.add(10.0, 1.0);
        carro.add(2.0, 4.0);
        carro.add(3.0, 3.0);
 
        XYSeries bici = new XYSeries("Bicicleta");
        bici.add(1.0, 4.0);
        bici.add(2.0, 5.0);
        bici.add(3.0, 6.0);
 
        XYSeries moto = new XYSeries("Motocicleta");
        moto.add(10.0, 4.0);
        moto.add(4.0, 5.0);
        moto.add(5.0, 4.0);
 
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(carro);
        
 
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Grafica XY",
                "Transporte",
                "Putuacion",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
 
       
        XYPlot plot = xylineChart.getXYPlot();
       
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
       
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.YELLOW);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
       
        ChartPanel panel = new ChartPanel(xylineChart);
 
        // Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        ventana.add(panel);
 
    }
 
}