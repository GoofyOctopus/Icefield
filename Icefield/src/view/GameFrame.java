package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.Game;

public class GameFrame extends JFrame implements IView{
	//Controller and game class passed in constructor
	private Controller controller = null; 
	private Game mGame;
	private pIcefield icefieldPanel;
	private pStats statsPanel;
	
	public GameFrame(Game mGame, Controller controller) {
		this.mGame = mGame;
		this.controller = controller;
		icefieldPanel = new pIcefield(mGame.icf);
		statsPanel = new pStats();
		//pIceberg p1 = new pIceberg(mGame.icf.getIceberg(1, 0));
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(icefieldPanel);
		mainPanel.add(statsPanel);
		this.pack();
		this.setSize(580,580);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		this.setVisible(true);
		//---------------------------
		icefieldPanel.setFocusable(true);
		icefieldPanel.requestFocusInWindow();
	}
	

	public void addKeyListener(KeyListener myListener) {
		System.out.println("Called");
		this.icefieldPanel.addKeyListener(myListener);
	}
	
	public void addBtnListener(ActionListener myListener) {};
	
	public void update() {
		icefieldPanel.update();
		//update statspanel also should be done
	}
}
