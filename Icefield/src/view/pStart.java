package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*
 * Author Kamyar Nazari
 */


public class pStart extends JPanel implements ActionListener
{
	public int numberPlayers = 0;
	private static final String IMG_PATH = "Images/newIce.jpg";
	ImageIcon img= new ImageIcon(IMG_PATH);
	
	protected pStart()
	{
		create();
	}
	
	public void create()
	{
		Font f0 = new Font("arial", Font.BOLD, 20);
		Font f1 = new Font("arial", Font.BOLD, 40);
		JPanel panel=new JPanel();
		JLabel backGround= new JLabel();
		backGround.setIcon(img);
		backGround.setLayout(new BoxLayout(backGround, BoxLayout.PAGE_AXIS));
		panel.setLayout(new BorderLayout());
		panel.add(backGround);
		panel.setOpaque(true);
		panel.setBounds(0, 0, 600, 600);
		
		/*
		 * Creating the components for the JPanel
		 * */
		JLabel title= new JLabel("ICEFIELD");
		title.setFont(f1);
		title.setForeground(Color.BLUE);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel string= new JLabel("Enter the number of players :");
		string.setAlignmentX(Component.CENTER_ALIGNMENT);
		string.setOpaque(true);
		string.setBackground(Color.cyan);
		string.setFont(f0);
		
		//Adding the buttons
		JButton bStart = new JButton("PLAY");
		bStart.setMaximumSize(new Dimension(120,60));
		bStart.setAlignmentX(Component.CENTER_ALIGNMENT);
		bStart.setBackground(Color.cyan);
		
		JButton bExit = new JButton("EXIT");
		bExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		bExit.setMaximumSize(new Dimension(60,20));
		bExit.setBackground(Color.cyan);
		
		JTextField tNumberPlayer = new JTextField();
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
		bStart.addActionListener(this);
		bExit.addActionListener(this);
		
		
		
	}
	
	
/*
 * Adding the action performed by the mouse click event for the buttons play and exit
 * */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("PLAY"))
		{
			if(numberPlayers == 0 || numberPlayers > 3)
			{
				//JOptionPane.showMessageDialog(frame, "Invalid number !!");
				
			}
			else 
			{
				//this.setVisible(false);
				//pSelect pselect = new pSelect();
				//pselect.setVisible(true);
			}
		}
		
		else if(e.getActionCommand().equals("EXIT"))
		{
			//frame.dispose();
		}
		
	}

}
