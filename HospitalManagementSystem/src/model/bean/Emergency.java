package model.bean;

import java.sql.Date;

public class Emergency {
	int emergencyPatientId;
	Date dateOfAdmission;
	String operationDone;
	String treatment;
	int regNo;
	public int getEmergencyPatientId() {
		return emergencyPatientId;
	}
	public void setEmergencyPatientId(int emergencyPatientId) {
		this.emergencyPatientId = emergencyPatientId;
	}
	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	public String getOperationDone() {
		return operationDone;
	}
	public void setOperationDone(String operationDone) {
		this.operationDone = operationDone;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
}
