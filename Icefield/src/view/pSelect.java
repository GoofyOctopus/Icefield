package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import jdk.dynalink.beans.StaticClass;

public class pSelect extends JPanel
{
	
	ImageIcon img= new ImageIcon(getClass().getClassLoader().getResource("newIce.jpg"));
	JLabel backGround,title, select;
	public JTextField tName;
	public JButton bEskimoo, bExplorer;
	private JPanel buttonsPanel = new JPanel();
	

	protected  pSelect() 
	{
		create();
	}

	public void create()
	{
		Font f0 = new Font("Comic Sans MS", Font.BOLD, 42);
		Font f1 = new Font("Comic Sans MS", Font.BOLD, 18);

		
		backGround= new JLabel(img);
		backGround.setLayout(new BoxLayout(backGround, BoxLayout.PAGE_AXIS));
		this.setLayout(new BorderLayout());
		this.add(backGround);
		this.setOpaque(true);
		this.setBounds(0, 0, 600, 600);

		title = new JLabel("Figure Selection");
		title.setFont(f0);
		title.setForeground(Color.blue);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		select= new JLabel("Enter the name of the figure:");
		select.setFont(f1);
		select.setForeground(Color.blue);
		select.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		tName = new JTextField();
		tName.setMaximumSize(new Dimension(80,20));
		
		bEskimoo = new JButton();
		ImageIcon eskimoButton= new ImageIcon(getClass().getClassLoader().getResource("eskimoButton.jpg"));
		bEskimoo.setIcon(eskimoButton);
		bEskimoo.setAlignmentX(Component.CENTER_ALIGNMENT);
		bEskimoo.setPreferredSize(new Dimension(100,100));
		validate();
	
		bExplorer = new JButton();
		ImageIcon explorerButton= new ImageIcon(getClass().getClassLoader().getResource("explorerButton.jpg"));
		bExplorer.setIcon(explorerButton);
		bExplorer.setAlignmentX(Component.CENTER_ALIGNMENT);
		bExplorer.setPreferredSize(new Dimension(100, 100));
		validate();
		
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.add(bEskimoo, BorderLayout.WEST);
		buttonsPanel.add(bExplorer, BorderLayout.EAST);
		buttonsPanel.setMaximumSize(new Dimension(450,100));
		buttonsPanel.setOpaque(false);
		
		backGround.add(title);
		backGround.add(Box.createRigidArea(new Dimension(0, 15)));
		backGround.add(select);
		backGround.add(Box.createRigidArea(new Dimension(0, 10)));
		backGround.add(tName);
		backGround.add(Box.createRigidArea(new Dimension(0, 20)));
		backGround.add(buttonsPanel);


	}
}	



