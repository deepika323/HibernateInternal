package model.bean;

public class Staff implements Comparable<Staff> {
	String staffId;
	String staffName;
	String specialization;
	String timing;
	String staffAddress;
	long staffPhoneNo;
	String staffPassword;
	int departmentId;
	public int getDepartmentId()
	{
		return departmentId;
	}
	public void setDepartmentId(int departmentId)
	{
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", specialization=" + specialization
				+ ", timing=" + timing + ", staffAddress=" + staffAddress + ", staffPhoneNo=" + staffPhoneNo
				+ ", staffPassword=" + staffPassword + ", departmentId=" + departmentId + "]";
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
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
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public long getStaffPhoneNo() {
		return staffPhoneNo;
	}
	public void setStaffPhoneNo(long staffPhoneNo) {
		this.staffPhoneNo = staffPhoneNo;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentId;
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
		result = prime * result + ((staffAddress == null) ? 0 : staffAddress.hashCode());
		result = prime * result + ((staffId == null) ? 0 : staffId.hashCode());
		result = prime * result + ((staffName == null) ? 0 : staffName.hashCode());
		result = prime * result + ((staffPassword == null) ? 0 : staffPassword.hashCode());
		result = prime * result + (int) (staffPhoneNo ^ (staffPhoneNo >>> 32));
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
		Staff other = (Staff) obj;
		if (departmentId != other.departmentId)
			return false;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		if (staffAddress == null) {
			if (other.staffAddress != null)
				return false;
		} else if (!staffAddress.equals(other.staffAddress))
			return false;
		if (staffId == null) {
			if (other.staffId != null)
				return false;
		} else if (!staffId.equals(other.staffId))
			return false;
		if (staffName == null) {
			if (other.staffName != null)
				return false;
		} else if (!staffName.equals(other.staffName))
			return false;
		if (staffPassword == null) {
			if (other.staffPassword != null)
				return false;
		} else if (!staffPassword.equals(other.staffPassword))
			return false;
		if (staffPhoneNo != other.staffPhoneNo)
			return false;
		if (timing == null) {
			if (other.timing != null)
				return false;
		} else if (!timing.equals(other.timing))
			return false;
		return true;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	@Override
	public int compareTo(Staff o) {
		if(this.equals(o))
			return 0;
		else
			return 1;
	}
}
