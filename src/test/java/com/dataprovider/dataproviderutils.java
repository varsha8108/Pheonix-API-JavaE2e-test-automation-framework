package com.dataprovider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.dataproviderbean.userbean;
import com.api.utils.csvreaderutility;

public class dataproviderutils {

	
	
	
	@DataProvider(name = "loginapidataprovider")
public static Iterator<userbean> loginapidataprovider() {
	
	return csvreaderutility.loadcsvmethod("csvfiles/logincred.csv");
	
	
	
	
	
}
	
	// returns
//	array-1d
//	array - 2d
//	iterator
}
