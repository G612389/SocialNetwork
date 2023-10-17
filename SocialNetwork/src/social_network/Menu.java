package social_network;

import java.util.Scanner;


public class Menu {
		
	public static void main(String[] strings) {
		FileLoader fl = new FileLoader();
		int userChoice;
		Scanner sc = new Scanner(System.in);
		userChoice = -1;
		while(userChoice != 0){
			System.out.println("----------------------");
			System.out.println("1 - Load 'people' into the network");
			System.out.println("2 - Load 'relationships' ");
			System.out.println("3 - Print out user list");
			System.out.println("4 - Print out relationship list");
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
		System.out.println("Program ended: " + java.time.LocalDateTime.now() + ".\n[G612389]");
	}
}
