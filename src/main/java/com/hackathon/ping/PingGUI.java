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
import java.io.File;

/**
 * @author river226
 */

public class PingGUI {
	JFrame frame;
	JPanel base, menu;
	PINGButton winex, winmax, winmin;
	Box box;
	int w, h;

	public PingGUI() {
		base = new JPanel();
		menu = new JPanel();
		base.setBackground(Color.WHITE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		w = 900;
		h = 600;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		frame = new JFrame("PING: PING is not Git");
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setSize(w, h);
		frame.setLocation(x, y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		buildWinOpArea();
		frame.add(base);
		
		frame.setVisible(true);
	}
	
	private void buildWinOpArea() {
		ImageIcon iExit = new ImageIcon("icons/exit.png");
		System.out.print(iExit.getIconHeight());
		base.setLayout(null);
		
		winex = new PINGButton(iExit);
		winex.setBounds(w-40,0, 40, 40);
		winmax = new PINGButton("max");
		winmax.setBounds(w-80,0, 40, 40);
		winmin = new PINGButton("min");
		winmin.setBounds(w-120,0, 40, 40);
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
		base.setAlignmentY(w);
		base.add(winmin);
		base.add(winmax);
		base.add(winex);
		//base.add(menu);
	}


}
