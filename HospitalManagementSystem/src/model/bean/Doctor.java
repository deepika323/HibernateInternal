package model.bean;

public class Doctor implements Comparable<Doctor>{
	private String doctorId;
	private String doctorName;
	private String specialization;
	private String timing;
	private String doctorAddress;
	private long doctorPhoneNo;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	String doctorPassword;
    @Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", specialization=" + specialization
				+ ", timing=" + timing + ", doctorAddress=" + doctorAddress + ", doctorPhoneNo=" + doctorPhoneNo
				+ ", doctorPassword=" + doctorPassword + ", departmentId=" + departmentId + "]";
	}
	int departmentId;
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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
	public String getDoctorAddress() {
		return doctorAddress;
	}
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	public long getDoctorPhoneNo() {
		return doctorPhoneNo;
	}
	public void setDoctorPhoneNo(long doctorPhoneNo) {
		this.doctorPhoneNo = doctorPhoneNo;
	}
	public String getDoctorPassword() {
		return doctorPassword;
	}
	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentId;
		result = prime * result + ((doctorAddress == null) ? 0 : doctorAddress.hashCode());
		result = prime * result + ((doctorId == null) ? 0 : doctorId.hashCode());
		result = prime * result + ((doctorName == null) ? 0 : doctorName.hashCode());
		result = prime * result + ((doctorPassword == null) ? 0 : doctorPassword.hashCode());
		result = prime * result + (int) (doctorPhoneNo ^ (doctorPhoneNo >>> 32));
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
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
		Doctor other = (Doctor) obj;
		if (departmentId != other.departmentId)
			return false;
		if (doctorAddress == null) {
			if (other.doctorAddress != null)
				return false;
		} else if (!doctorAddress.equals(other.doctorAddress))
			return false;
		if (doctorId == null) {
			if (other.doctorId != null)
				return false;
		} else if (!doctorId.equals(other.doctorId))
			return false;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
			return false;
		if (doctorPassword == null) {
			if (other.doctorPassword != null)
				return false;
		} else if (!doctorPassword.equals(other.doctorPassword))
			return false;
		if (doctorPhoneNo != other.doctorPhoneNo)
			return false;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		if (timing == null) {
			if (other.timing != null)
				return false;
		} else if (!timing.equals(other.timing))
			return false;
		return true;
	}
	public int compareTo(Doctor o) {
		if(this.equals(o))
		{return 0;
		}
		
		return 1;
	}
}
