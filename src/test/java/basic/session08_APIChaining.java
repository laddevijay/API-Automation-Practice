package basic;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import POJO.Address;
import POJO.Member;
import POJO.PersonalInfo;
import POJO.Plan;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class session08_APIChaining {

	String base_url = "http://localhost:3000/members";

	@Test(description = "GET request")
	public void getAllMembers(ITestContext context) {
		String member = null;

		Response response = given().when().get(base_url);

		// response.prettyPrint();

		JSONArray json = new JSONArray(response.asString());

		for (int i = 0; i < json.length(); i++) {

			JSONObject jsonObj = json.getJSONObject(i);
			if (jsonObj.has("enrollmentId")) {
				if (jsonObj.get("enrollmentId").toString().equals("834-1001")) {
					member = jsonObj.getString("id");
				}
			}
		}
		context.setAttribute("demoId", member);
	}

	@Test(description = "PUT request")
	public void updateMemberName(ITestContext context) {

		String updateMember = (String) context.getAttribute("demoId");

//		given()
//			.pathParam("memberId", updateMember)
//			.contentType("application/json")
//		.when()
//			.get(base_url+"/{memberId}")
//		.then()
//			.log().all();
//		
		PersonalInfo personalInfo = new PersonalInfo("MAX", "AMINI", "1985-06-15", "123-45-6789", "English");
		Address address = new Address("123 Main St", "Delhi", "MH", "411001");
		Plan plan1 = new Plan("Gold Plan", "Medical", "Primary");
		List<Plan> plans = new ArrayList<>();
		plans.add(plan1);

		Member member = new Member("834-1001", personalInfo, address, "1EG4-TE5-MK73", plans, 1);

		Response response = given().pathParam("updateMember", updateMember).contentType(ContentType.JSON).body(member)
				.when().put(base_url + "/{updateMember}");

		response.prettyPrint();
	}
}
