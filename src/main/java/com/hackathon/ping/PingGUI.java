package main.java.com.hackathon.ping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PingGUI {
	JFrame frame;


	public PingGUI() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setSize(900, 700);
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				//NOTHING
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//NOTHING	
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}
		});
		frame.setVisible(true);
	}


}
