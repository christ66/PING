package main.java.com.hackathon.ping.objects;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PINGButton extends JButton {
	
	private final Color defaultColor, hoverColor;
	
	/**
	 * Keeping Eclipse Happy
	 */
	private static final long serialVersionUID = 1L;

	public PINGButton(String text) {
		super(text);
		defaultColor = Color.WHITE;
		hoverColor = Color.LIGHT_GRAY;
		this.setBackground(defaultColor);
		addMouse();
		this.setBorderPainted(false);
		this.setIcon(getIcon());
	}
	
	public PINGButton(Icon i) {
		super(i);
		defaultColor = Color.WHITE;
		hoverColor = Color.LIGHT_GRAY;
		this.setBackground(defaultColor);
		addMouse();
		this.setBorderPainted(false);
	}
	
	private void addMouse() {
		super.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent a) {
				doMouseEnt();
			}

			@Override
			public void mouseExited(MouseEvent a) {
				doMouseEx();
			}
			
		});
	}
	
	private void doMouseEx() {
		this.setBackground(defaultColor);
	}
	
	private void doMouseEnt() {
		this.setBackground(hoverColor);
	}
}
