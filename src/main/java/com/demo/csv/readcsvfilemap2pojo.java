package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class readcsvfilemap2pojo {

	public static void main(String[] args) throws IOException, CsvException {
		
//		File file=new File("G:\\Workspace\\PheonixapplicationRestassurred\\src\\main\\resources\\csvfiles\\logincred.csv");
//		
//		FileReader filereader=new FileReader(file);
		
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("csvfiles/logincred.csv");
		
		InputStreamReader isr=new InputStreamReader(is);
		
		CSVReader csvreader=new CSVReader(isr);
//		List<String[]> list_data=csvreader.readAll();
//		
//		for(String[] dataarray:list_data) {
//			for(String s:dataarray) {
//				System.out.print(s +" ");
//			}
//			System.out.println("\n");
//		}

		
		
		
		CsvToBean<pojouser> csvbean=new CsvToBeanBuilder(csvreader)
				.withType(pojouser.class)
				.withIgnoreEmptyLine(true)
				.build();
		
		List<pojouser> pojouser=csvbean.parse();
		System.out.println(pojouser);
	}

}
