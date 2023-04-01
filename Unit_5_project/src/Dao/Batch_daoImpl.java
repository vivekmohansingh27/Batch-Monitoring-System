package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Dto.Batch_dto;
import Dto.Batch_dtoImpl;
import Excep.NoRecordFoundException;
import Excep.SomethingWentWrongException;




public class Batch_daoImpl implements Batch_dao{

	public void addBatch(Batch_dto batch) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "Insert into batch (batch_id, course_name, total_seat, batch_startDate, batch_duartion) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,batch.getBatch_id());
			ps.setString(2,batch.getCourse_name());
			ps.setInt(3, batch.getTotal_seat());
			ps.setDate(4, Date.valueOf(batch.getBatch_startDate()));
			ps.setInt(5, batch.getBatch_duration());
			//System.out.println("1  00");
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
	
	public void updatecourseName(String course_name,String batch_id)throws SomethingWentWrongException,NoRecordFoundException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "update batch set course_name=? where batch_id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,course_name);
			ps.setString(2,batch_id);
	
		ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("Not updated");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public void updateseatNumber(int total_seat, String batch_id)throws SomethingWentWrongException,NoRecordFoundException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "update batch set total_seat=? where batch_id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,total_seat);
			ps.setString(2,batch_id);
	
		ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("Not updated");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	public void updateduration(int batch_duration, String batch_id)throws SomethingWentWrongException,NoRecordFoundException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "update batch set batch_duartion=? where batch_id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,batch_duration);
			ps.setString(2,batch_id);
	
		ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("Not updated");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updatestartDate(LocalDate batch_startDate, String batch_id)throws SomethingWentWrongException,NoRecordFoundException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "update batch set batch_startDate=? where batch_id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDate(1,Date.valueOf(batch_startDate));
			ps.setString(2,batch_id);
	
		ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("Not updated");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Batch_dto> getbatchList()throws NoRecordFoundException, SomethingWentWrongException{
		Connection conn = null;
		List<Batch_dto> list = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "Select batch_id,course_name,total_seat,batch_startDate,batch_duartion from batch";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No record");
			}
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new Batch_dtoImpl(rs.getString("batch_id"),rs.getString("course_name"),rs.getInt("total_seat"),rs.getDate("batch_startDate").toLocalDate(),rs.getInt("batch_duartion")));
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("Not updated");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	public List<Batch_dto> getbatchListbyid(String batch_id) throws SomethingWentWrongException,NoRecordFoundException{
		Connection conn = null;
		List<Batch_dto> list = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "Select batch_id,course_name,total_seat,batch_startDate,batch_duartion from batch where batch_id =?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, batch_id);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No record");
			}
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new Batch_dtoImpl(rs.getString("batch_id"),rs.getString("course_name"),rs.getInt("total_seat"),rs.getDate("batch_startDate").toLocalDate(),rs.getInt("batch_duartion")));
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("Not updated");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public void assginfacultytobatch(String batch_id, String faculty_id)throws SomethingWentWrongException,NoRecordFoundException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "insert into batch_faculty (bid,fid) values ((select bid from batch where batch_id =?),(select fid from faculty where faculty_id=?))";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, batch_id);
			ps.setString(2, faculty_id);
			
			ps.executeUpdate();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Batch_dto> getBatchDetailsByFacultyid(String faculty_id)throws SomethingWentWrongException,NoRecordFoundException{
		Connection conn = null;
		List<Batch_dto> list = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "Select b.batch_id,b.course_name,b.total_seat,b.batch_startDate,b.batch_duartion from batch b inner join batch_faculty bf on b.bid=bf.bid inner join faculty f on (select fid from faculty where faculty_id=?) = bf.fid";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, faculty_id);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No record");
			}
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new Batch_dtoImpl(rs.getString("batch_id"),rs.getString("course_name"),rs.getInt("total_seat"),rs.getDate("batch_startDate").toLocalDate(),rs.getInt("batch_duartion")));
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("no batch given to faculty");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;	
	}


	
	public void deletebatch(String batch_id)throws SomethingWentWrongException,NoRecordFoundException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "update batch set is_delete=1 where batch_id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1,batch_id);
	
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

	@Override
	public List<Batch_dto> getAssignedbatchList(int id) throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<Batch_dto> list = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "Select b.batch_id,b.course_name,b.total_seat,b.batch_startDate,b.batch_duartion from batch b inner join batch_faculty bf on b.bid=bf.bid inner join faculty f on (select fid from faculty where fid=?) = bf.fid";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No record");
			}
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new Batch_dtoImpl(rs.getString("batch_id"),rs.getString("course_name"),rs.getInt("total_seat"),rs.getDate("batch_startDate").toLocalDate(),rs.getInt("batch_duartion")));
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		throw new SomethingWentWrongException("No batch assigned");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	
}
