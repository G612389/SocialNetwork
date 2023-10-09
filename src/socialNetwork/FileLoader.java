package socialNetwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoader {
	public void LoadFileOfPeople() {
		String[] list; 
		int listSize = 11;
		int i = 0; // counter for the number of integers in the file
		String mypath = "People.txt";
		try{
			File myfilename = new File( mypath );
			Scanner input2program = new Scanner (myfilename);
			String stringint = "";
			while ( input2program.hasNext() ){
				stringint = input2program.nextLine();
				// process the string
				list[i] = Integer.parseInt (stringint);
				String unsername = 
				i = i+1;
			}
			System.out.println(i);
			input2program.close();
		}
		catch ( FileNotFoundException e ) {
				 e.printStackTrace();
		}
	}
}
