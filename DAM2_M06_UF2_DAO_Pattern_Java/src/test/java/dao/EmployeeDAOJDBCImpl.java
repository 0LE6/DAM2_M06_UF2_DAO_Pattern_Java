package dao;
import java.sql.*;
import model.Employee;

public class EmployeeDAOJDBCImpl implements EmployeeDAO{

	static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/hospital?serverTimezone=UTC";
	static final String USER = "root"; 
	static final String PASS = "";
	// CallableStatement cS = null;
	
	Connection con;


	public void add(Employee empl) {
		// TODO Auto-generated method stub
		
	}

	public void update(Employee empl) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee[] getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	// Implementation of close() method
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Exception closing Connection: " + e);
		}
	}


}
