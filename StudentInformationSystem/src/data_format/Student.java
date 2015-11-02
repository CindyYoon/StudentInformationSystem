package data_format;

public class Student {
	int id;
	String name;
	String department;
	String phone_number;

	public void setId (int id) {
		this.id = id;
	}
	public int getId () {
		return id;
	}

	public void setName (String name) {
		this.name = name;
	}
	public String getName () {
		return name;
	}

	public void setDepartment (String department) {
		this.department = department;
	}
	public String getDepartment () {
		return department;
	}

	public void setPhone_number (String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPhone_number () {
		return phone_number;
	}
}