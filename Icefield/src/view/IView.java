package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface IView {
	
	/*
	 * This method is called from the Controller, every component here
	 * should be updated to be consistent with the model
	 */
	public void update();
	/*
	 * The following methods are used when adding the listeners(obviously:))
	 */
	public void close();
	public void addBtnListener(ActionListener myListener);
	public void addKeyListener(KeyListener myListener);
	public void blizzSwap(); 
	public boolean getBlizzard();
	public void changeBlizzard();
}
