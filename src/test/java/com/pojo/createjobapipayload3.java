package com.pojo;

import java.util.Arrays;
import java.util.List;

public record createjobapipayload3 (
	 int mst_service_location_id,
	 int mst_platform_id,
	 int mst_warrenty_status_id,
	 int mst_oem_id,
	 customerpojo customer,
	 customer_address customer_address,
	 customer_product customer_product,
	 List<problems> problems
	)
{
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	


