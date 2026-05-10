package basic;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class session05_FileUploadNDownload {

	String base_url = "https://gen-endpoint.com";

	@Test(description = "POST request - file Upload")
	public void fileUpload() {

		String filePath = "C:\\Users\\vijay\\eclipse-workspace\\API-Automation-Practice\\src\\test\\java\\TestData\\PatternProblems.txt";
		String filePath2 = "C:\\Users\\vijay\\eclipse-workspace\\API-Automation-Practice\\src\\test\\java\\TestData\\user.json";

		File file = new File(filePath);
		File file2 = new File(filePath2);
		given().pathParam("fileuploadenpoint", "api/upload").multiPart("files", file, "text/plain")
				.multiPart("files", file2, "application/json").contentType("multipart/form-data").when()
				.post(base_url + "/{fileuploadenpoint}").then().log().all();

	}

	@Test(description = "POST request - file Upload validation")
	public void fileUploadValidation() {
		String filePath = "C:\\Users\\vijay\\eclipse-workspace\\API-Automation-Practice\\src\\test\\java\\TestData\\PatternProblems.txt";
		String filePath2 = "C:\\Users\\vijay\\eclipse-workspace\\API-Automation-Practice\\src\\test\\java\\TestData\\user.json";

		File file = new File(filePath);
		File file2 = new File(filePath2);
		Response response = given().pathParam("fileuploadenpoint", "api/upload").multiPart("files", file, "text/plain")
				.multiPart("files", file2, "application/json").contentType("multipart/form-data").when()
				.post(base_url + "/{fileuploadenpoint}");

		JSONObject jo = new JSONObject(response.asString());

		JSONArray ja = jo.getJSONArray("files");

		for (int i = 0; i < ja.length(); i++) {
			JSONObject temp = (JSONObject) ja.get(i);
			System.out.println(temp.get("originalName"));
		}

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(jo.get("success"), true);
		sa.assertEquals(jo.get("message"), "All 2 file(s) uploaded successfully");

		sa.assertAll();

	}

	@Test(description = "GET request - file Download validation")
	public void downloadFile() {

		given().pathParam("filedownloadenpoint", "/api/files").when().get(base_url + "/{filedownloadenpoint}").then()
				.statusCode(200).log().all();

	}
}
