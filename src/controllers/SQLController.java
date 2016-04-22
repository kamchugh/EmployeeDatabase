package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.Department;
import data.Employee;
import data.EmployeeDao;
import data.Job;

@Controller
public class SQLController  {
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/companydb";
	String user = "student";
	String pword = "student";
	
	@Autowired
	private EmployeeDao empDao;
	
	// for the update function, gets the employee by ID and auto-populates their information
	@RequestMapping("GetEmployeeById.do")
	public ModelAndView getEmployeeById(int id) {
		Employee emp = empDao.getEmyById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UpdateEmployee.jsp");
		mv.addObject("employee", emp);
		List<Department> depts = empDao.getDepartments();
		mv.addObject("departments", depts);
		List<Employee> emps = empDao.getEmployees();
		System.out.println("I try to load the employees");
		System.out.println("This is the list I have" + emps);
		mv.addObject("employees", emps);
		List<Job> jobs = empDao.getJobs();
		mv.addObject("jobs", jobs);
		return mv;
	}
	
	//auto-populates all necessary information on the add new employee search 
	@RequestMapping("GoToAddEmployeePage.do")
	public ModelAndView goToAddEmployeePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddEmployee.jsp");
		List<Job> jobs = empDao.getJobs();
		mv.addObject("jobs", jobs);
		List<Department> depts = empDao.getDepartments();
		mv.addObject("departments", depts);
		return mv;
	}
	
 //someday you'll get this to work. This would auto-populate the id field
	@RequestMapping("GoToNormalWay.do")
	public ModelAndView goToNormalWayPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NormalWay.jsp");
		List<Employee> emps = empDao.getEmployees();
		System.out.println("I try to load the employees");
		System.out.println("This is the list I have" + emps);
		mv.addObject("employees", emps);
		return mv;
		
	}
	
	// will do the actual updating of the employee
	@RequestMapping("UpdateEmployee.do")
	public ModelAndView updateEmployees(Employee employee, @RequestParam("firstName") String firstName) {
	System.out.println("I make it into the updateEmployee.do method");
	System.out.println(employee);
		empDao.updateEmployee(employee);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NormalWay.jsp");
		mv.addObject("nameUpdated", firstName);
		return mv;
	}
	
	
	//for the "search for employees" only function - this auto-populates all the options 
	@RequestMapping("searchEmployees.do") 
		public ModelAndView searchJustEmployees() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("SearchEmployeeOnly.jsp");
			List<Employee> emps = empDao.getEmployees();
			System.out.println("I try to load the employees");
			System.out.println("This is the list I have" + emps);
			mv.addObject("employees", emps);
			List<Department> depts = empDao.getDepartments();
			mv.addObject("departments", depts);
			return mv;
		
	}
	
	// I don't remember if this actually does anything 
	
	@RequestMapping("GetAllFields.do")
	public ModelAndView getAllFields() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddEmployee.jsp");
		List<Department> dept = empDao.getDepartments();
		mv.addObject("departments", dept);
		
		return mv;
		
	}
	
	

	// add an employee to your database when you click submit on the add page
	 @RequestMapping("AddEmployee.do")
	 public ModelAndView AddEmployees(Employee employee, @RequestParam("firstName") String firstName) {
		 empDao.addEmployee(employee);
		 ModelAndView mv = new ModelAndView();
			mv.setViewName("NormalWay.jsp");
			mv.addObject("nameAdded", firstName);
			return mv;
	 }
	 
	 
		// Search by employee on the "NormalWay" page - input the information you want to search by 

		@RequestMapping(path = "selectEmployee.do", method = RequestMethod.GET)
		public ModelAndView getEmployee(@RequestParam("getField") String field, @RequestParam("databaseName") String table,
				@RequestParam("match") String match) {
			System.out.println("I have as field: " + field + " as table to seach: " + table + " as thing to match " + match);
			// you gotta do stuff in here to pass those through
			ArrayList<ArrayList> arrayList2 = new ArrayList<>();

			try {
				Class.forName(DRIVER_CLASS_NAME);
				System.out.println("got here 1");
				Connection conn = DriverManager.getConnection(URL, "student", "student");
				System.out.println("got here 2");
				Statement stmt = conn.createStatement();
				boolean haveResultSet = stmt.execute("SELECT * FROM " + table + " WHERE " + field + " = '" + match + "';");
				System.out.println("SELECT * FROM " + table + " WHERE " + field + " = " + match + ";");
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
			ModelAndView mv = new ModelAndView();
			mv.setViewName("NormalWay.jsp");
			mv.addObject("getEmployeeResult", arrayList2);
			return mv;

		}
		
		// delete something off of its id - could be employee, job, etc.
		
		@RequestMapping(path = "deleteByID.do", method = RequestMethod.GET)
		public ModelAndView deletebyID(@RequestParam("databaseName") String table,
				@RequestParam("id") String id) {
			System.out.println("I have as table to seach: " + table + " as thing to match " + id);
			int uc = 0;
			ArrayList<ArrayList> arrayList2 = new ArrayList<>();
			try {
				Class.forName(DRIVER_CLASS_NAME);
				Connection conn = DriverManager.getConnection(URL, "student", "student");
				Statement stmt = conn.createStatement();

				boolean haveResultSet = stmt.execute("DELETE FROM " + table + " WHERE id = " + id + ";");
				if (haveResultSet) {

					ResultSet rs = stmt.getResultSet();
					ResultSetMetaData rsmd = rs.getMetaData();
					ArrayList<String> heading = new ArrayList<>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						heading.add(rsmd.getColumnName(i));
					}
					arrayList2.add(heading);
					// result.add(arrayList2);

					while (rs.next()) {
						ArrayList<String> arrayList3 = new ArrayList<>();
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							arrayList3.add(rs.getString(i));
						}
						arrayList2.add(arrayList3);
						uc = stmt.getUpdateCount();
					}
					rs.close();
				} else { // No result set.
					uc = stmt.getUpdateCount();
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
			
			System.out.println("passed value of uc" + uc);

			ModelAndView mv = new ModelAndView();
			mv.setViewName("NormalWay.jsp");
			mv.addObject("DeletedId", id);
			mv.addObject("DeletedTable", table);
			mv.addObject("numberDeleted", uc);
			mv.addObject("rowResults", arrayList2);
			return mv;

		}
	
	// this is for everything on the "search by sql page (the first choice off the index page"

	@RequestMapping(path = "query.do", params = "query", method = RequestMethod.GET)
	public ModelAndView getQuery(@RequestParam("query") String query) {
		System.out.println("I've made it into the query method");
		int uc = 0;
		ArrayList<ArrayList> arrayList2 = new ArrayList<>();
		System.out.println("Executing SQL statement:\n" + query + "\n");
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement stmt = conn.createStatement();

			boolean haveResultSet = stmt.execute(query);
			if (haveResultSet) {

				ResultSet rs = stmt.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				// List<String> heading = new ArrayList<String>();
				// figure out the header!

				ArrayList<String> heading = new ArrayList<>();

				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					heading.add(rsmd.getColumnName(i));
				}
				arrayList2.add(heading);
				// result.add(arrayList2);

				while (rs.next()) {
					ArrayList<String> arrayList3 = new ArrayList<>();
					// String row = " ";
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						arrayList3.add(rs.getString(i));
						// row = row + rs.getString(i) + "\t";
					}
					arrayList2.add(arrayList3);
					uc = stmt.getUpdateCount();
				}
				rs.close();
			} else { // No result set.
				uc = stmt.getUpdateCount();
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

		ModelAndView mv = new ModelAndView();
		mv.setViewName("IKnowSQL.jsp");
		mv.addObject("numberUpdated", uc);
		mv.addObject("rowResults", arrayList2);
		return mv;

	}
	




}
