package Dao;

import java.util.List;
import Dto.Faculty_dto;
import Excep.NoRecordFoundException;
import Excep.SomethingWentWrongException;

public interface Faculty_dao {
	void addFaculty(Faculty_dto faculty) throws SomethingWentWrongException;
	void deleteFaculty(int faculty_id) throws SomethingWentWrongException, NoRecordFoundException, ClassNotFoundException;
	void Login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException, ClassNotFoundException;
	void logout();
}
