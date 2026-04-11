package com.api.test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.utils.configmanager;
import com.api.utils.specbuilder;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.pojo.usercred;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class loginapiTest {
	private usercred u;
	
	@BeforeMethod(description = "User credentials object creation")
	public void setup() {
		 u=new usercred("iamfd","password");
	}
	
	
@Test(description = "Verify if Login test for API is working as expected",groups = {"api","Regression","Smoke"})
	public void loginapitest() throws IOException {
		
		
		Response r=given()
		.spec(specbuilder.requestspec(u))
		.when()
		.post("login")
		.then()
		.spec(specbuilder.responsespecification())
		.body("message",equalTo("Success"))
		.body("data.token", notNullValue())
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidator/loginresponseschema.json"))
		.extract().response();
		
		System.out.println("Response"+r.asPrettyString());
		System.out.println("Response time"+r.time());
		System.out.println("Response code"+r.statusCode());
		
	}
	
	
	
	
}
