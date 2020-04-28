package Utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/*
 * Yazan
 * The purpose of this file is to save given data to a 
 * given txt file, returns true if successful
 */
public class WriteToFile {
	public static boolean writeTo(ArrayList<String> data, String fileName) {
		if (fileName == null || fileName.length() < 1|| data==null) {
			System.out.println("Filename may not be null or empty");
			return false;
		}
		
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);
		} catch (IOException e) {
			return false;
		}
		PrintWriter pw = new PrintWriter(fw);
		for (int i = 0; i < data.size(); i++) {
			pw.println(data.get(i));
		}
		pw.close();
		return true;
	}
}


