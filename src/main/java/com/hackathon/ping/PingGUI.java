/**
 * This class builds the GUI for the PING application window
 */

package main.java.com.hackathon.ping;

import javax.imageio.ImageIO;
import javax.swing.*;

import main.java.com.hackathon.ping.objects.PINGButton;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * @author river226
 */

public class PingGUI {
	JFrame frame;
	JPanel base, menu, wiki, repo, account;
	PINGButton winex, winmax, winmin;
	int w, h;

	public PingGUI() {
		base = new JPanel();
		menu = new JPanel();
		wiki = new JPanel();
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
		base.setLayout(null);		
		buildWinOpArea();
		buildMenu();
		buildPanels();
		base.add(menu);
		base.add(wiki);
		base.add(repo);
		base.add(account);
		frame.add(base);
		frame.setVisible(true);
	}
	
	private void buildPanels() {
		account = new JPanel();
		account.setBounds((int)((w*0.2)-10), 50, (int)((w*0.3)-10), h-60);
		account.setBackground(Color.BLACK);
		account.setLayout(new BoxLayout(account, BoxLayout.Y_AXIS));
		buildAccounts();
		
		repo = new JPanel();
		repo.setLayout(new BoxLayout(repo, BoxLayout.Y_AXIS));
		account.setBounds(10, 50, (int)((w*0.2)-10), h-60);
		account.setBackground(Color.RED);
		buildRepos();
		
		wiki = new JPanel();
		wiki.setBounds((int)((w/2)-10), 50, (int)((w/2)-10), h-60);
		wiki.setBackground(Color.LIGHT_GRAY);
		wiki.setLayout(new BoxLayout(wiki, BoxLayout.Y_AXIS));
	}

	private void buildRepos() {
		// TODO
		
	}

	private void buildAccounts() {
		// TODO
		
	}

	private void buildMenu() {
		// TODO
	}

	private void buildWinOpArea() {
		
		ImageIcon iExit = new ImageIcon("icons/exit.png");
		System.out.print(iExit.getIconHeight());
		base.setBounds(w-120, 0, 120, 40);
		
		winex = new PINGButton("X");
		winex.setBounds(w-40,0, 40, 40);
		winmax = new PINGButton("O");
		winmax.setBounds(w-80,0, 40, 40);
		winmin = new PINGButton("_");
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
		//base.add(winmin);
		//base.add(winmax);
		base.add(winex);
	}


}
