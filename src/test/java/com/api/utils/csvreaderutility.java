package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.api.dataproviderbean.userbean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class csvreaderutility {

	private csvreaderutility() {}
	
	public static Iterator<userbean> loadcsvmethod(String path) {
		
InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		
		InputStreamReader isr=new InputStreamReader(is);
		
		CSVReader csvreader=new CSVReader(isr);
		
		CsvToBean<userbean> csvbean=new CsvToBeanBuilder(csvreader)
				.withType(userbean.class)
				.withIgnoreEmptyLine(true)
				.build();
		
		List<userbean> pojouser=csvbean.parse();
		return pojouser.iterator();
		
		
		
		
		
	}
	
	
	
	
	
	
}
