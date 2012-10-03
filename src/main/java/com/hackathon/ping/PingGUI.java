/**
 * This class builds the GUI for the PING application window
 */

package main.java.com.hackathon.ping;

import javax.swing.*;

import main.java.com.hackathon.ping.objects.PINGButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author river226
 */

public class PingGUI {
	JFrame frame;
	JPanel base;
	PINGButton winex, winmax, winmin;
	Box box;

	public PingGUI() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = 900, h = 600;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		frame = new JFrame("PING: PING is not Git");
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(w, h);
		frame.setLocation(x, y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		box = new Box(BoxLayout.X_AXIS);
		box.setForeground(Color.BLACK);
		buildWinOpArea();
		frame.add(box);
		
		
		
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
				} // close window when esc is pressed
			}
		});
		
		frame.setVisible(true);
	}
	
	private void buildWinOpArea() {
		
		winex = new PINGButton("exit", Color.WHITE, Color.RED, 1);
		winex.setSize(20, 10);
		winmax = new PINGButton("max", 2);
		winmax.setSize(10, 10);
		winmin = new PINGButton("min", 3);
		winmin.setSize(10, 10);
		winex.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent a) {System.exit(0);}
			@Override
			public void mouseEntered(MouseEvent a) {winex.doMouseEnt();}
			@Override
			public void mouseExited(MouseEvent a) {winex.doMouseEx();}
			@Override
			public void mousePressed(MouseEvent arg0) {/* NOTHING */}
			@Override
			public void mouseReleased(MouseEvent arg0) {/* NOTHING */}			
		});
		box.add(winmin);
		box.add(winmax);
		box.add(winex);
		box.setAlignmentY(Component.TOP_ALIGNMENT);
	}


}
