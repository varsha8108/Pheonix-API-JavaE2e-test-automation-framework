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
	
	public static <T> Iterator<T> loadcsvmethod(String path,Class<T> bean) {
		
InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		
		InputStreamReader isr=new InputStreamReader(is);
		
		CSVReader csvreader=new CSVReader(isr);
		
		CsvToBean<T> csvbean=new CsvToBeanBuilder(csvreader)
				.withType(bean)
				.withIgnoreEmptyLine(true)
				.build();
		
		List<T> pojouser=csvbean.parse();
		return  pojouser.iterator();
		
		
		
		
		
	}
	
	
	
	
	
	
}
