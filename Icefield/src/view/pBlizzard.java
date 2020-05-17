package view;

import javax.swing.*;
import java.awt.*;

public class pBlizzard extends JPanel 
{
	private JPanel blizPanel = new JPanel();//blizzard panel
	private JLabel blizLable = new JLabel(new ImageIcon("Images/Blizzard650x700.gif"));
	
	
	public pBlizzard() 
	{
		create();
	}
	
	public void create()
	{
		blizLable.setSize(new Dimension(650, 700));
		this.setLayout(new FlowLayout());
		this.add(blizLable);
		this.setSize(650, 700);
		this.setVisible(true);
		
	}


}
