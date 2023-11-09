package test;


import model.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOFactory;
import java.util.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeTestInteractive {

	public static void main(String[] args) {

		EmployeeDAOFactory factory = new EmployeeDAOFactory();
		EmployeeDAO dao = factory.createEmployeeDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = "2023-11-09";
		Date d = sdf.parse(dateString);
		Employee e = new Employee(69, "OLEG", "KHARENKO", d, 2000f);
		dao.add(e);

		Employee[] allEmps = dao.getAllEmployees();
		for (Employee employee : allEmps) {
			System.out.println(employee + "\n");
		}
	}
}
