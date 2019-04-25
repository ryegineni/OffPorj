package DemoProg.OfficeProj;

public class EmpDetails {

	private String name;
	private String empType;

	public EmpDetails() {

	}

	public EmpDetails(String name, String empType) {
		this.name = name;
		this.empType = empType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

}