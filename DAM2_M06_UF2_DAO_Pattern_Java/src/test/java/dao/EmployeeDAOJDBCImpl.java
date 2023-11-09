package dao;
import java.sql.*;
import model.Employee;

public class EmployeeDAOJDBCImpl implements EmployeeDAO{

	String connectionUrl = "jdbc:mysql://localhost:3306/hospital?serverTimezone=UTC";
	String user = "root"; 
	String pass = "";
	CallableStatement cS = null;
	
	Connection con;
	
	@Override
	public void add(Employee empl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Employee empl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee[] getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	// Implementation of close() method
	public void close() {
		try {
			con.close();
		} catch (SQLException se) {
			System.out.println("Exception closing Connection: " + se);
		}
	}


}
