package com.github.brockstar17;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JPanel;

public class PaintDisplay extends JPanel{
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int)d.getWidth(), h = (int)d.getHeight();
	
	@Override
	public void paintComponent(Graphics g){
		//background
		g.fillRect(0, 0, w/2, h);
		List<Integer> l = Plotting.dataReturn();
		for(int i=0;i<360;i+=10){
			Line a = new Line(w/4, h/2, w/4+(int)(Math.cos(Math.toRadians(i))*100), h/2+(int)(Math.sin(Math.toRadians(i))*100), 100);
			a.drawLine(g, new int[]{0,255,0});
			System.out.println(a.x2);
		}
	}
}
