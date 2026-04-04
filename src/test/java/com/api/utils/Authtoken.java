package com.api.utils;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import com.api.constants.Role;
import com.pojo.usercred;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Authtoken {
	private Authtoken() {}
	public static String gettoken(Role role) throws IOException {
		usercred u=null;
		// Request for login api, retrieve the token and print
		if(role==Role.FD) {
		u=new usercred("iamfd","password");
		}
		else if(role==Role.SUP)
		{
			u=new usercred("iamsup","password");
		}
		else if(role==Role.ENG)
		{
			u=new usercred("iameng","password");
		}
		else if(role==Role.QC)
		{
			u=new usercred("iamqc","password");
		}
		Response response=given().
		baseUri("http://64.227.160.186:9000/v1")
		.contentType(ContentType.JSON)
		.body(u)
		.when()
		.post("login")
		.then()
		.statusCode(200)
		.body("message",equalTo("Success"))
		.body("data.token", notNullValue()).extract().response();
		String token=response.jsonPath().getString("data.token");
		return token;

	}

}
