package com.api.test;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.Authtoken;
import com.api.utils.configmanager;
import com.api.utils.specbuilder;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
//comment
public class countapiTest {
	@Test(description = "Verify if the count api test displays the number of jobs created and pending for assignment and delivery",groups = {"api","Regression","Smoke"})

	public void countapiTest() throws IOException  {
		Response r=given()
		.spec(specbuilder.requestspecwithrole(Role.FD))
		.when()
		.get("/dashboard/count")
		.then()
		.log().all()
		.spec(specbuilder.responsespecification_text(200))
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
	
	@Test(description = "Verify if the count api test does not display for invalid token",groups = {"api","Regression","Negative"})
	public void countapiTestnegative() throws IOException  {
		Response r=given()
		.spec(specbuilder.requestspec())
		.when()
		.get("/dashboard/count")
		.then()
		.log().all()
		.spec(specbuilder.responsespecification_invalidtoken(401))
		.extract()
		.response();
		
		System.out.println("Response code" +r.asPrettyString());
		System.out.println("Response code" +r.statusCode());
	
}
}