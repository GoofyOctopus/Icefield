package view;

import controller.Controller;
import model.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.GameFrame;
/*
 * Author Yazan Suleiman
 */
public class MainFrame extends JFrame implements IView{
	public Controller controller = null;
	private Game mGame;
	private JButton myBtn;
	private static MainFrame instance = null;
	pStart myPnl;
	JPanel testPnl;
	private JButton testBtn1;
	private JButton testBtn2;
	pSelect pselect;
	int numberPlayers;
	HashMap<String, String> figureNames;

	protected MainFrame(Game mGame) {
		this.mGame = mGame;
		Controller.createController(mGame, this);
		controller = Controller.getController();
		myPnl = new pStart();
		
		/*  For testing purpose dont delete
		testPnl = new JPanel();
		testBtn1 = new JButton("Eskimo",new ImageIcon("Images/Eskimo.jpg"));
		testBtn2 = new JButton("Explorer",new ImageIcon("Images/bpolar.png"));
		testPnl.add(testBtn1);
		testPnl.add(testBtn2);
		*/
		
		myPnl.bStart.addActionListener( 
				ae ->	{
					if(myPnl.tNumberPlayer.getText().equals("")) {
						JOptionPane.showMessageDialog(this, "Enter the number of players !!");
						return;
								}
					numberPlayers = Integer.parseInt(myPnl.tNumberPlayer.getText());//getting the number of players from the user
					if(numberPlayers < 3) //checking if the number of players is less than 3, if it is then show a message otherwise swap to the selection menu
						JOptionPane.showMessageDialog(this, "Invalid number !!");
					else 
					{
						myPnl.setVisible(false);//making the start panel invisible
						pselect = new pSelect();
						this.add(pselect);
						pselect.setVisible(true);//instead making the selection panel visible 
						figureNames = new HashMap<String, String>();
						/*
						 * adding the action listeners when the user clicks on either of the buttons which are 
						 * the Eskimo or the polar explorer and adding them to the hash table by the name
						 * and their type/
						 */
		
						pselect.bEskimoo.addActionListener(new ActionListener() 
						{
							@Override
							public void actionPerformed(ActionEvent e) 
							{
								createFigures(pselect.tName.getText(), "Eskimoo");
								pselect.tName.setText("");//removing the entered name from the textField after the button has been pressed
							}
						});
						pselect.bExplorer.addActionListener(new ActionListener()
						{	
							@Override
							public void actionPerformed(ActionEvent e) 
							{
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
        
		/*  For testing purpose dont delete
		this.add(testPnl);
		*/
		
		
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
	
	public void addBtnListener(ActionListener myListener) {
		//this.myBtn.addActionListener(myListener);
		
		/*  For testing purpose dont delete
		this.testBtn1.addActionListener(myListener);
		this.testBtn2.addActionListener(myListener);
		*/
		
	}
	public void addKeyListener(KeyListener myListener) {
		//this.myBtn.addKeyListener(myListener); //Other component to subscribe!
		
		/*  For testing purpose don't delete
		this.testBtn1.addKeyListener(myListener);
		this.testBtn2.addKeyListener(myListener);
		*/
	}
	
	public void update() {}
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
			System.out.println(mGame.figures.size());
			GameFrame gFrame = new GameFrame(mGame, controller);
			this.controller.setView(gFrame);
			this.controller.addListeners();
			this.setVisible(false);
		}
	}
	
	
	
	

	
}