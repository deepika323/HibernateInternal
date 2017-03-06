package model.bean;

public class Medicine implements Comparable<Medicine> {
	private int sNo;
	private String medicineName;
	private int quantity;
	private String dosage;
	private float price;
	private int appointmentId;
	private int billNo;
	public int getsNo() {
		return sNo;
	}
	@Override
	public String toString() {
		return "Medicine [sNo=" + sNo + ", medicineName=" + medicineName + ", quantity=" + quantity + ", dosage="
				+ dosage + ", price=" + price + ", appointmentId=" + appointmentId + "]";
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPatientId() {
		return appointmentId;
	}
	public void setPatientId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + billNo;
		result = prime * result + ((dosage == null) ? 0 : dosage.hashCode());
		result = prime * result + ((medicineName == null) ? 0 : medicineName.hashCode());
		result = prime * result + appointmentId;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + quantity;
		result = prime * result + sNo;
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
		Medicine other = (Medicine) obj;
		if (billNo != other.billNo)
			return false;
		if (dosage == null) {
			if (other.dosage != null)
				return false;
		} else if (!dosage.equals(other.dosage))
			return false;
		if (medicineName == null) {
			if (other.medicineName != null)
				return false;
		} else if (!medicineName.equals(other.medicineName))
			return false;
		if (appointmentId != other.appointmentId)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (sNo != other.sNo)
			return false;
		return true;
	}
	@Override
	public int compareTo(Medicine o) {
		if(this.equals(o))
				return 0;
		else 
			return 1;
	}
	
}
