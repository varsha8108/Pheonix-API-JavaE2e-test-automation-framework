package com.api.test;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.checkerframework.checker.index.qual.LessThan;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

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
		.header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE3NzQ4NjIzODV9.tyVUYdEV9_e9SPVefg7M4Z7-PfI6Xyc_FzZOJ1UoU8c")
		.contentType(ContentType.JSON)
		.when()
		.get("userdetails")
		.then()
		.statusCode(200)
		.time(lessThan(2000L))
		.body("message",equalTo("Success"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidator/userdetails.json"))
		.body("data.id",equalTo(4))
		.body("data.login_id",equalTo("iamfd"))
		.extract().response();
		System.out.println("Response "+r.asPrettyString());
		System.out.println("Response time "+r.time());
		System.out.println("Response code "+r.statusCode());
		System.out.println("ID "+r.jsonPath().getString("data.id"));
		System.out.println("first_name  "+r.jsonPath().getString("data.first_name"));
		
	
}
}
