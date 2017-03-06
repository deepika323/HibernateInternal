package model.bean;

import java.sql.Date;

public class DischargeSummary implements Comparable<DischargeSummary>{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admissionDate == null) ? 0 : admissionDate.hashCode());
		result = prime * result + bedNo;
		result = prime * result + ((dischargeDate == null) ? 0 : dischargeDate.hashCode());
		result = prime * result + ((doctorId == null) ? 0 : doctorId.hashCode());
		result = prime * result + ((history == null) ? 0 : history.hashCode());
		result = prime * result + ((onExamination == null) ? 0 : onExamination.hashCode());
		result = prime * result + ((operationDone == null) ? 0 : operationDone.hashCode());
		result = prime * result + ((operativeFindings == null) ? 0 : operativeFindings.hashCode());
		result = prime * result + otId;
		result = prime * result + patientId;
		result = prime * result + ((recommendations == null) ? 0 : recommendations.hashCode());
		result = prime * result + serialNo;
		result = prime * result + ((treatmentGiven == null) ? 0 : treatmentGiven.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "DischargeSummary [serialNo=" + serialNo + ", admissionDate=" + admissionDate + ", dischargeDate="
				+ dischargeDate + ", history=" + history + ", onExamination=" + onExamination + ", operationDone="
				+ operationDone + ", operativeFindings=" + operativeFindings + ", treatmentGiven=" + treatmentGiven
				+ ", recommendations=" + recommendations + ", appointmentId=" + patientId + ", otId=" + otId + ", doctorId="
				+ doctorId + ", bedNo=" + bedNo + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DischargeSummary other = (DischargeSummary) obj;
		if (admissionDate == null) {
			if (other.admissionDate != null)
				return false;
		} else if (!admissionDate.equals(other.admissionDate))
			return false;
		if (bedNo != other.bedNo)
			return false;
		if (dischargeDate == null) {
			if (other.dischargeDate != null)
				return false;
		} else if (!dischargeDate.equals(other.dischargeDate))
			return false;
		if (doctorId == null) {
			if (other.doctorId != null)
				return false;
		} else if (!doctorId.equals(other.doctorId))
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (onExamination == null) {
			if (other.onExamination != null)
				return false;
		} else if (!onExamination.equals(other.onExamination))
			return false;
		if (operationDone == null) {
			if (other.operationDone != null)
				return false;
		} else if (!operationDone.equals(other.operationDone))
			return false;
		if (operativeFindings == null) {
			if (other.operativeFindings != null)
				return false;
		} else if (!operativeFindings.equals(other.operativeFindings))
			return false;
		if (otId != other.otId)
			return false;
		if (patientId != other.patientId)
			return false;
		if (recommendations == null) {
			if (other.recommendations != null)
				return false;
		} else if (!recommendations.equals(other.recommendations))
			return false;
		if (serialNo != other.serialNo)
			return false;
		if (treatmentGiven == null) {
			if (other.treatmentGiven != null)
				return false;
		} else if (!treatmentGiven.equals(other.treatmentGiven))
			return false;
		return true;
	}
	private int serialNo;
	private Date admissionDate;
	private Date dischargeDate;
	private String history;
	private String onExamination;
	private String operationDone;
	private String operativeFindings;
	private String treatmentGiven;
	private String recommendations;
	private int patientId;
	private int otId;
	private String doctorId;
	private int bedNo;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getOnExamination() {
		return onExamination;
	}
	public void setOnExamination(String onExamination) {
		this.onExamination = onExamination;
	}
	public String getOperationDone() {
		return operationDone;
	}
	public void setOperationDone(String operationDone) {
		this.operationDone = operationDone;
	}
	public String getOperativeFindings() {
		return operativeFindings;
	}
	public void setOperativeFindings(String operativeFindings) {
		this.operativeFindings = operativeFindings;
	}
	public String getTreatmentGiven() {
		return treatmentGiven;
	}
	public void setTreatmentGiven(String treatmentGiven) {
		this.treatmentGiven = treatmentGiven;
	}
	public String getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int appointmentId) {
		this.patientId = appointmentId;
	}
	public int getOtId() {
		return otId;
	}
	public void setOtId(int otId) {
		this.otId = otId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public int getBedNo() {
		return bedNo;
	}
	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}
	
	@Override
	public int compareTo(DischargeSummary o) {
//		if(this.equals(o))
//		{return 0;
//		}
		
		return 1;
	}
}
