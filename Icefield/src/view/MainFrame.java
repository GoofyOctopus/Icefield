package view;

import controller.Controller;
import model.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.GameFrame;
/*
 * Auther Yazan Suleiman
 */
public class MainFrame extends JFrame{
	public Controller controller = null;
	private Game mGame;
	private JButton myBtn;
	private static MainFrame instance = null;
	pStart myPnl;
	pSelect pselect;
	int numberPlayers;
	HashMap<String, String> figureNames;
	/*
	 * as usual, in the constructor the components are added
	 * and instantiated
	 */
	protected MainFrame(Game mGame) {
		Controller.createController(mGame, this);
		controller = Controller.getController();
		myPnl = new pStart();
		myPnl.bStart.addActionListener( 
				ae ->	{
					numberPlayers = Integer.parseInt(myPnl.tNumberPlayer.getText());
					if(numberPlayers < 3)
						JOptionPane.showMessageDialog(this, "Invalid number !!");
					else 
					{
						myPnl.setVisible(false);
						pselect = new pSelect();
						this.add(pselect);
						pselect.setVisible(true);
						figureNames = new HashMap<String, String>();
						pselect.bEskimoo.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								createFigures(pselect.tName.getText(), "Eskimoo");
								pselect.tName.setText("");
							}
						});
						pselect.bExplorer.addActionListener(new ActionListener() {	
							@Override
							public void actionPerformed(ActionEvent e) {
								createFigures(pselect.tName.getText(), "Explorer");
								pselect.tName.setText("");
							}
						});
					}
				});
		myPnl.bExit.addActionListener(
			ae ->	{
			dispose(); // this only disposes the frame, I guess the game thread will still work 
		});
		this.setSize(580,580);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(myPnl);
        this.setVisible(true);
        
	}
	public static void createMainFrame(Game mGame) {
		if(instance==null)
			instance = new MainFrame(mGame);
		else
			System.out.println("Already created!");
	}
	public static MainFrame getMainFrame() {
		if(instance==null)
			System.out.println("Instance is null!");
		return instance;
	}
	
	/*
	 * here are the methods to be called from the controller
	 * to set the listeners to certain components 
	 */
	public void addBtnListener(ActionListener myListener) {
		this.myBtn.addActionListener(myListener);
	}
	public void addTestListener(KeyListener myListener) {
		this.myBtn.addKeyListener(myListener); //Other component to subscribe!
	}
	
	/*
	 * This method is called from the Controller, every component here
	 * should be updated to be consistent with the model
	 * (in other words: reset all components)
	 */
	public void update() {
		myBtn.setText("HI");
	}
	/*
	 * Saves names and types of the figures and
	 * gives to the controller to set up the game.
	 * After it creates a new frame and start the game.
	 * */
	public void createFigures(String name, String type) {
		figureNames.put(name, type);
		numberPlayers--;
		if(numberPlayers == 0) {
			controller.setGameParameters(figureNames);
			//GameFrame gFrame = new GameFrame(mGame, controller);
		}
	}
	
	
	

	
}