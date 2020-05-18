package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Figures.Eskimo;
import Figures.Figure;
import model.Iceberg;

public class pIceberg extends JPanel{
	Iceberg iceberg; //Iceberg to be drawn
	Figure currPl; //Current player
	public JLabel background, figureLabel;
	ImageIcon waterimg= new ImageIcon(getClass().getClassLoader().getResource("water.png"));
	ImageIcon iglooimg= new ImageIcon(getClass().getClassLoader().getResource("igloo.png"));
	ImageIcon iceimg= new ImageIcon(getClass().getClassLoader().getResource("ice.png"));
	ImageIcon snowimg= new ImageIcon(getClass().getClassLoader().getResource("snow.png"));
	ImageIcon eskiandexplor40x40img= new ImageIcon(getClass().getClassLoader().getResource("40x40 eskimo and explorer.png"));
	ImageIcon explorer2img= new ImageIcon(getClass().getClassLoader().getResource("2 explorer.png"));
	ImageIcon eskimo2img= new ImageIcon(getClass().getClassLoader().getResource("2 eskimo.png"));
	ImageIcon explorerimg= new ImageIcon(getClass().getClassLoader().getResource("explorer.png"));
	ImageIcon eskimoimg= new ImageIcon(getClass().getClassLoader().getResource("eskimo.png"));
	
	
	public pIceberg(Iceberg i) {
		figureLabel = new JLabel();
		background = new JLabel();
		background.setLayout(new FlowLayout());
        background.add(figureLabel);
		update(i);
		add(background);
	}
	/*
	 * Update
	 * */
	public void update(Iceberg i) {
		iceberg = i;
		createBackground();
		if(i.getFigures().size() > 0) {
			drawFigure();
		}
		else if(i.getFigures().size() == 0) {
			//System.out.println("("+i.getX()+"," + i.getY()+")");
			figureLabel.setIcon(null);
		}
	}
	/*
	 * Creating background image
	 * */
	void createBackground() {
		if(iceberg.getWater() || (iceberg.getCapacity() == 0 && iceberg.getHoleDiscovered())||(iceberg.isCollapsed()))
			background.setIcon(waterimg);
		else if(iceberg.ishasIgloos())
			background.setIcon(iglooimg);
		else if(iceberg.getSnow() == 0)
			background.setIcon(iceimg);
		else
			background.setIcon(snowimg);
		
        
	}
	/*
	 * Draw figure on the iceberg
	 * */
	void drawFigure() {
		boolean ex = false, es = false;
		
        for(int i = 0; i < iceberg.getFigures().size(); i++) {
        	if(iceberg.getFigures().get(i) instanceof Eskimo)
        		es = true;
        	else
        		ex = true;
        }
        if(es && ex)
        	this.figureLabel.setIcon(eskiandexplor40x40img);
        else if(ex && iceberg.getFigures().size() > 1)
        	this.figureLabel.setIcon(explorer2img);
        else if(ex)
        	this.figureLabel.setIcon(explorerimg);
        else if(es && iceberg.getFigures().size() > 1)
        	this.figureLabel.setIcon(eskimo2img);
        else if(es)
        	this.figureLabel.setIcon(eskimoimg);
	}
//	
//	/*
//	 * Override of paint, which draws iceberg or water as 
//	 * A background and also, figures if there is any
//	 * */
//	@Override
//	protected void paintComponent(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paintComponent(g);
//		BufferedImage bg = null;
//		try {
//			bg = getBackgroundImage();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		g.drawImage(bg, 0, 0, null);
//		ArrayList<BufferedImage> figures =  null;
//		try {
//			figures = getFigures();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for(int i = 0; i < figures.size(); i++) {
//			try {
//				bg = getBackgroundImage();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			g.drawImage(bg, 0, 0, null);
//		}
//	}
//	/*
//	 * Getting images for the figures
//	 * If there is any on the iceberg
//	 * */
//	ArrayList<BufferedImage> getFigures() throws IOException{
//		ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();
//		ArrayList<Figure> figures = (ArrayList<Figure>) iceberg.getFigures();
//		for(int i = 0; i < figures.size(); i++) {
//			BufferedImage img;
//			//if(figures.get(i) == currPl) continue; //To draw the current player on top of the players
//			if(figures.get(i) instanceof Eskimo)
//				img = ImageIO.read(new File("C:\\Users\\Beka\\Downloads\\grass.jpg")); //Eskimo image
//			else
//				img = ImageIO.read(new File("C:\\Users\\Beka\\Downloads\\grass.jpg")); //Explorer image
//			imgs.add(img);
//		}
//		return imgs;
//	}
//	/*
//	 * Getting specific image for the iceberg
//	 * Depending on its type
//	 * */
//	BufferedImage getBackgroundImage() throws IOException{
//		if(iceberg.getCapacity() == 0) 
//			return ImageIO.read(new File("C:\\Users\\Beka\\Downloads\\grass.jpg")); //Water image
//		else if(iceberg.getSnow() > 0) 
//			return ImageIO.read(new File("C:\\Users\\Beka\\Downloads\\grass.jpg")); //Iceberg with snow 
//		else
//			return ImageIO.read(new File("C:\\Users\\Beka\\Downloads\\grass.jpg")); //Iceberg without snow
//	}
//	@Override
//    public Dimension getPreferredSize()
//    {
//        return new Dimension(300,300);
//    }
}

