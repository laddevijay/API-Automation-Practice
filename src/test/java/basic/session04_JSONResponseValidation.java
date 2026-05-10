package basic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class session04_JSONResponseValidation {

	@Test(description = "Get Request - read the response & validate using hamcrest library")
	public void readResponse1() {

		String base_url = "http://localhost:3000";

		given().pathParam("endpoint", "members").contentType(ContentType.JSON).accept(ContentType.JSON).when()
				.get(base_url + "/{endpoint}").then().log().all().statusCode(200)
				.header("Content-Type", "application/json").body("[0].mbi", equalTo("1EG4-TE5-MK73"))
				.body("[0].personalInfo.ssn", equalTo("123-45-6789"));

	}

	@Test(description = "Get Request - read the response & validate using TestNG library")
	public void readResponse2() {

		String base_url = "http://localhost:3000";

		Response response = given().pathParam("endpoint", "members").contentType(ContentType.JSON)
				.accept(ContentType.JSON).when().get(base_url + "/{endpoint}");

		String ssn = response.getBody().jsonPath().getString("[0].personalInfo.ssn");

		System.out.println(ssn);
		Assert.assertEquals("123-45-6789", ssn);

	}

	@Test(description = "Get Request - read the response & validate using JSONObject")
	public void readResponse3() {

		String base_url = "http://localhost:3000";

		Response response = given().pathParam("endpoint", "members").contentType(ContentType.JSON)
				.accept(ContentType.JSON).when().get(base_url + "/{endpoint}");

//		If response starts with{} - It consider as whole JSON Object
//	JSONObject jo = new JSONObject(response.asString());
//	
//	for(int i=0;i<jo.getJSONArray("members").length();i++) {
//		
//		JSONArray ja = jo.getJSONArray("members");
//		String st = ja.getJSONObject(i).get("mbi").toString();
//		System.out.println(st);
//	}

//	// because root response starts with [ ]
//	JSONArray jsonarr = new JSONArray(response.asString());
//
//	// Iterate all objects inside array
//	for (int i = 0; i < jsonarr.length(); i++) {
//
//		// Get current object from array
//		JSONObject obj = jsonarr.getJSONObject(i);
//
//		// Check whether mbi key exists
//		if (obj.has("mbi")) {
//
//			// Read mbi value
//			String mbi = obj.get("mbi").toString();
//
//			System.out.println(mbi);
//		}
//	}
//	

		JSONArray ja = new JSONArray(response.asString());
		for (int i = 0; i < ja.length(); i++) {

			JSONObject jo = ja.getJSONObject(i);
			String id = jo.get("id").toString();
			System.out.println(id);

		}

	}

}