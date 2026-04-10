package com.api.test;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import  org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.Authtoken;
import com.api.utils.configmanager;
import com.api.utils.specbuilder;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class masterapiTest {
	@Test
	public void masterapitest() throws IOException {
		
		Response r=given()
		.spec(specbuilder.requestspecwithrole(Role.FD))
		.when()
		.post("master")
		.then()
		.spec(specbuilder.responsespecification())
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidator/masterapi.json"))
		.body("message",Matchers.equalTo("Success"))
		.body("data",Matchers.notNullValue())
		.body("data",Matchers.hasKey("mst_oem"))
		.body("data",Matchers.hasKey("mst_model"))
		.body("data.mst_oem.size()",Matchers.greaterThan(0))
		.body("data.mst_model.size()", Matchers.greaterThan(0))
		.body("data.mst_oem.id",Matchers.notNullValue())
		.body("data.mst_model.name", Matchers.notNullValue())
		.extract().response();
		System.out.println("Response "+r.asPrettyString());
		System.out.println("Response time "+r.time());
		System.out.println("Response code "+r.statusCode());
		
		
		
	}
	
	@Test
public void masterapitestnegative() throws IOException {
		
		Response r=given()
		.spec(specbuilder.requestspec())
		.when()
		.post("master")
		.then()
		.spec(specbuilder.responsespecification_invalidtoken(401))
		.extract().response();
		
		System.out.println("Response code "+r.statusCode());
}
}
