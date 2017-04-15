package com.github.brockstar17;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.github.brockstar17.userinterface.PaintInterface;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	
	
	public GUI(){
		super("Anilemma Paradigm");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int s = (int)(d.getWidth()/2);
		
		setSize(s, s);
		
		Container c = getContentPane();
		c.add(new PaintInterface(s));
		
		setLocation(0, 0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	
	
	
}
