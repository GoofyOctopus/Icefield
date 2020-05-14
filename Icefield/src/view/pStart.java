package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*
 * Author Kamyar Nazari
 */


public class pStart extends JPanel
{
	public int numberPlayers = 0;
	private static final String IMG_PATH = "Images\\newIce.jpg";
	ImageIcon img= new ImageIcon(IMG_PATH);

	JLabel backGround, title, string;
	public JButton bStart, bExit;
	public JTextField tNumberPlayer;

	protected pStart()
	{
		create();
	}
	
	public void create()
	{
		//changing the Fonts of the labels
		Font f0 = new Font("ubuntu", Font.BOLD, 20);
		Font f1 = new Font("ubuntu", Font.BOLD, 40);
		JPanel panel=new JPanel();
		JLabel backGround= new JLabel();
		
		backGround= new JLabel();
		backGround.setIcon(img);
		backGround.setLayout(new BoxLayout(backGround, BoxLayout.PAGE_AXIS));
		this.setLayout(new BorderLayout());
		this.add(backGround);
		this.setOpaque(true);
		this.setBounds(0, 0, 600, 600);
		
		/*
		 * Creating the components for the JPanel
		 * */
		title= new JLabel("ICEFIELD");
		title.setFont(f1);
		title.setForeground(Color.BLUE);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		string= new JLabel("Enter the number of players :");
		string.setAlignmentX(Component.CENTER_ALIGNMENT);
		string.setOpaque(true);
		string.setBackground(Color.cyan);
		string.setFont(f0);
		
		//Adding the buttons
		bStart = new JButton("PLAY");
		bStart.setMaximumSize(new Dimension(120,60));
		bStart.setAlignmentX(Component.CENTER_ALIGNMENT);
		bStart.setBackground(Color.cyan);
		
		bExit = new JButton("EXIT");
		bExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		bExit.setMaximumSize(new Dimension(60,20));
		bExit.setBackground(Color.cyan);
		
		tNumberPlayer = new JTextField();
		tNumberPlayer.setSize(10, 10);
		tNumberPlayer.setMaximumSize(new Dimension(50,20));
		
		//Adding the components to the JPanel
		backGround.add(title);
		backGround.add(Box.createRigidArea(new Dimension(0,165)));
		backGround.add(bStart);
		backGround.add(Box.createRigidArea(new Dimension(0,40)));
		backGround.add(string);
		backGround.add(Box.createRigidArea(new Dimension(0,20)));
		backGround.add(tNumberPlayer);
		backGround.add(Box.createRigidArea(new Dimension(0,40)));
		backGround.add(bExit);		

		
		numberPlayers = Integer.parseInt(tNumberPlayer.getText());
		
		//adding the action listeners for the buttons
		//bStart.addActionListener(this);
		//bExit.addActionListener(this);
		
		this.add(backGround);
		//frame.setSize(600, 600);
		//frame.setVisible(true);
		
		
	}
	
}
