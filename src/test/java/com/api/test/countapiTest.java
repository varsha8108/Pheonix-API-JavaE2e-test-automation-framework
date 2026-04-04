package com.api.test;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.Authtoken;
import com.api.utils.configmanager;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class countapiTest {
	@Test

	public void countapiTest() throws IOException  {
		Response r=given()
		.baseUri(configmanager.getproperty("BASEURI"))
		.header("Authorization", Authtoken.gettoken(Role.FD))
		.when()
		.get("/dashboard/count")
		.then()
		.log().all()
		.statusCode(200)
		.time(lessThan(1000L))
		.body("message",equalTo("Success"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidator/countapi.json"))
		.body("data.size()", equalTo(3))
		.body("data.count",everyItem(greaterThanOrEqualTo(0)))
		.body("data.label",everyItem(notNullValue()))
		.body("data.key",containsInAnyOrder("pending_for_delivery","created_today","pending_fst_assignment"))
		.extract()
		.response();
		System.out.println("Response code" +r.asPrettyString());
		System.out.println("Response code" +r.statusCode());
	}
	
	@Test
	public void countapiTestnegative() throws IOException  {
		Response r=given()
		.baseUri(configmanager.getproperty("BASEURI"))
		.when()
		.get("/dashboard/count")
		.then()
		.log().all()
		.statusCode(401)
		.extract()
		.response();;
		
		System.out.println("Response code" +r.asPrettyString());
		System.out.println("Response code" +r.statusCode());
	
}
}