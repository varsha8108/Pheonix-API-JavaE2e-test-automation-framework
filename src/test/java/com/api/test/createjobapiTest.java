package com.api.test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.specbuilder;
import com.pojo.createjobapipayload;
import com.pojo.customer;
import com.pojo.customer_address;
import com.pojo.customer_product;
import com.pojo.problems;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class createjobapiTest {
@Test
	public void createjobtest() throws IOException {
	customer customer=new customer("Varsha","k","863-487-1098","863-427-1098","Dolly83@gmail.com","Dolly83@gmail.com");
	customer_address customer_address=new customer_address("svamitva soul spring square", "ses123", "b street", "big bazaar", "bommanahalli", "560003", "India", "Karnataka");
	customer_product customer_product=new customer_product("2026-02-01T20:00:00.000Z", "46505921665889", "46505921665889", "46505921665889", "2026-02-01T20:00:00.000Z", 3, 3);
	problems problem=new problems(1,"Battery issue");
	problems[] problems=new problems[1];
	problems[0]=problem;
	createjobapipayload c=new createjobapipayload(0,2,1,2,customer,customer_address,customer_product,problems);
	Response r=
	given()
	.spec(specbuilder.requestspecwithobject_role(Role.FD, c))
	.contentType(ContentType.JSON)
	.body(c)
	.log().headers()
	.log().body()
	.log().method()
	.when()
	.post("/job/create")
	.then()
	.log().all()
	.spec(specbuilder.responsespecification())
	.body("message", Matchers.equalToIgnoringCase("Job created successfully. "))
	.body("data.id", Matchers.greaterThan(0))
	.body("data.job_number", Matchers.notNullValue())
	.body("data.tr_customer_id", Matchers.greaterThan(0))
	
	.extract()
	.response();
	
	System.out.println("RESPONSE time" +r.asPrettyString());
	System.out.println("RESPONSE CODE" +r.statusCode());
	System.out.println("RESPONSE TIME" +r.time());
	
}
}
