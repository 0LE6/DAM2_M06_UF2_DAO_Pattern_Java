package dao;

import model.Employee;

public interface EmployeeDAO {

	public void add(Employee empl);
	public void update(Employee empl);
	public void delete(int id);
	public Employee findById(int id);
	public Employee[] getAllEmployees();
}
