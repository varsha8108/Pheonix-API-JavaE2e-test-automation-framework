package com.api.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;
import com.pojo.createjobapipayload;
import com.pojo.customer;
import com.pojo.customer_address;
import com.pojo.customer_product;
import com.pojo.problems;

public class fakerdatagenerator {
private fakerdatagenerator() {}
private static Faker f=new Faker();
private static int mst_service_location_id=0;
private static int mst_platform_id=2;
private static int mst_warrenty_status_id=1;
private static int mst_oem_id=1;
private static Random r=new Random();
	public static createjobapipayload generatefakerdata() {
		
		customer c=generatefakecustomerdata();
		
		customer_address custaddress=generatefakecustomeraddressdata();
		customer_product cproduct=generatefakecustomerproductdata();
		List<problems> problemarray=generatefakeproblemlist();
		createjobapipayload payload=new createjobapipayload(mst_service_location_id, mst_platform_id, mst_warrenty_status_id, mst_oem_id, c, custaddress, cproduct, problemarray);
		return payload;
	}
	
	//List of payloads
public static Iterator<createjobapipayload> generatefakerdata(int count) {
		List<createjobapipayload> payloadarray=new ArrayList<createjobapipayload>();
		
		for(int i=1;i<=count;i++) {
		customer c=generatefakecustomerdata();
		
		customer_address custaddress=generatefakecustomeraddressdata();
		customer_product cproduct=generatefakecustomerproductdata();
		List<problems> problemarray=generatefakeproblemlist();
		createjobapipayload payload=new createjobapipayload(mst_service_location_id, mst_platform_id, mst_warrenty_status_id, mst_oem_id, c, custaddress, cproduct, problemarray);
		payloadarray.add(payload);
		}
		
		return payloadarray.iterator();
	}
	
	
	
	
	private static List<problems> generatefakeproblemlist() {
		Random r=new Random();
		int problemid=r.nextInt((20)+1);
		
		String fake_remark=f.lorem().sentence(10);
		
		problems problem=new problems(problemid,fake_remark);
		System.out.println(problem);
		List<problems> problemarray=new ArrayList<problems>();
		problemarray.add(problem);
		return problemarray;
	}
	private static customer_product generatefakecustomerproductdata() {
		String dop=datetime.gettimepast(10);
		
		String imei1=f.numerify("1###############");
		String popurl=f.internet().url();
		
		customer_product cproduct=new customer_product(dop,imei1,imei1,imei1,popurl,1,1);
		return cproduct;
	}
	private static customer_address generatefakecustomeraddressdata() {
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
		return custaddress;
	}
	private static customer generatefakecustomerdata() {
		String fname=f.name().firstName();
		String lname=f.name().lastName();
		String mobilenumber=f.numerify("971#######");
		String altmobilenumber=f.numerify("971#######");
		String email=f.internet().emailAddress();
		customer c=new customer(fname,lname,mobilenumber,altmobilenumber,email,email);
		return c;
	}
	
	
	
	
}
