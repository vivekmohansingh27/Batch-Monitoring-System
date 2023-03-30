package Dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Batch_dto {


	public String getBatch_id();

	public void setBatch_id(String batch_id) ;

	public String getCourse_name();

	public void setCourse_name(String course_name);

	public int getTotal_seat();

	public void setTotal_seat(int total_seat);

	public LocalDate getBatch_startDate();

	public void setBatch_startDate(LocalDate batch_startDate);

	public int getBatch_duration();

	public void setBatch_duration(int batch_duration);


}
