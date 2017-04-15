package com.github.brockstar17.userinterface;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintInterface extends JPanel{
	private int s;
	
	/**
	 * 
	 * @param s the width of the component
	 */
	public PaintInterface(int s){
		this.s = s;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
        Color color1 = Color.BLACK;
        Color color2 = Color.decode("#8514FF");
        int w = getWidth();
        int h = getHeight(); 
        GradientPaint gp = new GradientPaint(
                0, 0, color1,
                0, h, color2);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
	}
}
