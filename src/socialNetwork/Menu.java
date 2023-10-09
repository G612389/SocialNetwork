package socialNetwork;

import java.util.Scanner;


public class Menu {
		
	public void menu(){
		int userChoice;
		Scanner consoleinput = new Scanner(System.in);
		System.out.println("----------------------");
		System.out.println("1. Load 'people' into the network");
		System.out.println("2. Load 'realtionships' ");
		System.out.println("3. Print out people");
		System.out.println("4. Search...");
		System.out.println("9 - Quit");
		userChoice = -5;
		while(userChoice != 9){
			try{
				userChoice = consoleinput.nextInt();
				switch (userChoice){
				case 1:
					LoadFileOfPeople();
					break;
				case 2:
					
					break;
					
				case 4:
					System.out.println("Quit");
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
		consoleinput.close();
	}
}
