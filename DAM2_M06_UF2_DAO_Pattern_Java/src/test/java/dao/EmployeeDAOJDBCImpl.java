package dao;
import java.sql.*;
import model.Employee;

public class EmployeeDAOJDBCImpl implements EmployeeDAO{

	static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/employees?serverTimezone=UTC";
	static final String USER = "root"; 
	static final String PASS = "";
	// CallableStatement cS = null;
	
	Connection con;


	public void add(Employee empl) {
		
		try (Connection con = 
				DriverManager.getConnection(CONNECTION_URL, USER, PASS);){
			
			String sSQL = "INSERT INTO employee ("
					+ "ID, "
					+ "FIRSTNAME,"
					+ "LASTNAME, "
					+ "BIRTHDAY,"
					+ "SALARY)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pS = con.prepareStatement(sSQL);
			pS.setInt(1, empl.getId());
			pS.setString(2, empl.getFirstName());
			pS.setString(3, empl.getLastName());
			pS.setDate(4, (Date) empl.getBirthday());
			pS.setFloat(5, empl.getSalary());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
