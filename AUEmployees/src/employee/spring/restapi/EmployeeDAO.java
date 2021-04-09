package employee.spring.restapi;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	private static EmployeeDAO instance;
	private static List<Employee> data = new ArrayList<>();
	
	static {
		data.add(new Employee(1, "Vrutik", 100000f));
		data.add(new Employee(2, "Paresh", 200000f));
		data.add(new Employee(3, "Jigar", 800000f));
		data.add(new Employee(4, "Kiran", 500000f));
		data.add(new Employee(5, "Nehal", 600000f));
		
	}
	
	private EmployeeDAO() {
		
	}
	
	public static EmployeeDAO getInstance() {
		if (instance == null) {
			instance = new EmployeeDAO();
		}
		
		return instance;				
	}
	
	public List<Employee> listAll() {
		return new ArrayList<Employee>(data);
	}
	
	public int add(Employee employee) {
		int newId = data.size() + 1;
		employee.setId(newId);
		data.add(employee);
		
		return newId;
	}
	
	public Employee get(int id) {
		Employee employeeToFind = new Employee(id);
		int index = data.indexOf(employeeToFind);
		if (index >= 0) {
			return data.get(index);
		}
		return null;
	}
	
	public boolean delete(int id) {
		Employee employeeToFind = new Employee(id);
		int index = data.indexOf(employeeToFind);
		if (index >= 0) {
			data.remove(index);
			return true;
		}
		
		return false;
	}
	
	public boolean update(Employee employee) {
		int index = data.indexOf(employee);
		if (index >= 0) {
			data.set(index, employee);
			return true;
		}
		return false;
	}
}
