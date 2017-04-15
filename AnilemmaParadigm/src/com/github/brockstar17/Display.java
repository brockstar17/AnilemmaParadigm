package com.github.brockstar17;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Display extends JFrame{
	
	public Display(){
		super("Display");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int s = (int)(d.getWidth()/2);
		
		setSize(s, s);
		setExtendedState(MAXIMIZED_VERT);
		
		
		setLocation(s, 0);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
}
