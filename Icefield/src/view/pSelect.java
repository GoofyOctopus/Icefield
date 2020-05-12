package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import jdk.dynalink.beans.StaticClass;

public class pSelect extends JPanel implements ActionListener
{
	private static final String IMG_PATH = "C:\\Users\\kamiy\\OneDrive\\Desktop\\Figures game\\newIce.jpg";
	//private static final String pImg = "C:\\Users\\kamiy\\OneDrive\\Desktop\\Figures game\\bpolar.png";
	private static final String eImg =  "C:\\Users\\kamiy\\OneDrive\\Desktop\\Figures game\\Eskimo.png";
	JFrame frame = new JFrame("Myframe");
	ImageIcon img= new ImageIcon(IMG_PATH);

	protected  pSelect() 
	{
		create();
	}

	public void create()
	{
		Font f0 = new Font("arial", Font.BOLD, 30);
		Font f1 = new Font("arial", Font.BOLD, 15);
		
		JPanel panel = new JPanel();
		JLabel backGround= new JLabel(img);
		backGround.setLayout(new BoxLayout(backGround, BoxLayout.PAGE_AXIS));
		panel.setLayout(new BorderLayout());
		panel.add(backGround);
		panel.setOpaque(true);
		panel.setBounds(0, 0, 600, 600);
		
		JLabel title = new JLabel("Figure Selection");
		title.setFont(f0);
		title.setForeground(Color.blue);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel select= new JLabel("Enter the name of the figure:");
		select.setFont(f1);
		select.setForeground(Color.blue);
		select.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JTextField tName = new JTextField();
		tName.setMaximumSize(new Dimension(80,20));
		
		JButton bEskimoo = new JButton();
		bEskimoo.setIcon(new ImageIcon("Images/Eskimo.jpg"));
		bEskimoo.setAlignmentX(Component.LEFT_ALIGNMENT);
		bEskimoo.setMaximumSize(new Dimension(50,50));
		validate();
		
		
		JButton bExplorer = new JButton();
		bExplorer.setIcon(new ImageIcon("Images/bpolar.png"));
		bExplorer.setAlignmentX(Component.TOP_ALIGNMENT);
		bExplorer.setMaximumSize(new Dimension(50, 50));
		validate();
		
		
		
		backGround.add(title);
		backGround.add(Box.createRigidArea(new Dimension(0,20)));
		backGround.add(select);
		backGround.add(Box.createRigidArea(new Dimension(0,20)));
		backGround.add(tName);
		backGround.add(bEskimoo);
		backGround.add(bExplorer);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(600, 600);
	}
	
	
	
	public static void main(String args[])
	{
		pSelect menu=new pSelect();
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("bEskimoo"))
		{
			
		}
		
		else if(e.getActionCommand().equals("bExplorer"))
		{
			
		}
		
	}

}
