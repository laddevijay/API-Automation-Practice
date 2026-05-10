package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class S06_Profile {

	private String bio;

	public S06_Profile() {

	}

	public S06_Profile(String bio) {
		this.bio = bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getBio() {
		return this.bio;
	}

	@Override
	public String toString() {
		return "S06_Profile [bio: " + " bio" + "]";

	}

}
