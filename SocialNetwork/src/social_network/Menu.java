package social_network;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Menu {
		
	public static void main(String[] strings) {
		FileLoader fl = new FileLoader();
		FileExporter fe = new FileExporter();
		UserList ul = UserList.getInstance();
		RelationshipList rl = RelationshipList.getInstance();
		int userChoice;
		Scanner sc = new Scanner(System.in);
		userChoice = -1;
		while(userChoice != 0){
			System.out.println("----------------------");
			System.out.println("1 - Load 'people' into the network");
			System.out.println("2 - Load 'relationships' ");
			System.out.println("3 - Print out user list");
			System.out.println("4 - Print out relationship list");
			System.out.println("5 - Export user list to file");
			System.out.println("6 - Export relationship list to file");
			System.out.println("7 - Print relationships for a surname");
			System.out.println("8 - Print users from birthplace");
			System.out.println("9 - Print users born between two dates");
			System.out.println("10 - Print users from hometown list");
			System.out.println("11 - Print users with the same profile");
			System.out.println("12 - Print shortest path between two users (BFS))");
			System.out.println("13 - Print other path between two users (DFS)");
			System.out.println("0 - Quit");
			try {
				userChoice = sc.nextInt();
				switch (userChoice) {
					case 0:
						System.out.println("Exiting the menu.");
						break;
					case 1:
						fl.loadPeople();
						break;
					case 2:
						fl.loadRelationships();
						break;
					case 3:
						UserList.getInstance().printUserList();
						break;
					case 4:
						RelationshipList.getInstance().printRelationshipList();
						break;
					case 5:
						fe.exportPeople();
						break;
					case 6:
						fe.exportRelationships();
						break;
					case 7:
						String surname = JOptionPane.showInputDialog(null, "Enter a surname to print relationships for: ");
						ul.printRelationshipsBySurname(surname);
						break;
					case 8:
						String birthplace = JOptionPane.showInputDialog(null, "Enter a birthplace to print users from: ");
						ul.printPeopleByBirthplace(birthplace);
						break;
					case 9:
						int d1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the first date: "));
						int d2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the second date: "));
						ul.getPeopleBetweenDates(d1, d2);
						break;
					case 10:
						ul.printPeopleByHometownList();
						break;
					case 11:
						String userID = JOptionPane.showInputDialog(null, "Enter a user ID to check: ");
						ul.printSameProfile(userID);
						break;
					case 12:
						String user1 = JOptionPane.showInputDialog(null, "Enter the first user ID");
						String user2 = JOptionPane.showInputDialog(null, "Enter the second user ID");
						ul.showShortestPath(user1, user2);
						break;
					case 13:
						String user3 = JOptionPane.showInputDialog(null, "Enter the first user ID");
						String user4 = JOptionPane.showInputDialog(null, "Enter the second user ID");
						ul.showOtherPath(user3, user4);
						break;
					default:
						System.out.println("Invalid selection");
						break;
				}
			} catch (Exception e) {
				System.out.println("An error occurred. Error message: ");
				e.printStackTrace();
			}
		}

		sc.close();
		System.out.println("Program ended: " + java.time.LocalDateTime.now() + "\n[G612389]");
	}
}
