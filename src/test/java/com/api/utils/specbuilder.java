package com.api.utils;

import java.io.IOException;

import org.hamcrest.Matchers;

import com.api.constants.Role;
import com.pojo.usercred;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specbuilder {

	
	public static RequestSpecification requestspec() throws IOException {
		RequestSpecification request=new RequestSpecBuilder()
		.setBaseUri(configmanager.getproperty("BASEURI"))
		.setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.log(LogDetail.HEADERS)
		.log(LogDetail.BODY)
		.build();
		return request;
	}
	
	public static RequestSpecification requestspec(Object u) throws IOException {
		RequestSpecification request=new RequestSpecBuilder()
		.setBaseUri(configmanager.getproperty("BASEURI"))
		.setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.log(LogDetail.HEADERS)
		.log(LogDetail.BODY)
		.setBody(u)
		.build();
		return request;
	}
	
	public static RequestSpecification requestspecwithrole(Role r) throws IOException {
		RequestSpecification request=new RequestSpecBuilder()
		.setBaseUri(configmanager.getproperty("BASEURI"))
		.setContentType(ContentType.JSON)
		.addHeader("Authorization", Authtoken.gettoken(r))
		.setAccept(ContentType.JSON)
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.log(LogDetail.HEADERS)
		.log(LogDetail.BODY)
		.build();
		return request;
	}
	
	
	public static RequestSpecification requestspecwithobject_role(Role r,Object u) throws IOException {
		RequestSpecification request=new RequestSpecBuilder()
		.setBaseUri(configmanager.getproperty("BASEURI"))
		.setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.addHeader("Authorization", Authtoken.gettoken(r))
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.log(LogDetail.HEADERS)
		.log(LogDetail.BODY)
		.setBody(u)
		.build();
		return request;
	}
	
	public static ResponseSpecification responsespecification() {
		ResponseSpecification responsespecification=new ResponseSpecBuilder()
		.expectStatusCode(200)
		.expectResponseTime(Matchers.lessThan(2000L))
		.expectContentType(ContentType.JSON)
		.build();
		return responsespecification;
	}
	
	
	public static ResponseSpecification responsespecification_text(int statuscode) {
		ResponseSpecification responsespecification=new ResponseSpecBuilder()
		.expectStatusCode(200)
		.expectResponseTime(Matchers.lessThan(2000L))
		.build();
		return responsespecification;
	}
	public static ResponseSpecification responsespecification_invalidtoken(int statuscode) {
		ResponseSpecification responsespecification=new ResponseSpecBuilder()
		.expectStatusCode(statuscode)
		.expectResponseTime(Matchers.lessThan(2000L))
		.build();
		return responsespecification;
	}
}
