package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.usercred;

public class jsonreaderutility {

	
	public static <T>Iterator<T> loadjson(String filename, Class<T[]> c) {
	
	
	InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("testdata/demo.json");
	
	
	// use object mapper to read the value from the .json file and map to usercredentials.java pojo(record)
	
	
	ObjectMapper om=new ObjectMapper();
	T[] u;
	List<T> list = null;
	try {
		u = om.readValue(is, c);
		list=Arrays.asList(u);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list.iterator();
}
}