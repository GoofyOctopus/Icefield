package controller;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Random;
import java.lang.Math;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	/*
	 * Singleton class
	 */
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
			//the model edited then update the view
			update();
		}
	}
	private class MyKeyListener implements KeyListener{
		String firstinput;
		@Override
		public void keyTyped(KeyEvent e) { }

		@Override
		public void keyPressed(KeyEvent e) {
			if(view.getBlizzard()) { view.changeBlizzard(); view.blizzSwap(); return;}
			double rand = Math.random();
			if(rand > 0.97) {
				//add the following method to the interface
				System.out.println("Generating blizaard");
				view.changeBlizzard();
				view.blizzSwap(); 
				for(int i=0; i < 10; i++)
					for(int j = 0; j < 10; j++)
						mGame.icf.generateBlizzards(i, j);
			}
			int code = e.getKeyCode();
			System.out.println("   Code: " + KeyEvent.getKeyText(code));
			/*
			 * switch case based on it change the model
			 */
			if(mGame.finished!=true) {
			if(e.getKeyCode() == KeyEvent.VK_W) {
				if(firstinput!=null && firstinput.equalsIgnoreCase("Help")) {
					mGame.madeMove("urw");
					firstinput = null;
				}
				else if(firstinput!=null && firstinput.equalsIgnoreCase("Skill")) {
					mGame.madeMove("usw");
					firstinput = null;
				}
				else
					mGame.madeMove("w");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_S) {
	        	if(firstinput!=null && firstinput.equalsIgnoreCase("Help")) {
					mGame.madeMove("urs");
					firstinput = null;
				}
				else if(firstinput!=null && firstinput.equalsIgnoreCase("Skill")) {
					mGame.madeMove("uss");
					firstinput = null;
				}
				else
					mGame.madeMove("s");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_D) {
	        	if(firstinput!=null && firstinput.equalsIgnoreCase("Help")) {
					mGame.madeMove("urd");
					firstinput = null;
				}
				else if(firstinput!=null && firstinput.equalsIgnoreCase("Skill")) {
					mGame.madeMove("usd");
					firstinput = null;
				}
				else
					mGame.madeMove("d");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_A) {
	        	if(firstinput!=null && firstinput.equalsIgnoreCase("Help")) {
					mGame.madeMove("ura");
					firstinput = null;
				}
				else if(firstinput!=null && firstinput.equalsIgnoreCase("Skill")) {
					mGame.madeMove("usa");
					firstinput = null;
				}
				else
					mGame.madeMove("a");
	        }
	        
	        if(e.getKeyCode() == KeyEvent.VK_C) {
	        	mGame.madeMove("rs");
	        }

	        if(e.getKeyCode() == KeyEvent.VK_E) {
	            mGame.madeMove("use");
	        }
	        if(e.getKeyCode() == KeyEvent.VK_V) {
	        	/*
	        	 * Tell the user that "Please select the direction to check Capacity"
	        	 */
	        	view.showInfo("Choose direction");
	        	firstinput = "Skill";
	        }

	        if(e.getKeyCode() == KeyEvent.VK_R) {
	        	if(mGame.figures.get(mGame.currentFigure).getIceberg().getSnow() == 0)
	        		mGame.madeMove("ri");
	        }
	        if(e.getKeyCode() == KeyEvent.VK_H) {
	        	/*
	        	 * Tell the user that "Please select the direction to use rope"
	        	 */
	        	view.showInfo("Choose direction");
	        	firstinput = "Help";
	        }

	        if(e.getKeyCode() == KeyEvent.VK_U) {
	        	/*
	        	 * Tell the user that "Please select which item to use"
	        	 */
	        	view.showInfo("Choose item(number)");
	        	firstinput = "Use";
	        }
	        
	        if(e.getKeyCode() == KeyEvent.VK_1) {
	            if(firstinput!=null && firstinput.equalsIgnoreCase("Use")) {
	            	
	            	mGame.madeMove("u1");
	            	firstinput = null;
	            	}
	        	}
	        if(e.getKeyCode() == KeyEvent.VK_2) {
	            if(firstinput!=null && firstinput.equalsIgnoreCase("Use")) {
	            	
	            	mGame.madeMove("u2");
	            	firstinput = null;
	            	}
	        	}
	        if(e.getKeyCode() == KeyEvent.VK_3) {
	            if(firstinput!=null && firstinput.equalsIgnoreCase("Use")) {
	            	
	            	mGame.madeMove("u3");
	            	firstinput = null;
	            	}
	        	}
	        if(e.getKeyCode() == KeyEvent.VK_4) {
	            if(firstinput!=null && firstinput.equalsIgnoreCase("Use")) {
	            	
	            	mGame.madeMove("u4");
	            	firstinput = null;
	            	}
	        	}
	        if(e.getKeyCode() == KeyEvent.VK_5) {
	            if(firstinput!=null && firstinput.equalsIgnoreCase("Use")) {
	            	
	            	mGame.madeMove("u5");
	            	firstinput = null;
	            	}
	        	}
	        if(e.getKeyCode() == KeyEvent.VK_6) {
	            if(firstinput!=null && firstinput.equalsIgnoreCase("Use")) {
	            	
	            	mGame.madeMove("u6");
	            	firstinput = null;
	            	}
	        	}
			}
			
			
			
			update();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(mGame.won) {
				JOptionPane.showMessageDialog((Component) view, "You have won!");
				view.close();
			}
			if(!mGame.won && mGame.finished) {
				JOptionPane.showMessageDialog((Component) view, "Game over!");
				view.close();
			}
		}
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