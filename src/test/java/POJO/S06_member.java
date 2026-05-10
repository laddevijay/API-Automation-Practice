package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class S06_member {
	
	private String name;
	private String email;
	private String role;
	private S06_Profile profile;

	public S06_member() {

	}

	public S06_member(String name, String email, String role, S06_Profile profile) {
		this.name = name;
		this.email = email;
		this.role = role;
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public S06_Profile getProfile() {
		return profile;
	}

	public void setProfile(S06_Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "S06_member [name=" + name + ", email=" + email + ", role=" + role + ", profile=" + profile + "]";
	}

}
