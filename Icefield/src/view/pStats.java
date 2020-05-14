package view;
//Erdene
import javax.swing.JPanel;
import javax.swing.JLabel;
import Figures.Eskimo;
import Figures.PolarExplorer;
import Item.*;
import model.Game;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;



public class pStats extends JPanel {
	private JPanel pBottom;
	private JLabel lName;
	private JLabel lHealth;
	private JPanel pBottomRight;
	private JLabel lStats;
	private JLabel lRope, lFood, lSuit, lShovel, lGun, lFlare, lCharge;
	public ArrayList<JLabel> items;

	/**
	 * Create the panel.
	 */
	public pStats() {
		setLayout(new BorderLayout(0, 0));
		//adding border
		
		lRope = new JLabel(new ImageIcon("Images/rope.png")); 
		lFood =  new JLabel(new ImageIcon("Images/food.png"));
		lSuit = new JLabel(new ImageIcon("Images/diving suit.png"));
		lShovel = new JLabel(new ImageIcon("Images/shovel.png"));
		lGun = new JLabel(new ImageIcon("Images/gun.png"));
		lFlare = new JLabel(new ImageIcon("Images/flare.png"));
		lCharge = new JLabel(new ImageIcon("Images/charge.png"));
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		pBottom = new JPanel();
		items = new ArrayList<JLabel>();
		
		items.add(lRope);
		items.add(lCharge);
		items.add(lFood);
		items.add(lShovel);
		items.add(lSuit);
		items.add(lGun);
		items.add(lFlare);
		
		System.out.println(items.size());
		lName = new JLabel("Name: Figure1                 ");
		lHealth = new JLabel("Body heath:             ");
		pBottomRight = new JPanel();
		lStats = new JLabel("Stats: move 1  ");

		
		pBottomRight.add(lStats);
		for(int i = 0; i <items.size();i++)
		{
			pBottomRight.add(items.get(i));
		}
		pBottom.setLayout(new BorderLayout(0, 0));
		pBottom.add(lName, BorderLayout.WEST);	
		pBottom.add(lHealth, BorderLayout.CENTER);
		pBottom.add(pBottomRight, BorderLayout.EAST);
		add(pBottom, BorderLayout.SOUTH);	
		
	}
	public void HealthChange(int health)
	{
		lHealth.setText("Body heath: " + health);
	}
	public void ShowStats(int move) {
		lStats.setText("Stats: move " + move);
	}
	public void PlayerChange(Eskimo eskimo) {
		lName.setText("Name: " + eskimo.getName() + "       ");
		HealthChange(eskimo.getBodyHeatUnit());
		for(int i = 0; i < eskimo.getInventory().size(); i++)
		{
			if(eskimo.getInventory().get(i) instanceof Rope)
			{
				items.add(lRope);
			}
			if(eskimo.getInventory().get(i) instanceof Food)
			{
				items.add(lFood);
			}
			if(eskimo.getInventory().get(i) instanceof Shovel)
			{
				items.add(lShovel);
			}
			if(eskimo.getInventory().get(i) instanceof DivingSuit)
			{
				items.add(lSuit);
			}
			if(eskimo.getInventory().get(i) instanceof Gun)
			{
				items.add(lGun);
			}
			if(eskimo.getInventory().get(i) instanceof Flare)
			{
				items.add(lFlare);
			}
			if(eskimo.getInventory().get(i) instanceof Charge)
			{
				items.add(lCharge);
			}
		}
	}
	public void PlayerChange(PolarExplorer polarExplorer) {
		lName.setText("Name: " + polarExplorer.getName() + "       ");
		HealthChange(polarExplorer.getBodyHeatUnit());
		for(int i = 0; i < polarExplorer.getInventory().size(); i++)
		{
			if(polarExplorer.getInventory().get(i) instanceof Rope)
			{
				items.add(lRope);
			}
			if(polarExplorer.getInventory().get(i) instanceof Food)
			{
				items.add(lFood);
			}
			if(polarExplorer.getInventory().get(i) instanceof Shovel)
			{
				items.add(lShovel);
			}
			if(polarExplorer.getInventory().get(i) instanceof DivingSuit)
			{
				items.add(lSuit);
			}
			if(polarExplorer.getInventory().get(i) instanceof Gun)
			{
				items.add(lGun);
			}
			if(polarExplorer.getInventory().get(i) instanceof Flare)
			{
				items.add(lFlare);
			}
			if(polarExplorer.getInventory().get(i) instanceof Charge)
			{
				items.add(lCharge);
			}
		}
		
	}


}