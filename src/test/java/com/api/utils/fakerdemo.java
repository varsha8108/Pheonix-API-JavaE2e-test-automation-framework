package com.api.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class fakerdemo {

	public static void main(String[] args) {
		Faker f=new Faker();
		String firstname=f.name().name();
		String address_buildingno=f.address().buildingNumber();
		String address_street=f.address().streetAddress();
		System.out.println(firstname);
		System.out.println(address_buildingno);
		System.out.println(address_street);
		System.out.println(f.address().cityName());
		System.out.println(f.number().digits(13));
		System.out.println(f.internet().emailAddress());
		System.out.println(f.phoneNumber().phoneNumber());
	}

}
