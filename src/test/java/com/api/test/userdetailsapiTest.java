package com.api.test;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.checkerframework.checker.index.qual.LessThan;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.Authtoken;
import com.api.utils.configmanager;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class userdetailsapiTest {
	@Test
public void userdetailsapi() throws IOException {
		Response r=given()
		.baseUri(configmanager.getproperty("BASEURI"))
		.header("Authorization", Authtoken.gettoken(Role.FD))
		.contentType(ContentType.JSON)
		.when()
		.get("userdetails")
		.then()
		.statusCode(200)
		.time(lessThan(2000L))
		.body("message",equalTo("Success"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidator/userdetails.json"))
		//.body("data.id",equalTo(4))
		//.body("data.login_id",equalTo("iamfd"))
		.extract().response();
		System.out.println("Response "+r.asPrettyString());
		System.out.println("Response time "+r.time());
		System.out.println("Response code "+r.statusCode());
//		System.out.println("ID "+r.jsonPath().getString("data.id"));
//		System.out.println("first_name  "+r.jsonPath().getString("data.first_name"));
		
	
}
}
