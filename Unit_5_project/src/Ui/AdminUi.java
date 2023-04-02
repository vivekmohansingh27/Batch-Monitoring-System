package Ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import Dao.Batch_dao;
import Dao.Batch_daoImpl;
import Dto.Batch_dto;
import Dto.Batch_dtoImpl;
import Excep.NoRecordFoundException;
import Excep.SomethingWentWrongException;

public class AdminUi {
	
	public static void updateBatchcourseName(Scanner sc) {
		System.out.println("Enter batch id");
		String batch_id = sc.next();
		System.out.println("Enter course name");
		String course_name = sc.next();
		Batch_dao batchdao = new Batch_daoImpl();
		try {
			batchdao.updatecourseName(course_name, batch_id);
			System.out.println("Course Name updated");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void updateBatchtotal_seat(Scanner sc) {
		System.out.println("Enter batch id");
		String batch_id = sc.next();
		System.out.println("Enter batch seat");
		int total_seat = sc.nextInt();
		Batch_dao batchdao = new Batch_daoImpl();
		try {
			batchdao.updateseatNumber(total_seat, batch_id);
			System.out.println("Course seat updated");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateBatchduration(Scanner sc) {
		System.out.println("Enter batch id");
		String batch_id = sc.next();
		System.out.println("Enter batch duration");
		int batch_duration = sc.nextInt();
		Batch_dao batchdao = new Batch_daoImpl();
		try {
			batchdao.updateduration(batch_duration, batch_id);
			System.out.println("Course duration updated");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void updateStartdate(Scanner sc) {
		System.out.println("Enter batch id");
		String batch_id = sc.next();
		System.out.println("Enter batch Start date");
		LocalDate batch_startDate = LocalDate.parse(sc.next());
		Batch_dao batchdao = new Batch_daoImpl();
		try {
			batchdao.updatestartDate(batch_startDate, batch_id);
			System.out.println("Course start date updated");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateBatch(Scanner sc) {
		int choice=0;
		do{
			System.out.println("1 -> Update Batch course name");
			System.out.println("2 -> Update Batch total seat");
			System.out.println("3 -> Update Batch duration");
			System.out.println("4 -> Update Batch start date");

			System.out.println("0 -> Exit");
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				updateBatchcourseName(sc);
				break;
			case 2:
				updateBatchtotal_seat(sc);
				break;
			case 3:
				updateBatchduration(sc);
				break;
			case 4:
				updateStartdate(sc);
				break;
			case 0: System.out.println(" Bye Bye");
				break;
			default: System.out.println("Sorry you choose Wrong choice");
			    break;
			}
		}while(choice!=0);
		
		
	}
	
	public static void createBatch(Scanner sc) {
		System.out.println("Enter Batch id");
		String batch_id = sc.next();
		System.out.println("Enter course name");
		String course_name = sc.next();
		System.out.println("Enter total seat");
		int total_seat = sc.nextInt();
		System.out.println("Enter Batch start date");
		LocalDate batch_startDate = LocalDate.parse(sc.next());
		System.out.println("Enter Batch duration");
		int  batch_duration = sc.nextInt();
		
		
		Batch_dto batch = new Batch_dtoImpl(batch_id, course_name, total_seat,batch_startDate, batch_duration);
		Batch_dao batch_dao = new Batch_daoImpl();
		try {
			batch_dao.addBatch(batch);
			System.out.println("Batch is Added");
		} catch (SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}
	
	public static void viewAllBatch() {
		Batch_dao batch_dao = new Batch_daoImpl();
		try {
			List<Batch_dto> list = batch_dao.getbatchList();
			Consumer<Batch_dto> con = batch -> System.out.println("Batch Id " + batch.getBatch_id() + " corse_Name " + batch.getCourse_name() 
			+ " total Seat " + batch.getTotal_seat() + " Start Date " + batch.getBatch_startDate()+" Duration "+batch.getBatch_duration()+" Months");
			list.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void viewBatchbyid(Scanner sc) {
		System.out.println("Enter batch id");
		String batch_id = sc.next();
		
		Batch_dao batch_dao = new Batch_daoImpl();
		try {
			List<Batch_dto> list = batch_dao.getbatchListbyid(batch_id);
			Consumer<Batch_dto> con = batch -> System.out.println("Batch Id " + batch.getBatch_id() + " corse_Name " + batch.getCourse_name() 
			+ " total Seat " + batch.getTotal_seat() + " Start Date " + batch.getBatch_startDate()+" Duration "+batch.getBatch_duration()+" Months");
			list.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void AssignFacultyToBatch(Scanner sc) {
		System.out.println("Enter Batch id");
		String batch_id = sc.next();
		System.out.println("Enter Faculty id");
		String faculty_id = sc.next();
		
		Batch_dao bd = new Batch_daoImpl();
		try {
			bd.assginfacultytobatch(batch_id,faculty_id);
			System.out.println("Batch is Assign to faculty");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	///seeee method
	public static void getBatchDetailsByFacultyid(Scanner sc) {
		System.out.println("Enter faculty id");
		String faculty_id = sc.next();
		
		Batch_dao batch_dao = new Batch_daoImpl();
		try {
			List<Batch_dto> list = batch_dao.getBatchDetailsByFacultyid(faculty_id);
			Consumer<Batch_dto> con = batch -> System.out.println("Batch Id " + batch.getBatch_id() + " corse_Name " + batch.getCourse_name() 
			+ " total Seat " + batch.getTotal_seat() + " Start Date " + batch.getBatch_startDate()+" Duration "+batch.getBatch_duration()+" Months");
			list.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static void deletebatch(Scanner sc) {
		System.out.println("Enter batch id");
		String batch_id = sc.next();
		Batch_dao bd = new Batch_daoImpl();
		try {
			bd.deletebatch(batch_id);
			System.out.println("Batch is deleted");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminMenu(Scanner sc) {
		int choice=0;
		do{
			System.out.println("1 -> Create Batch");
			System.out.println("2 -> Update Batch");
			System.out.println("3 -> View All Batch");
			System.out.println("4 -> View Batch by batch_id");
			System.out.println("5 -> Assign faculty to Batch");
			System.out.println("6 -> Batch details by faculty_id");
			System.out.println("7 -> Delete Batch");
			System.out.println("0 -> Exit");
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				createBatch(sc);
				break;
			case 2:
				updateBatch(sc);
				break;
			case 3:
				viewAllBatch();
				break;
			case 4:
				viewBatchbyid(sc);
				break;
			case 5:
				AssignFacultyToBatch(sc);
				break;
			case 6:	
				getBatchDetailsByFacultyid(sc);
				break;
			case 7:
				deletebatch(sc);
				break;
			case 0: System.out.println(" Bye Bye");
				break;
			default: System.out.println("Sorry you choose Wrong choice");
			    break;
			}
		}while(choice!=0);
		
	}

	

	public static void adminLogin(Scanner sc) {
		System.out.println("Enter Username ");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username and Password");
		}
	}
}
