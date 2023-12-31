package test;


import model.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOFactory;
import java.util.Date;
//import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class EmployeeTestInteractive {

	public static void main(String[] args) throws ParseException {

		EmployeeDAOFactory factory = new EmployeeDAOFactory();
		EmployeeDAO dao = factory.createEmployeeDAO();
		
		// Part #1 - Create an Employee
		String dateString = "1995-06-09";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date utilDate = sdf.parse(dateString);
        Date sqlDate = new Date(utilDate.getTime());
        
		Employee e = new Employee(70, "OLEG", "KHARENKO", sqlDate, 42069f);
		dao.add(e);
		
		// Part #2 - Get all Employees using a Procedure
		Employee[] allEmps = dao.getAllEmployees();
		for (Employee employee : allEmps) {
			System.out.println(employee + "\n");
		}
		
		// Part #3 - Update an Employee
		
		
		// Part  #4 - Delete an Employee
		
		
	}
}
