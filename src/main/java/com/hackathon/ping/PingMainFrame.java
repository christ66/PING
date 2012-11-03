/**
 * This class builds the GUI for the PING application window
 * Specifically the Frame that holds it
 */

package com.hackathon.ping;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.hackathon.ping.git.GitInstance;
import com.hackathon.ping.objects.PingButton;
import com.hackathon.ping.objects.PingWinButton;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author river226
 */

@SuppressWarnings("serial")
public class PingMainFrame extends JFrame {
	JPanel base, menu, wiki;
	PingButton winex, winmax, winmin;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int w = 900;
	int h = 600;
	int x = (dim.width-w)/2;
	int y = (dim.height-h)/2;
	boolean drag = false;
	static Point mousePoint;
	private final Color DEFAULT_COLOR = Color.WHITE;
	private final Color HOVER_COLOR   = Color.LIGHT_GRAY;

	public PingMainFrame() throws RuntimeException {
		super("Ping: PING is not Git");

		initComponents();
	}

	private void initComponents() throws RuntimeException {
		base = new JPanel();
		menu = new JPanel();
		base.setBackground(Color.WHITE);

		setUndecorated(true);
		setResizable(false);
		setSize(w, h);
		setLocation(x, y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container login = buildWindowFrame();
	
		JPanel panel = new JPanel();

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(login);
		contentPane.add(new PingRepoPanel());

		addWindowDrag();
	}

	private void addWindowDrag() { // implement Window Drag listeners
		addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e){
				mousePoint = e.getPoint();
			}

			public void mouseReleased(MouseEvent e) {
				mousePoint = null;
			}
			
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

	//TODO: Fix ugly hard code
	private Container buildWindowFrame() throws RuntimeException {
		JPanel winOpArea = new JPanel();
		BoxLayout layout = new BoxLayout(winOpArea, BoxLayout.X_AXIS);
		winOpArea.setLayout(layout);
		PingButton exitButton = null;
		PingButton maximizeButton = null;
		PingButton minimizeButton = null;
		PingButton avatar = null;
		String[] icons = {"src/main/resources/icons/exit.png", "src/main/resources/icons/min.png", "src/main/resources/icons/max.png", "src/main/resources/icons/restore.png"};
			exitButton = new PingWinButton(icons[0], icons[0], "Exit", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					throw new RuntimeException();
				}
			});

			maximizeButton = new PingWinButton(icons[1], icons[2], "Maximize", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setSize(dim.width, dim.height);
				}
			});

			minimizeButton = new PingWinButton(icons[3], icons[3], "Minimize", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setState(JFrame.ICONIFIED);
				}
			});


//			avatar = new JButton(new ImageIcon(GitInstance.getInstance().getAvatar()));
//			avatar.setEnabled(false);
//			winOpArea.add(avatar, Component.LEFT_ALIGNMENT);

			winOpArea.add(minimizeButton, Component.LEFT_ALIGNMENT);
			winOpArea.add(maximizeButton, Component.RIGHT_ALIGNMENT);
			winOpArea.add(exitButton, Component.CENTER_ALIGNMENT);

			winOpArea.setBackground(Color.white);
			// Add component to jframe. 
		return winOpArea;
	}
}
