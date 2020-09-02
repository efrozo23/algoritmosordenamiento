package com.burbuja;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static Logger log = Logger.getLogger("Main");

	public static void main(String args[]) {
		log.info("INICIO EL PROGRAMA");
		String data = "-1,0,1,1,2,1,3,4,1";
		int[][] arr = llenarData(data);
		int[][] a = new int[][] {{-1,0},{1,2},{3,4},{-2,5}};
		metodo1(arr);
		metodo2(a);
	}

	public static int[][] llenarData(String data) {
		String[] dataArray = data.split(",");
		double raiz = Math.sqrt(dataArray.length);
		int n = (int) raiz;
		int a[][] = new int[n][n];
		int poss = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = Integer.valueOf(dataArray[poss]);
				poss++;
			}
		}

		return a;

	}

	public static void metodo1(int a[][]) {
		int max = Integer.MAX_VALUE;
		
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				count++;
				if (a[i][j] < max) {
					max = a[i][j];
				}

			}
		}
		log.log(Level.INFO, "Valor minimo: {0} , comparaciones:{1}", new Object[] { max, count });
	}

	public static void metodo2(int a[][]) {
		int min = Integer.MAX_VALUE;
		int count = 0;
		int c[][] = a;
		int aux = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				count++;
				if (a[i][j] < min) {
					min = a[i][j];
					
				}

				if ((j + 1) == a[i].length) {
					c[i][0] = min;
					if (c[i][0] < aux) {
						aux = c[i][0];
						
					}
					min = Integer.MAX_VALUE;
				}
			}
		}

		log.log(Level.INFO, "Valor minimo: {0} , comparaciones:{1}", new Object[] { aux, count });
	}

}
