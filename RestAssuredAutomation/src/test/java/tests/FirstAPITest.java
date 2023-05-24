package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class FirstAPITest {

	@Test
	public void demoTest() {
		
		Response resp=get("https://reqres.in/api/users?page=2");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getTime());
		System.out.println(resp.getBody().asString());
		System.out.println(resp.getContentType());
		System.out.println(resp.getHeader("content-type"));
		System.out.println(resp.getStatusLine());
		
		int statCode=resp.getStatusCode();
		
		Assert.assertEquals(statCode, 200);
		
		
	}
	
	@Test
	public void demoTest2() {
		baseURI="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data.id[1]", equalTo(8)).log().all();
	}
}
