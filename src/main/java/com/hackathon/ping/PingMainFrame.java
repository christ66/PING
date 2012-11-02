/**
 * This class builds the GUI for the PING application window
 */

package com.hackathon.ping;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.hackathon.ping.git.GitInstance;
import com.hackathon.ping.objects.PINGButton;
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
	JPanel base, menu;
	//, wiki, repo, account;
	PINGButton winex, winmax, winmin;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int w = 900;
	int h = 600;
	int x = (dim.width-w)/2;
	int y = (dim.height-h)/2;
	boolean drag = false;
	static Point mousePoint;
	private final Color DEFAULT_COLOR = Color.WHITE;
	private final Color HOVER_COLOR   = Color.LIGHT_GRAY;
	
	public PingMainFrame() {
		super("Ping: PING is not Git");
		
		initComponents();
	}
	
	private void initComponents() {
		base = new JPanel();
		menu = new JPanel();
//		wiki = new JPanel();
		base.setBackground(Color.WHITE);

		setUndecorated(true);
		setResizable(false);
		setSize(w, h);
		setLocation(x, y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
//		setLayout(null);
		Container login = buildWindowFrame();
		
		Container account = createContainer("Account", Color.black);
		Container repo    = createContainer("Repos", Color.red);
		Container wiki    = createContainer("Wiki", Color.lightGray);
		JPanel panel = new JPanel();
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(login);
		contentPane.add(account);
		contentPane.add(repo);
		contentPane.add(wiki);

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
	
	private Container createContainer(String string, Color color) {
		JPanel container = new JPanel();
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		
		container.setLayout(layout);
		
		container.setBackground(color);
		container.add(new JButton("TEST"));
		container.add(new JButton("test"));
		return container;
	}
	
	//TODO: Fix ugly hard code
	private Container buildWindowFrame() {
		JPanel winOpArea = new JPanel();
		BoxLayout layout = new BoxLayout(winOpArea, BoxLayout.X_AXIS);
		winOpArea.setLayout(layout);
		JButton exitButton = null;
		JButton maximizeButton = null;
		JButton minimizeButton = null;
		JButton avatar = null;
		try {
			exitButton = createComponentButtons("src/main/resources/icons/exit.png", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//TODO: On exit dispose and throw RTE instead of system.exit
					System.exit(0);
				}
			});
			
			maximizeButton = createComponentButtons("src/main/resources/icons/max.png", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setSize(dim.width, dim.height);
				}
			});
			
			minimizeButton = createComponentButtons("src/main/resources/icons/min.png", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setState(JFrame.ICONIFIED);
				}
			});
			
			
			avatar = new JButton(new ImageIcon(GitInstance.getInstance().getAvatar()));
			avatar.setEnabled(false);
			winOpArea.add(avatar, Component.LEFT_ALIGNMENT);
			
			winOpArea.add(minimizeButton, Component.LEFT_ALIGNMENT);
			winOpArea.add(maximizeButton, Component.RIGHT_ALIGNMENT);
			winOpArea.add(exitButton, Component.CENTER_ALIGNMENT);
			
			winOpArea.setBackground(Color.white);
			// Add component to jframe.
		} catch (IOException e) {
			e.printStackTrace();
			//If it fails to find an icon or fails to open an icon the instance will shutdown.
			dispose();
			throw new RuntimeException();
		}
		return winOpArea;
	}

	
	private JButton createComponentButtons(String imagePath,
			ActionListener actionListener) throws IOException {
		
		BufferedImage image = ImageIO.read(new File(imagePath));
		ImageIcon icon = new ImageIcon(image);
		final JButton button = new JButton(icon);
		button.setBackground(DEFAULT_COLOR);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent a) {
				button.setBackground(HOVER_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent a) {
				button.setBackground(DEFAULT_COLOR);
			}
		});
		
		button.setBorderPainted(false);
		button.addActionListener(actionListener);
		return button;
	}
}
