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
					+ "BIRTHDATE,"
					+ "SALARY)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pS = con.prepareStatement(sSQL);
			pS.setInt(1, empl.getId());
			pS.setString(2, empl.getFirstName());
			pS.setString(3, empl.getLastName());
			
			// Convert from java date to sql date
			java.sql.Date sqlDate = 
					new java.sql.Date(empl.getBirthday().getTime());

			pS.setDate(4, sqlDate);
			pS.setFloat(5, empl.getSalary());
			
			// After charge all the data of the Employee execute it
			pS.executeUpdate();
			
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
		
		Employee[] employeesArray =  {};
		
		try (Connection con = 
				DriverManager.getConnection(CONNECTION_URL, USER, PASS);){
			try {
				String storedProcedureCall = "{call GetAllEmployees}";
				CallableStatement cS = con.prepareCall(storedProcedureCall);
				ResultSet resultSet = null;
				
				boolean hasResults = cS.execute();
				
				// Processing the result if the executing is giving any result:
				if (hasResults) {
					resultSet = cS.getResultSet();
					
					while (resultSet.next()) {
						int id = resultSet.getInt("ID");
						int name = resultSet.getInt("FIRSTNAME");
			            String lastName = resultSet.getString("LASTNAME");
			            Date birthDate= resultSet.getDate("BIRTHDATE");
			            float salary = resultSet.getFloat("SALARY");
//			            System.out.println("ID: " + id + 
//			            		" | NAME: " + lastName + 
//			            		" | LASTNAME: " + name + 
//			            		" | BIRTDATE: " + birthDate +
//			            		" | SALARY: " + salary
//			            		);
			            Employee e = new Employee(id,name,lastName,birthDate,salary);
			            employeesArray.add(e);
					}
					
				}
				else System.out.println("The stored procedure did not return a ResultSet.");
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
