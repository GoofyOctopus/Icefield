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
import java.awt.Dimension;

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
	JScrollPane scrollPane;
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
		scrollPane = new JScrollPane(listBox);
		scrollPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		scrollPane.setPreferredSize(new Dimension(200, 90));
		pBottomRight.add(scrollPane);
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
	/*
	 * Sometimes there are some specific information needs to be sent to the user
	 * for those kind of cases this method is created
	 */
	public void showInfo(String info) {
		this.info = info;
		this.flag = true;
	}
	private String info = null;
	private boolean flag = false;
	/*
	 * Called when the view is updated, it refreshes the content of the JList and the panel
	 */
	public void playerChange(Figure figure){
		itemPanel.removeAll();
		listModel.clear();
		if(flag) {
			listModel.addElement(info);
			flag = false;
		}		
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
		}
		pBottomRight.add(itemPanel); 
	}
}