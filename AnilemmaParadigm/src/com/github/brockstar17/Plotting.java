package com.github.brockstar17;

import java.util.ArrayList;
import java.util.List;

public class Plotting {

	static List<Double> line = new ArrayList<Double>();
	static List<Double> line2 = new ArrayList<Double>();
	private static int xs, ys;

	public static void dataProcess(double[] points) {
		// 0-65535
		// 683x683
		//BUtils.sout(points.length);
		
		for (int i = 0; i < points.length; i++) {
			
			//BUtils.sout(683 * (points[i] / 65535));
			line.add(683 * (points[i] / 65535));

			if (i % 4 == 0 && i != 0) {
				xs = (int) ((line.get(line.size() - 1) - 1) - (line.get(line.size() - 1) - 3));
				ys = (int) ((line.get(line.size() - 1)) - (line.get(line.size() - 1) - 2));
				//BUtils.sout((int) Math.sqrt((xs * xs) + (ys * ys)));
				line.add(966 - Math.sqrt((xs * xs) + (ys * ys)));
			}
		}
		BUtils.sout(dataReturn());
		
		
	}

	public static List<Double> dataReturn() {

		line2 = line;
		/*if(line.isEmpty()){
			BUtils.sout("Empy");
		}*/
		//BUtils.sout(line);
		line.clear();
		return line2;
	}

	public static double[] byteProcess(byte[] b) {

		double[] array = new double[(b.length/2)];
		int a, c, d = 0;

		for (int i = 0; i <= b.length - 1; i += 2) {
			a = ((b[i] & 0xFF) + 0);
			c = ((b[i + 1] & 0xFF) + 0);
			
			//BUtils.sout("a " + a + "b " + c);
			
			array[d] = a * c;
			d++;
		}
		
		

		return array;
	}

}
