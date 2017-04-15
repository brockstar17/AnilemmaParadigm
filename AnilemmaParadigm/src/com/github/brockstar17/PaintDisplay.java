package com.github.brockstar17;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class PaintDisplay extends JPanel{
	
	private int scale = 200;
	public int inc = 0;
	
	public void setScale(int a){
		scale=a;
	}
	
	@Override
	public void paintComponent(Graphics g){
		//background
		int w = this.getWidth(), h = this.getHeight();
		g.fillRect(0, 0, w, h);
		//getData
		List<Integer> l = Plotting.dataReturn();
		for(int k=0;k<l.size();k+=5){
			Line temp = new Line(l.get(k)*scale,l.get(k+1)*scale,l.get(k+2)*scale,l.get(k+3)*scale,l.get(k+4));
			temp.drawLine(g, new int[]{0,255,0});
		}
	}
}
