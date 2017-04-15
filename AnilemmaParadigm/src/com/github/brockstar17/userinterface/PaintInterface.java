package com.github.brockstar17.userinterface;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintInterface extends JPanel implements ActionListener{
	private int s;
	private JComboBox lcolor;
	private JComboBox audIn;
	private String color;
	private String ain;
	
	private String[] patternExamples = {
			"Blue",
			"Red",
			"Green",
			"Purple",
			"Other"
			
	};
	
	private String[] audioIn = {
			"LINE_IN",
			"MICROPHONE",
			"SPEAKER"
	};
	
	/**
	 * 
	 * @param s the width of the component
	 */
	public PaintInterface(int s){
		this.s = s;
		
		lcolor = addTextInput(patternExamples, false);
		
		audIn = addTextInput(audioIn, false);
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
	private JComboBox addTextInput(String[] pattern, boolean edit){
		JComboBox jcb = new JComboBox(pattern);
		jcb.setEditable(edit);
		jcb.addActionListener(this);
        
        this.add(jcb);
        
        return jcb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == lcolor && lcolor.getSelectedItem() == "Other"){
			color = JOptionPane.showInputDialog("Enter a color");
		}
		
		if(e.getSource() == audIn){
			//call andrews crap
		}
	}
}
