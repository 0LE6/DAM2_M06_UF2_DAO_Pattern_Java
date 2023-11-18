package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAOJDBCImpl implements EmployeeDAO{

	//static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/employees?serverTimezone=UTC";
	//static final String USER = "root"; 
	//static final String PASS = "";
	// CallableStatement cS = null;
	
	private Connection con;
	public EmployeeDAOJDBCImpl() {
        // Constructor que abre la conexión al instanciar la clase
        try {
            this.con = DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/employees?serverTimezone=UTC", 
            		"root", 
            		"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

	public void add(Employee empl) {
		
		try {
            String sSQL = "INSERT INTO employee ("
                    + "ID, "
                    + "FIRSTNAME,"
                    + "LASTNAME, "
                    + "BIRTHDATE,"
                    + "SALARY)"
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pS = con.prepareStatement(sSQL);
            pS.setInt(1, empl.getId());
            pS.setString(2, empl.getFirstName());
            pS.setString(3, empl.getLastName());
            
            java.sql.Date sqlDate = new java.sql.Date(empl.getBirthday().getTime());
            pS.setDate(4, sqlDate);
            pS.setFloat(5, empl.getSalary());
            
            pS.executeUpdate();
            
        } catch (SQLException e) {
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
	    List<Employee> employeesList = new ArrayList<>();

	    try {
	        String storedProcedureCall = "{call GetAllEmployees}";
	        CallableStatement cS = con.prepareCall(storedProcedureCall);
	        ResultSet resultSet = null;

	        boolean hasResults = cS.execute();

	        if (hasResults) {
	            resultSet = cS.getResultSet();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("ID");
	                String name = resultSet.getString("FIRSTNAME");
	                String lastName = resultSet.getString("LASTNAME");
	                Date birthDate = resultSet.getDate("BIRTHDATE");
	                float salary = resultSet.getFloat("SALARY");

	                Employee e = new Employee(id, name, lastName, birthDate, salary);
	                employeesList.add(e);
	            }
	        } else {
	            System.out.println("The stored procedure did not return a ResultSet.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    Employee[] employeesArray = employeesList.toArray(new Employee[employeesList.size()]);
	    return employeesArray;
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
