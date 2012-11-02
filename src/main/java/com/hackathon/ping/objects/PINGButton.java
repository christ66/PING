package com.hackathon.ping.objects;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PINGButton extends JButton {
	
	private final Color defaultColor = Color.WHITE;
	private final Color hoverColor   = Color.LIGHT_GRAY;
	private Icon secondImage;
	private Icon mainImage;
	
	public PINGButton(String icon, String second, String text, ActionListener a) {
		super(text, new ImageIcon(icon));
		this.addActionListener(a);
		secondImage = new ImageIcon(second);
		mainImage = super.getIcon();
		setBackground(defaultColor);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent a) {
				doMouseEnt();
			}

			@Override
			public void mouseExited(MouseEvent a) {
				doMouseEx();
			}
			
			@Override
			public void mousePressed(MouseEvent a) {
				doMousePressed();
			}
			
		});
		this.setBorderPainted(false);
	}
	
	
	private void doMousePressed() {
		this.setIcon(this.getIcon().equals(mainImage) ? secondImage : mainImage);
	}


	private void doMouseEx() {
		this.setBackground(defaultColor);
	}
	
	private void doMouseEnt() {
		this.setBackground(hoverColor);
	}
}
