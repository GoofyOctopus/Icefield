package view;
//Erdene
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import java.rmi.activation.Activator;
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
	
	private DefaultListModel<String> listModel;
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
		listModel = new DefaultListModel<>();  
		listBox = new JList<>(listModel); 
        
		lName = new JLabel("Name: Figure1             ");
		lHealth = new JLabel("Body heath:             ");
		pBottomRight = new JPanel();
		lStats = new JLabel("Stats: move 1  ");

		pBottomRight.add(lStats);
		pBottomRight.add(listBox);
		itemPanel = new JPanel();
		for(int i = 0; i < items.size(); i++)
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
	
	public void playerChange(Figure figure){
		itemPanel.removeAll();
		listModel.clear();
		
		lName.setText("Name: " + figure.getName() + "       ");
		HealthChange(figure.getBodyHeatUnit());		

		for(int i = 0; i < figure.getInventory().size(); i++)
		{
			listModel.addElement(figure.getInventory().get(i).getClass().toString().replaceAll("class Item.", ""));		
			if(figure.getInventory().get(i) instanceof Rope)
			{
				itemPanel.add(lRope);
			}
			if(figure.getInventory().get(i) instanceof Food)
			{
				itemPanel.add(lFood);
			}
			if(figure.getInventory().get(i) instanceof Shovel)
			{
				itemPanel.add(lShovel);
			}
			if(figure.getInventory().get(i) instanceof DivingSuit)
			{
				itemPanel.add(lSuit);
			}
			if(figure.getInventory().get(i) instanceof Gun)
			{
				itemPanel.add(lGun);
			}
			if(figure.getInventory().get(i) instanceof Flare)
			{
				itemPanel.add(lFlare);
			}
			if(figure.getInventory().get(i) instanceof Charge)
			{
				itemPanel.add(lCharge);
			}
		}

		for(int i = 0; i < figure.getIceberg().getItems().size(); i++)
		{
			listModel.addElement("In this iceberg: " + figure.getIceberg().getItems().get(i).getClass().toString().replaceAll("class Item.", ""));
			//if the following lines are active we will not differentiate 
			//between what is in the inventory and what is on the iceberg
//			if(figure.getIceberg().getItems().get(i) instanceof Rope)
//			{
//				itemPanel.add(lRope);
//			}
//			if(figure.getIceberg().getItems().get(i) instanceof Food)
//			{
//				itemPanel.add(lFood);
//			}
//			if(figure.getIceberg().getItems().get(i) instanceof Shovel)
//			{
//				itemPanel.add(lShovel);
//			}
//			if(figure.getIceberg().getItems().get(i) instanceof DivingSuit)
//			{
//				itemPanel.add(lSuit);
//			}
//			if(figure.getIceberg().getItems().get(i) instanceof Gun)
//			{
//				itemPanel.add(lGun);
//			}
//			if(figure.getIceberg().getItems().get(i) instanceof Flare)
//			{
//				itemPanel.add(lFlare);
//			}
//			if(figure.getIceberg().getItems().get(i) instanceof Charge)
//			{
//				itemPanel.add(lCharge);
//			}
		}
		pBottomRight.add(itemPanel); 
	}
	
	
//	public void IcebergChange(Iceberg iceberg)
//	{
//		listModel.clear();
//		items.clear();
//		itemPanel.removeAll(); 
//		
//		for(int i = 0; i < iceberg.getItems().size(); i++)
//		{
//			//listModel.addElement(iceberg.getItems().get(i).getClass().toString());
//			if(iceberg.getItems().get(i) instanceof Rope)
//			{
//				items.add(lRope);
//				listModel.addElement("Rope");
//			}
//			if(iceberg.getItems().get(i) instanceof Food)
//			{
//				items.add(lFood);
//				listModel.addElement("Food");
//			}
//			if(iceberg.getItems().get(i) instanceof Shovel)
//			{
//				items.add(lShovel);
//				listModel.addElement("Shovel");
//			}
//			if(iceberg.getItems().get(i) instanceof DivingSuit)
//			{
//				items.add(lSuit);
//				listModel.addElement("Suit");
//			}
//			if(iceberg.getItems().get(i) instanceof Gun)
//			{
//				items.add(lGun);
//				listModel.addElement("Gun");
//			}
//			if(iceberg.getItems().get(i) instanceof Flare)
//			{
//				items.add(lFlare);
//				listModel.addElement("Flare");
//			}
//			if(iceberg.getItems().get(i) instanceof Charge)
//			{
//				items.add(lCharge);
//				listModel.addElement("Charge");
//			}
//		}
//		listBox = new JList<>(listModel); 
//		for(int i = 0; i <items.size();i++)
//		{
//			itemPanel.add(items.get(i));
//		}
//		pBottomRight.add(itemPanel); 
//	}
//	
//	public void PlayerChange(Figure figure) {
//		listModel.addElement("THIS IS A TEST PLEASE RUN");
//		lName.setText("Name: " + figure.getName() + "       ");
//		HealthChange(figure.getBodyHeatUnit());
//		
//		listModel.clear();
//		
//		items.clear();
//		itemPanel.removeAll(); 
//		for(int i = 0; i < figure.getInventory().size(); i++)
//		{
//			if(figure.getInventory().get(i) instanceof Rope)
//			{
//				items.add(lRope);
//				listModel.addElement("Rope");
//			}
//			if(figure.getInventory().get(i) instanceof Food)
//			{
//				items.add(lFood);
//				listModel.addElement("Food");
//			}
//			if(figure.getInventory().get(i) instanceof Shovel)
//			{
//				items.add(lShovel);
//				listModel.addElement("Shovel");
//			}
//			if(figure.getInventory().get(i) instanceof DivingSuit)
//			{
//				items.add(lSuit);
//				listModel.addElement("Suit");
//			}
//			if(figure.getInventory().get(i) instanceof Gun)
//			{
//				items.add(lGun);
//				listModel.addElement("Gun");
//			}
//			if(figure.getInventory().get(i) instanceof Flare)
//			{
//				items.add(lFlare);
//				listModel.addElement("Flare");
//			}
//			if(figure.getInventory().get(i) instanceof Charge)
//			{
//				items.add(lCharge);
//				listModel.addElement("Charge");
//			}
//		}
//		listBox = new JList<>(listModel); 
//		for(int i = 0; i <items.size();i++)
//		{
//			itemPanel.add(items.get(i));
//		}
//		pBottomRight.add(itemPanel); 
//	}
}