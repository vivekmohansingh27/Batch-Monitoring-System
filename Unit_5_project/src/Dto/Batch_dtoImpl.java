package Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Batch_dtoImpl implements Batch_dto {

	String batch_id;
	String course_name;
	int total_seat;
	LocalDate batch_startDate;
	int batch_duration;
	
	
	public Batch_dtoImpl(String batch_id, String course_name, int total_seat, LocalDate batch_startDate,
			int batch_duration) {
		this.batch_id = batch_id;
		this.course_name = course_name;
		this.total_seat = total_seat;
		this.batch_startDate = batch_startDate;
		this.batch_duration = batch_duration;
		
	}
	
	

	@Override
	public String getBatch_id() {
		return batch_id;
	}
	@Override
	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}
	@Override
	public String getCourse_name() {
		return course_name;
	}
	@Override
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Override
	public int getTotal_seat() {
		return total_seat;
	}
	@Override
	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}
	@Override
	public LocalDate getBatch_startDate() {
		return batch_startDate;
	}
	@Override
	public void setBatch_startDate(LocalDate batch_startDate) {
		this.batch_startDate = batch_startDate;
	}
	@Override
	public int getBatch_duration() {
		return batch_duration;
	}
	@Override
	public void setBatch_duration(int batch_duration) {
		this.batch_duration = batch_duration;
	}
	
	
	
	
	
	
}
