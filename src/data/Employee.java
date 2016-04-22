package data;

public class Employee {
	private String firstName;
	private String lastName;
	private int id;
	private int departmentId;
	private int jobId;
	
	public Employee() {
		 
	}
	
	
	public Employee(String firstName, String lastName, int id, int departmentId, int jobId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.departmentId = departmentId;
		this.jobId = jobId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", departmentId="
				+ departmentId + ", jobId=" + jobId + "]";
	}


	

}

