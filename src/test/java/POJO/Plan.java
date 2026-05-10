package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Plan {

	private String planName;
	private String planType;
	private String status;

	public Plan() {

	}

	public Plan(String planName, String planType, String status) {
		super();
		this.planName = planName;
		this.planType = planType;
		this.status = status;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Plan [planName=" + planName + ", planType=" + planType + ", status=" + status + ", getPlanName()="
				+ getPlanName() + ", getPlanType()=" + getPlanType() + ", getStatus()=" + getStatus() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
