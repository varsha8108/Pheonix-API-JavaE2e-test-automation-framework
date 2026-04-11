package com.api.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class datetime {

	
	private datetime() {}
	
	public static String gettimepast(int pastdays) {
		return Instant.now().minus(pastdays,ChronoUnit.DAYS).toString();
	}
	
	
	
	
	
	
	
}
