package com.github.brockstar17;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.brockstar17.userinterface.PaintInterface;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	
	
	
	
	public GUI(){
		super("Anilemma Paradigm");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int s = (int)(d.getWidth()/2);
		
		setSize(s, s);
		
		Container c = getContentPane();
		
		
		
		JPanel panel = new PaintInterface(s);
		
		
		c.add(panel);
		
		
		
		setLocation(0, 0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	


	
	
}