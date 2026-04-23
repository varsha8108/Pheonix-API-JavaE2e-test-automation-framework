package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.usercred;

public class objectmapperdemo {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("testdata/demo.json");
		
		
		// use object mapper to read the value from the .json file and map to usercredentials.java pojo(record)
		
		
		ObjectMapper om=new ObjectMapper();
		usercred[] usercredarray=om.readValue(is, usercred[].class);
		
		for(usercred u:usercredarray) {
			System.out.println(u);
			System.out.println(u.username());
			System.out.println(u.password());
		}
		
		
		
	}

}
