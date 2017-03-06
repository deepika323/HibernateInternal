package model.bean;

public class Department implements Comparable<Department> {
	private int departmentId;
	private String departmentName;
	private String departmentLocation;
	private String description;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "Department list departmentId :" + departmentId + " \n departmentName :" + departmentName
				+ "\n departmentLocation :" + departmentLocation + "\n description:" + description + "\n";
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentId;
		result = prime * result + ((departmentLocation == null) ? 0 : departmentLocation.hashCode());
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentId != other.departmentId)
			return false;
		if (departmentLocation == null) {
			if (other.departmentLocation != null)
				return false;
		} else if (!departmentLocation.equals(other.departmentLocation))
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	@Override
	public int compareTo(Department o) {
//		if(this.equals(o))
//			return 0;
//		else
			return 1;
	}
	
}
