package basic;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class session06_SchemaValidation {

	String base_url = "https://gen-endpoint.com";

	@Test(description = "GET request - Schema Validation")
	public void schemaValidation() {

		String filepath = "C:\\Users\\vijay\\eclipse-workspace\\API-Automation-Practice\\src\\test\\java\\TestData\\JSONSchema.json";
		File file = new File(filepath);

		given().pathParams("getUserEndPoint", "api/users").when().get(base_url + "/{getUserEndPoint}").then()
				.assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
		// XML file validator
		// .body(matchesXsdInClasspath("schemas/traveler.xsd")
	}
}
