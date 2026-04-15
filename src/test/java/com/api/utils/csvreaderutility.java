package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.api.dataprovider.pojouser;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class csvreaderutility {

	private csvreaderutility() {}
	
	public void loadcsvmethod(String path) {
		
InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		
		InputStreamReader isr=new InputStreamReader(is);
		
		CSVReader csvreader=new CSVReader(isr);
		CsvToBean<pojouser> csvbean=new CsvToBeanBuilder(csvreader)
				.withType(pojouser.class)
				.withIgnoreEmptyLine(true)
				.build();
		
		List<pojouser> pojouser=csvbean.parse();
		System.out.println(pojouser);
		
		
		
		
		
	}
	
	
	
	
	
	
}
