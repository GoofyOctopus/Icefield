package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Icefield;

public class pIcefield extends JPanel{
	Icefield icefield;
	pIceberg[][] picebergs;
	public pIcefield(Icefield field){
		icefield = field;
		picebergs = new pIceberg[10][10];//2D array for panels of icebergs
		setLayout(new GridLayout(10, 10)); //Making 10x10 grid panel
		createIcebergs();
	}
	/*
	 * Creating panels for each iceberg and adding on this panel
	 * */
	void createIcebergs() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.println(icefield.getIceberg(i, j).getCapacity());
				picebergs[i][j] = new pIceberg(icefield.getIceberg(i, j));
				add(picebergs[i][j]);
			}
		}        
	}
	/*
	 * Updates the panel according to the model
	 * */
	public void update() {
		for(int i = 0; i < 10; i++) 
			for(int j = 0; j < 10; j++) 
				picebergs[i][j].update(icefield.getIceberg(i, j));		
	}
	
}
