package social_network;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * The FileLoader class is responsible for loading data from files into the Social Network application.
 * It contains two methods: loadPeople() and loadRelationships().
 * The loadPeople() method loads user profiles from a file and adds them to the UserList.
 * The loadRelationships() method loads relationships between users from a file and creates Relationship objects.
 * Both methods prompt the user for the file name and extension, and then convert the file path to the appropriate format.
 * If the file is not found, an error message is printed to the console.
 * 
 * @author G612389
 * @version DSA_2023_2024
 * @see Profile
 * @see Relationship
 * @see UserList
 * @see RelationshipList
 */
public class FileLoader {
	UserList userList = UserList.getInstance();
	RelationshipList relationshipList = RelationshipList.getInstance();

	/**
	 * This method loads people from a file and creates profiles for them.
	 * It prompts the user to enter the file name and extension, and then reads the file and creates profiles for each person in the file.
	 * The profiles are added to the UserList instance.
	 */
	public void loadPeople() {
		// Processing file info
		// Create dialog box
		JOptionPane.showMessageDialog(null, "Please select a file to load.");
		// Create a file selector dialog
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		fileChooser.showOpenDialog(null);
		String filePath = fileChooser.getSelectedFile().getAbsolutePath();

		// Convert file path
		System.out.println("Selected file path: " + filePath);
		try{
			File inputFile = new File( filePath );
			Scanner fr = new Scanner (inputFile);
			String strLine = "";
			while (fr.hasNext()){
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
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prompts the user to enter a file name and extension, then loads the relationships from the specified file.
	 * The file should contain a list of user IDs separated by commas, with each relationship on a new line.
	 * Each relationship is added to the RelationshipList instance.
	 */
	public void loadRelationships() {
		// Check if people have been loaded
		if (userList.getSize() == 0) {
			JOptionPane.showMessageDialog(null, "Please load people first.");
			return;
		}
		// Processing file info
		// Create dialog box
		JOptionPane.showMessageDialog(null, "Please select a file to load.");
		// Create a file selector dialog
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		fileChooser.showOpenDialog(null);
		String filePath = fileChooser.getSelectedFile().getAbsolutePath();

		// Convert file path
		System.out.println("Selected file path: " + filePath);
		try {
			File inputFile = new File( filePath );
			Scanner fr = new Scanner (inputFile);
			String strLine = "";
			while (fr.hasNext()) {
				strLine = fr.nextLine();
				String[] strParts = strLine.split(",");
				String userID1 = strParts[0];
				System.out.println(userID1);
				String userID2 = strParts[1];
				System.out.println(userID2);

				// Create new relationship
				try {
					userList.getProfileByID(userID1.toLowerCase());
					userList.getProfileByID(userID2.toLowerCase());
				} catch (Exception e) {
					System.out.println("Invalid ID detected for relationship " + userID1 + ", " + userID2 + ". Skipping...");
					continue;
				}
				relationshipList.addRelationship(new Relationship(userID1.toLowerCase(), userID2.toLowerCase()));
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
