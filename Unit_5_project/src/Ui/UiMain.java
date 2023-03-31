package Ui;

import java.util.Scanner;

import Dao.LoggedINFaculty;
import Ui.FacultyUI;

//import com.masaischool.dao.LoggedINUser;


public class UiMain {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int choice=0;
		
		do {
			System.out.println("1 -> Admin login");
			System.out.println();
			System.out.println("2 -> User login");
			System.out.println();
			System.out.println("0 -> Exit");
			System.out.println();
			System.out.println("Please Enter your choice");
			System.out.println();
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				AdminUi.adminLogin(sc);
				break;
			case 2:
				FacultyLogin(sc);
				break;
			case 0: System.out.println(" Bye Bye");
				break;
			default: System.out.println("Sorry you choose Wrong choice");
			    break;
			}
		} while (choice!=0);
		
	}
	


	static void FacultyLogin(Scanner sc) {
		if(!FacultyUI.login())
			return;

		//you are here means login is successful
		int choice = 0;
		do {
			displayFacultyMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					FacultyUI.addFaculty();
					break;
				case 2:	
					break;
				case 3:
					FacultyUI.deleteFaculty();
					try{
						Thread.sleep(2000);
					}catch(InterruptedException ex) {
						
					}
					//no break statement here i.e. after deletion of user account, logout will also take place
				case 0:
					FacultyUI.logout();
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(LoggedINFaculty.loggedInFacultyId != 0);
	}
	static void displayFacultyMenu() {
		System.out.println("1. Add faculty");
		System.out.println("2. view assigned batch to faculty");
		System.out.println("3. Delete My Account");
		System.out.println("0. Logout");
	}
}
