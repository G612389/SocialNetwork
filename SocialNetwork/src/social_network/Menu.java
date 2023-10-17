package social_network;

import java.util.Scanner;


public class Menu {
		
	public static void main(String[] strings) {
		int userChoice;
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------");
		System.out.println("1 - Load 'people' into the network");
		System.out.println("2 - Load 'relationships' ");
		System.out.println("3 - Print out people");
		System.out.println("4 - Search...");
		System.out.println("0 - Quit");
		userChoice = -1;
		while(userChoice != 0){
			try{
				userChoice = sc.nextInt();
				switch (userChoice){
					case 0:
						System.out.println("Program exited. [G612389]");
						break;
					case 1:
						// Use FileLoader class to load people
						FileLoader fl = new FileLoader();
						fl.loadPeople();
						break;
					case 2:
					
						break;
					default:
						System.out.println("Invalid selection");
						break;
				}
			} catch (Exception e) {
				System.out.println("dosomething with the error");
			}
		}
		System.out.println("Finished processing.");
		sc.close();
	}
}
