package Ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;



import Dao.Faculty_dao;
import Dao.Faculty_daoImpl;
import Dao.LoggedINFaculty;
import Dto.Faculty_dto;
import Dto.Faculty_dtoImpl;
import Excep.SomethingWentWrongException;

public class FacultyUI {
	private static Faculty_dao faculty_dao;
	private static Scanner scanner;
	
	public FacultyUI(Scanner scanner) {
		this.faculty_dao = new Faculty_daoImpl();
		this.scanner = scanner;
	}	
	
	public static void addFaculty() {
		//code to take input product details
		System.out.print("Enter faculty id ");
		String faculty_id = scanner.next();
		System.out.print("Enter first name ");
		String first_name = scanner.next();
		System.out.print("Enter last name ");
		String last_name = scanner.next();
		System.out.println("Enter username");
		String username = scanner.next();
		System.out.println("Enter Password");
		String password = scanner.next();
		System.out.println("Enter mobile");
		String mobile = scanner.next();
		System.out.println("Enter Address");
		String address = scanner.next();
		
		//create object for user with all details
		Faculty_dto faculty = new Faculty_dtoImpl(faculty_id, first_name, last_name, username, password, mobile, address);
		
		try {
			faculty_dao.addFaculty(faculty);;
			System.out.println("User registered successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	

	

	
	public static void deleteFaculty() {
		try {
			int id = LoggedINFaculty.loggedInFacultyId;
			faculty_dao.deleteFaculty(id);
			System.out.println("You are Logged out.\nDeleted your account");
		}catch(SomethingWentWrongException | ClassNotFoundException | Excep.NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	

	
	public static boolean login() {
		boolean loginSuccessful = false;
		
		System.out.print("Enter username ");
		String username = scanner.next();
		
		System.out.print("Enter password ");
		String password = scanner.next();
		
		try {
			faculty_dao.Login(username, password);
			loginSuccessful = true;
		}catch(SomethingWentWrongException | ClassNotFoundException | Excep.NoRecordFoundException ex) {
			System.out.println(ex);
		}
		return loginSuccessful;
	}
	
	public static void logout() {
		faculty_dao.logout();
	}
}
