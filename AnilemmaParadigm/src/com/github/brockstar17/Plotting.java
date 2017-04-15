package com.github.brockstar17;

import java.util.ArrayList;
import java.util.List;

public class Plotting {

	static List<Integer> line = new ArrayList<Integer>();
	static List<Integer> line2 = new ArrayList<Integer>();
	static int xs, ys;

	public static void dataProcess(int[] points) {
		// 0-65535
		// 683x683

		for (int i = 0; i <= points.length; i++) {

			line.add(683 * (points[i] / 65535));

			if (i % 4 == 0 && i != 0) {
				xs = (line.get(line.size() - 1) - 1) - (line.get(line.size() - 1) - 3);
				ys = (line.get(line.size() - 1)) - (line.get(line.size() - 1) - 2);
				line.add((int) Math.sqrt((xs * xs) + (ys * ys)));
			}
		}
	}

	public static List<Integer> dataReturn() {

		line2 = line;
		line.clear();
		return line2;
	}

	public static int[] byteProcess(byte[] b) {

		int[] array = new int[b.length / 2];

		for (int i = 0; i <= b.length; i += 2) {
			array[i] = (b[i] & 0xFF) * (b[i + 1] & 0xFF);
		}

		return array;
	}

}
