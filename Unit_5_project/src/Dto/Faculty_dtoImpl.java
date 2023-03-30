package Dto;

public class Faculty_dtoImpl implements Faculty_dto{

	String faculty_id;
	String first_name;
	String last_name;
	String username;
	String password;
	String mobile;
	String address;
	
	
	public Faculty_dtoImpl(String faculty_id, String first_name, String last_name, String username, String password,
			String mobile, String address) {
		super();
		this.faculty_id = faculty_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		
	}

	@Override
	public String getFaculty_id() {
		return faculty_id;
	}
	@Override
	public void setFaculty_id(String faculty_id) {
		this.faculty_id = faculty_id;
	}
	@Override
	public String getFirst_name() {
		return first_name;
	}
	@Override
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	@Override
	public String getLast_name() {
		return last_name;
	}
	@Override
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getMobile() {
		return mobile;
	}
	@Override
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}


	
	
	
}
