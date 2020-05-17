package view;

import javax.swing.*;
import java.awt.*;

public class pBlizzard extends JPanel 
{
	private JPanel blizPanel = new JPanel();//blizzard panel
	private JLabel blizLable = new JLabel(new ImageIcon("Images/Blizzard650x700.gif"));
	private JLabel blizHappen = new JLabel("BLIZZARD IS HAPPENING");
	private JPanel blizH = new JPanel();
	
	public pBlizzard() 
	{
		create();
	}
	
	public void create()
	{
		blizLable.setSize(new Dimension(650, 700));
		this.setLayout(new FlowLayout());
		this.add(blizLable);
		this.add(blizH);
		this.setSize(650, 750);
		this.setVisible(true);
		
		blizH.setLayout(new BorderLayout());
		blizHappen.setForeground(Color.blue);
		blizH.add(blizHappen, BorderLayout.SOUTH);
		
	}


}
