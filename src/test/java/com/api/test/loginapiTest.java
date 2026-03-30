package com.api.test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.pojo.usercred;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class loginapiTest {
@Test
	public void loginapitest() {
		usercred u=new usercred("iamfd","password");
		Response r=given()
		.baseUri("http://64.227.160.186:9000/v1")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.log().uri()
		.log().headers()
		.log().method()
		.log().body()
		.body(u)
		.when()
		.post("login")
		.then()
		.statusCode(200)
		.time(lessThan(2000L))
		.body("message",equalTo("Success"))
		.body("data.token", notNullValue())
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidator/loginresponseschema.json"))
		.extract().response();
		
		System.out.println("Response"+r.asPrettyString());
		System.out.println("Response time"+r.time());
		System.out.println("Response time"+r.statusCode());
		
	}
	
	
	
	
}
