package com.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;
import com.pojo.createjobapipayload;
import com.pojo.customer;
import com.pojo.customer_address;
import com.pojo.customer_product;
import com.pojo.customerpojo;
import com.pojo.problems;

public class faker2demo {

	public static void main(String[] args) {
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
		
		createjobapipayload payload=new createjobapipayload(0, 2, 1, 1, c, custaddress, cproduct, problemarray);
	}

}
