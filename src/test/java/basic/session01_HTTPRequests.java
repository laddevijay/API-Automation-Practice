package basic;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.List;

public class session01_HTTPRequests {

	String base_url = "https://restful-booker.herokuapp.com";

	@Test(description = "POST request - Auth Token Generation")
	public void generateToken() {

		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("username", "admin");
		jsonPayload.put("password", "password123");

		Response response = given().pathParam("endpoint", "auth").contentType("application/json")
				.body(jsonPayload.toString()).when().post(base_url + "/{endpoint}").then().extract().response();
		System.out.println(response.getStatusCode());
		Headers allHeaders = response.getHeaders();
		for (Header hh : allHeaders) {
			System.out.println(hh.getName() + ": " + hh.getValue());
		}
		System.out.println(response.getStatusCode());
		response.prettyPrint();

	}

	@Test(description = "GET request")
	public void getBookingIds() {

		Response response = given().pathParam("endpoint", "booking").when().get(base_url + "/{endpoint}").then()
				.extract().response();

		response.prettyPrint();

	}

	@Test(description = "GET request - Get Booking")
	public void getBookingById() {

		Response response = given().pathParam("endpoint", "booking").pathParam("id", 497).when()
				.get(base_url + "/{endpoint}/{id}").then().extract().response();

		response.prettyPrint();

	}

	@Test(description = "POST request")
	public void createBoooking() {
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("firstname", "Vijay");
		jsonPayload.put("lastname", "Brown");

		jsonPayload.put("totalprice", 2334);
		jsonPayload.put("depositpaid", true);

		JSONObject bookingDates = new JSONObject();
		bookingDates.put("checkin", "2026-01-01");
		bookingDates.put("checkout", "2026-03-01");

		jsonPayload.put("bookingdates", bookingDates);
		jsonPayload.put("additionalneeds", "Breakfast");

		Response response = given().pathParam("endpoint", "booking").contentType("application/json")
				.body(jsonPayload.toString()).when().post(base_url + "/{endpoint}").then().extract().response();

		response.prettyPrint();
		response.getBody().toString();
	}

	@Test(description = "PUT request")
	public void updateBoooking() {

		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("firstname", "Jitin");
		jsonPayload.put("lastname", "Banji");

		jsonPayload.put("totalprice", 234);
		jsonPayload.put("depositpaid", true);

		JSONObject bookingDates = new JSONObject();
		bookingDates.put("checkin", "2026-03-01");
		bookingDates.put("checkout", "2026-03-03");

		jsonPayload.put("bookingdates", bookingDates);
		jsonPayload.put("additionalneeds", "Lunch");

		Response response = given().header("Cookie", "token=8881196c6477354").pathParam("endpoint", "booking")
				.pathParam("id", 497).contentType("application/json").body(jsonPayload.toString()).when()
				.put(base_url + "/{endpoint}/{id}").then().extract().response();

		response.prettyPrint();
		response.getBody().toString();
	}

	@Test(description = "DELETE request")
	public void deleteBoooking() {

		Response response = given().header("Cookie", "token=8881196c6477354").pathParam("endpoint", "booking")
				.pathParam("id", 497).contentType("application/json").when().delete(base_url + "/{endpoint}/{id}")
				.then().extract().response();

		response.prettyPrint();
		response.getBody().toString();
	}

	@Test
	public void optionsRequest() {
		given().when().options("https://reqres.in/api/users").then().statusCode(204).log().headers();
	}
}
