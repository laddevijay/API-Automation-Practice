package basic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import POJO.Member;
import TestData.CreateMember;

public class session02_RequestPayload {
	String base_url = "http://localhost:3000/members";

	@Test(description = "GET request")
	public void getAllMembers() {
		given().when().get(base_url).then().statusCode(200).body("[11].memberId", equalTo(12)).log().all();

	}

	@Test(description = "POST request - Send payload using map")
	public void createMember() {
		HashMap payload = new HashMap();
		payload.put("enrollmentId", "834-1011");

		HashMap personalInfo = new HashMap();
		personalInfo.put("firstName", "Test");
		personalInfo.put("lastName", "User");
		personalInfo.put("dob", "1999-01-01");
		personalInfo.put("ssn", "111-22-3339");
		personalInfo.put("language", "English");
		payload.put("personalInfo", personalInfo);

		HashMap address = new HashMap();
		address.put("street", "Test Street");
		address.put("city", "Pune");
		address.put("state", "MH");
		address.put("zip", "411001");
		payload.put("address", address);

		payload.put("mbi", "1AB2-ED3-EF45");

		HashMap enrollmentPlan1 = new HashMap();
		enrollmentPlan1.put("planName", "Gold Plan");
		enrollmentPlan1.put("planType", "Medical");
		enrollmentPlan1.put("status", "Primary");

		ArrayList plan = new ArrayList();
		plan.add(enrollmentPlan1);

		payload.put("enrollmentPlans", plan);

		given().contentType("application/json").body(payload).when().post(base_url).then().log().all();
	}

	@Test(description = "POST request - Send payload using JSONObject")
	public void createMember2() {
		/*
		 * If the API accepts data in JSON format, you should send the payload as a JSON
		 * string. Even if you build it using a JSONObject, make sure to convert it
		 * using toString() before sending—this ensures it’s in the correct format the
		 * API can process.
		 */

		JSONObject payload = new JSONObject();
		payload.put("memberId", 12);
		payload.put("enrollmentId", "834-1012");

		JSONObject personalInfo = new JSONObject();
		personalInfo.put("firstName", "Ankit");
		personalInfo.put("lastName", "Shrivastava");
		personalInfo.put("dob", "1999-11-11");
		personalInfo.put("ssn", "111-22-3341");
		personalInfo.put("language", "Spanish");
		payload.put("personalInfo", personalInfo);

		JSONObject address = new JSONObject();
		address.put("street", "MG Street");
		address.put("city", "Pune");
		address.put("state", "MH");
		address.put("zip", "411001");
		payload.put("address", address);

		payload.put("mbi", "5AB2-ED3-EF95");

		JSONObject enrollmentPlan1 = new JSONObject();
		enrollmentPlan1.put("planName", "Gold Plan");
		enrollmentPlan1.put("planType", "Medical");
		enrollmentPlan1.put("status", "Primary");

		JSONObject enrollmentPlan2 = new JSONObject();
		enrollmentPlan1.put("planName", "BRONZE Plan");
		enrollmentPlan1.put("planType", "Dental");
		enrollmentPlan1.put("status", "Primary");

		ArrayList plan = new ArrayList();
		plan.add(enrollmentPlan1);
		plan.add(enrollmentPlan2);

		payload.put("enrollmentPlans", plan);

		given().contentType("application/json").body(payload.toString()).when().post(base_url).then().log().all();
	}

	@Test(description = "POST request - Send payload using POJO")
	public void createMember3() {

		CreateMember cm = new CreateMember();
		Member member = cm.createMember();

		given().contentType("application/json").body(member).when().post(base_url).then().log().all();

	}

	@Test(description = "POST request - Send payload using JSON")
	public void createMember4() {

		String filepath = "C:\\Users\\vijay\\eclipse-workspace\\API-Automation-Practice\\src\\test\\java\\TestData\\member-data.json";
		File jsonFile = new File(filepath);
		FileReader fileread = null;
		try {
			fileread = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONTokener json = new JSONTokener(fileread);

		JSONObject jsonob = new JSONObject(json);

		given().contentType("application/json").body(jsonob.toString()).when().post(base_url).then().log().all();

	}

}
