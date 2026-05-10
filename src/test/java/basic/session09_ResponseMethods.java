package basic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class session09_ResponseMethods {

	@Test
	public void getUsers() {
		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200) // Validate HTTP status code
				.statusLine("HTTP/1.1 200 OK") // Validate status line
				.header("Content-Type", "application/json; charset=utf-8") // Validate response header
				.body("page", equalTo(2)) // Validate current page number
				.body("data[1].id", equalTo(8)) // Validate nested array value
				.body("data.first_name", hasItem("Michael")) // Validate single item exists in list
				.body("data.first_name", hasItems("Michael", "Lindsay")) // Validate multiple items exist
				.body("data", hasSize(6)) // Validate array/list size
				.body("support.url", notNullValue()) // Validate field is not null
				.time(lessThan(3000L)) // Validate response time
				.log().all(); // Print complete response
	}

	@Test
	public void downloadFile() throws IOException {
		Response response = given().when().get("http://localhost:8080/downloadFile/Test1.txt");

		FileOutputStream fos = new FileOutputStream("C:\\Downloads\\Test1.txt");
		fos.write(response.asByteArray());
		fos.close();
		System.out.println("File Downloaded Successfully");
	}

}
