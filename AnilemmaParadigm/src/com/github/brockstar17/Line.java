package com.github.brockstar17;

import java.awt.Color;
import java.awt.Graphics;

public class Line {
	public Color color;
	public int x1,y1,x2,y2,inten;
	
	//two constructors, one for all int, one for all double
	public Line(int x1, int y1, int x2, int y2, int i){
		this.x1=x1;this.x2=x2;this.y1=y1;this.y2=y2;this.inten=i;
	}
	public Line(double x1, double y1, double x2, double y2, double i){
		this.x1=(int)x1;this.x2=(int)x2;this.y1=(int)y1;this.y2=(int)y2;this.inten=(int)i;
	}
	
	//draw line on g with int[3] color
	public void drawLine(Graphics g, int[] color){
		g.setColor(new Color(color[0], color[1], color[2], this.inten));
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
	}
}
