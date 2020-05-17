package view;
//Erdene
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import Figures.Eskimo;
import Figures.Figure;
import Figures.PolarExplorer;
import Item.*;
import model.Game;
import model.Iceberg;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;



public class pStats extends JPanel {
	private JPanel pBottom;
	private JLabel lName;
	private JLabel lHealth;
	private JPanel pBottomRight;
	private JLabel lStats;
	private JLabel lRope, lFood, lSuit, lShovel, lGun, lFlare, lCharge;
	private ArrayList<JLabel> items;
	private JList<String> listBox; 
	private DefaultListModel<String> l1;
	private JPanel itemPanel; 
	/**
	 * Create the panel.
	 */
	public pStats() {
		//adding border
		setLayout(new BorderLayout(0, 0));

		//adding icons to panel
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
		

		
		
		//making jlist
		
		l1 = new DefaultListModel<>();  

  
        listBox = new JList<>(l1); 
        
        
		lName = new JLabel("Name: Figure1             ");
		lHealth = new JLabel("Body heath:             ");
		pBottomRight = new JPanel();
		lStats = new JLabel("Stats: move 1  ");

		pBottomRight.add(lStats);
		pBottomRight.add(listBox);
		itemPanel = new JPanel();
		for(int i = 0; i <items.size();i++)
		{
			itemPanel.add(items.get(i));
		}
		pBottomRight.add(itemPanel); 
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
	public void IcebergChange(Iceberg iceberg)
	{
		l1.clear();
		items.clear();
		itemPanel.removeAll(); 
		for(int i = 0; i < iceberg.getItems().size(); i++)
		{
			if(iceberg.getItems().get(i) instanceof Rope)
			{
				items.add(lRope);
				l1.addElement("Rope");
			}
			if(iceberg.getItems().get(i) instanceof Food)
			{
				items.add(lFood);
				l1.addElement("Food");
			}
			if(iceberg.getItems().get(i) instanceof Shovel)
			{
				items.add(lShovel);
				l1.addElement("Shovel");
			}
			if(iceberg.getItems().get(i) instanceof DivingSuit)
			{
				items.add(lSuit);
				l1.addElement("Suit");
			}
			if(iceberg.getItems().get(i) instanceof Gun)
			{
				items.add(lGun);
				l1.addElement("Gun");
			}
			if(iceberg.getItems().get(i) instanceof Flare)
			{
				items.add(lFlare);
				l1.addElement("Flare");
			}
			if(iceberg.getItems().get(i) instanceof Charge)
			{
				items.add(lCharge);
				l1.addElement("Charge");
			}
		}
		listBox = new JList<>(l1); 
		for(int i = 0; i <items.size();i++)
		{
			itemPanel.add(items.get(i));
		}
		pBottomRight.add(itemPanel); 
	}
	public void PlayerChange(Figure eskimo) {
		lName.setText("Name: " + eskimo.getName() + "       ");
		HealthChange(eskimo.getBodyHeatUnit());
		
		l1.clear();
		
		items.clear();
		itemPanel.removeAll(); 
		for(int i = 0; i < eskimo.getInventory().size(); i++)
		{
			if(eskimo.getInventory().get(i) instanceof Rope)
			{
				items.add(lRope);
				l1.addElement("Rope");
			}
			if(eskimo.getInventory().get(i) instanceof Food)
			{
				items.add(lFood);
				l1.addElement("Food");
			}
			if(eskimo.getInventory().get(i) instanceof Shovel)
			{
				items.add(lShovel);
				l1.addElement("Shovel");
			}
			if(eskimo.getInventory().get(i) instanceof DivingSuit)
			{
				items.add(lSuit);
				l1.addElement("Suit");
			}
			if(eskimo.getInventory().get(i) instanceof Gun)
			{
				items.add(lGun);
				l1.addElement("Gun");
			}
			if(eskimo.getInventory().get(i) instanceof Flare)
			{
				items.add(lFlare);
				l1.addElement("Flare");
			}
			if(eskimo.getInventory().get(i) instanceof Charge)
			{
				items.add(lCharge);
				l1.addElement("Charge");
			}
		}
		listBox = new JList<>(l1); 
		for(int i = 0; i <items.size();i++)
		{
			itemPanel.add(items.get(i));
		}
		pBottomRight.add(itemPanel); 
	}



}