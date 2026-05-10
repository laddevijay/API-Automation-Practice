package basic;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class session07_Authorizations {

	@Test(description = "Basic Authentication")
	public void basicAuth() {
		String base_url = "https://httpbin.org/basic-auth/user/passwd";

		Response response = given().auth().basic("user", "passwd").when().get(base_url);

		System.out.println(response.getStatusCode() + "\n" + response.getStatusLine());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(description = "Bearer Token  Authentication")
	public void beareToken() {
		String base_url = "https://api.github.com/user";
		String bearerToken = "ghp_demo";

		Response response = given().header("Authorization", "Bearer " + bearerToken).when().get(base_url);

		System.out.println(response.getStatusCode() + "\n" + response.getStatusLine());
		System.out.println(response.getBody().asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
