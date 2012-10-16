/**
 * This class builds the GUI for the PING application window
 */

package com.hackathon.ping;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.hackathon.ping.objects.PINGButton;
import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author river226
 */

//Future: Shut this stupid exception up.
@SuppressWarnings("serial")
public class PingMainFrame extends JFrame {
	JPanel base, menu, wiki, repo, account;
	PINGButton winex, winmax, winmin;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int w = 900;
	int h = 600;
	int x = (dim.width-w)/2;
	int y = (dim.height-h)/2;
	boolean drag = false;
	static Point mousePoint;

	public PingMainFrame() {
		super("Ping: PING is not Git");
		
		base = new JPanel();
		menu = new JPanel();
		wiki = new JPanel();
		base.setBackground(Color.WHITE);

		setUndecorated(true);
		setResizable(false);
		setSize(w, h);
		setLocation(x, y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		base.setLayout(null);		
		buildWinOpArea();
		buildMenu();
		buildPanels();
		
		base.add(menu);
		base.add(wiki);
		base.add(repo);
		base.add(account);
		
		add(base);
		addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent e){
				mousePoint = e.getPoint();
			}

			public void mouseReleased(MouseEvent e) {
				mousePoint = null;
			}

			/*
			 * By default do nothing for remaining events.
			 */
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			});
		
		
		addMouseMotionListener(new MouseMotionListener() {
			/*
			 * Do nothing.
			 */
			public void mouseMoved(MouseEvent e) {}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				Point newlocation = e.getLocationOnScreen();
				
				setLocation(newlocation.x - mousePoint.x, newlocation.y - mousePoint.y);
			}
		});
	}
	
	private void buildPanels() {
		account = new JPanel();
		account.setBounds((int)((w*0.2)+10), 50, (int)((w*0.3)-10), h-60);
		account.setBackground(Color.BLACK);
		account.setLayout(new BoxLayout(account, BoxLayout.Y_AXIS));
		buildAccounts();
		
		repo = new JPanel();
		repo.setLayout(new BoxLayout(repo, BoxLayout.Y_AXIS));
		repo.setBounds(10, 50, (int)((w*0.2)-10), h-60);
		repo.setBackground(Color.RED);
		repo.setLayout(new BoxLayout(repo, BoxLayout.Y_AXIS));
		
		wiki = new JPanel();
		wiki.setBounds((int)((w/2)+10), 50, (int)((w/2)-20), h-60);
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
		JMenu settings = new JMenu("Settings");
		settings.add(new JMenuItem("Add Account"));
		settings.add(new JMenuItem("Edit Account"));
		settings.add(new JMenuItem("Add Local Repo"));
		settings.setBackground(Color.WHITE);
		settings.setBorderPainted(false);
		settings.setEnabled(true);
		// To be completed 
		
		menu = new JPanel();
		menu.setBackground(Color.WHITE);
		menu.setBounds(0, 0, 75, 40);
		
		menu.add(settings);
	}
	
	private void buildRepo() {
		// TODO
	}
	
	//TODO: Fix ugly hard code
	private void buildWinOpArea() {
		JButton exitButton = null;
		JButton maximizeButton = null;
		JButton minimizeButton = null;
		
		try {
			exitButton = createComponentButtons("src/main/resources/icons/exit.png", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//On exit dispose and throw RTE instead of system.exit
					dispose();
					throw new RuntimeException("Exited.");
				}
			}, w-40);
			
			maximizeButton = createComponentButtons("src/main/resources/icons/max.png", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setSize(dim.width, dim.height);
					
				}
			}, w-80);
			
			minimizeButton = createComponentButtons("src/main/resources/icons/min.png", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setState(JFrame.ICONIFIED);
				}
			}, w-120);
			
			base.add(exitButton);
			base.add(maximizeButton);
			base.add(minimizeButton);
			
		} catch (IOException e) {
			e.printStackTrace();
			//If it fails to find an icon or fails to open an icon the instance will shutdown.
			dispose();
			throw new RuntimeException();
		}
	}

	
	private JButton createComponentButtons(String imagePath,
			ActionListener actionListener, int location) throws IOException {
		
		JButton button = new JButton(new ImageIcon(ImageIO.read(new File(imagePath))));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		
		//TODO: Fix so not dependent on static location but instead on groupLayout.
		button.setBounds(location,0, 40, 40);
		button.addActionListener(actionListener);
		return button;
	}
}
