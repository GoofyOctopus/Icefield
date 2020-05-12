package view;
//Erdene
import javax.swing.JPanel;
import javax.swing.JLabel;
import Figures.Eskimo;
import Figures.PolarExplorer;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

public class pStats extends JPanel {
	private JPanel pBottom;
	private JLabel lName;
	private JLabel lHealth;
	private JPanel pBottomRight;
	private JLabel lStats;
	private JTextField tInventory;

	/**
	 * Create the panel.
	 */
	public pStats() {
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		pBottom = new JPanel();
		
		lName = new JLabel("Name: Figure1                 ");
		lHealth = new JLabel("Body heath:             ");
		pBottomRight = new JPanel();
		lStats = new JLabel("Stats: move 1  ");
		tInventory = new JTextField("List of items");
		tInventory.setColumns(15);
		
		pBottomRight.add(lStats);
		pBottomRight.add(tInventory);
	
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
		String items = new String();
		for(int i = 0; i < eskimo.getInventory().size(); i++)
		{
			items += eskimo.getInventory().get(i) + " ";
		}
		tInventory.setText(items);
	}
	public void PlayerChange(PolarExplorer polarExplorer) {
		lName.setText("Name: " + polarExplorer.getName() + "       ");
		HealthChange(polarExplorer.getBodyHeatUnit());
		String items = new String();
		for(int i = 0; i < polarExplorer.getInventory().size(); i++)
		{
			items += polarExplorer.getInventory().get(i) + " ";
		}
		tInventory.setText(items);
	}

}
