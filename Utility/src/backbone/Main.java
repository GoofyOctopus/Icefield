package backbone;

import java.util.List;
import fileManagement.ReadFile;
import fileManagement.WriteToFile;

public class Main {
	public static void main(String[] args) throws Exception {
	
		
		
		
		/*
		 * don't delete the calls
		 * for testing and explaining purposes:)
		 */
		List<String> data = ReadFile.readFrom("deleteme.txt"); 
		for (String line : data) 
			System.out.println(line);
		
		if(WriteToFile.writeTo(data, "C:/temp/help.txt"))
			System.out.println("Saved Successfully!");
	}
}
