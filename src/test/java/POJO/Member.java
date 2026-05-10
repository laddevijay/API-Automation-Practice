package POJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {

	private String enrollmentId;
	private PersonalInfo personalInfo;
	private Address address;
	private String mbi;
	private List<Plan> enrollmentPlans;
	private int memberId;

	public Member() {

	}

	public Member(String enrollmentId, PersonalInfo personalInfo, Address address, String mbi,
			List<Plan> enrollmentPlans, int memberId) {
		super();
		this.enrollmentId = enrollmentId;
		this.personalInfo = personalInfo;
		this.address = address;
		this.mbi = mbi;
		this.enrollmentPlans = enrollmentPlans;
		this.memberId = memberId;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMbi() {
		return mbi;
	}

	public void setMbi(String mbi) {
		this.mbi = mbi;
	}

	public List<Plan> getEnrollmentPlans() {
		return enrollmentPlans;
	}

	public void setEnrollmentPlans(List<Plan> enrollmentPlans) {
		this.enrollmentPlans = enrollmentPlans;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int string) {
		this.memberId = string;
	}
	

	@Override
	public String toString() {
		return "Member [enrollmentId=" + enrollmentId + ", personalInfo=" + personalInfo + ", address=" + address
				+ ", mbi=" + mbi + ", enrollmentPlans=" + enrollmentPlans + ", memberId=" + memberId
				+ ", getEnrollmentId()=" + getEnrollmentId() + ", getPersonalInfo()=" + getPersonalInfo()
				+ ", getAddress()=" + getAddress() + ", getMbi()=" + getMbi() + ", getEnrollmentPlans()="
				+ getEnrollmentPlans() + ", getMemberId()=" + getMemberId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}


