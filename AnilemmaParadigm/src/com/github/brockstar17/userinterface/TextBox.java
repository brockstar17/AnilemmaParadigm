package com.github.brockstar17.userinterface;

import java.awt.Color;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextBox extends JTextField{

	
	
	/**
	 * 
	 * @param x pos x
	 * @param y pos y
	 * @param w width of this component
	 * @param h the height of this component
	 * @param name the name of this component
	 */
	public TextBox(int x, int y, int w, int h, String name){
		super(name);
		setSize(w, h);
		setLocation(x, y);
		
	}
	
	public String getMsg(){
		return this.getText();
	}
}
