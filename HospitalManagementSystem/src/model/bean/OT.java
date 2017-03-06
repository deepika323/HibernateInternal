package model.bean;

public class OT {
	int otId;
	String description;
	String equipments;
	int patientId;
	int staffId;
	String doctorId;
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getOtId() {
		return otId;
	}
	public void setOtId(int otId) {
		this.otId = otId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEquipments() {
		return equipments;
	}
	public void setEquipments(String equipments) {
		this.equipments = equipments;
	}
}
