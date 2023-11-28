package dao;
import dao.EmployeeDAOJDBCImpl;
import dao.EmployeeDAO;

public class EmployeeDAOFactory {

	public EmployeeDAO createEmployeeDAO() {
		return new EmployeeDAOJDBCImpl();
	}
}