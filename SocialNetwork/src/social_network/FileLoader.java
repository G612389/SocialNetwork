package social_network;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * The FileLoader class is responsible for loading data from files into the Social Network application.
 * It contains two methods: loadPeople() and loadRelationships().
 * The loadPeople() method loads user profiles from a file and adds them to the UserList.
 * The loadRelationships() method loads relationships between users from a file and creates Relationship objects.
 * Both methods prompt the user for the file name and extension, and then convert the file path to the appropriate format.
 * If the file is not found, an error message is printed to the console.
 * 
 * @author 612389
 * @version DSA_2023_2024
 */
public class FileLoader {

	public void loadPeople() {
		// Processing file info
		// Create input box for file name
		String fileName = JOptionPane.showInputDialog("Enter file name (ex. people, somefile, etc.)");
		String fileExt = JOptionPane.showInputDialog("Enter file extension or blank if \".txt\" (ex. yml, json, etc.)");
		// Convert file path
		String filePath = "./data/"+fileName+"."+(fileExt == null ? "txt" : fileExt);

		UserList userList = UserList.getInstance();
		try{
			File inputFile = new File( filePath );
			Scanner fr = new Scanner (inputFile);
			String strLine = "";
			while ( fr.hasNext() ){
				strLine = fr.nextLine();
				String[] strParts = strLine.split(",");
				String userID = strParts[0];
				String name = strParts[1];
				String lastName = strParts[2];
				String birthDate = strParts[3];
				String gender = strParts[4];
				String birthPlace = strParts[5];
				String homeTown = strParts[6];
				String[] studiedAt = strParts[7].split(";");
				String[] workedAt = strParts[8].split(";");
				String[] likedFilms = strParts[9].split(";");
				String groupCode = strParts[10];

				// Create new profile
				userList.addProfile(new Profile(userID, name, lastName, birthDate, gender, birthPlace, homeTown, studiedAt, workedAt, likedFilms, groupCode));
				
			}
			fr.close();
		}
		catch ( FileNotFoundException e ) {
				 e.printStackTrace();
		}
	}

	public void loadRelationships() {
		// Processing file info
		// Create input box for file name
		String fileName = JOptionPane.showInputDialog("Enter file name (ex. friends, somefile, etc.)");
		String fileExt = JOptionPane.showInputDialog("Enter file extension or blank if \".txt\" (ex. yml, json, etc.)");
		// Convert file path
		String filePath = "./data/"+fileName+"."+(fileExt == null ? "txt" : fileExt);

		Relationship[] relationshipList = new Relationship[100]; // array of relationships
		int i = 0; // counter for the number of relationships in relationshipList
		try {
			File inputFile = new File( filePath );
			Scanner fr = new Scanner (inputFile);
			String strLine = "";
			while (fr.hasNext()) {
				strLine = fr.nextLine();
				String[] strParts = strLine.split(",");
				String userID1 = strParts[0];
				String userID2 = strParts[1];

				// Create new relationship
				Relationship r = new Relationship(userID1, userID2);
				relationshipList[i] = r;
				// Increase counter
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
