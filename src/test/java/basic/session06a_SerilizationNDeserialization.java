package basic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO.S06_Profile;
import POJO.S06_member;
import io.restassured.response.Response;

public class session06a_SerilizationNDeserialization {
//	curl -X POST 'https://gen-endpoint.com/api/users' \
//	  -H 'Content-Type: application/json' \
//	  -d '{"name":"Charlie Brown","email":"charlie@example.com","role":"viewer","profile":{"bio":"Good grief!"}}'

	String base_url = "https://gen-endpoint.com";

	@Test(description = "POST Request - Send request payload using POJO")
	public void createUser() {

		S06_member member = new S06_member();
		member.setEmail("vxladde@gmail.com");
		member.setName("Vijay");
		member.setRole("SDET");

		S06_Profile profile = new S06_Profile();
		profile.setBio("Hope, Doing well!");
		member.setProfile(profile);

		// given()
		// .pathParams("createUserEndpoint","api/users")
		// .contentType("application/json")
		// .body(member)
		// .when()
		// .post(base_url+"/{createUserEndpoint}")
		// .then()
		// .log().all();

		ObjectMapper mapper = new ObjectMapper();
		String requestPayload = null;

		try {
			requestPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(member);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		given().pathParams("createUserEndpoint", "api/users").contentType("application/json").body(requestPayload)
				.when().post(base_url + "/{createUserEndpoint}").then().log().all();
	}

	@Test(description = "GET Request - response payload using POJO")
	public void getUsers() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Response responsePayload = given().pathParams("createUserEndpoint", "api/users").contentType("application/json")
				.when().get(base_url + "/{createUserEndpoint}");

		String respone = responsePayload.asString();
		List<S06_member> members = mapper.readValue(respone, new TypeReference<List<S06_member>>() {
		});
		// If single member Oject returns
		// Member members =mapper.readValue(respone,Member.class);
		for (int i = 0; i < members.size(); i++) {
			S06_member member = members.get(i);
			System.out.println(member.getName());
		}
	}

}
