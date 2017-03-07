package model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ICU {
	
	@Id
	int icuId;
	String examination;
	String investigations;
	String operationDescription;
	
	
	public ICU() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIcuId() {
		return icuId;
	}
	public void setIcuId(int icuId) {
		this.icuId = icuId;
	}
	public String getExamination() {
		return examination;
	}
	public void setExamination(String examination) {
		this.examination = examination;
	}
	public String getInvestigations() {
		return investigations;
	}
	public void setInvestigations(String investigations) {
		this.investigations = investigations;
	}
	public String getOperationDescription() {
		return operationDescription;
	}
	public void setOperationDescription(String operationDescription) {
		this.operationDescription = operationDescription;
	}
}
