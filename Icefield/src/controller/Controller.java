package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Game;
import view.GameFrame;
import view.IView;
import view.MainFrame;
/*
 * Author Yazan Suleiman
 */
public class Controller {
	private Game mGame;
	private IView view;
	
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
	public void setView(GameFrame view) {
		this.view = view;
	}
	/*
	 * sets listeners to the view components
	 */
	public void addListeners() {
		System.out.println("Called");
		this.view.addBtnListener(new MyBtnListener ());
		this.view.addKeyListener(new MyKeyListener());	
	}
	
	/*
	 * The implementation of the listeners
	 * model modified here based on the event then update method is called
	 */
	private class MyBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			System.out.println("Button Clicked!");
			System.out.println(button.getText());
			
//			if(e.getActionCommand().equalsIgnoreCase("Eskimo")) {
//				mGame.addFigure("Eskimo");
//			}
//			if(e.getActionCommand().equalsIgnoreCase("Explorer")) {
//				mGame.addFigure("Explorer");
//			}
			/*
			 * edit the model from here!
			 * after that ask the view to update
			 */
			update();
		}
	}
	private class MyKeyListener implements KeyListener{
		String firstinput;
		@Override
		public void keyTyped(KeyEvent e) { }

		@Override
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			System.out.println("   Code: " + KeyEvent.getKeyText(code));
			/*
			 * switch case based on it change the model
			 */
			if(mGame.finished!=true) {
			if(e.getKeyCode() == KeyEvent.VK_W) {
				mGame.madeMove("w");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_S) {
	            mGame.madeMove("s");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_D) {
	        	mGame.madeMove("d");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_A) {
	        	mGame.madeMove("a");
	        }
	        
	        if(e.getKeyCode() == KeyEvent.VK_C) {
	        	mGame.madeMove("rs");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_V) {
	            mGame.madeMove("us");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_R) {
	            mGame.madeMove("ri");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_U) {
	        	firstinput = "Use";
	        }
	        
	        if(e.getKeyCode() == KeyEvent.VK_1) {
	        	//mGame.figures.get(mGame.currentFigure).getInventory().get(0);
	            if(firstinput!=null && firstinput.equalsIgnoreCase("Use")) {
	            	mGame.madeMove("ef");
	            	firstinput = null;
	            	}
	            	
	        	}
			}
			
			update();
		}

		@Override
		public void keyReleased(KeyEvent e) { }
	}	
	/*
	 * updates the view
	 */
	private void update() {
		this.view.update();
	}

	/*
	 * Receives names and types of the figures and
	 * passes to the model to create icefield and figures
	 * */
	
	public void setGameParameters(HashMap<String, String> figureNames) {
		//System.out.println(figureNames.size());
//		for (String key : figureNames.keySet()) {
//		   System.out.println(key + " " + figureNames.get(key));
//		}	
		mGame.addFigure(figureNames);
	}
	
}