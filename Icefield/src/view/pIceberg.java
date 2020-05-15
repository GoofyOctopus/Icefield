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
	JLabel background, figureLabel;
	
	public pIceberg(Iceberg i) {
		update(i);
	}
	/*
	 * Update
	 * */
	public void update(Iceberg i) {
		iceberg = i;
		createBackground();
		if(i.getFigures().size() > 0)
			drawFigure();
		add(background);
	}
	/*
	 * Creating background image
	 * */
	void createBackground() {
		BufferedImage image = null;
//		try {
//			image = ImageIO.read(new File("/Images/2 eskimo.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        background = new JLabel(new ImageIcon("Images/snow.png"));
        background.setLayout(new FlowLayout());
	}
	/*
	 * Draw figure on the iceberg
	 * */
	void drawFigure() {
		BufferedImage image = null;
//		try {
//			image = ImageIO.read(new File("/Images/newIce.jpg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        figureLabel = new JLabel(new ImageIcon("Images/explorer.png"));
        background.add(figureLabel);
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

