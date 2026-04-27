package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pojo.usercred;

public class excelpractise2 {

	public static Iterator<usercred> loadtestdatawithexcel() throws IOException {
		
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("testdata/New Microsoft Excel Worksheet.xlsx");
		
	
		
		XSSFWorkbook workbook=new XSSFWorkbook(is);
		XSSFSheet sheet1=workbook.getSheet("Sheet1");
		XSSFRow row;
		XSSFCell cell;
		
		
		
		XSSFRow headerrow=sheet1.getRow(0);
		int usernameindex=-1;
		int passwordindex=-1;
		for(Cell c:headerrow) {
			if(c.getStringCellValue().trim().equalsIgnoreCase("username")){
				usernameindex=c.getColumnIndex();
			}
			if(c.getStringCellValue().trim().equalsIgnoreCase("password")){
				passwordindex=c.getColumnIndex();
			}
		}
		
		System.out.println(usernameindex +" "+passwordindex);
		
		
		int lastrowindex=sheet1.getLastRowNum();
		
		
		XSSFRow rowdata;
		
		usercred uc;
		ArrayList<usercred> ucarray=new ArrayList<usercred>();
		for(int rowindex=1;rowindex<=lastrowindex;rowindex++) {
			rowdata=sheet1.getRow(rowindex);
			uc=new usercred(rowdata.getCell(usernameindex).toString(),rowdata.getCell(passwordindex).toString());
			ucarray.add(uc);
		}
		
		
		return ucarray.iterator();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
