package com.github.brockstar17;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PaintDisplay extends JPanel{
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	
	@Override
	public void paintComponent(Graphics g){
		//background
		g.fillRect(0, 0, (int)d.getWidth()/2, (int)d.getHeight());
		
		
	}
}
