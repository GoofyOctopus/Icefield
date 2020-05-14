package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;

import model.Game;
import view.MainFrame;
/*
 * Auther Yazan Suleiman
 */
public class Controller {
	private Game mGame;
	private MainFrame view;
	
	private static Controller instance = null;	
	protected Controller(Game mGame, MainFrame view) {
		this.mGame = mGame; this.view=view;
	}
	public static void createController(Game mGame, MainFrame view) {
		if(instance==null)
			instance = new Controller(mGame, view);
		else
			System.out.println("Already created!");
	}
	public static Controller getController() {
		if(instance==null)
			System.out.println("Instance is null!");
		return instance;
	}
	
	/*
	 * to be called from the main, calls the method that
	 * sets the listeners in the view
	 * DO NOT SET DIRECTLY!
	 */
	public void addListeners() {
		this.view.addBtnListener(new MyBtnListener ());
		this.view.addTestListener(new MyKeyListener());	
	}
	
	/*
	 * The implementation of the listeners
	 * for certain components custom listeners can 
	 * created, then set using the method created for
	 * that purpose in the view -----------
	 * ----------- ----------------------
	 * model modified here based on the event then update method is called
	 */
	private class MyBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Button Clicked!");
			/*
			 * edit the model from here!
			 * after that ask the view to update
			 */
			update();
		}
	}
	private class MyKeyListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			System.out.println("   Code: " + KeyEvent.getKeyText(code));
			/*
			 * switch case based on it change the model
			 */
			
			update();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	}	
	/*
	 * the following method is called after modifying the model
	 * the purpose is to call the update method in the view
	 * don't call the view method directly from the listener
	 */
	private void update() {
		this.view.update();
	}
	/*
	 * Receives names and types of the figures and
	 * passes to the model to create icefield and figures
	 * */
	public void setGameParameters(HashMap<String, String> figureNames) {
		System.out.println(figureNames.size());
		for (String key : figureNames.keySet()) {
		   System.out.println(key + " " + figureNames.get(key));
		}
		
		
	}
}