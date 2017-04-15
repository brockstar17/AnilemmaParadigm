package com.github.brockstar17;

import java.util.ArrayList;
import java.util.List;

public class Plotting {

	static List<Integer> line = new ArrayList<Integer>();
	static List<Integer> line2 = new ArrayList<Integer>();
	static int xs, ys;

	public static void dataProcess(int[] x, int[] y){
		//0-65535		
		//683x683
		
		for(int i = 0; i <= x.length; i++){
			
			line.add(683*(x[i]/65535));
			line.add(683*(y[i]/65535));
			
			if(i % 4 == 0 && i != 0){				
				xs = (line.get(line.size()-1)-1) - (line.get(line.size()-1)-3);
				ys = (line.get(line.size()-1)) - (line.get(line.size()-1)-2);
				line.add((int) Math.sqrt((xs*xs) + (ys*ys)));
			}
		}
	}

	public static List<Integer> dataReturn() {

		line2 = line;
		line.clear();
		return line2;
	}

}
