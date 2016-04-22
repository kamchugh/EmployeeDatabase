package data;

import java.util.List;

public interface EmployeeDao {
	public Employee getEmyById(int id);
	public List<Department> getDepartments();
	public void updateEmployee(Employee employee);
	public void addEmployee(Employee employee);
	public List<Job> getJobs();
	public List<Employee> getEmployees();

}
