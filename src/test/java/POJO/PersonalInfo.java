package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonalInfo {

	private String firstName;
	private String lastName;
	private String dob;
	private String ssn;
	private String language;

	public PersonalInfo() {

	}

	public PersonalInfo(String firstName, String lastName, String dob, String ssn, String language) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.ssn = ssn;
		this.language = language;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return "PersonalInfo [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", ssn=" + ssn
				+ ", language=" + language + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getDob()=" + getDob() + ", getSsn()=" + getSsn() + ", getLanguage()=" + getLanguage()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}


