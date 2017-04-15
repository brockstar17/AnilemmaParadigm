package com.github.brockstar17.userinterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.github.brockstar17.BUtils;

@SuppressWarnings("serial")
public class PaintInterface extends JPanel implements ActionListener{
	private int s;
	private JComboBox patternList;
	
	private String[] patternExamples = {
			"Blue",
			"Red",
			"Green",
			"Purple",
			"Other"
			
	};
	
	/**
	 * 
	 * @param s the width of the component
	 */
	public PaintInterface(int s){
		this.s = s;
		
		addTextInput(patternExamples, false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
        Color color1 = Color.BLACK;
        Color color2 = Color.decode("#8514FF"); 
        GradientPaint gp = new GradientPaint(
                0, 0, color1,
                0, s, color2);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, s, s);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addTextInput(String[] pattern, boolean edit){
		patternList = new JComboBox(pattern);
        patternList.setEditable(edit);
        patternList.addActionListener(this);
        
        this.add(patternList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(patternList.getSelectedItem() == "Other"){
			//String color = JOptionPane.
		}
	}
}
