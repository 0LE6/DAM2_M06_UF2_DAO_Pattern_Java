package test;

import java.util.Date;
import java.text.SimpleDateFormat;

import dao.EmployeeDAO;
import dao.EmployeeDAOFactory;

public class EmployeeTestInteractive {

	public static void main(String[] args) {

		EmployeeDAOFactory factory = new EmployeeDAOFactory();
		EmployeeDAO dao = factory.createEmployeeDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String dateString = "1995-06-09";
		Date d = sdf.parse(dateString);
		

	}

}
