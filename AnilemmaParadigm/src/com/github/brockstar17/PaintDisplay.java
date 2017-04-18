package com.github.brockstar17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PaintDisplay extends JPanel implements ActionListener{

	private int scale = 200;
	public int inc = 0;
	public int wait = 0;
	
	static ArrayList<Double> line = new ArrayList<Double>();
	private static double xs, ys;
	
	public PaintDisplay(){
		Timer t = new Timer(10, this);
		t.start();
		
	}

	public void setScale(int a) {
		scale = a;
	}

	@Override
	public void paintComponent(Graphics g) {
		// background
		int w = this.getWidth(), h = this.getHeight();
		g.setColor(Color.black);
		g.fillRect(0, 0, w, h);
		// getData
		//List<Double> l = Plotting.dataReturn();
		//BUtils.sout(l.get(4));
		//List<Double> l = //((List<Double>) ((ArrayList<Double>) line).clone()); 
		//BUtils.sout(line);
		//
		

		for (int k = 0; k < line.size()-4; k += 5) {
		Line temp = new Line(line.get(k) , line.get(k + 1), line.get(k + 2), line.get(k + 3), Math.min(255, line.get(k + 4)));
			temp.drawLine(g, new int[] { 0, 255, 0 });
		temp.inten--;
		}
		//Line a = new Line(100.0, 100.0, 200.0, 200.0, 255);
		//a.drawLine(g, new int[]{255,0,0});
		
	}
	
	public static void dataProcess(double[] points) {
		// 0-65535
		// 683x683
		//BUtils.sout(points.length);
		
		for (int i = 0; i < points.length; i++) {
			
			//BUtils.sout(683 * (points[i] / 65535));
			line.add(683 * (points[i] / 65535));

			if (i % 4 == 0 && i != 0) {
				xs = ((line.get(line.size() - 1) - 1) - (line.get(line.size() - 1) - 3));
				ys = ((line.get(line.size() - 1)) - (line.get(line.size() - 1) - 2));
				//BUtils.sout(line.get(line.size() - 1) - 1 + " " + (line.get(line.size() - 1) - 3));
				
				
				BUtils.sout((int) Math.sqrt((xs * xs) + (ys * ys))/966 * 255);
				//BUtils.sout(xs + " " + ys + "" );
				//BUtils.sout(line.size());
				line.add((Math.sqrt((xs * xs) + (ys * ys)))/966 * 255);
			}
		}
		//BUtils.sout(line.get(0) + " " + line.get(1) + " " + line.get(5));
		//BUtils.sout(line);
		
		
	}

	public static List<Double> dataReturn() {

		/*if(line.isEmpty()){
			BUtils.sout("Empy");
		}*/
		//BUtils.sout(line);
		//line.clear();
		return line;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		wait++;
		if(wait >= 10){
			line.clear();
			wait = 0;
		}
		//BUtils.sout(line.size());
	}
}
