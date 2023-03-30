package Ui;

import java.util.Scanner;

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
			case 1://admin login;
				AdminUi.adminLogin(sc);
				break;
			case 2://user login;
				//userLogin(sc);
				break;
			case 0: System.out.println(" Bye Bye");
				break;
			default: System.out.println("Sorry you choose Wrong choice");
			    break;
			}
		} while (choice!=0);
		
	}
}
