package com.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.dataproviderbean.createjobbean;
import com.api.dataproviderbean.userbean;
import com.api.utils.createjobbeanmapper;
import com.api.utils.csvreaderutility;
import com.api.utils.fakerdatagenerator;
import com.pojo.createjobapipayload;

public class dataproviderutils {


@DataProvider(name = "loginapidataprovider")
public static Iterator<userbean> loginapidataprovider() {
	
	return csvreaderutility.loadcsvmethod("csvfiles/logincred.csv",userbean.class);
	
}
	
	// returns
//	array-1d
//	array - 2d
//	iterator


@DataProvider(name = "createjobapidataprovider")
public static Iterator<createjobapipayload> createjobapidataprovider() {
	
	Iterator<createjobbean> createjobbeaniterator= csvreaderutility.loadcsvmethod("csvfiles/createjob.csv",createjobbean.class);
	List<createjobapipayload> payloadlist=new ArrayList<createjobapipayload>();
	createjobbean tempbean;
	createjobapipayload temppayload;
	while(createjobbeaniterator.hasNext()) {
		tempbean=createjobbeaniterator.next();
		temppayload=createjobbeanmapper.createjobpayloadcreator(tempbean);
		payloadlist.add(temppayload);
	}
	
	return payloadlist.iterator();
}

@DataProvider(name = "createjobapifakerdataprovider")
public static Iterator<createjobapipayload> createjobapifakerdataprovider() {
	
	Iterator<createjobapipayload> fakerdatagen=fakerdatagenerator.generatefakerdata(10);
	
	return fakerdatagen;
}



}
