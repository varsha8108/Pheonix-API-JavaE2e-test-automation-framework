package com.api.test;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.createjobbeanmapper;
import com.api.utils.datetime;
import com.api.utils.specbuilder;
import com.github.javafaker.Faker;
import com.pojo.createjobapipayload;
import com.pojo.customer;
import com.pojo.customerpojo;
import com.pojo.customer_address;
import com.pojo.customer_product;
import com.pojo.problems;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class createjobapiTest {
	private createjobapipayload payload;
	
	
	@BeforeMethod(description = "Set up method for createjob payload")
	public void createjobtestsetup() {
//		customer customer=new customer("Varsha","k","863-487-1098","863-427-1098","Dolly83@gmail.com","Dolly83@gmail.com");
//		customer_address customer_address=new customer_address("svamitva soul spring square", "ses123", "b street", "big bazaar", "bommanahalli", "560003", "India", "Karnataka");
//		customer_product customer_product=new customer_product(datetime.gettimepast(10), "46505921665210", "46505921665210", "46505921665210", datetime.gettimepast(10), 3, 3);
//		problems problem=new problems(1,"Battery issue");
//		List<problems> problemslist=new ArrayList();
//		problemslist.add(problem);
//		 c=new createjobapipayload(0,2,1,2,customer,customer_address,customer_product,problemslist);
//		 
//		 
		 
		 
		 
		 
		 
		 Faker f=new Faker();
			String fname=f.name().firstName();
			String lname=f.name().lastName();
			String mobilenumber=f.numerify("971#######");
			String altmobilenumber=f.numerify("971#######");
			String email=f.internet().emailAddress();
			customer c=new customer(fname,lname,mobilenumber,altmobilenumber,email,email);
		
			System.out.println(c);
			String buildingnumber=f.address().buildingNumber();
			String flatnumber=f.numerify("1###");
			String street=f.address().streetName();
			String apartment=f.address().streetName();
			String landmark=f.address().streetName();
			String area=f.address().streetName();
			String pin=f.numerify("5#####");
			String country=f.country().name();
			String state=f.country().capital();
			customer_address custaddress=new customer_address(flatnumber,apartment,street,landmark,
					area,pin,country,state);
			System.out.println(custaddress);
			
			
			String dop=datetime.gettimepast(10);
			
			String imei1=f.numerify("1###############");
			String popurl=f.internet().url();
			
			customer_product cproduct=new customer_product(dop,imei1,imei1,imei1,popurl,1,1);
			System.out.println(cproduct);
			Random r=new Random();
			int problemid=r.nextInt((26)+1);
			
			String fake_remark=f.lorem().sentence(10);
			
			problems problem=new problems(problemid,fake_remark);
			System.out.println(problem);
			List<problems> problemarray=new ArrayList<problems>();
			problemarray.add(problem);
			
			 payload=new createjobapipayload(0, 2, 1, 1, c, custaddress, cproduct, problemarray);
	}
	
	
	
	
@Test(description = "Verify if the API create a job id successfully",groups = {"api","Regression","Smoke"})
	public void createjobtest() throws IOException {
	
	Response r=
	given()
	.spec(specbuilder.requestspecwithobject_role(Role.FD, payload))
	.contentType(ContentType.JSON)
	.body(payload)
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
	.body("data.job_number", Matchers.startsWith("JOB_"))
	.body("data.tr_customer_id", Matchers.greaterThan(0))
	.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidator/createapi.json"))
	.extract()
	.response();
	
	System.out.println("RESPONSE time" +r.asPrettyString());
	System.out.println("RESPONSE CODE" +r.statusCode());
	System.out.println("RESPONSE TIME" +r.time());
	
}
}
