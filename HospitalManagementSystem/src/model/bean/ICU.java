package model.bean;

public class ICU {
	int icuId;
	String examination;
	String investigations;
	String operationDescription;
	
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
