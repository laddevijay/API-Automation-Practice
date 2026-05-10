package basic;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.Map;

public class session03_HeaderNCookies {

	String base_url = "http://localhost:3000";

	@Test(description = "GET request - Create Booking")
	public void getHeaders() {

		Response response = given().pathParam("endpoint", "members").contentType("application/json").when()
				.post(base_url + "/{endpoint}").then().extract().response();

		System.out.println(response.getHeader("Date"));

		Headers allHeaders = response.getHeaders();

		for (Header hh : allHeaders) {
			System.out.println(hh.getName() + " : " + hh.getValue());
		}
	}

	@Test(description = "GET request - google API")
	public void getCookies() {

		base_url = "https://www.google.com";
		Response response = given().contentType("application/json").when().get(base_url).then()
				.header("Content-Type", "text/html; charset=ISO-8859-1").header("Content-Encoding", "gzip").extract()
				.response();

		System.out.println(response.getCookie("AEC"));
		// response.getCookie("");

		Map<String, String> allCookies = response.getCookies();

		for (Map.Entry<String, String> hh : allCookies.entrySet()) {
			System.out.println(hh.getKey() + " : " + hh.getValue());
		}
	}
}
