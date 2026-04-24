package com.api.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelpractise {

	public static void main(String[] args) throws IOException {
		
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("testdata/New Microsoft Excel Worksheet.xlsx");
		
	
		
		XSSFWorkbook workbook=new XSSFWorkbook(is);
		XSSFSheet sheet1=workbook.getSheet("Sheet1");
		XSSFRow row=sheet1.getRow(0);
		XSSFCell cell=row.getCell(0);
		System.out.println(cell);
		
		
		
		

	}

}
