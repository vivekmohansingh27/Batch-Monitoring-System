package Dao;

import java.time.LocalDate;
import java.util.List;

import Dto.Batch_dto;
import Excep.NoRecordFoundException;
import Excep.SomethingWentWrongException;

public interface Batch_dao {

	public void addBatch(Batch_dto batch)throws SomethingWentWrongException;

	public void updatecourseName(String course_name,String batch_id)throws SomethingWentWrongException,NoRecordFoundException;

	public void updateseatNumber(int total_seat, String batch_id)throws SomethingWentWrongException,NoRecordFoundException;

	public void updateduration(int batch_duration, String batch_id)throws SomethingWentWrongException,NoRecordFoundException;

	public void updatestartDate(LocalDate batch_startDate, String batch_id)throws SomethingWentWrongException,NoRecordFoundException;

	public List<Batch_dto> getbatchList() throws SomethingWentWrongException,NoRecordFoundException;

	public List<Batch_dto> getbatchListbyid(String batch_id) throws SomethingWentWrongException,NoRecordFoundException;
}
