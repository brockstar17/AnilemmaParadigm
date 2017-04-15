package com.github.brockstar17;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JFrame{
	
	public Dimension size;
	
	public Display(){
		super("Display");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		size = this.getSize();
		int s = (int)(d.getWidth()/2);
		
		setSize(s, s);
		setExtendedState(MAXIMIZED_VERT);
		
		setLocation(s, 0);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		Container c = getContentPane();
		this.add(new PaintDisplay());
		
	}
}
