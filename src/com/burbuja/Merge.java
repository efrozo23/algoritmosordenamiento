package com.burbuja;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Merge {

	private static int count = 0;
	private static XYSeries data = new XYSeries("Crecimiento");

	public static void main(String[] args) throws IOException {
		System.out.println("LISTA N INGRESADA POR EL USUARIO");
		
		
		// Enter data using BufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		resultados();
		while (true) {
			String x = reader.readLine();
			
			mostrarLista(Integer.valueOf(x));
			
		}

	}

	public static void showGraf(XYSeries data) {
		// Informacion

		XYSeries carro = data;
		

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(carro);
		

		JFreeChart xylineChart = ChartFactory.createXYLineChart("MERGE", "Size", "F(Size)", dataset,
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
		ventana.setSize(800, 800);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ventana.add(panel);
	}

	public static void resultados() {

		for (int i = 50; i <= 1000; i += 50) {
			int val[] = generador(i);
			mergeSort(val, val.length);
			data.add(i, count);
			count = 0;
		}
		
		showGraf(data);

	}

	public static void mostrarLista(int n) {
		count = 0;
		int val[] = generador(n);
		for (int i = 0; i < val.length; i++) {
			System.out.println(val[i]);
		}
		System.out.println("INICIO A ORDENAR");
		mergeSort(val, val.length);
		for (int i = 0; i < val.length; i++) {
			System.out.println(val[i]);
		}
		System.out.println("Tamano de lista:" + n + "- Comparaciones:" + count);
		data.add(n, count);
		showGraf(data);
		

	}

	public static int[] generador(int n) {
		Random r = new Random();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = r.nextInt(n) + 1;
		}
		return a;

	}

	public static void mergeSort(int[] a, int n) {
		if (n < 2)
			return;
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);
		merge(a, l, r, mid, n - mid);
		count++;

	}

	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < left && j < right) {

			if (l[i] <= r[j]) {
				a[k++] = l[i++];

			} else {
				a[k++] = r[j++];

			}

		}

		while (i < left) {

			a[k++] = l[i++];
		}

		while (j < right) {

			a[k++] = r[j++];
		}

	}

}
