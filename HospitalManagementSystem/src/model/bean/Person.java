package model.bean;

import java.sql.Date;

public class Person implements Comparable<Person>{
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personIdType=" + personIdType + ", personName=" + personName
				+ ", personDateOfBirth=" + personDateOfBirth + ", personAge=" + personAge + ", personGender="
				+ personGender + ", personAddress=" + personAddress + ", personPhoneNo=" + personPhoneNo
				+ ", personPassword=" + personPassword + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personAddress == null) ? 0 : personAddress.hashCode());
		result = prime * result + personAge;
		result = prime * result + ((personDateOfBirth == null) ? 0 : personDateOfBirth.hashCode());
		result = prime * result + ((personGender == null) ? 0 : personGender.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((personIdType == null) ? 0 : personIdType.hashCode());
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
		result = prime * result + ((personPassword == null) ? 0 : personPassword.hashCode());
		result = prime * result + (int) (personPhoneNo ^ (personPhoneNo >>> 32));
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
		Person other = (Person) obj;
		if (personAddress == null) {
			if (other.personAddress != null)
				return false;
		} else if (!personAddress.equals(other.personAddress))
			return false;
		if (personAge != other.personAge)
			return false;
		if (personDateOfBirth == null) {
			if (other.personDateOfBirth != null)
				return false;
		} else if (!personDateOfBirth.equals(other.personDateOfBirth))
			return false;
		if (personGender == null) {
			if (other.personGender != null)
				return false;
		} else if (!personGender.equals(other.personGender))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (personIdType == null) {
			if (other.personIdType != null)
				return false;
		} else if (!personIdType.equals(other.personIdType))
			return false;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		if (personPassword == null) {
			if (other.personPassword != null)
				return false;
		} else if (!personPassword.equals(other.personPassword))
			return false;
		if (personPhoneNo != other.personPhoneNo)
			return false;
		return true;
	}
	private String personId;
	private String personIdType;
	private String personName;
	private Date personDateOfBirth;
	private int personAge;
	private String personGender;
	private String personAddress;
	private long personPhoneNo;
	private String personPassword;
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonIdType() {
		return personIdType;
	}
	public void setPersonIdType(String personIdType) {
		this.personIdType = personIdType;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Date getPersonDateOfBirth() {
		return personDateOfBirth;
	}
	public void setPersonDateOfBirth(Date personDateOfBirth) {
		this.personDateOfBirth = personDateOfBirth;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	public String getPersonGender() {
		return personGender;
	}
	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	public long getPersonPhoneNo() {
		return personPhoneNo;
	}
	public void setPersonPhoneNo(long l) {
		this.personPhoneNo = l;
	}
	public String getPersonPassword() {
		return personPassword;
	}
	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}
	@Override
	public int compareTo(Person o) {
		if(this.equals(o))
		{return 0;
		}
		
		return 1;
	}
}
