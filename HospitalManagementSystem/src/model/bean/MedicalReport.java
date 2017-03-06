package model.bean;

import java.sql.Date;

public class MedicalReport implements Comparable<MedicalReport> {
	private int appointmentId;
	private Date visitDate;
	private String diagnosis;
	private String investigations;
	private String personId;
	private String tests;
	private String recommendations;
	private String doctorId;
	private String technicianId;
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getTechnicianId() {
		return technicianId;
	};
	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}
	public int getPatientId() {
		return appointmentId;
	}
	public void setPatientId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getInvestigations() {
		return investigations;
	}
	public void setInvestigations(String investigations) {
		this.investigations = investigations;
	}
	public String getTests() {
		return tests;
	}
	public void setTests(String tests) {
		this.tests = tests;
	}
	public String getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}
	
	
	
	@Override
	public String toString() {
		return "MedicalReport [appointmentId=" + appointmentId + ", visitDate=" + visitDate + ", diagnosis=" + diagnosis
				+ ", investigations=" + investigations + ", tests=" + tests + ", recommendations=" + recommendations
				+ ", doctorId=" + doctorId + ", technicianId=" + technicianId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appointmentId;
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + ((doctorId == null) ? 0 : doctorId.hashCode());
		result = prime * result + ((investigations == null) ? 0 : investigations.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((recommendations == null) ? 0 : recommendations.hashCode());
		result = prime * result + ((technicianId == null) ? 0 : technicianId.hashCode());
		result = prime * result + ((tests == null) ? 0 : tests.hashCode());
		result = prime * result + ((visitDate == null) ? 0 : visitDate.hashCode());
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
		MedicalReport other = (MedicalReport) obj;
		if (appointmentId != other.appointmentId)
			return false;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		if (doctorId == null) {
			if (other.doctorId != null)
				return false;
		} else if (!doctorId.equals(other.doctorId))
			return false;
		if (investigations == null) {
			if (other.investigations != null)
				return false;
		} else if (!investigations.equals(other.investigations))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (recommendations == null) {
			if (other.recommendations != null)
				return false;
		} else if (!recommendations.equals(other.recommendations))
			return false;
		if (technicianId == null) {
			if (other.technicianId != null)
				return false;
		} else if (!technicianId.equals(other.technicianId))
			return false;
		if (tests == null) {
			if (other.tests != null)
				return false;
		} else if (!tests.equals(other.tests))
			return false;
		if (visitDate == null) {
			if (other.visitDate != null)
				return false;
		} else if (!visitDate.equals(other.visitDate))
			return false;
		return true;
	}
	@Override
	public int compareTo(MedicalReport o) {
		if(this.equals(o))
			return 0;
		else
			return 1;
	}
}
