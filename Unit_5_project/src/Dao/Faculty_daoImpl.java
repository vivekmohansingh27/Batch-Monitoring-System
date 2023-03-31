package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Dto.Faculty_dto;
import Excep.NoRecordFoundException;
import Excep.SomethingWentWrongException;

public class Faculty_daoImpl implements Faculty_dao {

	
	public void addFaculty(Faculty_dto faculty) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "Insert into faculty (faculty_id, first_name, last_name, username, password, mobile, address) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,faculty.getFaculty_id());
			ps.setString(2,faculty.getFirst_name());
			ps.setString(3,faculty.getLast_name());
			ps.setString(4,faculty.getUsername());
			ps.setString(5,faculty.getPassword());
			ps.setString(6,faculty.getMobile());
			ps.setString(7,faculty.getAddress());
			
		ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("Not added");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	public void deleteFaculty(int faculty_id) throws SomethingWentWrongException, NoRecordFoundException, ClassNotFoundException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "update faculty set is_delete=1 where fid=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1,faculty_id);
	
		ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("Not deleted");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	public void Login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException, ClassNotFoundException {
		Connection conn = null;
		try {
			//connect to database
			conn = DBUtils.getConnectionTodatabase();
			//prepare the query
			String LOGIN_QUERY = "SELECT fid FROM faculty WHERE username = ? AND password = ?";
			
			//get the prepared statement object
			PreparedStatement ps = conn.prepareStatement(LOGIN_QUERY);
			
			//stuff the data in the query
			ps.setString(1, username);
			ps.setString(2, password);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("Invalid Username and Password");
			}
			
			//you are here means username and password combination is correct
			resultSet.next();
			LoggedINFaculty.loggedInFacultyId = resultSet.getInt("fid");
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomethingWentWrongException("not login");
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(conn);				
			}catch(SQLException sqlEX) {
				throw new SomethingWentWrongException("not close");
			}
		}
		
	}

	
	public void logout() {
		LoggedINFaculty.loggedInFacultyId = 0;
		
	}

}
