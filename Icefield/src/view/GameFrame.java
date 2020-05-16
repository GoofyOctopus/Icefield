package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Game;
import model.Icefield;

public class GameFrame extends JFrame implements IView{
	//Controller and game class passed in constructor
	private Controller controller = null; 
	private Game mGame;
	private pIcefield icefieldPanel;
	private pStats statsPanel;
	private JPanel bgContainer = new JPanel();//container panel for the game and blizzard panel
	private JPanel blizPanel = new JPanel();//blizzard panel
	private JLabel blizLable = new JLabel(new ImageIcon("Images/Blizzard.gif"));
	private JTextField blizHappen = new JTextField("BLIZZARD IS HAPPENING");
	CardLayout cardLayout = new CardLayout();
	
	public GameFrame(Game mGame, Controller controller) {
		this.mGame = mGame;
		this.controller = controller;
		icefieldPanel = new pIcefield(mGame.icf);
		statsPanel = new pStats();
		blizPanel.setLayout(new FlowLayout());
		blizLable.setSize(new Dimension(580, 580));
		blizPanel.add(blizLable);
		blizPanel.add(blizHappen);
		blizPanel.setSize(580, 580);
		bgContainer.setLayout(cardLayout);
		
		//pIceberg p1 = new pIceberg(mGame.icf.getIceberg(1, 0));
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(icefieldPanel);
		mainPanel.add(statsPanel);
		bgContainer.add(mainPanel, "GamePanel");
		bgContainer.add(blizPanel, "BlizzardPanel");
		
		cardLayout.show(bgContainer, "GamePanel");
		
		//the action has to occure here to switch to the blizpanel?????
		
		
		
		this.pack();
		this.setSize(580,580);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(bgContainer);
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
