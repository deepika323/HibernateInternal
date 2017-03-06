package model.bean;

public class Technician implements Comparable<Technician> {
	String technicianId;
	String technicianName;
	String specialization;
	String timing;
	String technicianAddress;
	long technicianPhoneNo;
	String technicianPassword;
	int departmentId;
	@Override
	public String toString() {
		return "Technician [technicianId=" + technicianId + ", technicianName=" + technicianName + ", specialization="
				+ specialization + ", timing=" + timing + ", technicianAddress=" + technicianAddress
				+ ", technicianPhoneNo=" + technicianPhoneNo + ", technicianPassword=" + technicianPassword
				+ ", departmentId=" + departmentId + "]";
	}
	public String getTechnicianId() {
		return technicianId;
	}
	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}
	public String getTechnicianName() {
		return technicianName;
	}
	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public String getTechnicianAddress() {
		return technicianAddress;
	}
	public void setTechnicianAddress(String technicianAddress) {
		this.technicianAddress = technicianAddress;
	}
	public long getTechnicianPhoneNo() {
		return technicianPhoneNo;
	}
	public void setTechnicianPhoneNo(long technicianPhoneNo) {
		this.technicianPhoneNo = technicianPhoneNo;
	}
	
	public String getTechnicianPassword() {
		return technicianPassword;}
	public int getDepartmentId() {	
		return departmentId;
	}
	public void setTechnicianPassword(String technicianPassword) {
		this.technicianPassword = technicianPassword;
		}
	public void setDepartmentId(int departmentId) {
		this.departmentId=departmentId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentId;
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
		result = prime * result + ((technicianAddress == null) ? 0 : technicianAddress.hashCode());
		result = prime * result + ((technicianId == null) ? 0 : technicianId.hashCode());
		result = prime * result + ((technicianName == null) ? 0 : technicianName.hashCode());
		result = prime * result + ((technicianPassword == null) ? 0 : technicianPassword.hashCode());
		result = prime * result + (int) (technicianPhoneNo ^ (technicianPhoneNo >>> 32));
		result = prime * result + ((timing == null) ? 0 : timing.hashCode());
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
		Technician other = (Technician) obj;
		if (departmentId != other.departmentId)
			return false;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		if (technicianAddress == null) {
			if (other.technicianAddress != null)
				return false;
		} else if (!technicianAddress.equals(other.technicianAddress))
			return false;
		if (technicianId == null) {
			if (other.technicianId != null)
				return false;
		} else if (!technicianId.equals(other.technicianId))
			return false;
		if (technicianName == null) {
			if (other.technicianName != null)
				return false;
		} else if (!technicianName.equals(other.technicianName))
			return false;
		if (technicianPassword == null) {
			if (other.technicianPassword != null)
				return false;
		} else if (!technicianPassword.equals(other.technicianPassword))
			return false;
		if (technicianPhoneNo != other.technicianPhoneNo)
			return false;
		if (timing == null) {
			if (other.timing != null)
				return false;
		} else if (!timing.equals(other.timing))
			return false;
		return true;
	}
	@Override
	public int compareTo(Technician o) {
		if(this.equals(o))
			return 0;
		else
			return 1;
	}
	
}
