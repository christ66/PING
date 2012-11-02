package com.hackathon.ping;

import java.awt.Color;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PingRepoPanel extends JPanel {
	
	public PingRepoPanel() {
		buildPanel();
	}
	
	public void buildPanel() {
		Container account = createContainer("Account", Color.black);
		Container repo = createContainer("Repos", Color.red);
		Container wiki = createContainer("Wiki", Color.lightGray);
		
		this.add(account);
		this.add(repo);
		this.add(wiki);
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
}
