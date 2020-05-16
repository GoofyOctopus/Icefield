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
	
	private static final String IMG_PATH = "Images/newIce.jpg";
	ImageIcon img= new ImageIcon(IMG_PATH);
	JLabel backGround,title, select;
	public JTextField tName;
	public JButton bEskimoo, bExplorer;

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
		bEskimoo.setIcon(new ImageIcon("Images/Eskimo.jpg"));
		bEskimoo.setAlignmentX(Component.CENTER_ALIGNMENT);
		bEskimoo.setMaximumSize(new Dimension(50,50));
		validate();
	
		bExplorer = new JButton();

		bExplorer.setIcon(new ImageIcon("Images/bpolar.png"));
		bExplorer.setAlignmentX(Component.CENTER_ALIGNMENT);
		bExplorer.setMaximumSize(new Dimension(50, 50));
		validate();
		
		backGround.add(title);
		backGround.add(Box.createRigidArea(new Dimension(0,15)));
		backGround.add(select);
		backGround.add(Box.createRigidArea(new Dimension(0,20)));
		backGround.add(tName);
		backGround.add(bEskimoo);
		backGround.add(Box.createRigidArea(new Dimension(50,20)));
		backGround.add(bExplorer);

	}
}	



