package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Figures.Eskimo;
import Figures.PolarExplorer;
import Item.Charge;
import Item.DivingSuit;
import Item.Flare;
import Item.Food;
import Item.Gun;
import Item.Rope;
import Item.Shovel;
import model.Direction;
import model.Game;
import model.Game.Items;
import model.Game.Move;

public class UtilClass {
	static ArrayList<String> output = new ArrayList<String>();
	public static void running() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userinput = "firstinput";
		Game game = new Game(true);
		while(!userinput.equals("close")) {
	      try {
	         userinput = br.readLine();
	      } catch (IOException ioe) {
	      }
		String[] input = userinput.split(" ");
		switch(input[0]) {
			case "run":
				output = new ArrayList<String>();
				run(input[1]);
			break;
			case "save":save(input[1]);
			break;
			case "load":load(input[1]);
			break;
			default:
				runline(input, game);
			}
		}
	}
	
	public static void run(String filename) throws Exception {
		Game game = new Game(true);
		int figureNumber = 0;
		int currentFigure = 0;
		int numMoves = 0;
		List<String> input=ReadFile.readFrom(filename);
		ArrayList<String[]> splitted = new ArrayList<String[]>();
		for(int i=0;i<input.size();i++) {
			splitted.add(input.get(i).split(" "));
		}
		for(int i=0;i<splitted.size();i++) {
			if(splitted.get(i)[0].equals("create")) {
				if(splitted.get(i)[1].equals("figure")) {
					switch(splitted.get(i)[2]) {
					case "eskimo":game.figures.add(new Eskimo(splitted.get(i)[5]));
					  game.icf.setFigures(game.figures.get(figureNumber),Integer.parseInt(splitted.get(i)[3]),Integer.parseInt(splitted.get(i)[4]));
					  figureNumber++;
					  output.add("Eskimo has created on iceberg "+splitted.get(i)[3]+splitted.get(i)[4]);
					  break;
					case "explorer":game.figures.add(new PolarExplorer(splitted.get(i)[5]));
					  game.icf.setFigures(game.figures.get(figureNumber),Integer.parseInt(splitted.get(i)[3]),Integer.parseInt(splitted.get(i)[4]));
					  figureNumber++;
					  output.add("Explorer has created on iceberg "+splitted.get(i)[3]+splitted.get(i)[4]);
					  break;
					}
				}
				else if(splitted.get(i)[1].equals("iceberg")) {
					switch(splitted.get(i)[2]) {
					case "stable":game.icf.createStableIceberg(Integer.parseInt(splitted.get(i)[3]), Integer.parseInt(splitted.get(i)[4]));
					output.add("Stable iceberg has been created on "+splitted.get(i)[3]+splitted.get(i)[4]);
					break;
					case "unstable":game.icf.createUnstableIceberg(Integer.parseInt(splitted.get(i)[3]), Integer.parseInt(splitted.get(i)[4]),Integer.parseInt(splitted.get(i)[5]));
					output.add("Unstable iceberg has been created on "+splitted.get(i)[3]+splitted.get(i)[4]);
					break;
					}
				}
				else {
					game.icf.setItems(splitted.get(i)[1], Integer.parseInt(splitted.get(i)[2]), Integer.parseInt(splitted.get(i)[3]));
					output.add(splitted.get(i)[1]+" has been created on iceberg "+splitted.get(i)[2]+splitted.get(i)[3]);
				}
				}
			if(splitted.get(i)[0].equals("modify")) {
				switch(splitted.get(i)[1]) {
				case "snow": game.icf.setSnow(Integer.parseInt(splitted.get(i)[2]), Integer.parseInt(splitted.get(i)[3]), Integer.parseInt(splitted.get(i)[4]));
					output.add("Iceberg on " + splitted.get(i)[2] + splitted.get(i)[3]+ " has snow unit of "+ splitted.get(i)[4]);
					break;
				case "capacity": game.icf.setCapacity(Integer.parseInt(splitted.get(i)[2]),Integer.parseInt(splitted.get(i)[3]), Integer.parseInt(splitted.get(i)[4]));
					output.add("Iceberg on "+ splitted.get(i)[2] + splitted.get(i)[3] +" has capacity of " +splitted.get(i)[4]+ " now");	
					break;
				case "bodyheat": 
					int chosen=0;
					for(int j=0;j<game.figures.size();j++) {
						if(game.figures.get(j).getName().equals(splitted.get(i)[2])) {
							chosen = j;
							break;
						}
					}
					game.figures.get(chosen).setBodyHeatUnit(Integer.parseInt(splitted.get(i)[3]));
					output.add(game.figures.get(chosen).getName() +"’s body heat unit is set to "+ game.figures.get(chosen).getBodyHeatUnit());
					break;
				}
			}
			if(splitted.get(i)[0].equals("show")) {
				switch(splitted.get(i)[1]) {
				case "bodyheat":
					int chosen=0;
					for(int j=0;j<game.figures.size();j++) {
						if(game.figures.get(j).getName().equals(splitted.get(i)[2])) {
							chosen = j;
							break;
						}
					}
					output.add(game.figures.get(chosen).getName()+"'s body heat unit is "+game.figures.get(chosen).getBodyHeatUnit());
					break;
				case "snow":
					output.add("Iceberg on "+splitted.get(i)[3]+splitted.get(i)[4]+ " has snow unit of " +game.icf.getIceberg(Integer.parseInt(splitted.get(i)[3])
							, Integer.parseInt(splitted.get(i)[4])).getSnow());
					break;
				}
			}
			if(splitted.get(i)[0].equals("step")) {
				int chosen=0;
				numMoves++;
				for(int j=0;j<game.figures.size();j++) {
					if(game.figures.get(j).getName().equals(splitted.get(i)[2])) {
						chosen = j;
						break;
					}
				}
				switch(splitted.get(i)[1]){
					case "up": game.makeMove(game.figures.get(chosen), Move.W);
					output.add(splitted.get(i)[2]+" has moved in up and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
					if(game.figures.get(chosen).getIceberg().isCollapsed())
						output.add("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
					break;
					case "down": game.makeMove(game.figures.get(chosen), Move.S);
					output.add(splitted.get(i)[2]+" has moved in down and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
					if(game.figures.get(chosen).getIceberg().isCollapsed())
						output.add("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
					break;
					case "right": game.makeMove(game.figures.get(chosen), Move.D);
					output.add(splitted.get(i)[2]+" has moved in right and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
					if(game.figures.get(chosen).getIceberg().isCollapsed())
						output.add("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
					break;
					case "left": game.makeMove(game.figures.get(chosen), Move.A);
					output.add(splitted.get(i)[2]+" has moved in left and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
					if(game.figures.get(chosen).getIceberg().isCollapsed())
						output.add("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
					break;
				}
			}
			if(splitted.get(i)[0].equals("use")) {
				int chosen=0;
				numMoves++;
				for(int j=0;j<game.figures.size();j++) {
					if(game.figures.get(j).getName().equals(splitted.get(i)[2])) {
						chosen = j;
						break;
					}
				}
				switch(splitted.get(i)[1]) {
				case "skill":
					if(game.figures.get(chosen) instanceof Eskimo) {
						game.makeMove(game.figures.get(chosen), Move.USE);
						output.add("Igloo has been built on iceberg" +game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
					}
					else {
						if(splitted.get(i)[3].equals("right")) {
							game.makeMove(game.figures.get(chosen), Move.USPE);
							output.add("Capacity of Iceberg in direction " + splitted.get(i)[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.RIGHT).getCapacity());
						}
						if(splitted.get(i)[3].equals("left")) {
							game.makeMove(game.figures.get(chosen), Move.USPE);
							output.add("Capacity of Iceberg in direction " + splitted.get(i)[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.LEFT).getCapacity());
						}
						if(splitted.get(i)[3].equals("down")) {
							game.makeMove(game.figures.get(chosen), Move.USPE);
							output.add("Capacity of Iceberg in direction " + splitted.get(i)[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.DOWN).getCapacity());
						}
						if(splitted.get(i)[3].equals("up")) {
							game.makeMove(game.figures.get(chosen), Move.USPE);
							output.add("Capacity of Iceberg in direction " + splitted.get(i)[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.UP).getCapacity());
						}
						
					}
					break;
				case "rope":
					game.makeMove(game.figures.get(chosen), Move.UR);
					output.add(splitted.get(i)[2]+" has helped figures in the direction "+ splitted.get(i)[3] +" with rope");
					break;
				case "shovel":
					game.makeMove(game.figures.get(chosen), Move.USH);
					output.add(splitted.get(i)[2]+" has used shovel and iceberg’s snow unit is decreased by 2");
					break;
				case "food":
					game.makeMove(game.figures.get(chosen), Move.EF);
					output.add(splitted.get(i)[2]+" ate the food and its body heat unit is increased by 1");
					break;
				case "divingsuit":
					game.makeMove(game.figures.get(chosen), Move.UD);
					output.add(splitted.get(i)[2]+" is now wearing divingsuit");
					break;
				}
			}
			if(splitted.get(i)[0].equals("generate") && splitted.get(i)[1].equals("blizzard")) {
				game.icf.generateBlizzards(Integer.parseInt(splitted.get(i)[2]), Integer.parseInt(splitted.get(i)[3]));
				output.add("Blizzard has been generated on iceberg "+splitted.get(i)[2]+splitted.get(i)[3]);
				for(int j = 0;j<game.figures.size();j++) {
					if(game.figures.get(j).getBodyHeatUnit()==0) {
						output.add("You have lost the game! ");
						break;
					}
				}
			}
			if(splitted.get(i)[0].equals("retrieve")) {
				int chosen=0;
				numMoves++;
				boolean have=false;
				for(int j=0;j<game.figures.size();j++) {
					if(game.figures.get(j).getName().equals(splitted.get(i)[2])) {
						chosen = j;
						break;
					}
				}
				switch(splitted.get(i)[1]) {
				case "rope":
					for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
						if(game.figures.get(chosen).getInventory().get(j) instanceof Rope) {
							have = true;
						}
					}
					if(!have) {
						game.grabItem(game.figures.get(chosen),Items.ROPE);
						game.figures.get(chosen).getInventory().add(new Rope());
						output.add("rope has been retrieved to " +splitted.get(i)[2]+"’s inventory");
					}
					if(have) {
						output.add(splitted.get(i)[2]+" has this item already");
					}
					break;
				case "food":
					for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
						if(game.figures.get(chosen).getInventory().get(j) instanceof Food)
							have = true;
					}
					if(!have) {
						game.grabItem(game.figures.get(chosen),Items.FOOD);
						//Food ds=new Food();
						//ds.setFigure(game.figures.get(chosen));
						//game.figures.get(chosen).getInventory().add(ds);
						output.add("food has been retrieved to " +splitted.get(i)[2]+"’s inventory");
					}
					if(have) {
						output.add(splitted.get(i)[2]+" has this item already");
					}
					break;
				case "shovel":
					for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
						if(game.figures.get(chosen).getInventory().get(j) instanceof Shovel)
							have = true;
					}
					if(!have) {
						game.grabItem(game.figures.get(chosen),Items.SHOVEL);
						output.add("shovel has been retrieved to " +splitted.get(i)[2]+"’s inventory");
					}
					if(have) {
						output.add(splitted.get(i)[2]+" has this item already");
					}
					break;
				case "divingsuit":
					for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
						if(game.figures.get(chosen).getInventory().get(j) instanceof DivingSuit)
							have = true;
					}
					if(!have) {
						game.grabItem(game.figures.get(chosen),Items.SUIT);
						output.add("divingsuit has been retrieved to " +splitted.get(i)[2]+"’s inventory");
					}
					if(have) {
						output.add(splitted.get(i)[2]+" has this item already");
					}
					break;
				case "gun":
					for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
						if(game.figures.get(chosen).getInventory().get(j) instanceof Gun)
							have = true;
					}
					if(!have) {
						game.grabItem(game.figures.get(chosen),Items.GUN);
						output.add("gun has been retrieved to " +splitted.get(i)[2]+"’s inventory");
					}
					if(have) {
						output.add(splitted.get(i)[2]+" has this item already");
					}
					break;
				case "charge":
					for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
						if(game.figures.get(chosen).getInventory().get(j) instanceof Charge)
							have = true;
					}
					if(!have) {
						game.grabItem(game.figures.get(chosen),Items.CHARGE);
						output.add("charge has been retrieved to " +splitted.get(i)[2]+"’s inventory");
					}
					if(have) {
						output.add(splitted.get(i)[2]+" has this item already");
					}
					break;
				case "flare":
					for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
						if(game.figures.get(chosen).getInventory().get(j) instanceof Flare)
							have = true;
					}
					if(!have) {
						game.grabItem(game.figures.get(chosen),Items.FLARE);
						output.add("flare has been retrieved to " +splitted.get(i)[2]+"’s inventory");
					}
					if(have) {
						output.add(splitted.get(i)[2]+" has this item already");
					}
					break;
				}
			}
			if(splitted.get(i)[0].equals("next")&&splitted.get(i)[1].equals("player")) {
				output.add("It is next player’s turn");
				if(currentFigure<figureNumber && game.figures.get(currentFigure).isDrowning()) 
					output.add("You have lost the game! ");
					currentFigure++;
				if(numMoves>=4)
					output.add("It is next player’s turn");
			}
			if(splitted.get(i)[0].equals("remove")&&splitted.get(i)[1].equals("snow")) {
				int chosen=0;
				numMoves++;
				for(int j=0;j<game.figures.size();j++) {
					if(game.figures.get(j).getName().equals(splitted.get(i)[2])) {
						chosen = j;
						break;
					}
				}
				output.add(splitted.get(i)[2]+" has removed snow from iceberg");
				game.makeMove(game.figures.get(chosen), Move.RS);
			}
			
			if(splitted.get(i)[0].equals("check")&&splitted.get(i)[1].equals("win")) {
				if(game.checkFlareGun()) {
					output.add("You have won the game!");
				}
				else
					output.add("You have not won the game yet");
			}
			if(splitted.get(i)[0].equals("help")) {
				System.out.println("help print");
			}
			if(numMoves>=4) {
				output.add("It is next player’s turn");
				numMoves=0;
			}
		}
		for(int i =0;i<output.size();i++) {
			System.out.println(output.get(i));
		}
	}
	
	

	public static void runline(String[] splitted,Game game) throws Exception {
		if(splitted[0].equals("create")) {
			if(splitted[1].equals("figure")) {
				switch(splitted[2]) {
				case "eskimo":game.figures.add(new Eskimo(splitted[5]));
				  game.icf.setFigures(game.figures.get(game.numberOfFigures),Integer.parseInt(splitted[3]),Integer.parseInt(splitted[4]));
				  game.numberOfFigures++;
				  output.add("Eskimo has created on iceberg "+splitted[3]+splitted[4]);
				  System.out.println("Eskimo has created on iceberg "+splitted[3]+splitted[4]);
				  break;
				case "explorer":game.figures.add(new PolarExplorer(splitted[5]));
				  game.icf.setFigures(game.figures.get(game.numberOfFigures),Integer.parseInt(splitted[3]),Integer.parseInt(splitted[4]));
				  game.numberOfFigures++;
				  output.add("Explorer has created on iceberg "+splitted[3]+splitted[4]);
				  System.out.println("Explorer has created on iceberg "+splitted[3]+splitted[4]);
				  break;
				}
			}
			else if(splitted[1].equals("iceberg")) {
				switch(splitted[2]) {
				case "stable":game.icf.createStableIceberg(Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]));
				output.add("Stable iceberg has been created on "+splitted[3]+splitted[4]);
				System.out.println("Stable iceberg has been created on "+splitted[3]+splitted[4]);
				break;
				case "unstable":game.icf.createUnstableIceberg(Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]),Integer.parseInt(splitted[5]));
				output.add("Unstable iceberg has been created on "+splitted[3]+splitted[4]);
				System.out.println("Unstable iceberg has been created on "+splitted[3]+splitted[4]);
				break;
				}
			}
			else {
				game.icf.setItems(splitted[1], Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]));
				output.add(splitted[1]+" has been created on iceberg "+splitted[2]+splitted[3]);
				System.out.println(splitted[1]+" has been created on iceberg "+splitted[2]+splitted[3]);
			}
			}
		else if(splitted[0].equals("modify")) {
			switch(splitted[1]) {
			case "snow": game.icf.setSnow(Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]));
				output.add("Iceberg on " + splitted[2] + splitted[3]+ " has snow unit of "+ splitted[4]);
				System.out.println("Iceberg on " + splitted[2] + splitted[3]+ " has snow unit of "+ splitted[4]);
				break;
			case "capacity": game.icf.setCapacity(Integer.parseInt(splitted[2]),Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]));
				output.add("Iceberg on "+ splitted[2] + splitted[3] +" has capacity of " +splitted[4]+ " now");	
				System.out.println("Iceberg on "+ splitted[2] + splitted[3] +" has capacity of " +splitted[4]+ " now");
				break;
			case "bodyheat": 
				int chosen=0;
				for(int j=0;j<game.figures.size();j++) {
					if(game.figures.get(j).getName().equals(splitted[2])) {
						chosen = j;
						break;
					}
				}
				game.figures.get(chosen).setBodyHeatUnit(Integer.parseInt(splitted[3]));
				output.add(game.figures.get(chosen).getName() +"’s body heat unit is set to "+ game.figures.get(chosen).getBodyHeatUnit());
				System.out.println(game.figures.get(chosen).getName() +"’s body heat unit is set to "+ game.figures.get(chosen).getBodyHeatUnit());
				break;
			}
		}
		else if(splitted[0].equals("show")) {
			switch(splitted[1]) {
			case "bodyheat":
				int chosen=0;
				for(int j=0;j<game.figures.size();j++) {
					if(game.figures.get(j).getName().equals(splitted[2])) {
						chosen = j;
						break;
					}
				}
				output.add(game.figures.get(chosen).getName()+"'s body heat unit is "+game.figures.get(chosen).getBodyHeatUnit());
				System.out.println(game.figures.get(chosen).getName()+"'s body heat unit is "+game.figures.get(chosen).getBodyHeatUnit());
				break;
			case "snow":
				output.add("Iceberg on "+splitted[3]+splitted[4]+ " has snow unit of " +game.icf.getIceberg(Integer.parseInt(splitted[3])
						, Integer.parseInt(splitted[4])).getSnow());
				System.out.println("Iceberg on "+splitted[3]+splitted[4]+ " has snow unit of " +game.icf.getIceberg(Integer.parseInt(splitted[3])
						, Integer.parseInt(splitted[4])).getSnow());
				break;
			}
		}
		else if(splitted[0].equals("step")) {
			int chosen=0;
			game.numberOfMoves++;
			for(int j=0;j<game.figures.size();j++) {
				if(game.figures.get(j).getName().equals(splitted[2])) {
					chosen = j;
					break;
				}
			}
			switch(splitted[1]){
				case "up": game.makeMove(game.figures.get(chosen), Move.W);
				output.add(splitted[2]+" has moved in up and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
				System.out.println(splitted[2]+" has moved in up and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
				if(game.figures.get(chosen).getIceberg().isCollapsed()) {
					output.add("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
					System.out.println("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
				}
				break;
				case "down": game.makeMove(game.figures.get(chosen), Move.S);
				output.add(splitted[2]+" has moved in down and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
				System.out.println(splitted[2]+" has moved in down and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
				if(game.figures.get(chosen).getIceberg().isCollapsed()) {
					output.add("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
					System.out.println("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
				}
				break;
				case "right": game.makeMove(game.figures.get(chosen), Move.D);
				output.add(splitted[2]+" has moved in right and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
				System.out.println(splitted[2]+" has moved in right and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
				if(game.figures.get(chosen).getIceberg().isCollapsed()) {
					output.add("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
					System.out.println("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
				}
				break;
				case "left": game.makeMove(game.figures.get(chosen), Move.A);
				output.add(splitted[2]+" has moved in left and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
				System.out.println(splitted[2]+" has moved in left and it is now on iceberg "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
				if(game.figures.get(chosen).getIceberg().isCollapsed()) {
					output.add("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
					System.out.println("Everything fell into the water on "+ game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY() +" iceberg");
				}
				break;
			}
		}
		else if(splitted[0].equals("use")) {
			int chosen=0;
			game.numberOfMoves++;
			for(int j=0;j<game.figures.size();j++) {
				if(game.figures.get(j).getName().equals(splitted[2])) {
					chosen = j;
					break;
				}
			}
			switch(splitted[1]) {
			case "skill":
				if(game.figures.get(chosen) instanceof Eskimo) {
					game.makeMove(game.figures.get(chosen), Move.USE);
					output.add("Igloo has been built on iceberg" +game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
					System.out.println("Igloo has been built on iceberg" +game.figures.get(chosen).getIceberg().getX()+ game.figures.get(chosen).getIceberg().getY());
				}
				else {
					if(splitted[3].equals("right")) {
						game.makeMove(game.figures.get(chosen), Move.USPE);
						output.add("Capacity of Iceberg in direction " + splitted[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.RIGHT).getCapacity());
						System.out.println("Capacity of Iceberg in direction " + splitted[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.RIGHT).getCapacity());
					}
					if(splitted[3].equals("left")) {
						game.makeMove(game.figures.get(chosen), Move.USPE);
						output.add("Capacity of Iceberg in direction " + splitted[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.LEFT).getCapacity());
						System.out.println("Capacity of Iceberg in direction " + splitted[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.LEFT).getCapacity());
					}
					if(splitted[3].equals("down")) {
						game.makeMove(game.figures.get(chosen), Move.USPE);
						output.add("Capacity of Iceberg in direction " + splitted[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.DOWN).getCapacity());
						System.out.println("Capacity of Iceberg in direction " + splitted[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.DOWN).getCapacity());
					}
					if(splitted[3].equals("up")) {
						game.makeMove(game.figures.get(chosen), Move.USPE);
						output.add("Capacity of Iceberg in direction " + splitted[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.UP).getCapacity());
						System.out.println("Capacity of Iceberg in direction " + splitted[2]+ " is "+ game.figures.get(chosen).getIceberg().getNeighbor(Direction.UP).getCapacity());
					}
					
				}
				break;
				
			case "rope":
				game.makeMove(game.figures.get(chosen), Move.UR);
				output.add(splitted[2]+" has helped figures in the direction "+ splitted[3] +" with rope");
				System.out.println(splitted[2]+" has helped figures in the direction "+ splitted[3] +" with rope");
				break;
				
			case "shovel":
				game.makeMove(game.figures.get(chosen), Move.USH);
				output.add(splitted[2]+" has used shovel and iceberg’s snow unit is decreased by 2");
				System.out.println(splitted[2]+" has used shovel and iceberg’s snow unit is decreased by 2");
				break;
			case "food":
				game.makeMove(game.figures.get(chosen), Move.EF);
				output.add(splitted[2]+" ate the food and its body heat unit is increased by 1");
				System.out.println(splitted[2]+" ate the food and its body heat unit is increased by 1");
				break;
			case "divingsuit":
				game.makeMove(game.figures.get(chosen), Move.UD);
				output.add(splitted[2]+" is now wearing divingsuit");
				System.out.println(splitted[2]+" is now wearing divingsuit");
				break;
			}
		}
		else if(splitted[0].equals("generate") && splitted[1].equals("blizzard")) {
			game.icf.generateBlizzards(Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]));
			output.add("Blizzard has been generated on iceberg "+splitted[2]+splitted[3]);
			System.out.println("Blizzard has been generated on iceberg "+splitted[2]+splitted[3]);
			for(int j = 0;j<game.figures.size();j++) {
				if(game.figures.get(j).getBodyHeatUnit()==0) {
					output.add("You have lost the game! ");
					System.out.println("You have lost the game! ");
					break;
				}
			}
		}
		else if(splitted[0].equals("retrieve")) {
			int chosen=0;
			game.numberOfMoves++;
			boolean have=false;
			for(int j=0;j<game.figures.size();j++) {
				if(game.figures.get(j).getName().equals(splitted[2])) {
					chosen = j;
					break;
				}
			}
			switch(splitted[1]) {
			case "rope":
				for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
					if(game.figures.get(chosen).getInventory().get(j) instanceof Rope) {
						have = true;
					}
				}
				if(!have) {
					game.grabItem(game.figures.get(chosen),Items.ROPE);
					game.figures.get(chosen).getInventory().add(new Rope());
					output.add("rope has been retrieved to " +splitted[2]+"’s inventory");
					System.out.println("rope has been retrieved to " +splitted[2]+"’s inventory");
				}
				if(have) {
					output.add(splitted[2]+" has this item already");
					System.out.println(splitted[2]+" has this item already");
				}
				break;
			case "food":
				for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
					if(game.figures.get(chosen).getInventory().get(j) instanceof Food)
						have = true;
				}
				if(!have) {
					game.grabItem(game.figures.get(chosen),Items.FOOD);
					//Food ds=new Food();
					//ds.setFigure(game.figures.get(chosen));
					//game.figures.get(chosen).getInventory().add(ds);
					output.add("food has been retrieved to " +splitted[2]+"’s inventory");
					System.out.println("food has been retrieved to " +splitted[2]+"’s inventory");
				}
				if(have) {
					output.add(splitted[2]+" has this item already");
					System.out.println(splitted[2]+" has this item already");
				}
				break;
			case "shovel":
				for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
					if(game.figures.get(chosen).getInventory().get(j) instanceof Shovel)
						have = true;
				}
				if(!have) {
					game.grabItem(game.figures.get(chosen),Items.SHOVEL);
					output.add("shovel has been retrieved to " +splitted[2]+"’s inventory");
					System.out.println("shovel has been retrieved to " +splitted[2]+"’s inventory");
				}
				if(have) {
					output.add(splitted[2]+" has this item already");
					System.out.println(splitted[2]+" has this item already");
				}
				break;
			case "divingsuit":
				for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
					if(game.figures.get(chosen).getInventory().get(j) instanceof DivingSuit)
						have = true;
				}
				if(!have) {
					game.grabItem(game.figures.get(chosen),Items.SUIT);
					output.add("divingsuit has been retrieved to " +splitted[2]+"’s inventory");
					System.out.println("divingsuit has been retrieved to " +splitted[2]+"’s inventory");
				}
				if(have) {
					output.add(splitted[2]+" has this item already");
					System.out.println(splitted[2]+" has this item already");
				}
				break;
			case "gun":
				for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
					if(game.figures.get(chosen).getInventory().get(j) instanceof Gun)
						have = true;
				}
				if(!have) {
					game.grabItem(game.figures.get(chosen),Items.GUN);
					output.add("gun has been retrieved to " +splitted[2]+"’s inventory");
					System.out.println("gun has been retrieved to " +splitted[2]+"’s inventory");
				}
				if(have) {
					output.add(splitted[2]+" has this item already");
					System.out.println(splitted[2]+" has this item already");
				}
				break;
			case "charge":
				for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
					if(game.figures.get(chosen).getInventory().get(j) instanceof Charge)
						have = true;
				}
				if(!have) {
					game.grabItem(game.figures.get(chosen),Items.CHARGE);
					output.add("charge has been retrieved to " +splitted[2]+"’s inventory");
					System.out.println("charge has been retrieved to " +splitted[2]+"’s inventory");
				}
				if(have) {
					output.add(splitted[2]+" has this item already");
					System.out.println(splitted[2]+" has this item already");
				}
				break;
			case "flare":
				for(int j =0;j<game.figures.get(chosen).getInventory().size();j++) {
					if(game.figures.get(chosen).getInventory().get(j) instanceof Flare)
						have = true;
				}
				if(!have) {
					game.grabItem(game.figures.get(chosen),Items.FLARE);
					output.add("flare has been retrieved to " +splitted[2]+"’s inventory");
					System.out.println("flare has been retrieved to " +splitted[2]+"’s inventory");
				}
				if(have) {
					output.add(splitted[2]+" has this item already");
					System.out.println(splitted[2]+" has this item already");
				}
				break;
			}
		}
		else if(splitted[0].equals("next") && splitted[1].equals("player")) {
			output.add("It is next player’s turn");
			System.out.println("It is next player’s turn");
			if(game.roundCounter<game.numberOfFigures && game.figures.get(game.roundCounter).isDrowning()) {
				output.add("You have lost the game! ");
				System.out.println("You have lost the game! ");
			}
			game.roundCounter++;
			if(game.numberOfMoves>=4) {
				output.add("It is next player’s turn");
				System.out.println("It is next player’s turn");
			}
		}
		else if(splitted[0].equals("remove") && splitted[1].equals("snow")) {
			int chosen=0;
			game.numberOfMoves++;
			boolean have=false;
			for(int j=0;j<game.figures.size();j++) {
				if(game.figures.get(j).getName().equals(splitted[2])) {
					chosen = j;
					break;
				}
			}
			game.numberOfMoves++;
			for(int j=0;j<game.figures.size();j++) {
				if(game.figures.get(j).getName().equals(splitted[2])) {
					chosen = j;
					break;
				}
			}
			output.add(splitted[2]+" has removed snow from iceberg");
			System.out.println(splitted[2]+" has removed snow from iceberg");
			game.makeMove(game.figures.get(chosen), Move.RS);
		}
		
		else if(splitted[0].equals("check")&&splitted[1].equals("win")) {
			if(game.checkFlareGun()) {
				output.add("You have won the game!");
				System.out.println("You have won the game!");
			}
			else {
				output.add("You have not won the game yet");
				System.out.println("You have not won the game yet");
			}
		}
		else if(splitted[0].equals("help")) {
			System.out.println("run FILENAME\r\n" + 
					"load FILENAME\r\n" + 
					"save FILENAME\r\n" + 
					"create figure FNAME COLINDEX ROWINDEX\r\n" + 
					"create ITEM COLINDEX ROWINDEX\r\n" + 
					"next player\r\n" + 
					"modify bodyheat CHANGE\r\n" + 
					"modify capacity COLINDEX ROWINDEX CHANGE\r\n" + 
					"step DIRECTION\r\n" + 
					"use ITEM\r\n" + 
					"use skill\r\n" + 
					"use skill DIRECTION\r\n" + 
					"generate blizzard\r\n" + 
					"retrieve ITEM\r\n" + 
					"remove snow\r\n" + 
					"check win\r\n" + 
					"help");
		}
		else if(game.numberOfMoves>=4) {
			output.add("It is next player’s turn");
			System.out.println("It is next player’s turn");
			game.numberOfMoves=0;
			game.roundCounter++;
		}
		else if(game.figures.size()!=0) {
			if(game.figures.get(game.roundCounter).isDrowning()) {
				System.out.println("It is next player’s turn");
				output.add("It is next player’s turn");
				game.numberOfMoves=0;
				game.roundCounter++;
			}
		}
		else 
			System.out.println("Invalid command!");
	}

	public static void save(String filename) {
		WriteToFile.writeTo(output, filename);
		System.out.println("Saving output to "+filename);
	}
	
	public static void load(String filename) throws FileNotFoundException {
		List<String> input=ReadFile.readFrom(filename);
		System.out.println("Loading files from "+filename);
		for(int i=0;i<input.size();i++) {
			System.out.println(input.get(i));
		}
	}
	
}
