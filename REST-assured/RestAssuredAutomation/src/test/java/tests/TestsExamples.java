package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestsExamples extends BaseTest {

	@Test
	public void test_1() {
		Response response = given().when().get("/users?page=2");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void test_2() {
		given().when().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
	}
}
