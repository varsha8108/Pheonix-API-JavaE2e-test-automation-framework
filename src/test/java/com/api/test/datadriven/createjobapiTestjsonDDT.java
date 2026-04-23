package com.api.test.datadriven;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.createjobbeanmapper;
import com.api.utils.datetime;
import com.api.utils.specbuilder;
import com.pojo.createjobapipayload;
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

public class createjobapiTestjsonDDT {
	private createjobapipayload c;
	
	
//	@BeforeMethod(description = "Set up method for createjob payload")
//	public void createjobtestsetup() {
//		customerpojo customer=new customerpojo("Varsha","k","863-487-1098","863-427-1098","Dolly83@gmail.com","Dolly83@gmail.com");
//		customer_address customer_address=new customer_address("svamitva soul spring square", "ses123", "b street", "big bazaar", "bommanahalli", "560003", "India", "Karnataka");
//		customer_product customer_product=new customer_product(datetime.gettimepast(10), "46505921665210", "46505921665210", "46505921665210", datetime.gettimepast(10), 3, 3);
//		problems problem=new problems(1,"Battery issue");
//		List<problems> problemslist=new ArrayList();
//		problemslist.add(problem);
//		 c=new createjobapipayload(0,2,1,2,customer,customer_address,customer_product,problemslist);
//	}
//	
	
	
	
@Test(description = "Verify if the API create a job id successfully",groups = {"api","Regression","DDT"},
dataProviderClass = com.dataprovider.dataproviderutils.class,
dataProvider = "createjobapijsondataprovider")
	public void createjobtest(createjobapipayload cp) throws IOException {
	
	Response r=
	given()
	.spec(specbuilder.requestspecwithobject_role(Role.FD, cp))
	.contentType(ContentType.JSON)
	//.body(c)
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
