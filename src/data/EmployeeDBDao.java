package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDBDao implements EmployeeDao {
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/companydb";
	
	private static final String USER = "student";
	private static final String PASS = "student";
	private Connection conn;
	
	public EmployeeDBDao() {
		try {
			Class.forName(DRIVER_CLASS_NAME);
			conn = DriverManager.getConnection(URL, USER, PASS);
				
			
		} catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe);
		}
		catch (SQLException sqle) {
			
		}
		
	}
	
	@Override
	public Employee getEmyById(int id) {
		Employee emp = null;
		String sql = "SELECT firstname, lastname, id, department_id, job_id FROM employees WHERE id = " + id;

		try {
			Class.forName(DRIVER_CLASS_NAME); // add this so MVC can find the driver
			//conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				System.out.println("I get here");
				emp = new Employee(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			}
			
			//System.out.println(rs.getInt(5));

			rs.close();
			statement.close();
			//conn.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		return emp;
	}
	
	@Override
	public void addEmployee(Employee employee) {
		System.out.println("in update method YOU MADE IT WHHAATT");
		System.out.println(employee + "is this set right?");
System.out.println("INSERT INTO employees (firstname, lastname, department_id, job_id) VALUES ('" + employee.getFirstName() + "', '" + employee.getLastName() + "', "
		+ employee.getDepartmentId() + ", " + employee.getJobId() + ");");
		String sql = "INSERT INTO employees (firstname, lastname, department_id, job_id) VALUES ('" + employee.getFirstName() + "', '" + employee.getLastName() + "', "
				+ employee.getDepartmentId() + ", " + employee.getJobId() + ");";
		ArrayList<ArrayList> arrayList2 = new ArrayList<>();
		try {
			Class.forName(DRIVER_CLASS_NAME);
			//conn = DriverManager.getConnection(URL, "student", "student");
			Statement stmt = conn.createStatement();
			System.out.println("Gets to right before");
			 stmt.executeUpdate(sql);
			System.out.println("Gets to right after sql");
			boolean haveResultSet = false;
			if (haveResultSet) {
				ResultSet rs = stmt.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				ArrayList<String> heading = new ArrayList<>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					heading.add(rsmd.getColumnName(i));
				}
				arrayList2.add(heading);
				while (rs.next()) {
					ArrayList<String> arrayList3 = new ArrayList<>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						arrayList3.add(rs.getString(i));
					}
					arrayList2.add(arrayList3);
				}
				rs.close();
			} else { // No result set.
				int uc = stmt.getUpdateCount();
				System.out.println(uc + " row(s) updated.");
			}
		} catch (SQLException e) {
			ArrayList<String> error = new ArrayList<String>();
			error.add(e.getMessage());
			arrayList2.add(error);
		} catch (Exception e) {
			ArrayList<String> error = new ArrayList<String>();
			error.add(e.getMessage());
			arrayList2.add(error);
		}
		
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		System.out.println("in update method YOU MADE IT WHHAATT");
		System.out.println(employee + "is this set right?");
System.out.println("UPDATE employees SET firstname='" + employee.getFirstName() + "', lastname='" + employee.getLastName() + "', department_id=" 
			+ employee.getDepartmentId() + ", job_id=" + employee.getJobId() + " WHERE id=" + employee.getId() + ";");
		String sql = "UPDATE employees SET firstname='" + employee.getFirstName() + "', lastname='" + employee.getLastName() + "', department_id=" 
				+ employee.getDepartmentId() + ", job_id=" + employee.getJobId() + " WHERE id=" + employee.getId() + ";";
		ArrayList<ArrayList> arrayList2 = new ArrayList<>();
		try {
			Class.forName(DRIVER_CLASS_NAME);
			//conn = DriverManager.getConnection(URL, "student", "student");
			Statement stmt = conn.createStatement();
			System.out.println("Gets to right before");
			 stmt.executeUpdate(sql);
			System.out.println("Gets to right after sql");
			boolean haveResultSet = false;
			if (haveResultSet) {
				ResultSet rs = stmt.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				ArrayList<String> heading = new ArrayList<>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					heading.add(rsmd.getColumnName(i));
				}
				arrayList2.add(heading);
				while (rs.next()) {
					ArrayList<String> arrayList3 = new ArrayList<>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						arrayList3.add(rs.getString(i));
					}
					arrayList2.add(arrayList3);
				}
				rs.close();
			} else { // No result set.
				int uc = stmt.getUpdateCount();
				System.out.println(uc + " row(s) updated.");
			}
		} catch (SQLException e) {
			ArrayList<String> error = new ArrayList<String>();
			error.add(e.getMessage());
			arrayList2.add(error);
		} catch (Exception e) {
			ArrayList<String> error = new ArrayList<String>();
			error.add(e.getMessage());
			arrayList2.add(error);
		}
		
	}
	
	
	@Override
	public List<Job> getJobs() {
		ArrayList<Job> jobs = new ArrayList<>();
		String sql = "SELECT id, name, minimum_salary, maximum_salary FROM jobs ORDER BY name";

		try {
			Class.forName(DRIVER_CLASS_NAME); // add this so MVC can find the driver
			//Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
				Job j = new Job(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				jobs.add(j);
			}

			rs.close();
			statement.close();
			//conn.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		return jobs;
	}
	
	

	
	@Override
	public List<Department> getDepartments() {
		ArrayList<Department> depts = new ArrayList<>();
		String sql = "SELECT id, name, manager_id, location_id FROM departments ORDER BY name";

		try {
			Class.forName(DRIVER_CLASS_NAME); // add this so MVC can find the driver
			//Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
				Department d = new Department(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				depts.add(d);
			}

			rs.close();
			statement.close();
			//conn.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		return depts;
	}
	
	//get all your employees 
	@Override
	public List<Employee> getEmployees() {
		ArrayList<Employee> emps = new ArrayList<>();
		System.out.println("I get into the getEmployee method");
		String sql = "SELECT firstname, lastname, id, department_id, job_id FROM employees ORDER BY id";

		try {
			Class.forName(DRIVER_CLASS_NAME); // add this so MVC can find the driver
			//Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
				Employee e = new Employee(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
				emps.add(e);
			}

			rs.close();
			statement.close();
			//conn.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		return emps;
		
	}

}
