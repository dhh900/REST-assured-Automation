package tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

public class TestsOnLocalAPI {

	@Test
	public void get() {
		given().baseUri("http://localhost:3000").when().get("/users").then().statusCode(200).log().all();
	}

	@Test
	public void delete() {
		when().delete("http://localhost:3000/users/4") // full URL is fine for local
				.then().statusCode(anyOf(is(200), is(404))); // 404 because it is already deleted
	}
}
