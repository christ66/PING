package main.java.com.hackathon.ping;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTracker implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ESCAPE)
			System.exit(0);
	}

}
