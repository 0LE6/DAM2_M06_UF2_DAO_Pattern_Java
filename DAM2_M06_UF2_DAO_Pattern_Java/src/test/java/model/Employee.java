package model;

import java.util.Date;

public class Employee {

	private int id;
	private String firstName; // can be null
	private String lastName;
	private String birthday;
	private float salary;
	
	public Employee() {}
	
	public Employee(int id, String firstName, String lastName, String birthday, float salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.salary = salary;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + 
				", lastName=" + lastName + ", birthday=" +
				birthday + ", salary=" + salary + ", id=" + id + "]";
	}
	
		
	
}
