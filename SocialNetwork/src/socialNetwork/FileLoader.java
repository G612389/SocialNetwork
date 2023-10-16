package socialNetwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileLoader {

	public void loadPeople() {
		// Processing file info
		// Create input box for file name
		String fileName = JOptionPane.showInputDialog("Enter file name (ex. people, somefile, etc.)");
		String fileExt = JOptionPane.showInputDialog("Enter file extension or blank if \".txt\" (ex. yml, json, etc.)");
		// Convert file path
		String filePath = "./data/"+fileName+"."+(if fileExt === null ? "txt" : fileExt);

		String[] list; 
		int listMaxSize = 100; // Default max value for size
		int i = 0; // counter for the number of integers in the file
		String filePath = "./data/"+fileName;
		try{
			File inputFile = new File( filePath );
			Scanner fr = new Scanner (inputFile);
			String strLine = "";
			while ( fr.hasNext() ){
				strLine = fr.nextLine();
				String[] strParts = strLine.split(',');
				// process the string
				list[i] = Integer.parseInt (stringint);
				String unsername = 
				i = i+1;
			}
			System.out.println(i);
			fr.close();
		}
		catch ( FileNotFoundException e ) {
				 e.printStackTrace();
		}
	}

	public void loadRelationships() {
		
	}
}
