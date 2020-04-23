package fileManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
 * Yazan
 * The purpose of this file to is to read a txt file at a given path
 * and returns a data ArrayList of all lines of the given file to be handled
 * in another part of the Utility program
 */
public class ReadFile {
	public static List<String> readFrom(String fileName) throws FileNotFoundException {
		if (fileName == null || fileName.length() < 1) {
			throw new IllegalArgumentException("Filename may not be null or empty");
		}
		File file = new File(fileName);
		if (!file.exists()) {
			throw new FileNotFoundException(file.getAbsolutePath());
		}
		List<String> data = new ArrayList<String>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
			while (in.ready()) {
				String line = in.readLine();
				if (!line.startsWith("//") && line.length() > 0) {
					data.add(line);
				}
			}
		} catch (IOException e) {
			System.out.println("CANT READ!!");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("CANT EXIT!!");
				}
			}
		}
		return data;
	}
}